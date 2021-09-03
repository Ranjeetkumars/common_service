package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class GetRemaindersPersistenceDto {
	
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
