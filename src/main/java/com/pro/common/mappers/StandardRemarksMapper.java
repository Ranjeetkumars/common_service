/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.StandardRemarksControllerDTO;
import com.pro.common.persistencedto.StandardRemarksPersistenceDTO;
import com.pro.common.servicedto.StandardRemarksServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class StandardRemarksMapper {
	public List<StandardRemarksPersistenceDTO> convertObjetsArraytoStandardRemarksPersistenceDTOList(List<Object[]> list) {
		List<StandardRemarksPersistenceDTO> persistenceDTOs = new ArrayList<StandardRemarksPersistenceDTO>();
		for (Object[] objects : list) {
			StandardRemarksPersistenceDTO persistenceDTO = new StandardRemarksPersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setRemarkID(objects[0].toString());
			} else {
				persistenceDTO.setRemarkID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setRemarkName(objects[1].toString());
			} else {
				persistenceDTO.setRemarkName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			persistenceDTOs.add(persistenceDTO);
		}
		return persistenceDTOs;
	}
	
	public List<StandardRemarksServiceDTO> convertStandardRemarksPersistenceDTOListToStandardRemarksServiceDTOList(
			List<StandardRemarksPersistenceDTO> persistenceDTOs) {
		List<StandardRemarksServiceDTO> coRelationServiceDTOs = new ArrayList<StandardRemarksServiceDTO>();
		for (StandardRemarksPersistenceDTO objects : persistenceDTOs) {
			StandardRemarksServiceDTO languageServiceDTO = new StandardRemarksServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			coRelationServiceDTOs.add(languageServiceDTO);
		}
		return coRelationServiceDTOs;
	}
	

	public List<StandardRemarksControllerDTO> convertStandardRemarksServiceDTOListToStandardRemarksControllerDTO(
			List<StandardRemarksServiceDTO> persistenceDTOs) {
		List<StandardRemarksControllerDTO> languageServiceDTOs = new ArrayList<StandardRemarksControllerDTO>();
		for (StandardRemarksServiceDTO objects : persistenceDTOs) {
			StandardRemarksControllerDTO languageServiceDTO = new StandardRemarksControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
