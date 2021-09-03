package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.AuthanticationControllerDTO;
import com.pro.common.persistencedto.AuthanticationPersistenceDTO;

import com.pro.common.servicedto.AuthanticationServiceDTO;



public class AuthanticationMapper {

	public AuthanticationServiceDTO convertAuthanticationControllerDTOToAuthanticationServiceDTO(
			AuthanticationControllerDTO dataControllerDTO) {
		AuthanticationServiceDTO authanticationServiceDTO = new AuthanticationServiceDTO();
		BeanUtils.copyProperties(dataControllerDTO,authanticationServiceDTO);
		return authanticationServiceDTO;
	}

	public AuthanticationServiceDTO convertAuthanticationPersistenceDTOtoAuthanticationServiceDTO(
			AuthanticationPersistenceDTO objAuthanticationPersistenceDTO) {
		AuthanticationServiceDTO authanticationServiceDTO = new AuthanticationServiceDTO();
		BeanUtils.copyProperties(objAuthanticationPersistenceDTO,authanticationServiceDTO);
		return authanticationServiceDTO;
	}

	public List<AuthanticationControllerDTO> convertAuthanticationServiceDTOListToAuthanticationControllerDTOList(
			List<AuthanticationServiceDTO> authanticationServiceDTOs) {
		List<AuthanticationControllerDTO> authanticationControllerDTOs = new ArrayList<AuthanticationControllerDTO>();
		for (AuthanticationServiceDTO objects : authanticationServiceDTOs) {
			AuthanticationControllerDTO authanticationControllerDTO = new AuthanticationControllerDTO();
			BeanUtils.copyProperties(objects,authanticationControllerDTO);
			authanticationControllerDTOs.add(authanticationControllerDTO);
		}
		return authanticationControllerDTOs;
	}
	public List<AuthanticationPersistenceDTO> conversionForuserIdCreationForSingleModule(List<Object[]> list) {
		List<AuthanticationPersistenceDTO> authanticationPersistenceDTOs = new ArrayList<AuthanticationPersistenceDTO>();
		for (Object[] objects : list) {
			AuthanticationPersistenceDTO objauthanticationPersistenceDTO = new AuthanticationPersistenceDTO();
			if(objects[0] != null ) {
			
			}else {
				
			}
			
			authanticationPersistenceDTOs.add(objauthanticationPersistenceDTO);
		}
		return authanticationPersistenceDTOs;
	}

}
