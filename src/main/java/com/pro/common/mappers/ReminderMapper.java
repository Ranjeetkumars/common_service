/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ReminderControllerDTO;
import com.pro.common.persistencedto.ReminderPersistenceDTO;
import com.pro.common.servicedto.ReminderServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class ReminderMapper {
	public ReminderServiceDTO convertReminderControllerDTOtoReminderServiceDTO(ReminderControllerDTO controllerDTO) {
		ReminderServiceDTO propertiesServiceDTO = new ReminderServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<ReminderPersistenceDTO> convertObjetsArraytoReminderPersistenceDTOList(List<Object[]> list) {
		List<ReminderPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<ReminderPersistenceDTO>();
		for (Object[] objects : list) {
			ReminderPersistenceDTO objCommonDataPersistenceDTO = new ReminderPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setReminderID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setReminderID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setReminderMessage(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setReminderMessage(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setReminderTime(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setReminderTime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setEventSpecificCorespondingstatus(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setEventSpecificCorespondingstatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objCommonDataPersistenceDTO.setEventID(objects[4].toString());
			} else {
				objCommonDataPersistenceDTO.setEventID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objCommonDataPersistenceDTO.setCreatedByID(objects[5].toString());
			} else {
				objCommonDataPersistenceDTO.setCreatedByID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objCommonDataPersistenceDTO.setIsAcknowldged(objects[6].toString());
			} else {
				objCommonDataPersistenceDTO.setIsAcknowldged(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objCommonDataPersistenceDTO.setAcknowldgedID(objects[7].toString());
			} else {
				objCommonDataPersistenceDTO.setAcknowldgedID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objCommonDataPersistenceDTO.setAcknowldgedTime(objects[8].toString());
			} else {
				objCommonDataPersistenceDTO.setAcknowldgedTime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objCommonDataPersistenceDTO.setUserName(objects[9].toString());
			} else {
				objCommonDataPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<ReminderServiceDTO> convertReminderPersistenceDTOListToReminderServiceDTOList(
			List<ReminderPersistenceDTO> persistenceDTOs) {
		List<ReminderServiceDTO> commonDataServiceDTOs = new ArrayList<ReminderServiceDTO>();
		for (ReminderPersistenceDTO objects : persistenceDTOs) {
			ReminderServiceDTO gisCommonDataServiceDTO = new ReminderServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<ReminderControllerDTO> convertNotificationAlertsServiceDTOListToReminderControllerDTOList(List<ReminderServiceDTO> dataServiceDTOs) {
		List<ReminderControllerDTO> controllerDTOs = new ArrayList<ReminderControllerDTO>();
		for (ReminderServiceDTO objects : dataServiceDTOs) {
			ReminderControllerDTO dataControllerDTO = new ReminderControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
}
