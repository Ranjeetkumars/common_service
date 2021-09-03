package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.BreakTypeServiceDTO;

public interface BreakTypeService {
	
	public String insertBreakDetails(BreakTypeServiceDTO breakTypeServiceDTO,String reqId)throws DataNotFoundException;
	public String updateBreakStatus(BreakTypeServiceDTO breakTypeServiceDTO,String reqId)throws DataNotFoundException;
	public List<BreakTypeServiceDTO> getBreakDetails(String strRequestID)
			throws DataNotFoundException;

}
