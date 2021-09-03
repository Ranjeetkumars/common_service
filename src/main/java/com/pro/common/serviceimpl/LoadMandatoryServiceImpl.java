
package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.LoadMandatoryFieldsMapper;
import com.pro.common.persistencedto.LoadMandatoryFieldsPersistanceDTO;
import com.pro.common.service.LoadMandatoryFieldsService;
import com.pro.common.servicedto.LoadMandatoryFieldsServiceDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 17-07-2019
 *
 */
@Service("objLoadMandatoryServiceImpl")
@Slf4j
public class LoadMandatoryServiceImpl implements LoadMandatoryFieldsService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	public List<LoadMandatoryFieldsServiceDTO> loadModuleFields(LoadMandatoryFieldsServiceDTO dataInfo,
			String strRequestID) throws DataNotFoundException {
		LoadMandatoryFieldsMapper objLoadMandatoryFieldsMapper = new LoadMandatoryFieldsMapper();
		List<LoadMandatoryFieldsServiceDTO> loadMandatoryFieldsServiceDTO = null;
		String strQuery = "select * from sp_admin_module_wise_select_ams_apps_fileds_conf_ref(" + dataInfo.getModuleId()
				+ ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<LoadMandatoryFieldsPersistanceDTO> objLoadMandatoryFieldsPersistanceDTO = objLoadMandatoryFieldsMapper
					.conversionForloadModuleFields(list);
			loadMandatoryFieldsServiceDTO = objLoadMandatoryFieldsMapper
					.convertPersistanceDTOtoServiceDTO(objLoadMandatoryFieldsPersistanceDTO);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadModuleFields::::::");
		}
		return loadMandatoryFieldsServiceDTO;
	}

	@Override
	public List<LoadMandatoryFieldsServiceDTO> loadScreenMandatoryFields(LoadMandatoryFieldsServiceDTO dataInfo,
			String strRequestID) throws DataNotFoundException {
		LoadMandatoryFieldsMapper objLoadMandatoryFieldsMapper = new LoadMandatoryFieldsMapper();
		List<LoadMandatoryFieldsServiceDTO> loadMandatoryFieldsServiceDTO = null;
		String strQuery = "select * from sp_admin_select_ams_apps_fileds_conf_ref(" + dataInfo.getModuleId() + ","
				+ dataInfo.getScreenId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<LoadMandatoryFieldsPersistanceDTO> objLoadMandatoryFieldsPersistanceDTO = objLoadMandatoryFieldsMapper
					.conversionForloadScreenMandatoryFields(list);
			loadMandatoryFieldsServiceDTO = objLoadMandatoryFieldsMapper
					.convertPersistanceDTOtoServiceDTO(objLoadMandatoryFieldsPersistanceDTO);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadScreenMandatoryFields::::::");
		}
		return loadMandatoryFieldsServiceDTO;
	}

}
