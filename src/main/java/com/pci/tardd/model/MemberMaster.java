package com.pci.tardd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberMaster {
	
	@JsonProperty("_id")
	public String onaId;
    @JsonProperty("members/Q201")
    public String q201;
    @JsonProperty("members/Q202") 
    public String q202;
    @JsonProperty("members/Q203") 
    public int q203;
    @JsonProperty("members/Q204") 
    public String q204;
    @JsonProperty("members/Q205") 
    public String q205;
    @JsonProperty("members/Q206") 
    public String q206;
    @JsonProperty("members/Q207") 
    public Integer q207;
    @JsonProperty("members/Q208") 
    public String q208;
    @JsonProperty("members/Q209") 
    public String q209;
    @JsonProperty("members/Q210") 
    public String q210;
    @JsonProperty("members/Q211") 
    public String q211;
    @JsonProperty("members/Q212") 
    public String q212;
    @JsonProperty("members/Q213") 
    public String q213;
    @JsonProperty("members/Q213_spy") 
    public String q213Spy;
    @JsonProperty("members/Q214") 
    public String q214;
    @JsonProperty("members/Q214_spy") 
    public String q214Spy;
    @JsonProperty("members/Q215") 
    public String q215;
    @JsonProperty("members/Q215_spy") 
    public String q215Spy;
    @JsonProperty("members/Q216") 
    public String q216;
    @JsonProperty("members/Q217") 
    public String q217;
    @JsonProperty("members/Q218") 
    public String q218;
    
    @JsonProperty("members/S1/S1P")
    public String s1P;
    @JsonProperty("members/S1/S1A") 
    public String s1A;
    @JsonProperty("members/S2/S2P")
    public String s2P;
    @JsonProperty("members/S2/S2A") 
    public String s2A;
    @JsonProperty("members/S3/S3P")
    public String s3P;
    @JsonProperty("members/S3/S3A") 
    public String s3A;
    @JsonProperty("members/S4/S4P")
    public String s4P;
    @JsonProperty("members/S4/S4A") 
    public String s4A;
    @JsonProperty("members/S5/S5P")
    public String s5P;
    @JsonProperty("members/S5/S5A") 
    public String s5A;
    @JsonProperty("members/S6/S6P") 
    public String s6P;
    @JsonProperty("members/S6/S6A") 
    public String s6A;
}
