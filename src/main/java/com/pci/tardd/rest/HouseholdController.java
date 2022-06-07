package com.pci.tardd.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pci.tardd.dto.HouseholdDTO;
import com.pci.tardd.model.AppResponse;
import com.pci.tardd.service.HouseholdService;

@RestController
@RequestMapping(value = "/households", produces = MediaType.APPLICATION_JSON_VALUE)
public class HouseholdController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HouseholdService householdService;

	@GetMapping
	public ResponseEntity<List<HouseholdDTO>> getAllHouseholds() {
		return ResponseEntity.ok(householdService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<HouseholdDTO> getHousehold(@PathVariable final Integer id) {
		return ResponseEntity.ok(householdService.get(id));
	}

	@PostMapping("getCLFNames")
	public ResponseEntity<?> getCLFNames(@RequestBody Map<String, Object> request) {
		logger.info("getCLFNames: {}", request);
		Set<String> clfNames = new HashSet<>();
		householdService.findAll().forEach(house -> clfNames.add(house.getClf().toUpperCase()));
		return ResponseEntity.ok().body(new AppResponse("success", "Clf Names", clfNames));
	}

	@PostMapping
	public ResponseEntity<Integer> createHousehold(@RequestBody @Valid final HouseholdDTO householdDTO) {
		return new ResponseEntity<>(householdService.create(householdDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateHousehold(@PathVariable final Integer id,
			@RequestBody @Valid final HouseholdDTO householdDTO) {
		householdService.update(id, householdDTO);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHousehold(@PathVariable final Integer id) {
		householdService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
