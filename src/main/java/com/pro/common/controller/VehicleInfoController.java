package com.pro.common.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.VehicleInfoControllerDTO;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.VehicleInfoMapper;
import com.pro.common.service.VehicleInfoService;
import com.pro.common.servicedto.VehicleInfoServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.VehicleInfoWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 */
@RestController
@RequestMapping("/VehicleInfoController")
@Slf4j
public class VehicleInfoController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("objVehicleInfoServiceImpl")
	private VehicleInfoService objVehicleInfoServiceImpl;
	@Autowired
	Environment environment;
	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 16-07-2019
	 * @Des : VehicleInformation
	 * @URL : 192.168.1.215:1003/common/VehicleInfoController/VehicleInformation
	 */

	@RequestMapping(value = "/VehicleInformation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response VehicleInformation(@RequestBody VehicleInfoControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		VehicleInfoMapper objVehicleInfoMapper = new VehicleInfoMapper();
		VehicleInfoWrapper objVehicleInfoWrapper = new VehicleInfoWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::VehicleInformation():::::INPUT::ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getVehicleId())) {
			throw new InSufficientInputException("::::VehicleInformation:::::");
		} else {
			VehicleInfoServiceDTO dataServiceDTO = objVehicleInfoMapper
					.convertControllerDTOtoServiceDTO(dataControllerDTO);
			List<VehicleInfoServiceDTO> sDto = objVehicleInfoServiceImpl.VehicleInformation(dataServiceDTO,
					strRequestID);
			objVehicleInfoWrapper
					.setObjVehicleInfoControllerDTO(objVehicleInfoMapper.convertServiceDTOtoControllerDTO(sDto));
			objVehicleInfoWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objVehicleInfoWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objVehicleInfoWrapper.setServerIp(ip);
			objVehicleInfoWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objVehicleInfoWrapper.toString());
		return objVehicleInfoWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 16-07-2019
	 * @Des : Infrastructure
	 * @URL : 192.168.1.215:1003/common/VehicleInfoController/Infrastructure
	 */

	@RequestMapping(value = "/Infrastructure", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response Infrastructure(@RequestBody VehicleInfoControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		VehicleInfoMapper objVehicleInfoMapper = new VehicleInfoMapper();
		VehicleInfoWrapper objVehicleInfoWrapper = new VehicleInfoWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::Infrastructure():::::INPUT::ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getVehicleId())) {
			throw new InSufficientInputException("::::Infrastructure:::::");
		} else {
			VehicleInfoServiceDTO dataServiceDTO = objVehicleInfoMapper
					.convertControllerDTOtoServiceDTO(dataControllerDTO);
			List<VehicleInfoServiceDTO> sDto = objVehicleInfoServiceImpl.Infrastructure(dataServiceDTO, strRequestID);
			objVehicleInfoWrapper
					.setObjVehicleInfoControllerDTO(objVehicleInfoMapper.convertServiceDTOtoControllerDTO(sDto));
			objVehicleInfoWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objVehicleInfoWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objVehicleInfoWrapper.setServerIp(ip);
			objVehicleInfoWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objVehicleInfoWrapper.toString());
		return objVehicleInfoWrapper;
	}

}
