/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.SkillsSetControllerDTO;
import com.pro.common.persistencedto.SkillsSetPersistenceDTO;
import com.pro.common.servicedto.SkillsSetServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class SkillsSetMapper {
	public List<SkillsSetPersistenceDTO> convertObjetsArraytoSkillsSetPersistenceDTOList(List<Object[]> list) {
		List<SkillsSetPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<SkillsSetPersistenceDTO>();
		for (Object[] objects : list) {
			SkillsSetPersistenceDTO objCommonDataPersistenceDTO = new SkillsSetPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setModulename(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setModulename(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setModuleid(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setModuleid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setSkillsetid(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setSkillsetid("0");
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<SkillsSetServiceDTO> convertSkillsSetPersistenceDTOListToSkillsSetServiceDTOList(
			List<SkillsSetPersistenceDTO> persistenceDTOs) {
		List<SkillsSetServiceDTO> breakTypeServiceDTOs = new ArrayList<SkillsSetServiceDTO>();
		for (SkillsSetPersistenceDTO objects : persistenceDTOs) {
			SkillsSetServiceDTO serviceDTO = new SkillsSetServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			breakTypeServiceDTOs.add(serviceDTO);
		}
		return breakTypeServiceDTOs;
	}
	
	public List<SkillsSetControllerDTO> convertSkillsSetServiceDTOToSkillsSetServiceDTOList(List<SkillsSetServiceDTO> dataServiceDTOs) {
		List<SkillsSetControllerDTO> controllerDTOs = new ArrayList<SkillsSetControllerDTO>();
		for (SkillsSetServiceDTO objects : dataServiceDTOs) {
			SkillsSetControllerDTO dataControllerDTO = new SkillsSetControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
}
