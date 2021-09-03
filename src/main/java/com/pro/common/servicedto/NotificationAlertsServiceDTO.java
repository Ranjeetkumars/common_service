/**
 * 
 */
package com.pro.common.servicedto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class NotificationAlertsServiceDTO {
	private String alertId;
	private String alertname;
	private String alertMessage;
	private String alertExpiryTime;
	private String alertRequestedModuleID;

	private String userId;
	private String moduleId;
	private String roleId;
	private String version;
	
	private String statusTypeId;
	private String statusType;
}
