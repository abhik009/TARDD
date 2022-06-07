package com.pci.tardd.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pci.tardd.dto.HouseholdDTO;
import com.pci.tardd.model.LoginModelDTO;
import com.pci.tardd.service.HouseholdService;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HouseholdService householdService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginUser(Model model) {
		LoginModelDTO dto = new LoginModelDTO();
		dto.setBtn("लॉग इन");
		model.addAttribute("data", dto);
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) {
		if (session!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/vo", method = RequestMethod.GET)
	public String loadVO(Model model, HttpSession session) {
		logger.info("loadVOPage {}", session.getAttribute("vo"));
		Map<String, Object> response = new HashMap<>();
		if (session.getAttribute("token") != null) {
			List<HouseholdDTO> households = householdService.findAllByVO(session.getAttribute("vo").toString());
			Set<String> shgList = new HashSet<>();
			int[] totalMem = new int[1];
			Arrays.fill(totalMem, 0);
			households.forEach(house -> shgList.add(house.getShg().toUpperCase()));
			households.forEach(house -> totalMem[0] = totalMem[0] + Integer.valueOf(house.getMembersCount()));
			
			List<Map<String, Object>> row1Data = new ArrayList<Map<String, Object>>();
			String[] row1values = new String[6];
			String[] row1headers = { "ग्राम संगठन नाम", "ग्राम-संगठन प्रधान", "समूहों की संख्या", "सदस्यों की संख्या", "OB सदस्य" };
			row1values[0] = session.getAttribute("vo").toString();
			row1values[1] = "-";
			row1values[2] = String.valueOf(shgList.size());
			row1values[3] = String.valueOf(totalMem[0]); // Total Members
			row1values[4] = "0"; // Total OB Members
			for (int i = 0; i < row1headers.length; i++) {
				Map<String, Object> row1Vals = new HashMap<>();
				row1Vals.put("header", row1headers[i]);
				row1Vals.put("value", row1values[i]);
				row1Data.add(row1Vals);
			}
			response.put("row1", row1Data);
			
			// Calculation For Row 2
			List<Map<String, Object>> row2Data = new ArrayList<Map<String, Object>>();
			String[] row2headers = { "मनरेगा", "राशन कार्ड", "गोल्डन कार्ड", "बी.पी.एल कार्ड", "ऐ.पी.ऐ कार्ड","अन्तोदय कार्ड" };
			int[] q106 = new int[7];
			Arrays.fill(q106, 0);
			Integer totalItemHH = households.size();
			households.forEach(house -> {
				if (house.getQ106().contains("A"))
					q106[0]++;
				if (house.getQ106().contains("B"))
					q106[1]++;
				if (house.getQ106().contains("C"))
					q106[2]++;
				if (house.getQ106().contains("D"))
					q106[3]++;
				if (house.getQ106().contains("E"))
					q106[4]++;
				if (house.getQ106().contains("F"))
					q106[5]++;
				if (house.getQ106().contains("Y"))
					q106[6]++;
			});
			for (int i = 0; i < row2headers.length; i++) {
				Map<String, Object> row2Vals = new HashMap<>();
				row2Vals.put("header", row2headers[i]);
				row2Vals.put("value", q106[i] + " / " + totalItemHH);
				row2Data.add(row2Vals);
			}
			response.put("row2", row2Data);
			
			// Calculation For Table Data
			Map<String, Object> voWise106 = new HashMap<>();
			shgList.stream().sorted().forEach(shg -> {
				int[] shg106 = new int[6];
				households.stream().filter(hh -> hh.getVo().equalsIgnoreCase(shg)).forEach(house -> {
					if (house.getQ106().contains("A"))
						shg106[0]++;
					if (house.getQ106().contains("B"))
						shg106[1]++;
					if (house.getQ106().contains("C"))
						shg106[2]++;
					if (house.getQ106().contains("D"))
						shg106[3]++;
					if (house.getQ106().contains("E"))
						shg106[4]++;
					if (house.getQ106().contains("F"))
						shg106[5]++;
				});
				voWise106.put(shg, shg106);
			});
			
			response.put("tableData", voWise106);
			model.addAttribute("data", response);
			return "dashboard-vo";
		}
		return "redirect:/";

	}

	@RequestMapping(value = "/clf", method = RequestMethod.GET)
	public String loadCLf(Model model, HttpSession session) {
		if (session.getAttribute("token") != null) {
			Map<String, Object> response = new HashMap<>();
			List<HouseholdDTO> households = householdService.findAllByCLF("बादल");
			Set<String> voList = new HashSet<>();
			Set<String> shgList = new HashSet<>();
			households.forEach(house -> voList.add(house.getVo().toUpperCase()));
			households.forEach(house -> shgList.add(house.getShg().toUpperCase()));

			// Calculation For Row-1
			int[] totalMem = new int[1];
			Arrays.fill(totalMem, 0);
			households.forEach(house -> totalMem[0] = totalMem[0] + Integer.valueOf(house.getMembersCount()));
			List<Map<String, Object>> row1Data = new ArrayList<Map<String, Object>>();
			String[] row1headers = { "संकुल नाम", "संकुल प्रधान", "ग्राम-संगठनों की संख्या", "समूहों की संख्या", "सदस्यों की संख्या", "OB सदस्य" };
			String[] row1values = new String[6];
			row1values[0] = "बादल";
			row1values[1] = "-";
			row1values[2] = String.valueOf(voList.size());
			row1values[3] = String.valueOf(voList.size());
			row1values[4] = String.valueOf(totalMem[0]); // Total Members
			row1values[5] = "0"; // Total OB Members
			for (int i = 0; i < 6; i++) {
				Map<String, Object> row1Vals = new HashMap<>();
				row1Vals.put("header", row1headers[i]);
				row1Vals.put("value", row1values[i]);
				row1Data.add(row1Vals);
			}
			response.put("row1", row1Data);

			// Calculation For Row-2
			List<Map<String, Object>> row2Data = new ArrayList<Map<String, Object>>();
			String[] row2headers = { "मनरेगा", "राशन कार्ड", "गोल्डन कार्ड", "बी.पी.एल कार्ड", "ऐ.पी.ऐ कार्ड", "अन्तोदय कार्ड" };
			Integer totalItemHH = households.size();
			int[] q106 = new int[7];
			Arrays.fill(q106, 0);
			households.forEach(house -> {
				if (house.getQ106().contains("A"))
					q106[0]++;
				if (house.getQ106().contains("B"))
					q106[1]++;
				if (house.getQ106().contains("C"))
					q106[2]++;
				if (house.getQ106().contains("D"))
					q106[3]++;
				if (house.getQ106().contains("E"))
					q106[4]++;
				if (house.getQ106().contains("F"))
					q106[5]++;
				if (house.getQ106().contains("Y"))
					q106[6]++;
			});
			for (int i = 0; i < row2headers.length; i++) {
				Map<String, Object> row2Vals = new HashMap<>();
				row2Vals.put("header", row2headers[i]);
				row2Vals.put("value", q106[i] + " / " + totalItemHH);
				row2Data.add(row2Vals);
			}
			response.put("row2", row2Data);

			// Calculation For Table Data
			Map<String, Object> voWise106 = new HashMap<>();
			voList.stream().sorted().forEach(vo -> {
				int[] vo106 = new int[6];
				households.stream().filter(hh -> hh.getVo().equalsIgnoreCase(vo)).forEach(house -> {
					if (house.getQ106().contains("A"))
						vo106[0]++;
					if (house.getQ106().contains("B"))
						vo106[1]++;
					if (house.getQ106().contains("C"))
						vo106[2]++;
					if (house.getQ106().contains("D"))
						vo106[3]++;
					if (house.getQ106().contains("E"))
						vo106[4]++;
					if (house.getQ106().contains("F"))
						vo106[5]++;
				});
				voWise106.put(vo, vo106);
			});
			session.setAttribute("vo", "Saheli"); // manually setting vo value
			response.put("tableData", voWise106);
			model.addAttribute("data", response);
			return "dashboard-clf";
		}
		return "redirect:/";
	}
}
