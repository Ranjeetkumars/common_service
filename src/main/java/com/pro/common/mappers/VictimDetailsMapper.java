package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.VictimDetailControllerDTO;
import com.pro.common.persistencedto.VictimDetailPersistenanceDTO;
import com.pro.common.servicedto.VictimDetailServiceDTO;
import com.pro.common.utills.CommonConstants;


public class VictimDetailsMapper {
	public List<VictimDetailControllerDTO> conversionForServiceTOControllerDTO(List<VictimDetailServiceDTO> ServiceDto) {
		List<VictimDetailControllerDTO> objERSViewControllerDto = new ArrayList<VictimDetailControllerDTO>();
		for (VictimDetailServiceDTO objects : ServiceDto) {
			VictimDetailControllerDTO ControllerDtos = new VictimDetailControllerDTO();
			BeanUtils.copyProperties(objects, ControllerDtos);
			objERSViewControllerDto.add(ControllerDtos);
		}
		return objERSViewControllerDto;
	}
   public List<VictimDetailServiceDTO> conversionpersistanceDTOtoServiceDTO(List<VictimDetailPersistenanceDTO> persistenceDTOs) {
		List<VictimDetailServiceDTO> objServiceDTOs = new ArrayList<VictimDetailServiceDTO>();
		for (VictimDetailPersistenanceDTO objects : persistenceDTOs) {
			VictimDetailServiceDTO objServiceDto = new VictimDetailServiceDTO();
			BeanUtils.copyProperties(objects, objServiceDto);
			objServiceDTOs.add(objServiceDto);
		}
		return objServiceDTOs;
	}
	
	public VictimDetailServiceDTO conversionForControllerToServiceDTO(VictimDetailControllerDTO ControllerDto) {
		VictimDetailServiceDTO serviceDTO = new VictimDetailServiceDTO();
		BeanUtils.copyProperties(ControllerDto, serviceDTO);
		return serviceDTO;
	}
	public List<VictimDetailPersistenanceDTO> conversionOfgetVictimDetails(List<Object[]> list) {
		List<VictimDetailPersistenanceDTO> listOfData = new ArrayList<VictimDetailPersistenanceDTO>();
		for (Object[] objects : list) {
			VictimDetailPersistenanceDTO persistenceDTO = new VictimDetailPersistenanceDTO();
			if (objects[0] != null) {
				persistenceDTO.setVictimid(objects[0].toString());
			} else {
				persistenceDTO.setVictimid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setVictim(objects[1].toString());
			} else {
				persistenceDTO.setVictim(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				persistenceDTO.setGender(objects[2].toString());
			} else {
				persistenceDTO.setGender(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[3] != null) {
				persistenceDTO.setAge(objects[3].toString());
			} else {
				persistenceDTO.setAge(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				persistenceDTO.setDob(objects[4].toString());
			} else {
				persistenceDTO.setDob(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[5] != null) {
				persistenceDTO.setBloodgroup(objects[5].toString());
			} else {
				persistenceDTO.setBloodgroup(CommonConstants.DATA_NOT_AVIALABLE);
			}
            if (objects[6] != null) {
				persistenceDTO.setAllergy(objects[6].toString());
			} else {
				persistenceDTO.setAllergy(CommonConstants.DATA_NOT_AVIALABLE);
			}
            if (objects[7] != null) {
				persistenceDTO.setEconomicStatus(objects[7].toString());
			} else {
				persistenceDTO.setEconomicStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				persistenceDTO.setSocicalStaus(objects[8].toString());
			} else {
				persistenceDTO.setSocicalStaus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				persistenceDTO.setMedicalPastHistroy(objects[9].toString());
			} else {
				persistenceDTO.setMedicalPastHistroy(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				persistenceDTO.setCurrentmedication(objects[10].toString());
			} else {
				persistenceDTO.setCurrentmedication(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[11] != null) {
				persistenceDTO.setCheifcomplainttype(objects[11].toString());
			} else {
				persistenceDTO.setCheifcomplainttype(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(persistenceDTO);

		}
		return listOfData;
	}
	
	
	
}
