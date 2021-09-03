package com.pro.common.controllerdto;

import lombok.Data;

@Data
public class EventIdBySearchControllerDTO {
	private String Moduleid;
	private String eventid;
	private String vehicleNO;
	private String eventdate;
	private String createdbyid;
	private String createdByRoleid;
}
