
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GetModuleSpecifcAgentsControllerDTO;
import com.pro.common.persistencedto.GetModuleSpecifcAgentsPersistanceDTO;
import com.pro.common.servicedto.GetModuleSpecifcAgentsServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author : Habiboon Patan
 */
public class GetModuleSpecifcAgentsMapper {

	public GetModuleSpecifcAgentsServiceDTO convertControllerDTOtoServiceDTO(
			GetModuleSpecifcAgentsControllerDTO controllerDTO) {
		GetModuleSpecifcAgentsServiceDTO propertiesServiceDTO = new GetModuleSpecifcAgentsServiceDTO();
		BeanUtils.copyProperties(controllerDTO, propertiesServiceDTO);
		return propertiesServiceDTO;
	}

	public List<GetModuleSpecifcAgentsServiceDTO> convertPersistanceDTOtoServiceDTO(
			List<GetModuleSpecifcAgentsPersistanceDTO> persistenceDTOs) {
		List<GetModuleSpecifcAgentsServiceDTO> getModuleSpecifcAgentsServiceDTO = new ArrayList<GetModuleSpecifcAgentsServiceDTO>();
		for (GetModuleSpecifcAgentsPersistanceDTO objects : persistenceDTOs) {
			GetModuleSpecifcAgentsServiceDTO objGetModuleSpecifcAgentsServiceDTO = new GetModuleSpecifcAgentsServiceDTO();
			BeanUtils.copyProperties(objects, objGetModuleSpecifcAgentsServiceDTO);
			getModuleSpecifcAgentsServiceDTO.add(objGetModuleSpecifcAgentsServiceDTO);
		}
		return getModuleSpecifcAgentsServiceDTO;
	}

	public List<GetModuleSpecifcAgentsControllerDTO> convertServiceDTOtoControllerDTO(
			List<GetModuleSpecifcAgentsServiceDTO> dataServiceDTOs) {
		List<GetModuleSpecifcAgentsControllerDTO> controllerDTOs = new ArrayList<GetModuleSpecifcAgentsControllerDTO>();
		for (GetModuleSpecifcAgentsServiceDTO objects : dataServiceDTOs) {
			GetModuleSpecifcAgentsControllerDTO dataControllerDTO = new GetModuleSpecifcAgentsControllerDTO();
			BeanUtils.copyProperties(objects, dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}

	public List<GetModuleSpecifcAgentsPersistanceDTO> conversiongetModuleSpecifcAgents(List<Object[]> list) {
		List<GetModuleSpecifcAgentsPersistanceDTO> getModuleSpecifcAgentsPersistanceDTO = new ArrayList<GetModuleSpecifcAgentsPersistanceDTO>();
		for (Object[] objects : list) {
			GetModuleSpecifcAgentsPersistanceDTO objGetModuleSpecifcAgentsPersistanceDTO = new GetModuleSpecifcAgentsPersistanceDTO();
			if (objects[0] != null) {
				objGetModuleSpecifcAgentsPersistanceDTO.setUserid(objects[0].toString());
			} else {
				objGetModuleSpecifcAgentsPersistanceDTO.setUserid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objGetModuleSpecifcAgentsPersistanceDTO.setUsername(objects[1].toString());
			} else {
				objGetModuleSpecifcAgentsPersistanceDTO.setUsername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			getModuleSpecifcAgentsPersistanceDTO.add(objGetModuleSpecifcAgentsPersistanceDTO);
		}
		return getModuleSpecifcAgentsPersistanceDTO;
	}

}
