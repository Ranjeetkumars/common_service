
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.VehicleInfoServiceDTO;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 *
 */
public interface VehicleInfoService {

	public List<VehicleInfoServiceDTO> VehicleInformation(VehicleInfoServiceDTO dataInfo, String strRequestID)
			throws DataNotFoundException;


	public List<VehicleInfoServiceDTO> Infrastructure(VehicleInfoServiceDTO dataInfo, String strRequestID)
			throws DataNotFoundException;

	
}
