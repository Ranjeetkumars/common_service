package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.NoticeAlertControllerDTO;
import com.pro.common.persistencedto.NoticeAlertPersistenaceDTO;
import com.pro.common.servicedto.NoticeAlertServiceDTO;
import com.pro.common.utills.CommonConstants;


public class NoticeAlertMapper {
	public List<NoticeAlertServiceDTO> convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(
			List<NoticeAlertPersistenaceDTO> persistenceDTOs) {
		List<NoticeAlertServiceDTO> objEventIdBySearch = new ArrayList<NoticeAlertServiceDTO>();
		for (NoticeAlertPersistenaceDTO objects : persistenceDTOs) {
			NoticeAlertServiceDTO serviceDTO = new NoticeAlertServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			objEventIdBySearch.add(serviceDTO);
		}
		return objEventIdBySearch;
	}
	
	public List<NoticeAlertControllerDTO> convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(List<NoticeAlertServiceDTO> dataServiceDTOs) {
		List<NoticeAlertControllerDTO> controllerDTOs = new ArrayList<NoticeAlertControllerDTO>();
		for (NoticeAlertServiceDTO objects : dataServiceDTOs) {
			NoticeAlertControllerDTO dataControllerDTO = new NoticeAlertControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public NoticeAlertServiceDTO convertNoticeAlertControllerDTOToServiceDTO(NoticeAlertControllerDTO controllerDTO) {
		NoticeAlertServiceDTO propertiesServiceDTO = new NoticeAlertServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<NoticeAlertPersistenaceDTO> convertNoticeAlert(List<Object[]> list) {
		List<NoticeAlertPersistenaceDTO> commonDataPersistenceDTOs = new ArrayList<NoticeAlertPersistenaceDTO>();
		for (Object[] objects : list) {
			NoticeAlertPersistenaceDTO objCommonDataPersistenceDTO = new NoticeAlertPersistenaceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setCca_alertid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setCca_alertid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setCc_alertmessage(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setCc_alertmessage(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setCc_msg_expiredate(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setCc_msg_expiredate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setCc_alert_name(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setCc_alert_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
