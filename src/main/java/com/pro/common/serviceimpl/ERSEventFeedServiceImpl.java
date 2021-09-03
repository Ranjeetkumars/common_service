
package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.ERSEventFeedMapper;
import com.pro.common.persistencedto.ERSEventFeedPersistanceDTO;
import com.pro.common.service.ERSEventFeedService;
import com.pro.common.servicedto.ERSEventFeedServiceDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 *
 */
@Service("objERSEventFeedServiceImpl")
@Slf4j
public class ERSEventFeedServiceImpl implements ERSEventFeedService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	@Cacheable("feedTypes")
	public List<ERSEventFeedServiceDTO> loadErsEventFeedTypes(String strRequestID) throws DataNotFoundException {
		ERSEventFeedMapper objERSEventFeedMapper = new ERSEventFeedMapper();
		List<ERSEventFeedServiceDTO> ersEventFeedServiceDTO = null;
		String strQuery = "select * from sp_select_erseventfeedtype_ref()";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<ERSEventFeedPersistanceDTO> gisPersDTOs = objERSEventFeedMapper
					.conversionForloadErsEventFeedTypes(list);
			ersEventFeedServiceDTO = objERSEventFeedMapper.convertPersistanceDTOtoServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadErsEventFeedTypes::::::");
		}
		return ersEventFeedServiceDTO;
	}

	@Override
	public String saveFeedInfo(ERSEventFeedServiceDTO dataInfo, String strRequestID) throws DataNotFoundException {
		String listData = null;
		String query = "Select * from sp_insert_erseventfeeds_trans(" + dataInfo.getEventId() + ",'"
				+ dataInfo.getFeedText() + "'," + dataInfo.getFeedTypeId() + ",'" + dataInfo.getUserId() + "','"
				+ dataInfo.getModuleId() + "','" + dataInfo.getRoleId() + "')";
		log.info("saveFeedInfo query::::: " + query);
		listData = objCommonDataDaoImpl.saveData(query);
		return listData;
	}

}
