/**
 * 
 */
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.GetRemaindersServiceDto;
import com.pro.common.servicedto.NotificationAlertsServiceDTO;
import com.pro.common.servicedto.ReminderServiceDTO;

/**
 * @author VENKAT_PRO
 *
 */
public interface NotificationAlertsService {
	public List<NotificationAlertsServiceDTO> loadNotificationAlerts(NotificationAlertsServiceDTO alertsServiceDTO,
			String requestID) throws DataNotFoundException;

	public List<ReminderServiceDTO> loadReminders(ReminderServiceDTO alertsServiceDTO, String requestID)
			throws DataNotFoundException;

	public String updateVersion(NotificationAlertsServiceDTO dataInfo, String requestId) throws DataNotFoundException;

	public String performedManualLogout(NotificationAlertsServiceDTO dataInfo, String requestId)
			throws DataNotFoundException;

	public List<NotificationAlertsServiceDTO> getStatus(NotificationAlertsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public String updateRemainder(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<GetRemaindersServiceDto> getRemainders(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

}
