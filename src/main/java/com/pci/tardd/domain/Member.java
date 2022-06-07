package com.pci.tardd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(length = 100)
    private String onaId;
    @Column
    private String q201;
    @Column(length = 100)
    private String q202;
    @Column(length = 100)
    private String q203;
    @Column(length = 100)
    private String q204;
    @Column
    private String q205;
    @Column(length = 100)
    private String q206;
    @Column(length = 100)
    private String q207;
    @Column(length = 100)
    private String q208;
    @Column(length = 100)
    private String q209;
    @Column(length = 10)
    private String q210;
    @Column(length = 10)
    private String q211;
    @Column(length = 10)
    private String q212;
    @Column(length = 100)
    private String q213;
    @Column(columnDefinition = "longtext")
    private String q213Spy;
    @Column(length = 100)
    private String q214;
    @Column(columnDefinition = "longtext")
    private String q214Spy;
    @Column(length = 100)
    private String q215;
    @Column(columnDefinition = "longtext")
    private String q215Spy;
    @Column(length = 50)
    private String q216;
    @Column(length = 50)
    private String q217;
    @Column(length = 10)
    private String q218;
    @Column(length = 10)
    private String s1P;
    @Column(length = 10)
    private String s1A;
    @Column(length = 10)
    private String s2P;
    @Column(length = 10)
    private String s2A;
    @Column(length = 10)
    private String s3P;
    @Column(length = 10)
    private String s3A;
    @Column(length = 10)
    private String s4P;
    @Column(length = 10)
    private String s4A;
    @Column(length = 10)
    private String s5P;
    @Column(length = 10)
    private String s5A;
    @Column(length = 10)
    private String s6P;
    @Column(length = 10)
    private String s6A;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_id", nullable = false)
    private Household households;
}
