/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.EventStatusControllerDTO;
import com.pro.common.persistencedto.EventStatusPersistenceDTO;
import com.pro.common.servicedto.EventStatusServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class EventStatusMapper {
	public List<EventStatusPersistenceDTO> convertObjetsArraytoEventStatusPersistenceDTOList(List<Object[]> list) {
		List<EventStatusPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<EventStatusPersistenceDTO>();
		for (Object[] objects : list) {
			EventStatusPersistenceDTO persistenceDTO = new EventStatusPersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setStatusTypeID(objects[0].toString());
			} else {
				persistenceDTO.setStatusTypeID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setStatusTypeName(objects[1].toString());
			} else {
				persistenceDTO.setStatusTypeName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(persistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<EventStatusServiceDTO> convertEventStatusPersistenceDTOListToEventStatusServiceDTO(
			List<EventStatusPersistenceDTO> persistenceDTOs) {
		List<EventStatusServiceDTO> languageServiceDTOs = new ArrayList<EventStatusServiceDTO>();
		for (EventStatusPersistenceDTO objects : persistenceDTOs) {
			EventStatusServiceDTO languageServiceDTO = new EventStatusServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	

	public List<EventStatusControllerDTO> convertEventStatusServiceDTOToEventStatusControllerDTO(
			List<EventStatusServiceDTO> persistenceDTOs) {
		List<EventStatusControllerDTO> languageServiceDTOs = new ArrayList<EventStatusControllerDTO>();
		for (EventStatusServiceDTO objects : persistenceDTOs) {
			EventStatusControllerDTO languageServiceDTO = new EventStatusControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
