/**
 * 
 */
package com.pro.common.persistencedto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class ReminderPersistenceDTO {
	 private String reminderID;
	 private String reminderMessage;
	 private String reminderTime;
	 private String eventSpecificCorespondingstatus;
	 private String eventID;
	 private String createdByID;
	 private String isAcknowldged;
	 private String acknowldgedID;
	 private String acknowldgedTime;
	 private String userName;
	 private String moduleid;
}
