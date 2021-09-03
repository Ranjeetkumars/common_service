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
import com.pro.common.mappers.GetRemaindersMapper;
import com.pro.common.mappers.NotificationAlertsMapper;
import com.pro.common.mappers.ReminderMapper;
import com.pro.common.persistencedto.GetRemaindersPersistenceDto;
import com.pro.common.persistencedto.NotificationAlertsPersistenceDTO;
import com.pro.common.persistencedto.ReminderPersistenceDTO;
import com.pro.common.service.NotificationAlertsService;
import com.pro.common.servicedto.GetRemaindersServiceDto;
import com.pro.common.servicedto.NotificationAlertsServiceDTO;
import com.pro.common.servicedto.ReminderServiceDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO
 *
 */
@Service("objNotificationAlertsServiceImpl")
@Slf4j
public class NotificationAlertsServiceImpl implements NotificationAlertsService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	public List<NotificationAlertsServiceDTO> loadNotificationAlerts(NotificationAlertsServiceDTO alertsServiceDTO,
			String requestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		NotificationAlertsMapper alertsMapper = new NotificationAlertsMapper();
		List<NotificationAlertsServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_em_hm_contactcenter_alerts_trans("
				+ alertsServiceDTO.getAlertRequestedModuleID() + ")";
		log.info(requestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<NotificationAlertsPersistenceDTO> gisPersDTOs = alertsMapper
					.convertObjetsArraytoNotificationAlertsPersistenceDTOList(list);
			commonDataServiceDTOs = alertsMapper
					.convertNotificationAlertsPersistenceDTOListToNotificationAlertsServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(requestID + ":::::::No loadNotificationAlerts::::::"
					+ alertsServiceDTO.getAlertRequestedModuleID());
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<ReminderServiceDTO> loadReminders(ReminderServiceDTO alertsServiceDTO, String requestID)
			throws DataNotFoundException {
		ReminderMapper alertsMapper = new ReminderMapper();
		List<ReminderServiceDTO> reminderServiceDTOs = null;
		String strQuery = "select * from sp_select_get_remainders(" + alertsServiceDTO.getModuleid() + ")";
		log.info(requestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<ReminderPersistenceDTO> gisPersDTOs = alertsMapper
					.convertObjetsArraytoReminderPersistenceDTOList(list);
			reminderServiceDTOs = alertsMapper.convertReminderPersistenceDTOListToReminderServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(
					requestID + ":::::::No loadNotificationAlerts::::::" + alertsServiceDTO.getModuleid());
		}
		return reminderServiceDTOs;
	}

	@Override
	public String updateVersion(NotificationAlertsServiceDTO dataInfo, String requestId) throws DataNotFoundException {
		String listData = null;
		if (null != dataInfo) {
			String query = "select * from sp_updateversion(" + dataInfo.getUserId() + "," + dataInfo.getModuleId() + ","
					+ dataInfo.getRoleId() + ",'" + dataInfo.getVersion() + "')";
			log.info("updateVersion query::::: " + query);
			listData = objCommonDataDaoImpl.saveData(query);
		} else {
			throw new DataNotFoundException("");
		}
		return listData;
	}

	@Override
	public String performedManualLogout(NotificationAlertsServiceDTO dataInfo, String requestId)
			throws DataNotFoundException {
		String listData = null;
		if (null != dataInfo) {
			String query = "select * from sp_updatemanuallogout(" + dataInfo.getUserId() + ")";
			log.info("performedManualLogout query::::: " + query);
			listData = objCommonDataDaoImpl.saveData(query);
		} else {
			throw new DataNotFoundException("");
		}
		return listData;
	}

	@Override
	public List<NotificationAlertsServiceDTO> getStatus(NotificationAlertsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		NotificationAlertsMapper objNotificationAlertsMapper = new NotificationAlertsMapper();
		List<NotificationAlertsServiceDTO> NotificationAlertsServiceDTOs = null;
		String strQuery = "select * from sp_select_module_wise_erseventstatus_type(" + dataInfo.getModuleId() + ")";
		log.info(":::::::getStatus::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<NotificationAlertsPersistenceDTO> PersDTOs = objNotificationAlertsMapper
					.conversiongettingStatusDetails(list);
			NotificationAlertsServiceDTOs = objNotificationAlertsMapper
					.convertNotificationAlertsPersistenceDTOListToNotificationAlertsServiceDTOList(PersDTOs);
		} else {
			throw new DataNotFoundException(":::::::getStatus::::::" + dataInfo.getUserId());
		}
		return NotificationAlertsServiceDTOs;
	}

	@Override
	public String updateRemainder(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("updateRemainder method is executed inside ERSViewServiceImpl");
		String strQuery = "select * from sp_upd_ers_agent_remainder_trans(" + dataServiceDTO.getAcKnowledged() + ","
				+ dataServiceDTO.getCreatedById() + ",'" + dataServiceDTO.getAcKnowledgedTime() + "'," + "'"
				+ dataServiceDTO.getReamainderWithTimeStamp() + "'," + dataServiceDTO.getRemainderId() + ")";

		log.info(strRequestID + "::::::::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}
	@Override
	public List<GetRemaindersServiceDto> getRemainders(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		List<GetRemaindersServiceDto> listOfData;
		log.info("getRemainders method is executed inside ERSViewServiceImpl");
		String strQuery = "select * from sp_select_get_remainders(" + dataServiceDTO.getModuleId() + ")";
		log.info(strRequestID + "::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetRemaindersMapper mapper = new GetRemaindersMapper();
			List<GetRemaindersPersistenceDto> gisPersDTOs = mapper.conversionForListOfRemainders(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + "::::::: NO  Data Avl..---->getRemainders::::::");
		}
		return listOfData;
	}
	
}
