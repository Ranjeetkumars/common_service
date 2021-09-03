/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.EmGroupWiseCompControllerDTO;
import com.pro.common.persistencedto.EmGroupWiseCompPersistenceDTO;
import com.pro.common.servicedto.EmGroupWiseCompServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class EmGroupWiseCompMapper {
	
	public List<EmGroupWiseCompPersistenceDTO> convertObjetsArraytoEmGroupWiseCompPersistenceDTOList(List<Object[]> list) {
		List<EmGroupWiseCompPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<EmGroupWiseCompPersistenceDTO>();
		for (Object[] objects : list) {
			EmGroupWiseCompPersistenceDTO objCommonDataPersistenceDTO = new EmGroupWiseCompPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEmergencyGroupID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyGroupID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setEmergencyGroupName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<EmGroupWiseCompPersistenceDTO> convertObjetsArraytoEmGroupWiseCompPersistenceDTOList_cheifcomp(List<Object[]> list) {
		List<EmGroupWiseCompPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<EmGroupWiseCompPersistenceDTO>();
		for (Object[] objects : list) {
			EmGroupWiseCompPersistenceDTO objCommonDataPersistenceDTO = new EmGroupWiseCompPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEmergencyCheifCompId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyCheifCompId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setEmergencyCheifCompName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyCheifCompName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setEmergencyGroupID(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyGroupID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setEmergencyGroupName(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<EmGroupWiseCompServiceDTO> convertEmGroupWiseCompPersistenceDTOListToEmGroupWiseCompServiceDTOList(
			List<EmGroupWiseCompPersistenceDTO> persistenceDTOs) {
		List<EmGroupWiseCompServiceDTO> commonDataServiceDTOs = new ArrayList<EmGroupWiseCompServiceDTO>();
		for (EmGroupWiseCompPersistenceDTO objects : persistenceDTOs) {
			EmGroupWiseCompServiceDTO gisCommonDataServiceDTO = new EmGroupWiseCompServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<EmGroupWiseCompControllerDTO> convertEmGroupWiseCompServiceDTOToEmGroupWiseCompControllerDTOList(List<EmGroupWiseCompServiceDTO> dataServiceDTOs) {
		List<EmGroupWiseCompControllerDTO> controllerDTOs = new ArrayList<EmGroupWiseCompControllerDTO>();
		for (EmGroupWiseCompServiceDTO objects : dataServiceDTOs) {
			EmGroupWiseCompControllerDTO dataControllerDTO = new EmGroupWiseCompControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public List<EmGroupWiseCompPersistenceDTO> convertObjetsArraytoEmGroupWiseCompPersistenceDTOListForGenderWiseChiefCompl(List<Object[]> list) {
		List<EmGroupWiseCompPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<EmGroupWiseCompPersistenceDTO>();
		for (Object[] objects : list) {
			EmGroupWiseCompPersistenceDTO objCommonDataPersistenceDTO = new EmGroupWiseCompPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEmergencyCheifCompId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyCheifCompId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setEmergencyCheifCompName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setEmergencyCheifCompName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
