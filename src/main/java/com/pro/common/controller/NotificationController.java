/**
 * 
 */
package com.pro.common.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.common.controllerdto.GetRemaindersControllerDto;
import com.pro.common.controllerdto.NotificationAlertsControllerDTO;
import com.pro.common.controllerdto.ReminderControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.GetRemaindersMapper;
import com.pro.common.mappers.NotificationAlertsMapper;
import com.pro.common.mappers.ReminderMapper;
import com.pro.common.service.NotificationAlertsService;
import com.pro.common.servicedto.GetRemaindersServiceDto;
import com.pro.common.servicedto.NotificationAlertsServiceDTO;
import com.pro.common.servicedto.ReminderServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.GetRemaindersWrapper;
import com.pro.common.wrapers.NotificationAlertsWrapper;
import com.pro.common.wrapers.ReminderWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO Notifications are loading from here
 */
@RestController
@RequestMapping("/notifications")
@Slf4j
public class NotificationController {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	Environment environment;
	@Autowired
	@Qualifier("objNotificationAlertsServiceImpl")
	private NotificationAlertsService objNotificationAlertsServiceImpl;

	/*
	 * For loading of Notifications in a module AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/notifications/getNotifications
	 * {"alertRequestedModuleID":4}
	 */
	@RequestMapping(value = "/getNotifications", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getNotifications(@RequestBody NotificationAlertsControllerDTO alertsControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		NotificationAlertsMapper alertsMapper = new NotificationAlertsMapper();
		NotificationAlertsWrapper alertsWrapper = new NotificationAlertsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getNotifications():::INPUTS ARE::::" + alertsControllerDTO);
		if (IsEmptyUtil.isEmptyObject(alertsControllerDTO.getAlertRequestedModuleID())) {
			throw new InSufficientInputException("");
		} else {
			NotificationAlertsServiceDTO dataServiceDTO = alertsMapper
					.convertNotificationAlertsControllerDTOtoNotificationAlertsServiceDTO(alertsControllerDTO);
			List<NotificationAlertsServiceDTO> sDto = objNotificationAlertsServiceImpl
					.loadNotificationAlerts(dataServiceDTO, strRequestID);
			alertsWrapper.setNotificationAlertsControllerDTOs(
					alertsMapper.convertNotificationAlertsServiceDTOListToNotificationAlertsControllerDTOList(sDto));
			alertsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			alertsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			alertsWrapper.setServerIp(ip);
			alertsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + alertsWrapper.toString());
		return alertsWrapper;
	}

	/*
	 * For loading of Reminders in a module AUTHOR::::VENKAT DATE::::::16-05-2019
	 * http://localhost:1000/notifications/getReminders {"moduleid":4}
	 */
	@RequestMapping(value = "/getReminders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getReminders(@RequestBody ReminderControllerDTO alertsControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		ReminderMapper alertsMapper = new ReminderMapper();
		ReminderWrapper alertsWrapper = new ReminderWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getReminders():::INPUTS ARE:::" + alertsControllerDTO);
		if (IsEmptyUtil.isEmptyObject(alertsControllerDTO.getModuleid())) {
			throw new InSufficientInputException("");
		} else {
			ReminderServiceDTO dataServiceDTO = alertsMapper
					.convertReminderControllerDTOtoReminderServiceDTO(alertsControllerDTO);
			List<ReminderServiceDTO> sDto = objNotificationAlertsServiceImpl.loadReminders(dataServiceDTO,
					strRequestID);
			alertsWrapper.setControllerDTOs(
					alertsMapper.convertNotificationAlertsServiceDTOListToReminderControllerDTOList(sDto));
			alertsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			alertsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			alertsWrapper.setServerIp(ip);
			alertsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + alertsWrapper.toString());
		return alertsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-06-08
	 * @Des : updateVersion
	 * @Parameters : NotificationAlertsControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/notifications/updateVersion
	 */

	@CrossOrigin
	@RequestMapping(value = "/updateVersion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateVersion(@RequestBody NotificationAlertsControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateVersion():::INPUTS ARE:::" + dataControllerDTO);
		NotificationAlertsServiceDTO dataInfo = new NotificationAlertsServiceDTO();
		NotificationAlertsMapper objNotificationAlertsMapper = new NotificationAlertsMapper();
		NotificationAlertsWrapper objNotificationAlertsWrapper = new NotificationAlertsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getVersion())) {
			throw new InSufficientInputException(dataControllerDTO.toString());
		} else {
			dataInfo = objNotificationAlertsMapper
					.convertNotificationAlertsControllerDTOtoNotificationAlertsServiceDTO(dataControllerDTO);
			String commonResponse = objNotificationAlertsServiceImpl.updateVersion(dataInfo, strRequestID);
			objNotificationAlertsWrapper.setResponseCode(HttpStatus.OK.value());
			objNotificationAlertsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objNotificationAlertsWrapper.setCount(commonResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objNotificationAlertsWrapper.setServerIp(ip);
			objNotificationAlertsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objNotificationAlertsWrapper.toString());
		return objNotificationAlertsWrapper;

	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-06-08
	 * @Des : performedManualLogout
	 * @Parameters : NotificationAlertsControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/notifications/performedManualLogout
	 */

	@CrossOrigin
	@RequestMapping(value = "/performedManualLogout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response performedManualLogout(@RequestBody NotificationAlertsControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::performedManualLogout():::INPUTS ARE:::" + dataControllerDTO);
		NotificationAlertsServiceDTO dataInfo = new NotificationAlertsServiceDTO();
		NotificationAlertsMapper objNotificationAlertsMapper = new NotificationAlertsMapper();
		NotificationAlertsWrapper objNotificationAlertsWrapper = new NotificationAlertsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())) {
			throw new InSufficientInputException(dataControllerDTO.toString());
		} else {
			dataInfo = objNotificationAlertsMapper
					.convertNotificationAlertsControllerDTOtoNotificationAlertsServiceDTO(dataControllerDTO);
			String commonResponse = objNotificationAlertsServiceImpl.performedManualLogout(dataInfo, strRequestID);
			objNotificationAlertsWrapper.setResponseCode(HttpStatus.OK.value());
			objNotificationAlertsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objNotificationAlertsWrapper.setCount(commonResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objNotificationAlertsWrapper.setServerIp(ip);
			objNotificationAlertsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objNotificationAlertsWrapper.toString());
		return objNotificationAlertsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-06-08
	 * @Des : getStatus
	 * @Parameters : NotificationAlertsControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/notifications/getStatus
	 */
	@RequestMapping(value = "/getStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStatus(@RequestBody NotificationAlertsControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		NotificationAlertsMapper mapper = new NotificationAlertsMapper();
		NotificationAlertsWrapper wrapper = new NotificationAlertsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getStatus():::INPUTS ARE:::" + dataControllerDTO);
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())) {
			throw new InSufficientInputException(dataControllerDTO.getModuleId());
		} else {
			NotificationAlertsServiceDTO dataServiceDTO = mapper
					.convertNotificationAlertsControllerDTOtoNotificationAlertsServiceDTO(dataControllerDTO);
			List<NotificationAlertsServiceDTO> sDto = objNotificationAlertsServiceImpl.getStatus(dataServiceDTO,
					strRequestID);
			wrapper.setNotificationAlertsControllerDTOs(
					mapper.convertNotificationAlertsServiceDTOListToNotificationAlertsControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 17-07-2019
	 * @Des : updateRemainder
	 * @Parameters : NotificationAlertsControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/notifications/updateRemainder {
	 *      "acKnowledged":true, "createdById":1, "acKnowledgedTime":"now()",
	 *      "reamainderWithTimeStamp":"now()", "remainderId":1 }
	 */
	@RequestMapping(value = "/updateRemainder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateRemainder(@RequestBody GetRemaindersControllerDto objGetRemaindersControllerDto)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		NotificationAlertsWrapper wrapper = new NotificationAlertsWrapper();
		log.info(strRequestID + "::::updateRemainder():::INPUTS ARE:::" + objGetRemaindersControllerDto);
		if (IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getAcKnowledged())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getCreatedById())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getAcKnowledgedTime())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getReamainderWithTimeStamp())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getRemainderId())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objNotificationAlertsServiceImpl.updateRemainder(
					new GetRemaindersMapper().conversionForControllerToServiceDTO(objGetRemaindersControllerDto),
					strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 17-07-2019
	 * @Des : getRemainders
	 * @Parameters : NotificationAlertsControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/notifications/getRemainders
	 */

	@RequestMapping(value = "/getRemainders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRemainders(@RequestBody GetRemaindersControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getRemainders():::INPUTS ARE:::" + objControllerDto);
		GetRemaindersWrapper wrapper = new GetRemaindersWrapper();
		if (IsEmptyUtil.isEmptyObject(objControllerDto.getModuleId())) {
			throw new InSufficientInputException(objControllerDto.toString());
		} else {
			GetRemaindersMapper mapper = new GetRemaindersMapper();
			List<GetRemaindersServiceDto> sDto = objNotificationAlertsServiceImpl
					.getRemainders(mapper.conversionForControllerToServiceDTO(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}
}
