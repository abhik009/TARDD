package com.pci.tardd.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MasterData {
	@JsonProperty("_id")
    private Integer onaId;
	private String today;
    private String district;
    private String block;
    private String clf;
    private String panchayat;
    private String vo;
    private String village;
    private String ward;
    private String shg;
    private String caste;
    @JsonProperty("Q101") 
    private String q101;
    @JsonProperty("Q102") 
    private String q102;
    @JsonProperty("Q103") 
    private Integer q103;
    @JsonProperty("Q104") 
    private Integer q104;
    @JsonProperty("Q105") 
    private Integer q105;
    @JsonProperty("Q106") 
    private String q106;
    @JsonProperty("Q106_SPY") 
    private String q106SPY;
    @JsonProperty("Q107") 
    private String q107;
    @JsonProperty("Q108") 
    private String q108;
    @JsonProperty("Q109") 
    private String q109;
    @JsonProperty("Q110")
    private String q110;
    @JsonProperty("Q111") 
    private String q111;
    @JsonProperty("Q112") 
    private String q112;
    private String memCount;
    private ArrayList<MemberMaster> members;
    private String remarks;
    @JsonProperty("members_count")
    private String membersCount;
    @JsonProperty("_version")
    private String version;
    
    @JsonProperty("_uuid")
    private String caseUUID;
    @JsonProperty("_edited")
    private Boolean edited;
    @JsonProperty("_last_edited")
    private String editedOn;
    @JsonProperty("Device_Id") 
    private String device_Id;
    @JsonProperty("Form_Date") 
    private String formDate;
    @JsonProperty("_duration")
    private double duration;
    @JsonProperty("_xform_id")
    private Integer xformId;
    @JsonProperty("formhub/uuid") 
    private String formhubId;
    @JsonProperty("Form_End_Time") 
    private String formEndTime;
    private String _submitted_by;
    @JsonProperty("_date_modified")
    private String dateModified;
    @JsonProperty("Form_Start_Time") 
    private String formStartTime;
    @JsonProperty("meta/instanceID") 
    private String metaInstanceID;
    @JsonProperty("_submission_time")
    private String submissionTime;
    @JsonProperty("_xform_id_string")
    private String xformName;
    
//    private ArrayList<Object> _attachments;
//    private ArrayList<Object> _geolocation;
}
