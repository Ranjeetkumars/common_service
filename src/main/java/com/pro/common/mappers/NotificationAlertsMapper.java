/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.NotificationAlertsControllerDTO;
import com.pro.common.persistencedto.NotificationAlertsPersistenceDTO;
import com.pro.common.servicedto.NotificationAlertsServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class NotificationAlertsMapper {
	public NotificationAlertsServiceDTO convertNotificationAlertsControllerDTOtoNotificationAlertsServiceDTO(NotificationAlertsControllerDTO controllerDTO) {
		NotificationAlertsServiceDTO propertiesServiceDTO = new NotificationAlertsServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<NotificationAlertsPersistenceDTO> convertObjetsArraytoNotificationAlertsPersistenceDTOList(List<Object[]> list) {
		List<NotificationAlertsPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<NotificationAlertsPersistenceDTO>();
		for (Object[] objects : list) {
			NotificationAlertsPersistenceDTO objCommonDataPersistenceDTO = new NotificationAlertsPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setAlertId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setAlertId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setAlertMessage(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setAlertMessage(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setAlertname(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setAlertname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setAlertExpiryTime(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setAlertExpiryTime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<NotificationAlertsServiceDTO> convertNotificationAlertsPersistenceDTOListToNotificationAlertsServiceDTOList(
			List<NotificationAlertsPersistenceDTO> persistenceDTOs) {
		List<NotificationAlertsServiceDTO> commonDataServiceDTOs = new ArrayList<NotificationAlertsServiceDTO>();
		for (NotificationAlertsPersistenceDTO objects : persistenceDTOs) {
			NotificationAlertsServiceDTO gisCommonDataServiceDTO = new NotificationAlertsServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<NotificationAlertsControllerDTO> convertNotificationAlertsServiceDTOListToNotificationAlertsControllerDTOList(List<NotificationAlertsServiceDTO> dataServiceDTOs) {
		List<NotificationAlertsControllerDTO> controllerDTOs = new ArrayList<NotificationAlertsControllerDTO>();
		for (NotificationAlertsServiceDTO objects : dataServiceDTOs) {
			NotificationAlertsControllerDTO dataControllerDTO = new NotificationAlertsControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public List<NotificationAlertsPersistenceDTO> conversiongettingStatusDetails(List<Object[]> list) {
		List<NotificationAlertsPersistenceDTO> notificationAlertsPersistenceDTOs = new ArrayList<NotificationAlertsPersistenceDTO>();
		for (Object[] objects : list) {
			NotificationAlertsPersistenceDTO objNotificationAlertsPersistenceDTO = new NotificationAlertsPersistenceDTO();
			if (objects[0] != null) {
				objNotificationAlertsPersistenceDTO.setStatusTypeId(objects[0].toString());
			} else {
				objNotificationAlertsPersistenceDTO.setStatusTypeId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objNotificationAlertsPersistenceDTO.setStatusType(objects[1].toString());
			} else {
				objNotificationAlertsPersistenceDTO.setStatusType(CommonConstants.DATA_NOT_AVIALABLE);
			}	
			notificationAlertsPersistenceDTOs.add(objNotificationAlertsPersistenceDTO);
		}
		return notificationAlertsPersistenceDTOs;
	}
	
}
