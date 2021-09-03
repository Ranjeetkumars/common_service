
package com.pro.common.mappers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.common.controllerdto.CTIControllerDTO;
import com.pro.common.controllerdto.GetEventLandmarkControllerDTO;
import com.pro.common.persistencedto.CTIPersistanceDTO;
import com.pro.common.persistencedto.GetEventLandmarkPersistanceDTO;
import com.pro.common.servicedto.CTIServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;
import com.pro.common.utills.CommonConstants;
/**
 * @author Habiboon Patan
 * @Date : 21-05-2019
 */

public class CTIDataMapper {
	public CTIServiceDTO convertforControllerDTOtoServiceDTO(CTIControllerDTO controllerDTO) {
		CTIServiceDTO cTIServiceDTO = new CTIServiceDTO();
		BeanUtils.copyProperties(controllerDTO,cTIServiceDTO);
		return cTIServiceDTO;
	}
	public List<CTIControllerDTO> convertServiceDTOtoControllerDTO(
			List<CTIServiceDTO> dataServiceDTOs) {
		List<CTIControllerDTO> controllerDTOs = new ArrayList<CTIControllerDTO>();
		for (CTIServiceDTO objects : dataServiceDTOs) {
			CTIControllerDTO dataControllerDTO = new CTIControllerDTO();
			BeanUtils.copyProperties(objects, dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	public List<CTIServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<CTIPersistanceDTO> persistenceDTOs) {
		List<CTIServiceDTO> getEventLandmarkServiceDTO = new ArrayList<CTIServiceDTO>();
		for (CTIPersistanceDTO objects : persistenceDTOs) {
			CTIServiceDTO objGetEventLandmarkServiceDTO = new CTIServiceDTO();
			BeanUtils.copyProperties(objects, objGetEventLandmarkServiceDTO);
			getEventLandmarkServiceDTO.add(objGetEventLandmarkServiceDTO);
		}
		return getEventLandmarkServiceDTO;
	}
	public List<CTIPersistanceDTO> conversionForloadModuleRoleUsers(List<Object[]> list) {
		List<CTIPersistanceDTO> getEventLandmarkPersistanceDTO = new ArrayList<CTIPersistanceDTO>();
		for (Object[] objects : list) {
			CTIPersistanceDTO objGetEventLandmarkPersistanceDTO = new CTIPersistanceDTO();
			
			if (objects[0] != null) {
				objGetEventLandmarkPersistanceDTO.setName(objects[0].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objGetEventLandmarkPersistanceDTO.setCdPhone(objects[1].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setCdPhone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objGetEventLandmarkPersistanceDTO.setCdMobile(objects[2].toString());
			} else {
				objGetEventLandmarkPersistanceDTO.setCdMobile(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			getEventLandmarkPersistanceDTO.add(objGetEventLandmarkPersistanceDTO);
		}
		return getEventLandmarkPersistanceDTO;
	}
	
}
