package com.pci.tardd.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdDTO {
	private Integer id;
	@Size(max = 255)
	private String onaId;
	private LocalDate today;
	@Size(max = 255)
	private String district;
	@Size(max = 255)
	private String block;
	@Size(max = 255)
	private String clf;
	@Size(max = 255)
	private String panchayat;
	@Size(max = 255)
	private String vo;
	@Size(max = 255)
	private String village;
	@Size(max = 255)
	private String ward;
	@Size(max = 255)
	private String shg;
	@Size(max = 255)
	private String caste;
	@Size(max = 255)
	private String q101;
	@Size(max = 255)
	private String q102;
	@Size(max = 255)
	private String q103;
	@Size(max = 255)
	private String q104;
	@Size(max = 255)
	private String q105;
	@Size(max = 255)
	private String q106;
	@Size(max = 255)
	private String q106Spy;
	@Size(max = 255)
	private String q107;
	@Size(max = 255)
	private String q108;
	@Size(max = 255)
	private String q109;
	@Size(max = 255)
	private String q110;
	@Size(max = 255)
	private String q111;
	@Size(max = 255)
	private String q112;
	@Size(max = 255)
	private String version;
	@Size(max = 255)
	private String duration;
	@Size(max = 255)
	private String membersCount;
	private String remarks;
	@Size(max = 255)
	private String formStartTime;
	@Size(max = 255)
	private String formEndTime;
	@NotNull
	private Boolean edited;
	@Size(max = 255)
	private String editedOn;
	private Integer xformId;
	@Size(max = 255)
	private String xformName;

}