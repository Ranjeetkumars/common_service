/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.GISCommonDataControllerDTO;
import com.pro.common.persistencedto.GISCommonDataPersistenceDTO;
import com.pro.common.servicedto.GISCommonDataServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO 15-05-2019
 */
public class GISDataMapper {
//	private final Logger logger = Logger.getLogger(GISDataMapper.class);

	public GISCommonDataServiceDTO gISCommonDataControllerDTOtoGISCommonDataServiceDTO(GISCommonDataControllerDTO controllerDTO) {
		GISCommonDataServiceDTO gisCommonDataServiceDTO = new GISCommonDataServiceDTO();
//		logger.info("::::::::controllerDTO::111:::::"+controllerDTO);
		BeanUtils.copyProperties(controllerDTO,gisCommonDataServiceDTO);
//		logger.info("::::::::controllerDTO:::::::"+controllerDTO);
//		logger.info("::::::::gisCommonDataServiceDTO:::::::"+gisCommonDataServiceDTO);
		return gisCommonDataServiceDTO;
	}
	
	

	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListStates(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setStateId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setStateId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setStateName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setStateId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListDistricts(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setDistrictId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setDistrictId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setDistrictname(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setDistrictname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListMandals(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setMandalId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setMandalId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setMandalName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setMandalName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListCities(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setCityId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setCityId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setCityName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setCityName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListLocalities(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setLocalityId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setLocalityId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setLoclaityname(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setLoclaityname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListLandmarks(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setLandmarkId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setLandmarkId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setLandmarkname(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setLandmarkname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<GISCommonDataPersistenceDTO> convertObjetsArraytoGISCommonDataPersistenceDTOListCountries(List<Object[]> list) {
		List<GISCommonDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<GISCommonDataPersistenceDTO>();
		for (Object[] objects : list) {
			GISCommonDataPersistenceDTO objCommonDataPersistenceDTO = new GISCommonDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setCountryId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setCountryId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setCountryName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setCountryName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<GISCommonDataServiceDTO> convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(
			List<GISCommonDataPersistenceDTO> persistenceDTOs) {
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = new ArrayList<GISCommonDataServiceDTO>();
		for (GISCommonDataPersistenceDTO objects : persistenceDTOs) {
			GISCommonDataServiceDTO gisCommonDataServiceDTO = new GISCommonDataServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<GISCommonDataControllerDTO> convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(List<GISCommonDataServiceDTO> dataServiceDTOs) {
		List<GISCommonDataControllerDTO> controllerDTOs = new ArrayList<GISCommonDataControllerDTO>();
		for (GISCommonDataServiceDTO objects : dataServiceDTOs) {
			GISCommonDataControllerDTO dataControllerDTO = new GISCommonDataControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	

}
