
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ERSEventFeedControllerDTO;
import com.pro.common.persistencedto.ERSEventFeedPersistanceDTO;
import com.pro.common.servicedto.ERSEventFeedServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author : Habiboon Patan
 * @DATE: 16-07-2019
 */
public class ERSEventFeedMapper {
	
	public ERSEventFeedServiceDTO convertControllerDTOtoServiceDTO(ERSEventFeedControllerDTO controllerDTO) {
		ERSEventFeedServiceDTO propertiesServiceDTO = new ERSEventFeedServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}

	
	public List<ERSEventFeedServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<ERSEventFeedPersistanceDTO> persistenceDTOs) {
		List<ERSEventFeedServiceDTO> ersEventFeedServiceDTO = new ArrayList<ERSEventFeedServiceDTO>();
		for (ERSEventFeedPersistanceDTO objects : persistenceDTOs) {
			ERSEventFeedServiceDTO objERSEventFeedServiceDTO = new ERSEventFeedServiceDTO();
			BeanUtils.copyProperties(objects,objERSEventFeedServiceDTO);
			ersEventFeedServiceDTO.add(objERSEventFeedServiceDTO);
		}
		return ersEventFeedServiceDTO;
	}
	
	public List<ERSEventFeedControllerDTO> convertServiceDTOtoControllerDTO(List<ERSEventFeedServiceDTO> dataServiceDTOs) {
		List<ERSEventFeedControllerDTO> controllerDTOs = new ArrayList<ERSEventFeedControllerDTO>();
		for (ERSEventFeedServiceDTO objects : dataServiceDTOs) {
			ERSEventFeedControllerDTO dataControllerDTO = new ERSEventFeedControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public List<ERSEventFeedPersistanceDTO> conversionForloadErsEventFeedTypes(List<Object[]> list) {
		List<ERSEventFeedPersistanceDTO> ersEventFeedPersistanceDTO = new ArrayList<ERSEventFeedPersistanceDTO>();
		for (Object[] objects : list) {
			ERSEventFeedPersistanceDTO objERSEventFeedPersistanceDTO = new ERSEventFeedPersistanceDTO();
			if (objects[0] != null) {
				objERSEventFeedPersistanceDTO.setTypeId(objects[0].toString());
			} else {
				objERSEventFeedPersistanceDTO.setTypeId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objERSEventFeedPersistanceDTO.setFeedName(objects[1].toString());
			} else {
				objERSEventFeedPersistanceDTO.setFeedName(CommonConstants.DATA_NOT_AVIALABLE);
			}			
			ersEventFeedPersistanceDTO.add(objERSEventFeedPersistanceDTO);
		}
		return ersEventFeedPersistanceDTO;
	}
	
	
}
