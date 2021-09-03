/**
 * 
 */
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.CTIServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;

/**
 * @author Habiboon Patan
 * @Date: 21-05-2019
 */
public interface CTIDataService {
	public String saveAsteriskCallTimes(CTIServiceDTO dataInfo, String strRequestID);
	
	public String saveCallerCTICallDropTime(CTIServiceDTO dataInfo, String strRequestID);
	
	public List<CTIServiceDTO> loadModuleRoleUsers(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException;

	public List<CTIServiceDTO> loadDistrictWiseUsers(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException;
	
	public List<CTIServiceDTO> loadUserDetails(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException;

	public String updateCtiDropTime(CTIServiceDTO dataServiceDTO, String strRequestID);

	}
