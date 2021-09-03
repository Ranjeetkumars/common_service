/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ServityTypeControllerDTO;
import com.pro.common.persistencedto.ServityTypePersistenceDTO;
import com.pro.common.servicedto.ServityTypeServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class ServityTypeMapper {
	public List<ServityTypePersistenceDTO> convertObjetsArraytoRelationPersistenceDTOList(List<Object[]> list) {
		List<ServityTypePersistenceDTO> persistenceDTOs = new ArrayList<ServityTypePersistenceDTO>();
		for (Object[] objects : list) {
			ServityTypePersistenceDTO persistenceDTO = new ServityTypePersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setServityTypeID(objects[0].toString());
			} else {
				persistenceDTO.setServityTypeID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setServityTypeName(objects[1].toString());
			} else {
				persistenceDTO.setServityTypeName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			persistenceDTOs.add(persistenceDTO);
		}
		return persistenceDTOs;
	}

	public List<ServityTypeServiceDTO> convertServityTypePersistenceDTOListToServityTypeServiceDTOList(
			List<ServityTypePersistenceDTO> persistenceDTOs) {
		List<ServityTypeServiceDTO> coRelationServiceDTOs = new ArrayList<ServityTypeServiceDTO>();
		for (ServityTypePersistenceDTO objects : persistenceDTOs) {
			ServityTypeServiceDTO languageServiceDTO = new ServityTypeServiceDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			coRelationServiceDTOs.add(languageServiceDTO);
		}
		return coRelationServiceDTOs;
	}

	public List<ServityTypeControllerDTO> convertServityTypeServiceDTOListToServityTypeControllerDTO(
			List<ServityTypeServiceDTO> persistenceDTOs) {
		List<ServityTypeControllerDTO> languageServiceDTOs = new ArrayList<ServityTypeControllerDTO>();
		for (ServityTypeServiceDTO objects : persistenceDTOs) {
			ServityTypeControllerDTO languageServiceDTO = new ServityTypeControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
