package com.pro.common.servicedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//Habiboon
@Data
@JsonIgnoreProperties
public class GetModuleSpecifcAgentsServiceDTO {
	private String managerid;
	private String moduleid;
	private String userid;
	private String username;

	private String emgmedicalid;
	private String emgpoliceid;
	private String emgfireid;
	private String landmarkid;
	private String localityid;
	private String city_townid;
	private String mandalid;
	private String districtid;
	private String stateid;
	private String countryid;
	private String callername;
	private String callerno;
	private String calltypeid;
	private String eventstatustypeid;
	private String eventid;
	private String today;
	private String stardate;

	private String endate;
	private String ordering;
	private String limitcount;
	private String pageno;
	private String agentid;
	private String ambulance;
	private String search_string_one;
	private String search_string_two;
	private String search_string_three;
	private String serach_level;
}
