package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.BloodGroupControllerDTO;
import com.pro.common.persistencedto.BloodGroupPersistenanceDTO;
import com.pro.common.servicedto.BloodGroupServiceDTO;
import com.pro.common.utills.CommonConstants;

public class BloodGroupMapper {
	public List<BloodGroupServiceDTO> convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(
			List<BloodGroupPersistenanceDTO> persistenceDTOs) {
		List<BloodGroupServiceDTO> objEventIdBySearch = new ArrayList<BloodGroupServiceDTO>();
		for (BloodGroupPersistenanceDTO objects : persistenceDTOs) {
			BloodGroupServiceDTO serviceDTO = new BloodGroupServiceDTO();
			BeanUtils.copyProperties(objects,serviceDTO);
			objEventIdBySearch.add(serviceDTO);
		}
		return objEventIdBySearch;
	}
	
	public List<BloodGroupControllerDTO> convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(List<BloodGroupServiceDTO> dataServiceDTOs) {
		List<BloodGroupControllerDTO> controllerDTOs = new ArrayList<BloodGroupControllerDTO>();
		for (BloodGroupServiceDTO objects : dataServiceDTOs) {
			BloodGroupControllerDTO dataControllerDTO = new BloodGroupControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public BloodGroupServiceDTO convertNoticeAlertControllerDTOToServiceDTO(BloodGroupControllerDTO controllerDTO) {
		BloodGroupServiceDTO propertiesServiceDTO = new BloodGroupServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<BloodGroupPersistenanceDTO> conversionofBloodgroup(List<Object[]> list) {
		List<BloodGroupPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<BloodGroupPersistenanceDTO>();
		for (Object[] objects : list) {
			BloodGroupPersistenanceDTO objCommonDataPersistenceDTO = new BloodGroupPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setBloodgrouptypeid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setBloodgrouptypeid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setBloodgroupname(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setBloodgroupname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<BloodGroupPersistenanceDTO> conversionOfEconomicType(List<Object[]> list) {
		List<BloodGroupPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<BloodGroupPersistenanceDTO>();
		for (Object[] objects : list) {
			BloodGroupPersistenanceDTO objCommonDataPersistenceDTO = new BloodGroupPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setEconomictypeid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setEconomictypeid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setEconomictypename(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setEconomictypename(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<BloodGroupPersistenanceDTO> conversionSocicalType(List<Object[]> list) {
		List<BloodGroupPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<BloodGroupPersistenanceDTO>();
		for (Object[] objects : list) {
			BloodGroupPersistenanceDTO objCommonDataPersistenceDTO = new BloodGroupPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setSocialstatustypeid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setSocialstatustypeid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setSocialStatusType(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setSocialStatusType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<BloodGroupPersistenanceDTO> conversionAllCheifComplaints(List<Object[]> list) {
		List<BloodGroupPersistenanceDTO> commonDataPersistenceDTOs = new ArrayList<BloodGroupPersistenanceDTO>();
		for (Object[] objects : list) {
			BloodGroupPersistenanceDTO objCommonDataPersistenceDTO = new BloodGroupPersistenanceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setChct_chiefcomptypeid(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setChct_chiefcomptypeid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setChct_chiefcompltype(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setChct_chiefcompltype(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setChct_cc_sec_lang(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setChct_cc_sec_lang(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setChct_cc_third_lang(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setChct_cc_third_lang(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objCommonDataPersistenceDTO.setChct_chief_comp_type_lang4(objects[4].toString());
			} else {
				objCommonDataPersistenceDTO.setChct_chief_comp_type_lang4(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
