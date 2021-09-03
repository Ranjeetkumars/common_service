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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.common.controllerdto.ERSEventFeedControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.ERSEventFeedMapper;
import com.pro.common.service.ERSEventFeedService;
import com.pro.common.servicedto.ERSEventFeedServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.ERSEventFeedWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 */
@RestController
@RequestMapping("/ERSEventFeedController")
@Slf4j
public class ERSEventFeedController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("objERSEventFeedServiceImpl")
	private ERSEventFeedService objERSEventFeedServiceImpl;
	@Autowired
	Environment environment;

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 16-07-2019
	 * @Des : loadErsEventFeedTypes
	 * @URL : 192.168.1.215:1003/common/ERSEventFeedController/loadErsEventFeedTypes
	 */

	@RequestMapping(value = "/loadErsEventFeedTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadErsEventFeedTypes() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		ERSEventFeedMapper objERSEventFeedMapper = new ERSEventFeedMapper();
		ERSEventFeedWrapper objERSEventFeedWrapper = new ERSEventFeedWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::loadErsEventFeedTypes:::GET::METHOD");
		List<ERSEventFeedServiceDTO> sDto = objERSEventFeedServiceImpl.loadErsEventFeedTypes(strRequestID);
		objERSEventFeedWrapper
				.setObjERSEventFeedControllerDTO(objERSEventFeedMapper.convertServiceDTOtoControllerDTO(sDto));
		objERSEventFeedWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objERSEventFeedWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::OUTPUT:::::" + objERSEventFeedWrapper.toString());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		objERSEventFeedWrapper.setServerIp(ip);
		objERSEventFeedWrapper.setPort(port);
		return objERSEventFeedWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 16-07-2019
	 * @Des : saveFeedInfo
	 * @URL : 192.168.1.215:1003/common/ERSEventFeedController/saveFeedInfo
	 */

	@RequestMapping(value = "/saveFeedInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveFeedInfo(@RequestBody ERSEventFeedControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::saveFeedInfo():::::INPUTS ARE:::" + dataControllerDTO.toString());
		ERSEventFeedServiceDTO objERSEventFeedServiceDTO = new ERSEventFeedServiceDTO();
		ERSEventFeedMapper objERSEventFeedMapper = new ERSEventFeedMapper();
		ERSEventFeedWrapper objERSEventFeedWrapper = new ERSEventFeedWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getEventId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFeedText())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFeedTypeId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())) {
			throw new InSufficientInputException("");
		} else {
			objERSEventFeedServiceDTO = objERSEventFeedMapper.convertControllerDTOtoServiceDTO(dataControllerDTO);
			String result = objERSEventFeedServiceImpl.saveFeedInfo(objERSEventFeedServiceDTO, strRequestID);
			objERSEventFeedWrapper.setResponseCode(HttpStatus.OK.value());
			objERSEventFeedWrapper.setOutput(result);
			objERSEventFeedWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objERSEventFeedWrapper.setServerIp(ip);
			objERSEventFeedWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objERSEventFeedWrapper.toString());
		return objERSEventFeedWrapper;
	}

}
