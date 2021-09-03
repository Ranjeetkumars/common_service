
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.SocialMediaControllerDTO;
import com.pro.common.persistencedto.SocialMediaPersistanceDTO;
import com.pro.common.servicedto.SocialMediaSericeDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author Habiboon Patan
 * @Date : 21-05-2019
 */

public class SocialMediaMapper {
	public List<SocialMediaSericeDTO> convertPersistenceDTOtoServiceDTO(List<SocialMediaPersistanceDTO> socialMediaPersistanceDTOs) {
		List<SocialMediaSericeDTO> socialMediaSericeDTOs = new ArrayList<SocialMediaSericeDTO>();
		for (SocialMediaPersistanceDTO objects : socialMediaPersistanceDTOs) {
			SocialMediaSericeDTO socialMediaSericeDTO = new SocialMediaSericeDTO();
			BeanUtils.copyProperties(objects,socialMediaSericeDTO);
			socialMediaSericeDTOs.add(socialMediaSericeDTO);
		}
		return socialMediaSericeDTOs;
	}

	public List<SocialMediaControllerDTO> converterviceDTOListtoControllerDTO(List<SocialMediaSericeDTO> socialMediaSericeDTOs) {
		List<SocialMediaControllerDTO> controllerDTOs = new ArrayList<SocialMediaControllerDTO>();
		for (SocialMediaSericeDTO objects : socialMediaSericeDTOs) {
			SocialMediaControllerDTO dataControllerDTO = new SocialMediaControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	public SocialMediaSericeDTO socialMediaControllerDtoToServiceFTO(SocialMediaControllerDTO dataInfo) {
		SocialMediaSericeDTO socialMediaSericeDTO = new SocialMediaSericeDTO();
		BeanUtils.copyProperties(dataInfo, socialMediaSericeDTO);
		return socialMediaSericeDTO;
	}
	public List<SocialMediaPersistanceDTO> conversionForGetFacebookPost(List<Object[]> objects) {
		List<SocialMediaPersistanceDTO> deploymentPropertiesDTOs = new ArrayList<SocialMediaPersistanceDTO>();
		for (Object object : objects) {
			Object row = (Object) object;
			SocialMediaPersistanceDTO objTyreDTO = new SocialMediaPersistanceDTO();
			if(row!=null) {
				objTyreDTO.setMsg(row.toString());
			}else {
				objTyreDTO.setMsg(CommonConstants.DATA_NOT_AVIALABLE);
			}
			deploymentPropertiesDTOs.add(objTyreDTO);
		}
		return deploymentPropertiesDTOs;		
	}
	
	public List<SocialMediaPersistanceDTO> convertionForgettingUserCount(List<Object[]> objects) {
		List<SocialMediaPersistanceDTO> deploymentPropertiesDTOs = new ArrayList<SocialMediaPersistanceDTO>();
		for (Object object : objects) {
			Object row = (Object) object;
			SocialMediaPersistanceDTO objTyreDTO = new SocialMediaPersistanceDTO();
			if(row!=null) {
				objTyreDTO.setUser_count(row.toString());
			}else {
				objTyreDTO.setUser_count(CommonConstants.DATA_NOT_AVIALABLE);
			}		
			
			deploymentPropertiesDTOs.add(objTyreDTO);
		}
		return deploymentPropertiesDTOs;
		
	}
}
