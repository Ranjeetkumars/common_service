/**
 * 
 */
package com.pro.common.controllerdto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class ReminderControllerDTO {
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
