package com.pci.tardd.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Household {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100,unique = true)
	private String onaId;
	@Column
	private LocalDate today;
	@Column
	private String district;
	@Column
	private String block;
	@Column
	private String clf;
	@Column
	private String panchayat;
	@Column
	private String vo;
	@Column
	private String village;
	@Column
	private String ward;
	@Column
	private String shg;
	@Column
	private String caste;
	@Column
	private String q101;
	@Column
	private String q102;
	@Column
	private String q103;
	@Column
	private String q104;
	@Column
	private String q105;
	@Column
	private String q106;
	@Column
	private String q106Spy;
	@Column
	private String q107;
	@Column
	private String q108;
	@Column
	private String q109;
	@Column
	private String q110;
	@Column
	private String q111;
	@Column
	private String q112;
	@Column
	private String version;
	@Column
	private String duration;
	@Column
	private String membersCount;
	@Column(columnDefinition = "longtext")
	private String remarks;
	@Column
	private String formStartTime;
	@Column
	private String formEndTime;
	@Column(nullable = false)
	private Boolean edited;
	@Column
	private String editedOn;
	@Column
	private Integer xformId;
	@Column
	private String xformName;
//	@ManyToMany
//	@JoinTable(name = "hh_mem_map", joinColumns = { @JoinColumn(name = "hh_id") }, inverseJoinColumns = {@JoinColumn(name = "mem_id") })
	@OneToMany(mappedBy = "households")
	private Set<Member> members;
}
