/**
 * 
 */
package com.pro.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.UsersDataControllerDTO;
import com.pro.common.persistencedto.UsersDataPersistenceDTO;
import com.pro.common.servicedto.UsersDataServiceDTO;
import com.pro.common.utills.CommonConstants;

/**
 * @author VENKAT_PRO
 * DATE:-20-05-2019
 */
public class UsersDataMapper {
	public UsersDataServiceDTO convertUsersDataControllerDTOtoUsersDataServiceDTO(UsersDataControllerDTO controllerDTO) {
		UsersDataServiceDTO propertiesServiceDTO = new UsersDataServiceDTO();
		BeanUtils.copyProperties(controllerDTO,propertiesServiceDTO);
		return propertiesServiceDTO;
	}
	public List<UsersDataPersistenceDTO> convertObjetsArraytoUsersDataPersistenceDTOList(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setPrevillageId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setPrevillageId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setPrevillageName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setPrevillageName(CommonConstants.DATA_NOT_AVIALABLE);
			}			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<UsersDataServiceDTO> convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(
			List<UsersDataPersistenceDTO> persistenceDTOs) {
		List<UsersDataServiceDTO> commonDataServiceDTOs = new ArrayList<UsersDataServiceDTO>();
		for (UsersDataPersistenceDTO objects : persistenceDTOs) {
			UsersDataServiceDTO gisCommonDataServiceDTO = new UsersDataServiceDTO();
			BeanUtils.copyProperties(objects,gisCommonDataServiceDTO);
			commonDataServiceDTOs.add(gisCommonDataServiceDTO);
		}
		return commonDataServiceDTOs;
	}
	
	public List<UsersDataControllerDTO> convertUsersDataServiceDTOListtoUsersDataControllerDTOList(List<UsersDataServiceDTO> dataServiceDTOs) {
		List<UsersDataControllerDTO> controllerDTOs = new ArrayList<UsersDataControllerDTO>();
		for (UsersDataServiceDTO objects : dataServiceDTOs) {
			UsersDataControllerDTO dataControllerDTO = new UsersDataControllerDTO();
			BeanUtils.copyProperties(objects,dataControllerDTO);
			controllerDTOs.add(dataControllerDTO);
		}
		return controllerDTOs;
	}
	
	
	public List<UsersDataPersistenceDTO> convertionForgettingRoles(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setRoleID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setRoleID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setRoleName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setRoleName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setModuleID(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setModuleID(CommonConstants.DATA_NOT_AVIALABLE);
			}	
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<UsersDataPersistenceDTO> convertionForgettingOffLineUserFailedEvents(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setUserID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setUserID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setUserName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setEar_event_id(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setEar_event_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgetAsdterisdk_CCTCredentialsNew(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setHhc_terminal(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setHhc_terminal(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setHhc_terminal_password(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setHhc_terminal_password(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setHhc_terminal_queue_ids(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setHhc_terminal_queue_ids(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	public List<UsersDataPersistenceDTO> conversionForgetManagerId(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setManagerId(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setManagerId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	
	public List<UsersDataPersistenceDTO> conversionForloadAVAYATerminalLoginDetails(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setHhc_terminal(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setHhc_terminal(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setUserName(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objCommonDataPersistenceDTO.setUserPassword(objects[2].toString());
			} else {
				objCommonDataPersistenceDTO.setUserPassword(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objCommonDataPersistenceDTO.setHhc_terminal_queue_ids(objects[3].toString());
			} else {
				objCommonDataPersistenceDTO.setHhc_terminal_queue_ids(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgettingLeastLoaded(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects != null ) {
			
				if (objects[0]!=null ) {
					objCommonDataPersistenceDTO.setUserID(objects[0].toString());
				} else {
					objCommonDataPersistenceDTO.setUserID(CommonConstants.DATA_NOT_AVIALABLE);
				}	
			}else {
				objCommonDataPersistenceDTO.setUserID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgettinLoggedModules(List<Object> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects != null ) {
			objCommonDataPersistenceDTO.setModuleID(objects.toString());
		
			}else {
				objCommonDataPersistenceDTO.setModuleID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForcheckingModule(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects[0] != null ) {
			objCommonDataPersistenceDTO.setModuleID(objects[0].toString());
		
			}else {
				objCommonDataPersistenceDTO.setModuleID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if(objects[1]!= null ) {
				objCommonDataPersistenceDTO.setModuleName(objects[1].toString());
			
				}else {
					objCommonDataPersistenceDTO.setModuleName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgettingPostgers(List<Object> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects != null ) {
			objCommonDataPersistenceDTO.setServiceName(objects.toString());
		
			}else {
				objCommonDataPersistenceDTO.setServiceName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgettingServerLicences(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects[0] != null ) {
			objCommonDataPersistenceDTO.setLicenceID(objects[0].toString());
		
			}else {
				objCommonDataPersistenceDTO.setLicenceID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if(objects[1] != null ) {
				objCommonDataPersistenceDTO.setKey2(objects[1].toString());
			
				}else {
					objCommonDataPersistenceDTO.setKey2(CommonConstants.DATA_NOT_AVIALABLE);
				}
			if(objects[2] != null ) {
				objCommonDataPersistenceDTO.setKey1(objects[2].toString());
			
				}else {
					objCommonDataPersistenceDTO.setKey1(CommonConstants.DATA_NOT_AVIALABLE);
				}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForgettingPrevillages(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects[0] != null ) {
			objCommonDataPersistenceDTO.setPrevillageId(objects[0].toString());
		
			}else {
				objCommonDataPersistenceDTO.setPrevillageId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if(objects[1]!= null ) {
				objCommonDataPersistenceDTO.setPrevillageName(objects[1].toString());
			
				}else {
					objCommonDataPersistenceDTO.setPrevillageName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForsCheckusershift(List<Object> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if(objects != null ) {
			objCommonDataPersistenceDTO.setModuleID(objects.toString());
		
			}else {
				objCommonDataPersistenceDTO.setModuleID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	public List<UsersDataPersistenceDTO> conversionForisUserExist(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects != null) {
				objCommonDataPersistenceDTO.setUserID(objects.toString());
			} else {
				objCommonDataPersistenceDTO.setUserID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
	
	
	public List<UsersDataPersistenceDTO> conversionForgetUserShiftsByModule(List<Object[]> list) {
		List<UsersDataPersistenceDTO> commonDataPersistenceDTOs = new ArrayList<UsersDataPersistenceDTO>();
		for (Object[] objects : list) {
			UsersDataPersistenceDTO objCommonDataPersistenceDTO = new UsersDataPersistenceDTO();
			if (objects[0] != null) {
				objCommonDataPersistenceDTO.setShiftID(objects[0].toString());
			} else {
				objCommonDataPersistenceDTO.setShiftID(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objCommonDataPersistenceDTO.setShiftTimings(objects[1].toString());
			} else {
				objCommonDataPersistenceDTO.setShiftTimings(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			commonDataPersistenceDTOs.add(objCommonDataPersistenceDTO);
		}
		return commonDataPersistenceDTOs;
	}
}
