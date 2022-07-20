package com.pci.tardd.rest;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pci.tardd.model.LoginModelDTO;
import com.pci.tardd.service.HouseholdService;

@Controller
@RequestMapping(value = "/authenticate")
public class Authentication {
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
				session.setAttribute("clf", "बादल");
				return "redirect:/clf";
			}
			request.setStatus("error");
			request.setMessage("Authentication Failed! Wrong Username/Password");
			model.addAttribute("data", request);
			return "login";
		}
		return "redirect:/";
	}
}