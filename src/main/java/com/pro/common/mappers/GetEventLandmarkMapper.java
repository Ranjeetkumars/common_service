
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GetEventLandmarkControllerDTO;
import com.pro.common.persistencedto.CTIPersistanceDTO;
import com.pro.common.persistencedto.GetEventLandmarkPersistanceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author : Habiboon Patan
 */
public class GetEventLandmarkMapper {

	public GetEventLandmarkServiceDTO convertControllerDTOtoServiceDTO(GetEventLandmarkControllerDTO controllerDTO) {
		GetEventLandmarkServiceDTO propertiesServiceDTO = new GetEventLandmarkServiceDTO();
		BeanUtils.copyProperties(controllerDTO, propertiesServiceDTO);
		return propertiesServiceDTO;
	}

	public List<GetEventLandmarkServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<GetEventLandmarkPersistanceDTO> persistenceDTOs) {
		List<GetEventLandmarkServiceDTO> getEventLandmarkServiceDTO = new ArrayList<GetEventLandmarkServiceDTO>();
		for (GetEventLandmarkPersistanceDTO objects : persistenceDTOs) {
			GetEventLandmarkServiceDTO objGetEventLandmarkServiceDTO = new GetEventLandmarkServiceDTO();
			BeanUtils.copyProperties(objects, objGetEventLandmarkServiceDTO);
			getEventLandmarkServiceDTO.add(objGetEventLandmarkServiceDTO);
		}
		return getEventLandmarkServiceDTO;
	}

	public List<GetEventLandmarkControllerDTO> convertServiceDTOtoControllerDTO(
			List<GetEventLandmarkServiceDTO> dataServiceDTOs) {
		List<GetEventLandmarkControllerDTO> controllerDTOs = new ArrayList<GetEventLandmarkControllerDTO>();
		for (GetEventLandmarkServiceDTO objects : dataServiceDTOs) {
			GetEventLandmarkControllerDTO dataControllerDTO = new GetEventLandmarkControllerDTO();
			BeanUtils.copyProperties(objects, dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}

	public List<GetEventLandmarkPersistanceDTO> conversiongetEventLandmark(List<Object[]> list) {
		List<GetEventLandmarkPersistanceDTO> getEventLandmarkPersistanceDTO = new ArrayList<GetEventLandmarkPersistanceDTO>();
		for (Object[] objects : list) {
			GetEventLandmarkPersistanceDTO objGetEventLandmarkPersistanceDTO = new GetEventLandmarkPersistanceDTO();
			if (objects[0] != null) {
				objGetEventLandmarkPersistanceDTO.setLandMarkBlockId(objects[0].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setLandMarkBlockId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objGetEventLandmarkPersistanceDTO.setLm_lname(objects[1].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setLm_lname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objGetEventLandmarkPersistanceDTO.setL_lname(objects[2].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setL_lname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objGetEventLandmarkPersistanceDTO.setCt_lname(objects[3].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setCt_lname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objGetEventLandmarkPersistanceDTO.setMdl_lname(objects[4].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setMdl_lname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objGetEventLandmarkPersistanceDTO.setDs_lname(objects[5].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setDs_lname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objGetEventLandmarkPersistanceDTO.setDistrictid(objects[6].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setDistrictid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objGetEventLandmarkPersistanceDTO.setMandalid(objects[7].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setMandalid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objGetEventLandmarkPersistanceDTO.setCityId(objects[8].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setCityId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objGetEventLandmarkPersistanceDTO.setLocalityId(objects[9].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setLocalityId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objGetEventLandmarkPersistanceDTO.setLandmarkId(objects[10].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setLandmarkId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			getEventLandmarkPersistanceDTO.add(objGetEventLandmarkPersistanceDTO);
		}
		return getEventLandmarkPersistanceDTO;
	}

	
}
