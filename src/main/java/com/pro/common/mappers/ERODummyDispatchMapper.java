package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ERODummyDispatchControllerDTO;
import com.pro.common.persistencedto.ERODummyDispatchPersistenanceDTO;
import com.pro.common.servicedto.ERODummyDispatchServiceDTO;
import com.pro.common.utills.CommonConstants;



public class ERODummyDispatchMapper {
	public List<ERODummyDispatchServiceDTO> convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(
			List<ERODummyDispatchPersistenanceDTO> persistenceDTOs) {
		List<ERODummyDispatchServiceDTO> objEventIdBySearch = new ArrayList<ERODummyDispatchServiceDTO>();
		for (ERODummyDispatchPersistenanceDTO objects : persistenceDTOs) {
			ERODummyDispatchServiceDTO serviceDTO = new ERODummyDispatchServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			objEventIdBySearch.add(serviceDTO);
		}
		return objEventIdBySearch;
	}
	
	public List<ERODummyDispatchControllerDTO> convertGetDistrictSetServiceDTOToDistrictSetServiceDTOList(List<ERODummyDispatchServiceDTO> dataServiceDTOs) {
		List<ERODummyDispatchControllerDTO> controllerDTOs = new ArrayList<ERODummyDispatchControllerDTO>();
		for (ERODummyDispatchServiceDTO objects : dataServiceDTOs) {
			ERODummyDispatchControllerDTO dataControllerDTO = new ERODummyDispatchControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public ERODummyDispatchServiceDTO convertEventIdSearchRelatedControllerDTOToServiceDTO(ERODummyDispatchControllerDTO controllerDTO) {
		ERODummyDispatchServiceDTO propertiesServiceDTO = new ERODummyDispatchServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<ERODummyDispatchPersistenanceDTO> ConvertERODummyDispatch(List<Object[]> list) {
		List<ERODummyDispatchPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<ERODummyDispatchPersistenanceDTO>();
		for (Object[] objects : list) {
			ERODummyDispatchPersistenanceDTO objCommonDataPersistenceDTO = new ERODummyDispatchPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEventid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEventid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setVehicleid(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setVehicleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setAmb_reg_no(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setAmb_reg_no(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setAddress(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setAddress(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objCommonDataPersistenceDTO.setCallerNo(objects[4].toString());
			} else {
				objCommonDataPersistenceDTO.setCallerNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objCommonDataPersistenceDTO.setEroid(objects[5].toString());
			} else {
				objCommonDataPersistenceDTO.setEroid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objCommonDataPersistenceDTO.setEro_ext(objects[6].toString());
			} else {
				objCommonDataPersistenceDTO.setEro_ext(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objCommonDataPersistenceDTO.setDuration(objects[7].toString());
			} else {
				objCommonDataPersistenceDTO.setDuration(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
