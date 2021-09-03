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
public class UsersDataPersistenceDTO {
	 private String userID;
	 private String userName;
	 private String moduleID;
	 private String moduleName;
	 private String roleID;
	 private String roleName;
	 private String previllageId;
	 private String previllageName;
	 
	 private String hhc_terminal;
	 private String hhc_terminal_password;
	 private String hhc_terminal_queue_ids;
	 private String hhc_ip;
	 
	 private String userPassword;
	 private String loginTime;
	 private String extension;
	 private String remarks;
	 
	 private String managerId;
	 
	 private String shiftID;
	 private String shiftTimings;
	 
	 private String ear_remainder_text;
	 private String ear_remainder_date;
	 private String ear_is_event_specific_or_personal;
	 private String ear_event_id;
	 private String ear_remainder_created_by_id;
	 private String emergencyGroupID;
	 private String emergencyTYpeID;
	 private String clientSystemTime;
	 private String olduserID;
     private String newuserID;
     private String issystemPrivilege;
     private String strXml;
     private String serviceName;
     private String unifiedgrouptypeId;
 	 private String portNo;
 	 private String licenceID;
 	 private String key2;
 	 private String key1;

}
