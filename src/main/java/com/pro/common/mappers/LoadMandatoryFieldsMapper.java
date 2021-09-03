
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.LoadMandatoryFieldsControllerDTO;
import com.pro.common.persistencedto.LoadMandatoryFieldsPersistanceDTO;
import com.pro.common.servicedto.LoadMandatoryFieldsServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author : Habiboon Patan
 * @DATE: 17-07-2019
 */
public class LoadMandatoryFieldsMapper {
	
	public LoadMandatoryFieldsServiceDTO convertControllerDTOtoServiceDTO(LoadMandatoryFieldsControllerDTO controllerDTO) {
		LoadMandatoryFieldsServiceDTO objLoadMandatoryFieldsServiceDTO = new LoadMandatoryFieldsServiceDTO();
		BeanUtils.copyProperties(controllerDTO,objLoadMandatoryFieldsServiceDTO);
		return objLoadMandatoryFieldsServiceDTO;
	}

	
	public List<LoadMandatoryFieldsServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<LoadMandatoryFieldsPersistanceDTO> persistenceDTOs) {
		List<LoadMandatoryFieldsServiceDTO> objLoadMandatoryFieldsServiceDTO = new ArrayList<LoadMandatoryFieldsServiceDTO>();
		for (LoadMandatoryFieldsPersistanceDTO objects : persistenceDTOs) {
			LoadMandatoryFieldsServiceDTO loadMandatoryFieldsServiceDTO = new LoadMandatoryFieldsServiceDTO();
			BeanUtils.copyProperties(objects,loadMandatoryFieldsServiceDTO);
			objLoadMandatoryFieldsServiceDTO.add(loadMandatoryFieldsServiceDTO);
		}
		return objLoadMandatoryFieldsServiceDTO;
	}
	
	public List<LoadMandatoryFieldsControllerDTO> convertServiceDTOtoControllerDTO(List<LoadMandatoryFieldsServiceDTO> dataServiceDTOs) {
		List<LoadMandatoryFieldsControllerDTO> controllerDTOs = new ArrayList<LoadMandatoryFieldsControllerDTO>();
		for (LoadMandatoryFieldsServiceDTO objects : dataServiceDTOs) {
			LoadMandatoryFieldsControllerDTO dataControllerDTO = new LoadMandatoryFieldsControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public List<LoadMandatoryFieldsPersistanceDTO> conversionForloadModuleFields(List<Object[]> list) {
		List<LoadMandatoryFieldsPersistanceDTO> loadMandatoryFieldsPersistanceDTO = new ArrayList<LoadMandatoryFieldsPersistanceDTO>();
		for (Object[] objects : list) {
			LoadMandatoryFieldsPersistanceDTO objLoadMandatoryFieldsPersistanceDTO = new LoadMandatoryFieldsPersistanceDTO();
			if (objects[0] != null) {
				objLoadMandatoryFieldsPersistanceDTO.setScreenId(objects[0].toString());
			} else {
				objLoadMandatoryFieldsPersistanceDTO.setScreenId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objLoadMandatoryFieldsPersistanceDTO.setFieldsName(objects[1].toString());
			} else {
				objLoadMandatoryFieldsPersistanceDTO.setFieldsName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objLoadMandatoryFieldsPersistanceDTO.setStatus(objects[2].toString());
			} else {
				objLoadMandatoryFieldsPersistanceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			loadMandatoryFieldsPersistanceDTO.add(objLoadMandatoryFieldsPersistanceDTO);
		}
		return loadMandatoryFieldsPersistanceDTO;
	}
	public List<LoadMandatoryFieldsPersistanceDTO> conversionForloadScreenMandatoryFields(List<Object[]> list) {
		List<LoadMandatoryFieldsPersistanceDTO> loadMandatoryFieldsPersistanceDTO = new ArrayList<LoadMandatoryFieldsPersistanceDTO>();
		for (Object[] objects : list) {
			LoadMandatoryFieldsPersistanceDTO objLoadMandatoryFieldsPersistanceDTO = new LoadMandatoryFieldsPersistanceDTO();
			if (objects[0] != null) {
				objLoadMandatoryFieldsPersistanceDTO.setFieldsName(objects[0].toString());
			} else {
				objLoadMandatoryFieldsPersistanceDTO.setFieldsName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objLoadMandatoryFieldsPersistanceDTO.setStatus(objects[1].toString());
			} else {
				objLoadMandatoryFieldsPersistanceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			loadMandatoryFieldsPersistanceDTO.add(objLoadMandatoryFieldsPersistanceDTO);
		}
		return loadMandatoryFieldsPersistanceDTO;
	}
	
}
