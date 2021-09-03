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

import com.pro.common.controllerdto.LoadMandatoryFieldsControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.LoadMandatoryFieldsMapper;
import com.pro.common.service.LoadMandatoryFieldsService;
import com.pro.common.servicedto.LoadMandatoryFieldsServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.LoadMandatoryFieldsWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 17-07-2019
 */
@RestController
@RequestMapping("/LoadMandatoryFieldController")
@Slf4j
public class LoadMandatoryFieldController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("objLoadMandatoryServiceImpl")
	private LoadMandatoryFieldsService objLoadMandatoryServiceImpl;
	@Autowired
	Environment environment;
	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 17-07-2019
	 * @Des : loadModuleFields
	 * @URL :
	 *      192.168.1.215:1003/common/LoadMandatoryFieldController/loadModuleFields
	 */

	@RequestMapping(value = "/loadModuleFields", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadModuleFields(@RequestBody LoadMandatoryFieldsControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadModuleFields():::INPUTS ARE:::" + dataControllerDTO);
		LoadMandatoryFieldsServiceDTO objLoadMandatoryFieldsServiceDTO = new LoadMandatoryFieldsServiceDTO();
		LoadMandatoryFieldsMapper objLoadMandatoryFieldsMapper = new LoadMandatoryFieldsMapper();
		LoadMandatoryFieldsWrapper objLoadMandatoryFieldsWrapper = new LoadMandatoryFieldsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())) {
			throw new InSufficientInputException("");
		} else {
			objLoadMandatoryFieldsServiceDTO = objLoadMandatoryFieldsMapper
					.convertControllerDTOtoServiceDTO(dataControllerDTO);
			List<LoadMandatoryFieldsServiceDTO> result = objLoadMandatoryServiceImpl
					.loadModuleFields(objLoadMandatoryFieldsServiceDTO, strRequestID);
			objLoadMandatoryFieldsWrapper.setResponseCode(HttpStatus.OK.value());
			objLoadMandatoryFieldsWrapper.setObjLoadMandatoryFieldsControllerDTO(
					objLoadMandatoryFieldsMapper.convertServiceDTOtoControllerDTO(result));
			objLoadMandatoryFieldsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objLoadMandatoryFieldsWrapper.setServerIp(ip);
			objLoadMandatoryFieldsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objLoadMandatoryFieldsWrapper.toString());
		return objLoadMandatoryFieldsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 17-07-2019
	 * @Des : loadScreenMandatoryFields
	 * @URL :
	 *      192.168.1.215:1003/common/LoadMandatoryFieldController/loadScreenMandatoryFields
	 */

	@RequestMapping(value = "/loadScreenMandatoryFields", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadScreenMandatoryFields(@RequestBody LoadMandatoryFieldsControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadScreenMandatoryFields():::INPUTS ARE:::" + dataControllerDTO);
		LoadMandatoryFieldsServiceDTO objLoadMandatoryFieldsServiceDTO = new LoadMandatoryFieldsServiceDTO();
		LoadMandatoryFieldsMapper objLoadMandatoryFieldsMapper = new LoadMandatoryFieldsMapper();
		LoadMandatoryFieldsWrapper objLoadMandatoryFieldsWrapper = new LoadMandatoryFieldsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getScreenId())) {
			throw new InSufficientInputException("");
		} else {
			objLoadMandatoryFieldsServiceDTO = objLoadMandatoryFieldsMapper
					.convertControllerDTOtoServiceDTO(dataControllerDTO);
			List<LoadMandatoryFieldsServiceDTO> result = objLoadMandatoryServiceImpl
					.loadScreenMandatoryFields(objLoadMandatoryFieldsServiceDTO, strRequestID);
			objLoadMandatoryFieldsWrapper.setResponseCode(HttpStatus.OK.value());
			objLoadMandatoryFieldsWrapper.setObjLoadMandatoryFieldsControllerDTO(
					objLoadMandatoryFieldsMapper.convertServiceDTOtoControllerDTO(result));
			objLoadMandatoryFieldsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objLoadMandatoryFieldsWrapper.setServerIp(ip);
			objLoadMandatoryFieldsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objLoadMandatoryFieldsWrapper.toString());
		return objLoadMandatoryFieldsWrapper;
	}

}
