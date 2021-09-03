package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class EventIdBySearchPersistenanceDTO {
	private String Moduleid;
	private String eventid;
	private String vehicleNO;
	private String eventdate;
	private String createdbyid;
	private String createdByRoleid;
}
