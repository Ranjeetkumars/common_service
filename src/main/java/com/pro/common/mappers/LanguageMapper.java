/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.LanguageControllerDTO;
import com.pro.common.persistencedto.LanguagePersistenceDTO;
import com.pro.common.servicedto.LanguageServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class LanguageMapper {
	public List<LanguagePersistenceDTO> convertObjetsArraytoLanguagePersistenceDTOList(List<Object[]> list) {
		List<LanguagePersistenceDTO> commonDataPersistenceDTOs = new ArrayList<LanguagePersistenceDTO>();
		for (Object[] objects : list) {
			LanguagePersistenceDTO persistenceDTO = new LanguagePersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setLanguageID(objects[0].toString());
			} else {
				persistenceDTO.setLanguageID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setLanguageName(objects[1].toString());
			} else {
				persistenceDTO.setLanguageName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(persistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<LanguageServiceDTO> convertLanguagePersistenceDTOListToLanguageServiceDTO(
			List<LanguagePersistenceDTO> persistenceDTOs) {
		List<LanguageServiceDTO> languageServiceDTOs = new ArrayList<LanguageServiceDTO>();
		for (LanguagePersistenceDTO objects : persistenceDTOs) {
			LanguageServiceDTO languageServiceDTO = new LanguageServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	

	public List<LanguageControllerDTO> convertLanguageServiceDTOListToLanguageControllerDTO(
			List<LanguageServiceDTO> persistenceDTOs) {
		List<LanguageControllerDTO> languageServiceDTOs = new ArrayList<LanguageControllerDTO>();
		for (LanguageServiceDTO objects : persistenceDTOs) {
			LanguageControllerDTO languageServiceDTO = new LanguageControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
