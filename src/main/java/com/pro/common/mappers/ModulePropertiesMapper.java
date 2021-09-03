/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ModulePropertiesControllerDTO;
import com.pro.common.persistencedto.ModulePropertiesPersistenceDTO;
import com.pro.common.servicedto.ModulePropertiesServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class ModulePropertiesMapper {
	public List<ModulePropertiesPersistenceDTO> convertObjetsArraytoModulePropertiesPersistenceDTOList(List<Object[]> list) {
		List<ModulePropertiesPersistenceDTO> persistenceDTOs = new ArrayList<ModulePropertiesPersistenceDTO>();
		for (Object[] objects : list) {
			ModulePropertiesPersistenceDTO persistenceDTO = new ModulePropertiesPersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setKey(objects[0].toString());
			} else {
				persistenceDTO.setKey(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setValue(objects[1].toString());
			} else {
				persistenceDTO.setValue(CommonConstants.DATA_NOT_AVIALABLE);
			}
			persistenceDTOs.add(persistenceDTO);
		}
		return persistenceDTOs;
	}
	public List<ModulePropertiesServiceDTO> convertModulePropertiesPersistenceDTOListToModulePropertiesServiceDTOList(
			List<ModulePropertiesPersistenceDTO> persistenceDTOs) {
		List<ModulePropertiesServiceDTO> coRelationServiceDTOs = new ArrayList<ModulePropertiesServiceDTO>();
		for (ModulePropertiesPersistenceDTO objects : persistenceDTOs) {
			ModulePropertiesServiceDTO languageServiceDTO = new ModulePropertiesServiceDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			coRelationServiceDTOs.add(languageServiceDTO);
		}
		return coRelationServiceDTOs;
	}

	public List<ModulePropertiesControllerDTO> convertModulePropertiesServiceDTOListToModulePropertiesControllerDTO(
			List<ModulePropertiesServiceDTO> persistenceDTOs) {
		List<ModulePropertiesControllerDTO> languageServiceDTOs = new ArrayList<ModulePropertiesControllerDTO>();
		for (ModulePropertiesServiceDTO objects : persistenceDTOs) {
			ModulePropertiesControllerDTO languageServiceDTO = new ModulePropertiesControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	
	public ModulePropertiesServiceDTO convertModulePropertiesControllerDTOtoModulePropertiesServiceDTO(ModulePropertiesControllerDTO controllerDTO) {
		ModulePropertiesServiceDTO propertiesServiceDTO = new ModulePropertiesServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
}
