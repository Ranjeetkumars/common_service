package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class VictimDetailPersistenanceDTO {
	private String victimid;
	private String victim;
	private String gender;
	private String age;
	private String dob;
	private String bloodgroup;
	private String allergy;
	private String economicStatus;
	private String socicalStaus;
	private String medicalPastHistroy;
	private String currentmedication;
	private String cheifcomplainttype;
	
	private String firstname;
	private String createdbyid;
	private String createdbymoduleid;
	private String createdbyroleid;
	private String economictypeid;
	private String socialstatustypeid;
	private String gendertypeid;
	private String bloodgroupid;
}
