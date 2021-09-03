package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GetDistrictRelatedToUser;
import com.pro.common.persistencedto.GetDistrictRelatedPersistenanceDTO;
import com.pro.common.servicedto.GetDistrictRelatedServiceDTO;
import com.pro.common.utills.CommonConstants;



public class GetDistrictRelatedMapper {
	public List<GetDistrictRelatedServiceDTO> convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(
			List<GetDistrictRelatedPersistenanceDTO> persistenceDTOs) {
		List<GetDistrictRelatedServiceDTO> breakTypeServiceDTOs = new ArrayList<GetDistrictRelatedServiceDTO>();
		for (GetDistrictRelatedPersistenanceDTO objects : persistenceDTOs) {
			GetDistrictRelatedServiceDTO serviceDTO = new GetDistrictRelatedServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			breakTypeServiceDTOs.add(serviceDTO);
		}
		return breakTypeServiceDTOs;
	}
	
	public List<GetDistrictRelatedToUser> convertGetDistrictSetServiceDTOToDistrictSetServiceDTOList(List<GetDistrictRelatedServiceDTO> dataServiceDTOs) {
		List<GetDistrictRelatedToUser> controllerDTOs = new ArrayList<GetDistrictRelatedToUser>();
		for (GetDistrictRelatedServiceDTO objects : dataServiceDTOs) {
			GetDistrictRelatedToUser dataControllerDTO = new GetDistrictRelatedToUser();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public GetDistrictRelatedServiceDTO convertDistrictRelatedControllerDTOToServiceDTO(GetDistrictRelatedToUser controllerDTO) {
		GetDistrictRelatedServiceDTO propertiesServiceDTO = new GetDistrictRelatedServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	
	public List<GetDistrictRelatedPersistenanceDTO> convertObjetsArraytoDistrictRelatedToUserPersistenceDTOList(List<Object[]> list) {
		List<GetDistrictRelatedPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<GetDistrictRelatedPersistenanceDTO>();
		for (Object[] objects : list) {
			GetDistrictRelatedPersistenanceDTO objCommonDataPersistenceDTO = new GetDistrictRelatedPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setDistrictid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setDistrictid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setDistrictName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setDistrictName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
