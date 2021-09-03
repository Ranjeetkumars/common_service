package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.BreakTypeMapper;
import com.pro.common.persistencedto.BreakTypePersistenceDTO;
import com.pro.common.service.BreakTypeService;
import com.pro.common.servicedto.BreakTypeServiceDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO
 *
 */
@Service("objBreakTypeServiceImpl")
@Slf4j
public class BreakTypeServiceImpl implements BreakTypeService {

	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	/*
	 * Inserting insertBreakDetails
	 */

	@Override
	public String insertBreakDetails(BreakTypeServiceDTO dataInfo, String reqID) throws DataNotFoundException {

		String query = "select * from sp_insert_ams_break_type_trans('" + dataInfo.getBreakTypeID() + "',"
				+ dataInfo.getIntUserId() + "," + dataInfo.getIntModuleId() + "," + dataInfo.getIntRoleId() + ")";
		log.info(reqID + ":::::query::::::" + query);
		return objCommonDataDaoImpl.saveData(query);
	}
	@Override
	@Cacheable("BreakTypes")
	public List<BreakTypeServiceDTO> getBreakDetails(String strRequestID) throws DataNotFoundException {
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		List<BreakTypeServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("select * from sp_select_ams_breaktyperef()");
		log.info(strRequestID + "::::::strQuery:::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BreakTypePersistenceDTO> persistenceDTOs = breakTypeMapper
					.convertObjetsArraytoBreakTypePersistenceDTOList(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertBreakTypePersistenceDTOListToBreakTypeServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	public String updateBreakStatus(BreakTypeServiceDTO dataInfo, String reqID) throws DataNotFoundException {
		String query = "select * from sp_update_ams_break_type_trans(" + dataInfo.getBreakTransId() + ")";
		log.info(reqID + "::::::query:::::" + query);
		return objCommonDataDaoImpl.saveData(query);

	}

}