package com.pci.tardd;

import java.util.Objects;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.pci.tardd.model.AppResponse;
import com.pci.tardd.model.MasterData;
import com.pci.tardd.service.HouseholdService;
import com.pci.tardd.service.MembersService;

@SpringBootApplication
public class TARDDApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HouseholdService householdService;
	@Autowired
	MembersService membersService;

	public static void main(String[] args) {
		SpringApplication.run(TARDDApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		getOnaData();
	}

	@GetMapping({ "/getOnaData" })
	public ResponseEntity<?> getOnaData() {
		logger.info("started fetching data");
		final RestTemplate template = new RestTemplate();
		final ResponseEntity<MasterData[]> entity = template.getForEntity("https://api.ona.io/api/v1/data/663310",
				MasterData[].class, new Object[0]);
		logger.info("data fetch completed");
		for (MasterData data : Objects.requireNonNull(entity.getBody())) {
			try {
				int hhId = householdService.create(data);
				if (!data.getMembersCount().equalsIgnoreCase("0")) {
					data.getMembers().forEach(member -> {
						member.setOnaId(String.valueOf(data.getOnaId()));
						membersService.create(member, hhId);
					});
				}
			} catch (DataIntegrityViolationException | ConstraintViolationException ex) {
				logger.warn("{}, {}", ex.getLocalizedMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("db updation completed");
		return ResponseEntity.ok().body(new AppResponse("success", "Returning received object", entity));
	}
}