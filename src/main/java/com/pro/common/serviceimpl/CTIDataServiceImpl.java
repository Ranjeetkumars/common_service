/**
 * 
 */
package com.pro.common.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.CTIDataMapper;
import com.pro.common.mappers.GetEventLandmarkMapper;
import com.pro.common.persistencedto.CTIPersistanceDTO;
import com.pro.common.persistencedto.GetEventLandmarkPersistanceDTO;
import com.pro.common.service.CTIDataService;
import com.pro.common.servicedto.CTIServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;

import lombok.extern.slf4j.Slf4j;



/**
 * @author: Habiboon Patan
 * @Date: 21-05-2019
 */
@Service("objCTIDataServiceImpl")
@Slf4j
public class CTIDataServiceImpl implements CTIDataService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;
	
	@Override
	public String saveAsteriskCallTimes(CTIServiceDTO dataInfo, String strRequestID) {
		String listData = null;
			String query = "select * from sp_ins_cct_astsk_call_timiings_trans('" + dataInfo.getCact_eventid() + "',"
					+ dataInfo.getCact_cnumber() + ",'" + dataInfo.getCact_starttime() + "','" + dataInfo.getCact_iatime()
					+ "','" + dataInfo.getCact_arqtime() + "','" + dataInfo.getCact_arngtime() + "','"
					+ dataInfo.getCact_aatime() + "','" + dataInfo.getCact_ahtime() + "','" + dataInfo.getCact_endtime()
					+ "','" + dataInfo.getCact_awtime() + "','" + dataInfo.getCact_htime() + "','"
					+ dataInfo.getCact_callurl() + "','" + dataInfo.getCact_custnumber() + "','"
					+ dataInfo.getCact_aloginexten() + "','" + dataInfo.getCact_aloginid() + "','"
					+ dataInfo.getCact_serviceid() + "','" + dataInfo.getCact_logintime() + "',"
					+ dataInfo.getCct_createdbyid() + "," + dataInfo.getCct_createdbyroleid() + ","
					+ dataInfo.getCct_createdbymodu() + ")";	
			log.info("saveAsteriskCallTimes query::::: "+query);
			listData = objCommonDataDaoImpl.saveData(query);
		return listData;
	}
	
	@Override
	public String saveCallerCTICallDropTime(CTIServiceDTO dataInfo, String strRequestID) {
		String listData = null;
		String query = "SELECT * FROM sp_update_caller_cti_calltimings(" + dataInfo.getCact_eventid() + ","
				+ dataInfo.getCct_createdbymodu() + "," + dataInfo.getUser_id() + ","
				+ dataInfo.getCct_createdbyroleid() + ", '"+dataInfo.getEci_calldropeddtm()+"')";	
		log.info("saveCallerCTICallDropTime query::::: "+query);
		listData = objCommonDataDaoImpl.saveData(query);
	return listData;
	}
	@Override
	public List<CTIServiceDTO> loadModuleRoleUsers(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException {
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		List<CTIServiceDTO> objGetEventLandmarkServiceDTO = null;
		String strQuery = "select * from sp_select_communcation_directory_rolewise(" + dataInfo.getModuleid() + ","
				+ dataInfo.getRoleId() + ")";
		log.info(reqId + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CTIPersistanceDTO> persistenceDTOs = objGetEventLandmarkMapper
					.conversionForloadModuleRoleUsers(list);
			objGetEventLandmarkServiceDTO = objGetEventLandmarkMapper
					.convertPersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(reqId + ":::::::No loadModuleRoleUsers::::::");
		}
		return objGetEventLandmarkServiceDTO;
	}

	@Override
	public List<CTIServiceDTO> loadDistrictWiseUsers(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException {
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		List<CTIServiceDTO> objGetEventLandmarkServiceDTO = null;
		String strQuery = "select * from sp_select_communcation_directory_Districtwise("+dataInfo.getDistrictid()+"," + dataInfo.getModuleid() + ","
				+ dataInfo.getRoleId() + ")";
		log.info(reqId + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CTIPersistanceDTO> persistenceDTOs = objGetEventLandmarkMapper
					.conversionForloadModuleRoleUsers(list);
			objGetEventLandmarkServiceDTO = objGetEventLandmarkMapper
					.convertPersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(reqId + ":::::::No loadModuleRoleUsers::::::");
		}
		return objGetEventLandmarkServiceDTO;
	}
	@Override
	public List<CTIServiceDTO> loadUserDetails(CTIServiceDTO dataInfo, String reqId)
			throws DataNotFoundException {
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		List<CTIServiceDTO> objGetEventLandmarkServiceDTO = null;
//		String strQuery = "select * from sp_select_communcation_directory_Districtwise("+dataInfo.getDistrictid()+"," + dataInfo.getModuleid() + ","
//				+ dataInfo.getRoleId() + ")";
		String strQuery ="select * from sp_select_communcation_directory_ref(" + dataInfo.getModuleid() + ")";
		log.info(reqId + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CTIPersistanceDTO> persistenceDTOs = objGetEventLandmarkMapper
					.conversionForloadModuleRoleUsers(list);
			objGetEventLandmarkServiceDTO = objGetEventLandmarkMapper
					.convertPersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(reqId + ":::::::No loadModuleRoleUsers::::::");
		}
		return objGetEventLandmarkServiceDTO;
	}

	@Override
	public String updateCtiDropTime(CTIServiceDTO dataServiceDTO, String strRequestID) {
		String listData = null;
		String query = "SELECT * FROM sp_update_caller_call_drop_time(" + dataServiceDTO.getCact_eventid() + ","
				+ dataServiceDTO.getCact_cnumber() + "," + dataServiceDTO.getUser_id() + ",'"+dataServiceDTO.getEci_calldropeddtm()+"')";	
		log.info("saveCallerCTICallDropTime query::::: "+query);
		listData = objCommonDataDaoImpl.saveData(query);
		
		return listData;
	}
}
