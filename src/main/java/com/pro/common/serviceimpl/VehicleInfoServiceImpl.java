
package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.VehicleInfoMapper;
import com.pro.common.persistencedto.VehicleInfoPersistanceDTO;
import com.pro.common.service.VehicleInfoService;
import com.pro.common.servicedto.VehicleInfoServiceDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 *
 */
@Service("objVehicleInfoServiceImpl")
@Slf4j
public class VehicleInfoServiceImpl implements VehicleInfoService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	public List<VehicleInfoServiceDTO> VehicleInformation(VehicleInfoServiceDTO dataInfo, String strRequestID)
			throws DataNotFoundException {
		VehicleInfoMapper objVehicleInfoMapper = new VehicleInfoMapper();
		List<VehicleInfoServiceDTO> vehicleInfoServiceDTO = null;
		String strQuery = "select * from sp_get_unassignedvehicledetails_wfms(" + dataInfo.getVehicleId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<VehicleInfoPersistanceDTO> gisPersDTOs = objVehicleInfoMapper.conversionForVehicleInformation(list);
			vehicleInfoServiceDTO = objVehicleInfoMapper.convertPersistanceDTOtoServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No VehicleInformation::::::");
		}
		return vehicleInfoServiceDTO;
	}

	@Override
	public List<VehicleInfoServiceDTO> Infrastructure(VehicleInfoServiceDTO dataInfo, String strRequestID)
			throws DataNotFoundException {
		VehicleInfoMapper objVehicleInfoMapper = new VehicleInfoMapper();
		List<VehicleInfoServiceDTO> vehicleInfoServiceDTO = null;
		String strQuery = "select * from sp_select_VehicleInfra(" + dataInfo.getVehicleId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<VehicleInfoPersistanceDTO> gisPersDTOs = objVehicleInfoMapper.conversionForInfrastructure(list);
			vehicleInfoServiceDTO = objVehicleInfoMapper.convertPersistanceDTOtoServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No Infrastructure::::::");
		}
		return vehicleInfoServiceDTO;
	}

}
