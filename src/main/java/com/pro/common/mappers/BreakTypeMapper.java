/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.BreakTypeControllerDTO;
import com.pro.common.persistencedto.BreakTypePersistenceDTO;
import com.pro.common.persistencedto.GISCommonDataPersistenceDTO;
import com.pro.common.servicedto.BreakTypeServiceDTO;
import com.pro.common.servicedto.GISCommonDataServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 *
 */
public class BreakTypeMapper {
	public List<BreakTypePersistenceDTO> convertObjetsArraytoBreakTypePersistenceDTOList(List<Object[]> list) {
		List<BreakTypePersistenceDTO> commonDataPersistenceDTOs = new ArrayList<BreakTypePersistenceDTO>();
		for (Object[] objects : list) {
			BreakTypePersistenceDTO objCommonDataPersistenceDTO = new BreakTypePersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setBreakTypeID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setBreakTypeID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setBreakTypeName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setBreakTypeName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<BreakTypeServiceDTO> convertBreakTypePersistenceDTOListToBreakTypeServiceDTOList(
			List<BreakTypePersistenceDTO> persistenceDTOs) {
		List<BreakTypeServiceDTO> breakTypeServiceDTOs = new ArrayList<BreakTypeServiceDTO>();
		for (BreakTypePersistenceDTO objects : persistenceDTOs) {
			BreakTypeServiceDTO breakTypeServiceDTO = new BreakTypeServiceDTO();
			BeanUtils.copyProperties(objects,breakTypeServiceDTO);
			breakTypeServiceDTOs.add(breakTypeServiceDTO);
		}
		return breakTypeServiceDTOs;
	}
	
	public List<BreakTypeControllerDTO> convertBreakTypeServiceDTOToBreakTypeControllerDTOList(List<BreakTypeServiceDTO> dataServiceDTOs) {
		List<BreakTypeControllerDTO> controllerDTOs = new ArrayList<BreakTypeControllerDTO>();
		for (BreakTypeServiceDTO objects : dataServiceDTOs) {
			BreakTypeControllerDTO dataControllerDTO = new BreakTypeControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	
	public BreakTypeServiceDTO  breakTypeControllerDTODtoToServiceFTO(BreakTypeControllerDTO dataInfo) {
		BreakTypeServiceDTO breakTypeServiceDTO = new BreakTypeServiceDTO();
		BeanUtils.copyProperties(dataInfo, breakTypeServiceDTO);
		return breakTypeServiceDTO;
		
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
	
	
}
