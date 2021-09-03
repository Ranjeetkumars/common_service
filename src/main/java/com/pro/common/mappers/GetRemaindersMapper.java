package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GetRemaindersControllerDto;
import com.pro.common.persistencedto.GetRemaindersPersistenceDto;
import com.pro.common.servicedto.GetRemaindersServiceDto;
import com.pro.common.utills.CommonConstants;



public class GetRemaindersMapper {
	
	
	
	public List<GetRemaindersControllerDto> conversionForServiceTOControllerDTO(List<GetRemaindersServiceDto> ServiceDto) {
		List<GetRemaindersControllerDto> objERSViewControllerDto = new ArrayList<GetRemaindersControllerDto>();
		for (GetRemaindersServiceDto objects : ServiceDto) {
			GetRemaindersControllerDto ControllerDtos = new GetRemaindersControllerDto();
			BeanUtils.copyProperties(objects, ControllerDtos);
			objERSViewControllerDto.add(ControllerDtos);
		}
		return objERSViewControllerDto;
	}
   public List<GetRemaindersServiceDto> conversionpersistanceDTOtoServiceDTO(List<GetRemaindersPersistenceDto> persistenceDTOs) {
		List<GetRemaindersServiceDto> objServiceDTOs = new ArrayList<GetRemaindersServiceDto>();
		for (GetRemaindersPersistenceDto objects : persistenceDTOs) {
			GetRemaindersServiceDto objServiceDto = new GetRemaindersServiceDto();
			BeanUtils.copyProperties(objects, objServiceDto);
			objServiceDTOs.add(objServiceDto);
		}
		return objServiceDTOs;
	}
	
	public GetRemaindersServiceDto conversionForControllerToServiceDTO(GetRemaindersControllerDto ControllerDto) {
		GetRemaindersServiceDto serviceDTO = new GetRemaindersServiceDto();
		BeanUtils.copyProperties(ControllerDto, serviceDTO);
		return serviceDTO;
	}
	
	
	
	public List<GetRemaindersPersistenceDto> conversionForListOfRemainders(List<Object[]> list) {
		List<GetRemaindersPersistenceDto> listOfData = new ArrayList<GetRemaindersPersistenceDto>();
		for (Object[] objects : list) {
			GetRemaindersPersistenceDto persistenceDTO = new GetRemaindersPersistenceDto();
			if (objects[0] != null) {
				persistenceDTO.setRemainderId(objects[0].toString());
			} else {
				persistenceDTO.setRemainderId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				persistenceDTO.setRemainderName(objects[1].toString());
			} else {
				persistenceDTO.setRemainderName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				persistenceDTO.setReamainderWithTimeStamp(objects[2].toString());
			} else {
				persistenceDTO.setReamainderWithTimeStamp(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[3] != null) {
				persistenceDTO.setEventSpecificorPersonlStatus(objects[3].toString());
			} else {
				persistenceDTO.setEventSpecificorPersonlStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				persistenceDTO.setEventId(objects[4].toString());
			} else {
				persistenceDTO.setEventId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[5] != null) {
				persistenceDTO.setCreatedById(objects[5].toString());
			} else {
				persistenceDTO.setCreatedById(CommonConstants.DATA_NOT_AVIALABLE);
			}
            if (objects[6] != null) {
				persistenceDTO.setAcKnowledged(objects[6].toString());
			} else {
				persistenceDTO.setAcKnowledged(CommonConstants.DATA_NOT_AVIALABLE);
			}
            if (objects[7] != null) {
				persistenceDTO.setAcKnowledgeId(objects[7].toString());
			} else {
				persistenceDTO.setAcKnowledgeId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				persistenceDTO.setAcKnowledgedTime(objects[8].toString());
			} else {
				persistenceDTO.setAcKnowledgedTime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				persistenceDTO.setUserName(objects[9].toString());
			} else {
				persistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(persistenceDTO);

		}
		return listOfData;
	}

}
