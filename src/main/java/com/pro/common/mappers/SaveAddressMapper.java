package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.SaveAddressControllerDTO;
import com.pro.common.persistencedto.SaveAddressPersistenanceDTO;
import com.pro.common.servicedto.SaveAddressServiceDTO;
import com.pro.common.utills.CommonConstants;

public class SaveAddressMapper {
	public List<SaveAddressPersistenanceDTO> conversionSaveAddress(List<Object[]> list) {
		List<SaveAddressPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<SaveAddressPersistenanceDTO>();
		for (Object[] objects : list) {
			SaveAddressPersistenanceDTO persistenceDTO = new SaveAddressPersistenanceDTO();
			if (objects[0] != null) {
				persistenceDTO.setEventid(objects[0].toString());
			} else {
				persistenceDTO.setEventid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setHouseno(objects[1].toString());
			} else {
				persistenceDTO.setHouseno(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				persistenceDTO.setLaneStreet(objects[2].toString());
			} else {
				persistenceDTO.setLaneStreet(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				persistenceDTO.setLandmarkid(objects[3].toString());
			} else {
				persistenceDTO.setLandmarkid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				persistenceDTO.setLocalityid(objects[4].toString());
			} else {
				persistenceDTO.setLocalityid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				persistenceDTO.setCityid(objects[5].toString());
			} else {
				persistenceDTO.setCityid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				persistenceDTO.setMandalid(objects[6].toString());
			} else {
				persistenceDTO.setMandalid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				persistenceDTO.setDistrictid(objects[7].toString());
			} else {
				persistenceDTO.setDistrictid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				persistenceDTO.setUserid(objects[8].toString());
			} else {
				persistenceDTO.setUserid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				persistenceDTO.setModuleid(objects[9].toString());
			} else {
				persistenceDTO.setModuleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				persistenceDTO.setRoleid(objects[10].toString());
			} else {
				persistenceDTO.setRoleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(persistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<SaveAddressServiceDTO> convertEventStatusPersistenceDTOListToEventStatusServiceDTO(
			List<SaveAddressPersistenanceDTO> persistenceDTOs) {
		List<SaveAddressServiceDTO> languageServiceDTOs = new ArrayList<SaveAddressServiceDTO>();
		for (SaveAddressPersistenanceDTO objects : persistenceDTOs) {
			SaveAddressServiceDTO languageServiceDTO = new SaveAddressServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	

	public List<SaveAddressControllerDTO> convertEventStatusServiceDTOToEventStatusControllerDTO(
			List<SaveAddressServiceDTO> persistenceDTOs) {
		List<SaveAddressControllerDTO> languageServiceDTOs = new ArrayList<SaveAddressControllerDTO>();
		for (SaveAddressServiceDTO objects : persistenceDTOs) {
			SaveAddressControllerDTO languageServiceDTO = new SaveAddressControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	
	public SaveAddressServiceDTO convertVehicleIdbasedOnEMTNoControllerDTOToServiceDTO(SaveAddressControllerDTO controllerDTO) {
		SaveAddressServiceDTO propertiesServiceDTO = new SaveAddressServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
}
