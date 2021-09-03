package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.EventIdBySearchControllerDTO;
import com.pro.common.persistencedto.EventIdBySearchPersistenanceDTO;
import com.pro.common.servicedto.EventIdBySearchServiceDTO;
import com.pro.common.utills.CommonConstants;

public class EventIdBySearchMapper {
	public List<EventIdBySearchServiceDTO> convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(
			List<EventIdBySearchPersistenanceDTO> persistenceDTOs) {
		List<EventIdBySearchServiceDTO> objEventIdBySearch = new ArrayList<EventIdBySearchServiceDTO>();
		for (EventIdBySearchPersistenanceDTO objects : persistenceDTOs) {
			EventIdBySearchServiceDTO serviceDTO = new EventIdBySearchServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			objEventIdBySearch.add(serviceDTO);
		}
		return objEventIdBySearch;
	}
	
	public List<EventIdBySearchControllerDTO> convertGetDistrictSetServiceDTOToDistrictSetServiceDTOList(List<EventIdBySearchServiceDTO> dataServiceDTOs) {
		List<EventIdBySearchControllerDTO> controllerDTOs = new ArrayList<EventIdBySearchControllerDTO>();
		for (EventIdBySearchServiceDTO objects : dataServiceDTOs) {
			EventIdBySearchControllerDTO dataControllerDTO = new EventIdBySearchControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public EventIdBySearchServiceDTO convertEventIdSearchRelatedControllerDTOToServiceDTO(EventIdBySearchControllerDTO controllerDTO) {
		EventIdBySearchServiceDTO propertiesServiceDTO = new EventIdBySearchServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	
	public List<EventIdBySearchPersistenanceDTO> convertObjetsArraytoEventIdSearch(List<Object[]> list) {
		List<EventIdBySearchPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<EventIdBySearchPersistenanceDTO>();
		for (Object[] objects : list) {
			EventIdBySearchPersistenanceDTO objCommonDataPersistenceDTO = new EventIdBySearchPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEventid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEventid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setVehicleNO(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setVehicleNO(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setEventdate(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setEventdate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setCreatedbyid(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setCreatedbyid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objCommonDataPersistenceDTO.setCreatedByRoleid(objects[4].toString());
			} else {
				objCommonDataPersistenceDTO.setCreatedByRoleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
