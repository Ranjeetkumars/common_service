package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class BloodGroupPersistenanceDTO {
	private String bloodgrouptypeid;
	private String bloodgroupname;
	
	private String economictypeid;
	private String economictypename;
	
	private String socialstatustypeid;
	private String socialStatusType;
	
	private String chct_chiefcomptypeid;
	private String chct_chiefcompltype;
	private String chct_cc_sec_lang;
	private String chct_cc_third_lang;
	private String chct_chief_comp_type_lang4;
	private String emeregerncyGroupid;
	
	private String eventid;
	private String victimlist;
	private String chiefcomplaintslist;
	private String createdbyid;
	private String createdbymoduleid;
	private String createdbyrollid;
	private String size;
}
