/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.CheifComplaintControllerDTO;
import com.pro.common.persistencedto.CheifComplaintPersistenceDTO;
import com.pro.common.servicedto.CheifComplaintServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class CheifComplaintMapper {
	public List<CheifComplaintPersistenceDTO> convertObjetsArraytoCheifComplaintPersistenceDTOList(List<Object[]> list) {
		List<CheifComplaintPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<CheifComplaintPersistenceDTO>();
		for (Object[] objects : list) {
			CheifComplaintPersistenceDTO persistenceDTO = new CheifComplaintPersistenceDTO();
			if (objects[0] != null) {
				persistenceDTO.setChiefCompliantId(objects[0].toString());
			} else {
				persistenceDTO.setChiefCompliantId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setChiefComplaintname(objects[1].toString());
			} else {
				persistenceDTO.setChiefComplaintname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				persistenceDTO.setChiefComplaintname_sec(objects[2].toString());
			} else {
				persistenceDTO.setChiefComplaintname_sec(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				persistenceDTO.setChiefComplaintname_third(objects[3].toString());
			} else {
				persistenceDTO.setChiefComplaintname_third(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				persistenceDTO.setChiefComplaintname_fourth(objects[4].toString());
			} else {
				persistenceDTO.setChiefComplaintname_fourth(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(persistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<CheifComplaintServiceDTO> convertCheifComplaintPersistenceDTOListToCheifComplaintServiceDTOList(
			List<CheifComplaintPersistenceDTO> persistenceDTOs) {
		List<CheifComplaintServiceDTO> languageServiceDTOs = new ArrayList<CheifComplaintServiceDTO>();
		for (CheifComplaintPersistenceDTO objects : persistenceDTOs) {
			CheifComplaintServiceDTO languageServiceDTO = new CheifComplaintServiceDTO();
			BeanUtils.copyProperties(objects,languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
	

	public List<CheifComplaintControllerDTO> convertCheifComplaintServiceDTOListToCheifComplaintControllerDTO(
			List<CheifComplaintServiceDTO> persistenceDTOs) {
		List<CheifComplaintControllerDTO> languageServiceDTOs = new ArrayList<CheifComplaintControllerDTO>();
		for (CheifComplaintServiceDTO objects : persistenceDTOs) {
			CheifComplaintControllerDTO languageServiceDTO = new CheifComplaintControllerDTO();
			BeanUtils.copyProperties(objects, languageServiceDTO);
			languageServiceDTOs.add(languageServiceDTO);
		}
		return languageServiceDTOs;
	}
}
