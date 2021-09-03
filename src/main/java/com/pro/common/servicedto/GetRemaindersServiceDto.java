package com.pro.common.servicedto;

import lombok.Data;

@Data
public class GetRemaindersServiceDto {

	private String moduleId;
	private String remainderId;
	private String remainderName;
	private String reamainderWithTimeStamp;
	private String eventSpecificorPersonlStatus;
	private String eventId;
	private String createdById;
	private String acKnowledged;
	private String acKnowledgeId;
	private String acKnowledgedTime;
	private String userName;
}
