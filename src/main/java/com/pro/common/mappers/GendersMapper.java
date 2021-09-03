/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GendersControllerDTO;
import com.pro.common.persistencedto.GendersPersistenceDTO;
import com.pro.common.servicedto.GendersServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 * 16-05-2019
 */
public class GendersMapper {
	public List<GendersPersistenceDTO> convertObjetsArraytoGendersPersistenceDTOList(List<Object[]> list) {
		List<GendersPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GendersPersistenceDTO>();
		for (Object[] objects : list) {
			GendersPersistenceDTO objCommonDataPersistenceDTO = new GendersPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setGenderId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setGenderId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setGenderName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setGenderName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<GendersServiceDTO> convertGendersPersistenceDTOListToGendersServiceDTOList(
			List<GendersPersistenceDTO> persistenceDTOs) {
		List<GendersServiceDTO> commonDataServiceDTOs = new ArrayList<GendersServiceDTO>();
		for (GendersPersistenceDTO objects : persistenceDTOs) {
			GendersServiceDTO gisCommonDataServiceDTO = new GendersServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<GendersControllerDTO> convertGendersServiceDTOListToGendersControllerDTOList(List<GendersServiceDTO> dataServiceDTOs) {
		List<GendersControllerDTO> controllerDTOs = new ArrayList<GendersControllerDTO>();
		for (GendersServiceDTO objects : dataServiceDTOs) {
			GendersControllerDTO dataControllerDTO = new GendersControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
}
