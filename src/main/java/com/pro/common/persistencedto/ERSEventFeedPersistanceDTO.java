
package com.pro.common.persistencedto;

import lombok.Data;

/**
 * @author : Habiboon Patan
 * @Date : 2091-07-16
 *
 */
@Data
public class ERSEventFeedPersistanceDTO {
	private String typeId;
	private String feedName;
	
	private String eventId;
	private String feedText;
	private String feedTypeId;
	private String userId;
	private String moduleId;
	private String roleId;
	
	

}
