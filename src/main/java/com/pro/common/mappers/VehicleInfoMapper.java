
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.VehicleInfoControllerDTO;
import com.pro.common.persistencedto.VehicleInfoPersistanceDTO;
import com.pro.common.servicedto.VehicleInfoServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author : Habiboon Patan
 * @DATE: 16-07-2019
 */
public class VehicleInfoMapper {

	public VehicleInfoServiceDTO convertControllerDTOtoServiceDTO(VehicleInfoControllerDTO controllerDTO) {
		VehicleInfoServiceDTO propertiesServiceDTO = new VehicleInfoServiceDTO();
		BeanUtils.copyProperties(controllerDTO, propertiesServiceDTO);
		return propertiesServiceDTO;
	}

	public List<VehicleInfoServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<VehicleInfoPersistanceDTO> persistenceDTOs) {
		List<VehicleInfoServiceDTO> vehicleInfoServiceDTO = new ArrayList<VehicleInfoServiceDTO>();
		for (VehicleInfoPersistanceDTO objects : persistenceDTOs) {
			VehicleInfoServiceDTO objVehicleInfoServiceDTO = new VehicleInfoServiceDTO();
			BeanUtils.copyProperties(objects, objVehicleInfoServiceDTO);
			vehicleInfoServiceDTO.add(objVehicleInfoServiceDTO);
		}
		return vehicleInfoServiceDTO;
	}

	public List<VehicleInfoControllerDTO> convertServiceDTOtoControllerDTO(
			List<VehicleInfoServiceDTO> dataServiceDTOs) {
		List<VehicleInfoControllerDTO> controllerDTOs = new ArrayList<VehicleInfoControllerDTO>();
		for (VehicleInfoServiceDTO objects : dataServiceDTOs) {
			VehicleInfoControllerDTO dataControllerDTO = new VehicleInfoControllerDTO();
			BeanUtils.copyProperties(objects, dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}

	public List<VehicleInfoPersistanceDTO> conversionForVehicleInformation(List<Object[]> list) {
		List<VehicleInfoPersistanceDTO> vehicleInfoPersistanceDTO = new ArrayList<VehicleInfoPersistanceDTO>();
		for (Object[] objects : list) {
			VehicleInfoPersistanceDTO objVehicleInfoPersistanceDTO = new VehicleInfoPersistanceDTO();
			if (objects[0] != null) {
				objVehicleInfoPersistanceDTO.setVehicleNo(objects[0].toString());
			} else {
				objVehicleInfoPersistanceDTO.setVehicleNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objVehicleInfoPersistanceDTO.setEmt(objects[1].toString());
			} else {
				objVehicleInfoPersistanceDTO.setEmt(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objVehicleInfoPersistanceDTO.setDriver(objects[2].toString());
			} else {
				objVehicleInfoPersistanceDTO.setDriver(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objVehicleInfoPersistanceDTO.setVehicleType(objects[3].toString());
			} else {
				objVehicleInfoPersistanceDTO.setVehicleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objVehicleInfoPersistanceDTO.setContactNo(objects[4].toString());
			} else {
				objVehicleInfoPersistanceDTO.setContactNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objVehicleInfoPersistanceDTO.setAddress(objects[5].toString());
			} else {
				objVehicleInfoPersistanceDTO.setAddress(CommonConstants.DATA_NOT_AVIALABLE);
			}
			vehicleInfoPersistanceDTO.add(objVehicleInfoPersistanceDTO);
		}
		return vehicleInfoPersistanceDTO;
	}
	public List<VehicleInfoPersistanceDTO> conversionForInfrastructure(List<Object[]> list) {
		List<VehicleInfoPersistanceDTO> vehicleInfoPersistanceDTO = new ArrayList<VehicleInfoPersistanceDTO>();
		for (Object[] objects : list) {
			VehicleInfoPersistanceDTO objVehicleInfoPersistanceDTO = new VehicleInfoPersistanceDTO();
			if (objects[0] != null) {
				objVehicleInfoPersistanceDTO.setInverntoryName(objects[0].toString());
			} else {
				objVehicleInfoPersistanceDTO.setInverntoryName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objVehicleInfoPersistanceDTO.setQuantity(objects[1].toString());
			} else {
				objVehicleInfoPersistanceDTO.setQuantity(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			vehicleInfoPersistanceDTO.add(objVehicleInfoPersistanceDTO);
		}
		return vehicleInfoPersistanceDTO;
	}
}
