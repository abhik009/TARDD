package com.pci.tardd.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembersDTO {
	private Integer id;
	private String onaId;
	@Size(max = 255)
	private String q201;
	@Size(max = 100)
	private String q202;
	@Size(max = 100)
	private String q203;
	@Size(max = 100)
	private String q204;
	@Size(max = 255)
	private String q205;
	@Size(max = 100)
	private String q206;
	@Size(max = 100)
	private String q207;
	@Size(max = 100)
	private String q208;
	@Size(max = 100)
	private String q209;
	@Size(max = 10)
	private String q210;
	@Size(max = 10)
	private String q211;
	@Size(max = 10)
	private String q212;
	@Size(max = 100)
	private String q213;
	private String q213Spy;
	@Size(max = 100)
	private String q214;
	private String q214Spy;
	@Size(max = 100)
	private String q215;
	private String q215Spy;
	@Size(max = 50)
	private String q216;
	@Size(max = 50)
	private String q217;
	@Size(max = 10)
	private String q218;
	@Size(max = 10)
	
	private String s1P;
	@Size(max = 10)
	private String s1A;
	@Size(max = 10)
	private String s2P;
	@Size(max = 10)
	private String s2A;
	@Size(max = 10)
	private String s3P;
	@Size(max = 10)
	private String s3A;
	@Size(max = 10)
	private String s4P;
	@Size(max = 10)
	private String s4A;
	@Size(max = 10)
	private String s5P;
	@Size(max = 10)
	private String s5A;
	@Size(max = 10)
	private String s6P;
	@Size(max = 10)
	private String s6A;
	@NotNull
	private Integer householdId;
}
