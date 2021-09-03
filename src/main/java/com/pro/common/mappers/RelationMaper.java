/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.RelationControllerDTO;
import com.pro.common.persistencedto.RelationPersistenceDTO;
import com.pro.common.servicedto.RelationServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class RelationMaper {
	public List<RelationPersistenceDTO> convertObjetsArraytoRelationPersistenceDTOList(List<Object[]> list) {
		List<RelationPersistenceDTO> persistenceDTOs = new ArrayList<RelationPersistenceDTO>();
		for (Object[] objects : list) {
			RelationPersistenceDTO persistenceDTO = new RelationPersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setRelationId(objects[0].toString());
			} else {
				persistenceDTO.setRelationId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setRelationName(objects[1].toString());
			} else {
				persistenceDTO.setRelationName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			persistenceDTOs.add(persistenceDTO);
		}
		return persistenceDTOs;
	}
	
	public List<RelationServiceDTO> convertRelationServiceDTOListToRelationServiceDTOList(
			List<RelationPersistenceDTO> persistenceDTOs) {
		List<RelationServiceDTO> coRelationServiceDTOs = new ArrayList<RelationServiceDTO>();
		for (RelationPersistenceDTO objects : persistenceDTOs) {
			RelationServiceDTO languageServiceDTO = new RelationServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			coRelationServiceDTOs.add(languageServiceDTO);
		}
		return coRelationServiceDTOs;
	}
	

	public List<RelationControllerDTO> convertRelationServiceDTOListToRelationControllerDTO(
			List<RelationServiceDTO> persistenceDTOs) {
		List<RelationControllerDTO> languageServiceDTOs = new ArrayList<RelationControllerDTO>();
		for (RelationServiceDTO objects : persistenceDTOs) {
			RelationControllerDTO languageServiceDTO = new RelationControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
