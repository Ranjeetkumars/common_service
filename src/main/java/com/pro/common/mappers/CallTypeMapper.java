/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.CallTypeControllerDTO;
import com.pro.common.persistencedto.CallTypePersistenceDTO;
import com.pro.common.servicedto.CallTypeServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class CallTypeMapper {
	public List<CallTypePersistenceDTO> convertObjetsArraytoGISCallTypePersistenceDTOList(List<Object[]> list) {
		List<CallTypePersistenceDTO> commonDataPersistenceDTOs = new ArrayList<CallTypePersistenceDTO>();
		for (Object[] objects : list) {
			CallTypePersistenceDTO objCommonDataPersistenceDTO = new CallTypePersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setCallTypeID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setCallTypeID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setCallTypeName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setCallTypeName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<CallTypeServiceDTO> convertCallTypePersistenceDTOListToCallTypeServiceDTOList(
			List<CallTypePersistenceDTO> persistenceDTOs) {
		List<CallTypeServiceDTO> commonDataServiceDTOs = new ArrayList<CallTypeServiceDTO>();
		for (CallTypePersistenceDTO objects : persistenceDTOs) {
			CallTypeServiceDTO gisCommonDataServiceDTO = new CallTypeServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<CallTypeControllerDTO> convertCallTypeServiceDTOListToCallTypeControllerDTOList(List<CallTypeServiceDTO> dataServiceDTOs) {
		List<CallTypeControllerDTO> controllerDTOs = new ArrayList<CallTypeControllerDTO>();
		for (CallTypeServiceDTO objects : dataServiceDTOs) {
			CallTypeControllerDTO dataControllerDTO = new CallTypeControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
}
