package com.pci.tardd.rest;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pci.tardd.model.AppResponse;
import com.pci.tardd.model.LoginModelDTO;
import com.pci.tardd.service.HouseholdService;

@Controller
@RequestMapping(value = "/authenticate")
public class AuthenticationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HouseholdService householdService;

	@CrossOrigin
	@PostMapping
	public String authenticateUser(HttpSession session, Model model, @ModelAttribute("data") LoginModelDTO request) {
		logger.info("Username: {}, Password: {}", request.getUsername(), request.getUserkey());
		if (request.getUsername() != "") {
			if (request.getUsername().equalsIgnoreCase("clf_badal")
					&& request.getUserkey().equalsIgnoreCase("badalPass")) {
				session.setAttribute("token", UUID.randomUUID().toString());
				return "redirect:/clf";
			}
			request.setStatus("error");
			request.setMessage("Authentication Failed! Wrong Username/Password");
			model.addAttribute("data", request);
			return "login";
		}
		return "redirect:/";
	}

	@CrossOrigin
	@RequestMapping(value = "/getVONames", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVONames(@RequestBody Map<String, Object> request) {
		logger.info("getVONames: {}", request);
		Set<String> voNames = new HashSet<>();
		householdService.findAll().stream().filter(house -> house.getClf().equals(request.get("clf")))
				.forEach(house -> voNames.add(house.getVo().toUpperCase()));
		return ResponseEntity.ok().body(new AppResponse("success", "VO Names", voNames.stream().sorted()));
	}

}
