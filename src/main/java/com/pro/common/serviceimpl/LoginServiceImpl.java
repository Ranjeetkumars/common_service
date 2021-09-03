/**
 * 
 */
package com.pro.common.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.AuthanticationMapper;
import com.pro.common.mappers.UsersDataMapper;
import com.pro.common.persistencedto.AuthanticationPersistenceDTO;
import com.pro.common.persistencedto.UsersDataPersistenceDTO;
import com.pro.common.service.LoginService;
import com.pro.common.servicedto.AuthanticationServiceDTO;
import com.pro.common.servicedto.UsersDataServiceDTO;
import com.pro.common.utills.CommonConstants;
import com.pro.common.utills.CommonMethods;
import com.pro.common.utills.LoginErrorCodes;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO
 *
 */
@SuppressWarnings("unchecked")
@Service("objLoginServiceImpl")
@Slf4j
public class LoginServiceImpl implements LoginService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	public List<UsersDataServiceDTO> loadPrevillages(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_useprevilizes(" + dataServiceDTO.getUserID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper
					.convertObjetsArraytoUsersDataPersistenceDTOList(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(
					strRequestID + ":::::::No loadPrevillages::::::" + dataServiceDTO.getUserID());
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> loadRoles(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select rl_roleid,rl_rolename,rl_moduleid from amsroles_ref where rl_isactive=TRUE ORDER BY rl_moduleid";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.convertionForgettingRoles(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadRoles::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> getAsdterisdk_CCTCredentialsNew(UsersDataServiceDTO dataServiceDTO,
			String strRequestID) throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "Select * from sp_slelct_hhc_ip_terminal('" + dataServiceDTO.getHhc_ip() + "',"
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgetAsdterisdk_CCTCredentialsNew(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getAsdterisdk_CCTCredentialsNew::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public String saveInvalidCredentials(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String listData = null;
		String query = "select * from sp_ins_ams_invalid_login_trans('" + dataServiceDTO.getHhc_ip() + "',"
				+ dataServiceDTO.getExtension() + "," + dataServiceDTO.getModuleID() + ",'"
				+ dataServiceDTO.getUserName() + "','" + dataServiceDTO.getUserPassword() + "','"
				+ dataServiceDTO.getRemarks() + "')";
		log.info("saveAsteriskCallTimes query::::: " + query);
		listData = objCommonDataDaoImpl.saveData(query);
		return listData;
	}

	@Override
	public String getManagerId(String strRequestID) throws DataNotFoundException {
		String strQuery = "select * from sp_select_amsmanager_employee_trans()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public String updateShiftTimings(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String listData = null;
		String query = "select * from sp_update_amslogin_trans_shiftid(" + dataServiceDTO.getShiftID() + ","
				+ dataServiceDTO.getUserID() + "," + dataServiceDTO.getModuleID() + ")";
		log.info("updateShiftTimings query::::: " + query);
		listData = objCommonDataDaoImpl.saveData(query);
		return listData;
	}

	@Override
	public List<UsersDataServiceDTO> loadAVAYATerminalLoginDetails(UsersDataServiceDTO dataServiceDTO,
			String strRequestID) throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "SELECT * FROM sp_admin_select_cct_credentials(" + dataServiceDTO.getModuleID() + ","
				+ dataServiceDTO.getUserID() + ",'" + dataServiceDTO.getHhc_ip() + "')";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForloadAVAYATerminalLoginDetails(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getManagerId::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public String saveRemainder(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		String listData = null;
		String query = "select * from sp_insert_ers_agent_remainder_trans('" + dataServiceDTO.getEar_remainder_text()
				+ "','" + dataServiceDTO.getEar_remainder_date() + "','"
				+ dataServiceDTO.getEar_is_event_specific_or_personal() + "'," + dataServiceDTO.getEar_event_id() + ","
				+ dataServiceDTO.getEar_remainder_created_by_id() + "," + dataServiceDTO.getModuleID() + ")";
		log.info("saveRemainder query::::: " + query);
		listData = objCommonDataDaoImpl.saveData(query);
		return listData;
	}

	@Override
	public List<UsersDataServiceDTO> isUserExist(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_login_checkuser('" + dataServiceDTO.getUserName() + "','"
				+ dataServiceDTO.getUserPassword() + "')";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);

		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForisUserExist(list);

			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No isUserExist::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> getUserShiftsByModule(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = " select * from sp_get_dropdown('ersshifts_ref', 'es_shifttype', ' and es_moduleid = "
				+ dataServiceDTO.getModuleID()
				+ "', ' and es_isactive = true',' and extract(hour from current_timestamp) between extract(hour from es_starttime) and extract(hour from es_endtime)-1', '', '')";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgetUserShiftsByModule(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getUserShiftsByModule::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public String Logout(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		String strQuery = "select * from sp_logout_user(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public String getTerMinalID(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		String strQuery = "SELECT  hhc_terminal  FROM hhc_ip_terminal where hhc_ip='" + dataServiceDTO.getHhc_ip()
				+ "'";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public String checkClientServerTime(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		Date dateServer = new Date();
		Date clientDate = null;
		try {
			clientDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(dataServiceDTO.getClientSystemTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultTime = "$" + CommonMethods.validateTime(dateServer, clientDate) + "$" + clientDate + ", "
				+ dateServer + "";

		log.info(strRequestID + "::::::*********:::::::" + resultTime);
		return resultTime;
	}

	@Override
	public List<UsersDataServiceDTO> getOffLineUserFailedEvents(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from vwoffline_events_mda";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.convertionForgettingOffLineUserFailedEvents(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getOffLineUserFailedEvents::::::");
		}
		return commonDataServiceDTOs;
	}

	public String insertOfflineEvents(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		String strQuery = "select * from sp_insert_hm_offlineusercalls(" + dataServiceDTO.getEar_event_id() + ","
				+ dataServiceDTO.getOlduserID() + "," + dataServiceDTO.getNewuserID() + ")";

		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public List<UsersDataServiceDTO> getLeastLoaded(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = null;
		if (dataServiceDTO.getEmergencyGroupID().equalsIgnoreCase("2")) {
			strQuery = "select * from vwoffline_events_mda";

		} else if (dataServiceDTO.getEmergencyGroupID().equalsIgnoreCase("3")) {
			strQuery = "select * from  sp_getleastloadeduserpda()";

		} else if (dataServiceDTO.getEmergencyGroupID().equalsIgnoreCase("5")) {
			strQuery = "select * from sp_getleastloadeduserfda()";
			log.info(strRequestID + ":::::::::::::" + strQuery);
		}

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgettingLeastLoaded(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getLeastLoaded::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<AuthanticationServiceDTO> authenticate(AuthanticationServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		List<AuthanticationServiceDTO> authanticationServiceDTOs=new ArrayList<>();
		
		AuthanticationMapper mapper=new AuthanticationMapper();
		AuthanticationPersistenceDTO objAuthanticationPersistenceDTO = userIdCreationForSingleModule(dataServiceDTO,
				strRequestID);
		if (objAuthanticationPersistenceDTO.getErrorcode().equals("0")) {
			/*
			 * Check here he is allready login Or not
			 */
			String check_allready_login = "select  * from sp_loggedin_user("
					+ objAuthanticationPersistenceDTO.getUserId() + "," + objAuthanticationPersistenceDTO.getModuleId()
					+ ")";
			log.info(strRequestID + "::::::check_allready_login:::::::" + check_allready_login);
			List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(check_allready_login);
			if (list == null || list.isEmpty()) {
				String login_query = "select  * from sp_ins_amslogin_trans("
						+ objAuthanticationPersistenceDTO.getUserId() + ",'" + dataServiceDTO.getIpAddress() + "',"
						+ dataServiceDTO.getPort() + "," + dataServiceDTO.getExtention() + ","
						+ objAuthanticationPersistenceDTO.getModuleId() + ","+CommonConstants.LOGIN_INTO_MODULE+")";
				log.info(strRequestID + "::::::login_query:::::::" + login_query);
				objCommonDataDaoImpl.saveData(login_query);			
			} else {
				objAuthanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_ALLREADY_LOGGEDIN);
			}
			
			String update_exceptional_call_status ="select * from sp_insert_update_hm_all_modules_exceptional_call_status(" + objAuthanticationPersistenceDTO.getUserId() + ")";
			log.info(strRequestID + "::::::update_exceptional_call_status:::::::" + update_exceptional_call_status);
			objCommonDataDaoImpl.saveData(update_exceptional_call_status);		
			authanticationServiceDTOs.add(mapper.convertAuthanticationPersistenceDTOtoAuthanticationServiceDTO(objAuthanticationPersistenceDTO));
		}		
		return authanticationServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> getLoggedModules(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select * from sp_select_online_user_moduleslist(" + dataServiceDTO.getUserID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object> list = (List<Object>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgettinLoggedModules(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getLoggedModules::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public String sp_chk_usershift(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String strQuery = "select * from sp_chk_usershift(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public List<UsersDataServiceDTO> checkForModule(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select * from  sp_login_checkformodule(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForcheckingModule(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No checkForModule::::::");
		}
		return commonDataServiceDTOs;
	}

	
	@Override
	public List<UsersDataServiceDTO> getRoles(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select * from sp_login_assignedroles(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForcheckingModule(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getRoles::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> getPrevillages(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select * from sp_login_assignedprivileges(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + "," + dataServiceDTO.getRoleID() + ","
				+ dataServiceDTO.getIssystemPrivilege() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgettingPrevillages(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getPrevillages::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> checkForLogin(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select  * from sp_loggedin_user(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForcheckingModule(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No checkForLogin::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public List<UsersDataServiceDTO> getPostgers(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "select * from sp_ams_select_ams_postgres_service_trans('" + dataServiceDTO.getStrXml()
				+ "')";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object> list = (List<Object>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgettingPostgers(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No checkPostgers::::::");
		}
		return commonDataServiceDTOs;
	}

	@Override
	public String login(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		String strQuery = "select * from sp_ins_amslogin_trans(" + dataServiceDTO.getUserID() + ",'"
				+ dataServiceDTO.getHhc_ip() + "'," + dataServiceDTO.getPortNo() + " ," + dataServiceDTO.getExtension()
				+ " ," + dataServiceDTO.getModuleID() + ", " + dataServiceDTO.getUnifiedgrouptypeId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public String insertandUpdateCallStatus(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String strQuery = "select * from sp_insert_update_hm_all_modules_exceptional_call_status("
				+ dataServiceDTO.getUserID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public String getSupervisorId(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String strQuery = "select * from sp_logincheck_supervisor(" + dataServiceDTO.getUserID() + ","
				+ dataServiceDTO.getModuleID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String result = objCommonDataDaoImpl.getSingleData(strQuery);
		return result;
	}

	@Override
	public List<UsersDataServiceDTO> getServerLicences(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		UsersDataMapper alertsMapper = new UsersDataMapper();
		List<UsersDataServiceDTO> commonDataServiceDTOs = null;

		String strQuery = "SELECT * FROM sp_admin_licence_select_ams_postgres_service_trans('"
				+ dataServiceDTO.getHhc_ip() + "');";
		log.info(strRequestID + ":::::::::::::" + strQuery);

		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<UsersDataPersistenceDTO> gisPersDTOs = alertsMapper.conversionForgettingServerLicences(list);
			commonDataServiceDTOs = alertsMapper
					.convertUsersDataPersistenceDTOListToUsersDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getServerLicences::::::");
		}
		return commonDataServiceDTOs;
	}

	public AuthanticationPersistenceDTO userIdCreationForSingleModule(AuthanticationServiceDTO dataServiceDTO,
			String strRequestID) throws DataNotFoundException {		
		AuthanticationPersistenceDTO authanticationPersistenceDTO = new AuthanticationPersistenceDTO();
		authanticationPersistenceDTO.setErrorcode(dataServiceDTO.getErrorcode());
		authanticationPersistenceDTO.setModuleId(dataServiceDTO.getModuleId());
		authanticationPersistenceDTO.setUserName(dataServiceDTO.getUserName());
		authanticationPersistenceDTO.setPassword(dataServiceDTO.getPassword());
		String strQuery = "select * from sp_login_checkuser('" + dataServiceDTO.getUserName() + "','"+ dataServiceDTO.getPassword() + "')";
		log.info(strRequestID + "::::authenticate:::::::::" + strQuery);
		String userID = objCommonDataDaoImpl.getSingleData(strQuery);
		log.info(strRequestID + "::::userID:::::::::" + userID);
		if (userID == null || userID.isEmpty()) {
			authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USERNAME_PASSWORD_WORNG);
			log.warn("in valid user name and password");
			
		} else {			
			authanticationPersistenceDTO.setUserId(userID);
			String strQuery_modules = "select * from sp_select_online_user_moduleslist(" + userID + ")";
			log.info(strRequestID + "::::strQuery_modules:::::::::" + strQuery_modules);
			List<Object> modulesList = (List<Object>) objCommonDataDaoImpl.getData(strQuery_modules);
			if (modulesList != null && modulesList.size() > 0) {
				if (dataServiceDTO.getModuleId().equalsIgnoreCase("4")) {
					Iterator it = modulesList.iterator();
					while (it.hasNext()) {
						Object objmodule = it.next();
						Integer loggedModule = Integer.parseInt(objmodule.toString());
						if (loggedModule == 21 || loggedModule == 22 || loggedModule == 23 || loggedModule == 24
								|| loggedModule == 5) {
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.LOGGEDINSOMEANOTHER_MODULE);
							break;
						}

					}

				}
				if (dataServiceDTO.getModuleId().equalsIgnoreCase("5")) {
					Iterator it = modulesList.iterator();
					while (it.hasNext()) {
						Object objmodule = it.next();
						Integer loggedModule = (Integer) objmodule;
						if (loggedModule == 21 || loggedModule == 22 || loggedModule == 23 || loggedModule == 24
								|| loggedModule == 4) {
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.LOGGEDINSOMEANOTHER_MODULE);
							break;
						}

					}
				}
				if (dataServiceDTO.getModuleId().equalsIgnoreCase("21")
						|| dataServiceDTO.getModuleId().equalsIgnoreCase("22")
						|| dataServiceDTO.getModuleId().equalsIgnoreCase("23")
						|| dataServiceDTO.getModuleId().equalsIgnoreCase("24")) {
					Iterator it = modulesList.iterator();
					while (it.hasNext()) {
						Object objmodule = it.next();
						Integer loggedModule = (Integer) objmodule;
						if (loggedModule == 4 || loggedModule == 5) {
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.LOGGEDINSOMEANOTHER_MODULE);
							break;
						}

					}
				}
			}
			if (authanticationPersistenceDTO.getErrorcode().equalsIgnoreCase("0")) {
				authanticationPersistenceDTO.setUserId(userID);
				String strQuery_checkusershift = "select * from sp_chk_usershift(" + userID + ","+ dataServiceDTO.getModuleId() + ")";
				log.info(strRequestID + "::::strQuery_checkusershift:::::::::" + strQuery_checkusershift);
				String output = objCommonDataDaoImpl.getSingleData(strQuery_checkusershift);
				Integer check_Shift = Integer.parseInt(output);
				authanticationPersistenceDTO.setUserId(dataServiceDTO.getUserId());
				if (check_Shift > 0) {
					List<Object[]> check_modules = null;
					if (dataServiceDTO.getModuleId().equalsIgnoreCase("4")) {
						if (dataServiceDTO.getModuleId().equalsIgnoreCase("4")) {
							authanticationPersistenceDTO.setModuleId("4");
							authanticationPersistenceDTO.setUserId(userID);
							String strQuery_checkModule = "select * from  sp_login_checkformodule(" + userID + ","
									+ authanticationPersistenceDTO.getModuleId() + ")";
							log.info(strRequestID + "::::strQuery_checkModule:::::::::" + strQuery_checkModule);
							check_modules = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_checkModule);
						}
						if (check_modules == null || check_modules.isEmpty()) {
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_MODULE);
						}
					} else {
						authanticationPersistenceDTO.setUserId(userID);
						String strQuery_checkModule = "select * from  sp_login_checkformodule("
								+ authanticationPersistenceDTO.getUserId() + "," + dataServiceDTO.getModuleId() + ")";
						log.info(strRequestID + "::::strQuery_checkModule:123::::::::" + strQuery_checkModule);
						check_modules = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_checkModule);
						if (check_modules == null || check_modules.isEmpty()) {
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_MODULE);
						}
					}
					log.info("number of modules" + check_modules.size());

					if (authanticationPersistenceDTO.getErrorcode().equalsIgnoreCase("0")) {
						Iterator<Object[]> moduleCheckIt = check_modules.listIterator();
						while (moduleCheckIt.hasNext()) {
							Object[] data = moduleCheckIt.next();
							authanticationPersistenceDTO.setModuleName(data[1].toString());
						}
						authanticationPersistenceDTO.setUserId(userID);
						String strQuery_Roles = "select * from  sp_login_assignedroles(" + userID + ","+ authanticationPersistenceDTO.getModuleId() + ")";
						log.info(strRequestID + "::::strQuery_Roles:::::::::" + strQuery_Roles);
						List<Object[]> check_roles = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_Roles);
						if (check_roles == null || check_roles.isEmpty()) {
							System.out.println("no roles are given");
							authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_ROLE);
						} else {
							Iterator<Object[]> rolesIt = check_roles.listIterator();
							JSONArray rolesArray = new JSONArray();
							JSONArray PrivvilagesArray = new JSONArray();
							while (rolesIt.hasNext()) {
								Object[] role = rolesIt.next();
								if (role.length > 0 || role[0] != null) {
									JSONObject roleJson = new JSONObject();
									roleJson.put("roleid", role[0].toString());
									roleJson.put("rolename", role[1].toString());
									rolesArray.add(roleJson);
									authanticationPersistenceDTO.setUserId(userID);									
									//System Privillages
									String strQuery_Privillages = "select * from  sp_login_assignedprivileges(" + userID
											+ "," + authanticationPersistenceDTO.getModuleId() + ","
											+ role[0].toString() + ",true)";////true for systemprevillage
									
									log.info(strRequestID + "::::strQuery_Privillages:::::::::" + strQuery_Privillages);
									List<Object[]> check_previllages = (List<Object[]>) objCommonDataDaoImpl
											.getData(strQuery_Privillages);
									
									if (check_previllages == null || check_previllages.isEmpty()) {
										System.out.println("no Previllages are given");
										authanticationPersistenceDTO
												.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_PREVILLAGES);
									} else {
										Iterator<Object[]> check_obj = check_previllages.listIterator();
										while (check_obj.hasNext()) {
											Object[] previllage = check_obj.next();
											JSONObject prevJson = new JSONObject();
											prevJson.put("roleid", role[0].toString());
											prevJson.put("rolename", role[1].toString());
											prevJson.put("previllageType", "systemprevillage");
											prevJson.put("previllageID", previllage[0].toString());
											prevJson.put("previllageName", previllage[1].toString());
											PrivvilagesArray.add(prevJson);
										}
									}
									
//									//Normal previllage
									String strQuery__norPrivillages = "select * from  sp_login_assignedprivileges(" + userID
											+ "," + authanticationPersistenceDTO.getModuleId() + ","
											+ role[0].toString() + ",false)";  //false for normal previllage
									log.info(strRequestID + "::::strQuery__norPrivillages:::::::::" + strQuery__norPrivillages);
									List<Object[]> check_previllages_nor = (List<Object[]>) objCommonDataDaoImpl
											.getData(strQuery__norPrivillages);
									if (check_previllages_nor == null || check_previllages_nor.isEmpty()) {
										log.info("no Previllages are given");
//										authanticationPersistenceDTO
//												.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_PREVILLAGES);
									} else {
										Iterator<Object[]> check_obj = check_previllages.listIterator();
										while (check_obj.hasNext()) {
											Object[] previllage = check_obj.next();
											JSONObject prevJson = new JSONObject();
											prevJson.put("roleid", role[0].toString());
											prevJson.put("rolename", role[1].toString());
											prevJson.put("previllageType", "previllage");
											prevJson.put("previllageID", previllage[0].toString());
											prevJson.put("previllageName", previllage[1].toString());
											PrivvilagesArray.add(prevJson);
										}
									}
								}
							}
							authanticationPersistenceDTO.setRoleId(rolesArray.toString());
							authanticationPersistenceDTO.setPrevilageId(PrivvilagesArray.toString());
						}
					}
				} else {
					authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_SHIFT);
				}
			} else {
				authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.LOGGEDINSOMEANOTHER_MODULE);
			}
		}
		return authanticationPersistenceDTO;
	}
	
	
	@Override
	public List<AuthanticationServiceDTO> authenticatewebLogin(AuthanticationServiceDTO objAuthanticationServiceDTO,
			String strRequestID) throws DataNotFoundException {
		AuthanticationMapper mapper=new AuthanticationMapper();
		List<AuthanticationServiceDTO> objAuthanticationServiceDTOs=new ArrayList<AuthanticationServiceDTO>();
		AuthanticationPersistenceDTO authanticationPersistenceDTO = new AuthanticationPersistenceDTO();
		authanticationPersistenceDTO.setErrorcode("0");
		authanticationPersistenceDTO.setUserName(objAuthanticationServiceDTO.getUserName());
		authanticationPersistenceDTO.setPassword(objAuthanticationServiceDTO.getPassword());
		/*
		 * Validating username and password
		 */
		String strQuery = "select * from sp_login_checkuser('" + objAuthanticationServiceDTO.getUserName() + "','"+ objAuthanticationServiceDTO.getPassword() + "')";
		log.info(strRequestID + "::::authenticate:::::::::" + strQuery);
		String userID = objCommonDataDaoImpl.getSingleData(strQuery);
		log.info(strRequestID + "::::userID:::::::::" + userID);
		if (userID == null || userID.isEmpty()) {
			authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USERNAME_PASSWORD_WORNG);
			log.warn("in valid user name and password");
			
		} else {
			authanticationPersistenceDTO.setUserId(userID);
			String modulesassigned="select * from sp_login_assignedmodules(" + authanticationPersistenceDTO.getUserId() +")";
			List<Object[]> modulesMapped= (List<Object[]>) objCommonDataDaoImpl.getData(modulesassigned);
			if(modulesMapped!=null&&!modulesMapped.isEmpty()) {
				
				JSONArray modulesArray=new JSONArray();
				JSONArray rolesArray=new JSONArray();
				JSONArray PrevillagesArray=new JSONArray();
				//Modules loading
				modulesMapped.forEach(modulesObject -> {
				 JSONObject module=new JSONObject();
				 module.put("moduleid", modulesObject[0]);
				 module.put("modulename", modulesObject[1]);
				 modulesArray.add(module);
					String strQuery_Roles = "select * from  sp_login_assignedroles(" + authanticationPersistenceDTO.getUserId() + ","+ modulesObject[0].toString() + ")";
					log.info(strRequestID + "::::strQuery_Roles:::::::::" + strQuery_Roles);
					List<Object[]> check_roles = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_Roles);
					if (check_roles != null && !check_roles.isEmpty()) {
						check_roles.forEach(rolesObject -> {
							JSONObject role=new JSONObject();
							role.put("moduleid", modulesObject[0]);
							role.put("modulename", modulesObject[1]);
							role.put("roleid", rolesObject[0]);
							role.put("rolename", rolesObject[1]);
							rolesArray.add(role);
							String strQuery_Privillages = "select * from  sp_login_assignedprivileges(" + userID
									+ "," +modulesObject[0]+ ","
									+ rolesObject[0].toString() + ",true)";////true for systemprevillage
							
							log.info(strRequestID + "::::strQuery_Privillages:::::::::" + strQuery_Privillages);
							List<Object[]> check_previllages = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_Privillages);
							if(check_previllages!=null&&!check_previllages.isEmpty()) {
								check_previllages.forEach(sysPrevillObject -> {
									JSONObject sysprivillage=new JSONObject();
									sysprivillage.put("moduleid", modulesObject[0]);
									sysprivillage.put("modulename", modulesObject[1]);
									sysprivillage.put("roleid", rolesObject[0]);
									sysprivillage.put("rolename", rolesObject[1]);
									sysprivillage.put("previllageid", sysPrevillObject[0]);
									sysprivillage.put("previllageType", sysPrevillObject[0]);
									sysprivillage.put("previllagename", sysPrevillObject[1]);
									sysprivillage.put("previllageType", "systemprevillage");
									PrevillagesArray.add(sysprivillage);
								});
							}else {
								authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_PREVILLAGES);
							}
							if(authanticationPersistenceDTO.getErrorcode().equalsIgnoreCase("0")) {
								String strQuery_normal_Privillages = "select * from  sp_login_assignedprivileges(" + userID
										+ "," +modulesObject[0] + ","
										+ rolesObject[0].toString() + ",false)";////true for normal previllage								
								log.info(strRequestID + "::::strQuery_normal_Privillages:::::::::" + strQuery_normal_Privillages);
								List<Object[]> check_normalprevillages = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery_normal_Privillages);
								if(check_normalprevillages!=null&&!check_normalprevillages.isEmpty()) {									
									check_normalprevillages.forEach(normalPrevillObject -> {
										JSONObject normprivillage=new JSONObject();
										normprivillage.put("moduleid", modulesObject[0]);
										normprivillage.put("modulename", modulesObject[1]);
										normprivillage.put("roleid", rolesObject[0]);
										normprivillage.put("rolename", rolesObject[1]);
										normprivillage.put("previllageid", normalPrevillObject[0]);
										normprivillage.put("previllageType", "previllage");
										normprivillage.put("previllagename", normalPrevillObject[1]);
										PrevillagesArray.add(normprivillage);
									});
								}
							}							
						});	
						authanticationPersistenceDTO.setPrevilageId(PrevillagesArray.toString());
						authanticationPersistenceDTO.setRoleId(rolesArray.toString());
					}else {
						authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_ROLE);
					}
					
					
				});
				authanticationPersistenceDTO.setModuleId(modulesArray.toString());
				
			}else {
				authanticationPersistenceDTO.setErrorcode(LoginErrorCodes.USER_NOTMAPPED_MODULE);
			}
		}
		 
		objAuthanticationServiceDTOs.add(mapper.convertAuthanticationPersistenceDTOtoAuthanticationServiceDTO(authanticationPersistenceDTO));
		
		return objAuthanticationServiceDTOs;
	}

	@Override
	public String getRolesForOperationalDesk(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String strQuery_Roles = "select * from  sp_select_roleid_foruser(" + dataServiceDTO.getUserName()+ ","+ dataServiceDTO.getModuleID()+ ")";
		String result=objCommonDataDaoImpl.saveData(strQuery_Roles);
		return result;
	}
	
}
