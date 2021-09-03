package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.VehicleIdBasedOnEMTNoControllerDTO;

import com.pro.common.persistencedto.VehicleIdBasedOnEMTNoPersistenanceDTO;
import com.pro.common.servicedto.VehicleIdBasedOnEMTnoServiceDTO;
import com.pro.common.utills.CommonConstants;



public class VehilceIdBasedOnEmtNoMapper {
	public List<VehicleIdBasedOnEMTnoServiceDTO> convertVehicleIdbasedOnEMTNoPersistenceDTOListToVehicleIdbasedOnEMTNoServiceDTOList(
			List<VehicleIdBasedOnEMTNoPersistenanceDTO> persistenceDTOs) {
		List<VehicleIdBasedOnEMTnoServiceDTO> objEventIdBySearch = new ArrayList<VehicleIdBasedOnEMTnoServiceDTO>();
		for (VehicleIdBasedOnEMTNoPersistenanceDTO objects : persistenceDTOs) {
			VehicleIdBasedOnEMTnoServiceDTO serviceDTO = new VehicleIdBasedOnEMTnoServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			objEventIdBySearch.add(serviceDTO);
		}
		return objEventIdBySearch;
	}
	
	public List<VehicleIdBasedOnEMTNoControllerDTO> convertVehicleIdbasedOnEMTNoServiceDTOToVehicleIdbasedOnEMTNoControllerDTOList(List<VehicleIdBasedOnEMTnoServiceDTO> dataServiceDTOs) {
		List<VehicleIdBasedOnEMTNoControllerDTO> controllerDTOs = new ArrayList<VehicleIdBasedOnEMTNoControllerDTO>();
		for (VehicleIdBasedOnEMTnoServiceDTO objects : dataServiceDTOs) {
			VehicleIdBasedOnEMTNoControllerDTO dataControllerDTO = new VehicleIdBasedOnEMTNoControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public VehicleIdBasedOnEMTnoServiceDTO convertVehicleIdbasedOnEMTNoControllerDTOToServiceDTO(VehicleIdBasedOnEMTNoControllerDTO controllerDTO) {
		VehicleIdBasedOnEMTnoServiceDTO propertiesServiceDTO = new VehicleIdBasedOnEMTnoServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	
	public List<VehicleIdBasedOnEMTNoPersistenanceDTO> convertVehicleIdBasedOnEMTNO(List<Object[]> list) {
		List<VehicleIdBasedOnEMTNoPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<VehicleIdBasedOnEMTNoPersistenanceDTO>();
		for (Object objects : list) {
			VehicleIdBasedOnEMTNoPersistenanceDTO objCommonDataPersistenceDTO = new VehicleIdBasedOnEMTNoPersistenanceDTO();
			if (objects != null) {
				objCommonDataPersistenceDTO.setVehicleid(objects.toString());
			} else {
				objCommonDataPersistenceDTO.setVehicleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
