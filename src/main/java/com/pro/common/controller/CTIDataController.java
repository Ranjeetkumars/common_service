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

import com.pro.common.controllerdto.CTIControllerDTO;
import com.pro.common.controllerdto.GetEventLandmarkControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.CTIDataMapper;
import com.pro.common.mappers.GetEventLandmarkMapper;
import com.pro.common.service.CTIDataService;
import com.pro.common.servicedto.CTIServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.CTIDataWrapper;
import com.pro.common.wrapers.GetEventLandmarkWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Habiboon Patan
 * @Date : 21-05-2019
 */
@RestController
@RequestMapping("/CTIDataController")
@Slf4j
public class CTIDataController {
	@Autowired
	@Qualifier("objCTIDataServiceImpl")
	private CTIDataService objCTIDataService;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	Environment environment;
	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-05-21
	 * @Des : saveAsteriskCallTimes
	 * @Parameters : CTIControllerDTO cTIControllerDTO
	 * @URL : 192.168.1.215:1000/common/CTIDataController/saveAsteriskCallTimes
	 */

	@CrossOrigin
	@RequestMapping(value = "/saveAsteriskCallTimes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveAsteriskCallTimes(@RequestBody CTIControllerDTO cTIControllerDTO)
			throws InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		String commonDataInfoResponse = null;
		log.info(strRequestID + "::::::saveAsteriskCallTimes()::::INPUTS ARE::::" + cTIControllerDTO);
		CTIServiceDTO dataInfo = new CTIServiceDTO();
		CTIDataMapper objOTIDataMapper = new CTIDataMapper();
		CTIDataWrapper objCTIDataWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_eventid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_cnumber())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_starttime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_arngtime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_aatime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_ahtime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_endtime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_htime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_callurl())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_custnumber())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_aloginexten())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_aloginid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_serviceid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_logintime())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCct_createdbyid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCct_createdbyroleid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCct_createdbymodu())) {
			throw new InSufficientInputException(cTIControllerDTO.toString());
		} else {
			dataInfo = objOTIDataMapper.convertforControllerDTOtoServiceDTO(cTIControllerDTO);
			commonDataInfoResponse = objCTIDataService.saveAsteriskCallTimes(dataInfo, strRequestID);
			objCTIDataWrapper.setResponseCode(HttpStatus.OK.value());
			objCTIDataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objCTIDataWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objCTIDataWrapper.setServerIp(ip);
			objCTIDataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objCTIDataWrapper.toString());
		return objCTIDataWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-05-21
	 * @Des : saveCallerCTICallDropTime
	 * @Parameters : CTIControllerDTO cTIControllerDTO
	 * @URL : 192.168.1.215:1000/common/CTIDataController/saveCallerCTICallDropTime
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveCallerCTICallDropTime", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveCallerCTICallDropTime(@RequestBody CTIControllerDTO cTIControllerDTO)
			throws InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::saveCallerCTICallDropTime()::::INPUTS ARE::::" + cTIControllerDTO);
		CTIServiceDTO dataInfo = new CTIServiceDTO();
		String commonDataInfoResponse = null;
		CTIDataMapper objOTIDataMapper = new CTIDataMapper();
		CTIDataWrapper objCTIDataWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCact_eventid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCct_createdbymodu())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getUser_id())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getCct_createdbyroleid())
				|| IsEmptyUtil.isEmptyObject(cTIControllerDTO.getEci_calldropeddtm())) {
			throw new InSufficientInputException(cTIControllerDTO.toString());
		} else {
			dataInfo = objOTIDataMapper.convertforControllerDTOtoServiceDTO(cTIControllerDTO);
			commonDataInfoResponse = objCTIDataService.saveCallerCTICallDropTime(dataInfo, strRequestID);
			objCTIDataWrapper.setResponseCode(HttpStatus.OK.value());
			objCTIDataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objCTIDataWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objCTIDataWrapper.setServerIp(ip);
			objCTIDataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objCTIDataWrapper.toString());
		return objCTIDataWrapper;
	}
	/**
	 * @Author: Habiboon Patan
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @url: localhost:1003/common/CTIDataController/loadModuleRoleUsers 
	 * { "moduleid":5,
	       "roleId":4 }
	 */

	@RequestMapping(value = "/loadModuleRoleUsers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response loadModuleRoleUsers(@RequestBody CTIControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadModuleRoleUsers():::::INPUTS ARE:::" + commonDataObj);
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		CTIDataWrapper objGetEventLandmarkWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getRoleId())) {
			throw new InSufficientInputException("");
		} else {
			CTIServiceDTO dataServiceDTO = objGetEventLandmarkMapper
					.convertforControllerDTOtoServiceDTO(commonDataObj);
			List<CTIServiceDTO> sDto = objCTIDataService.loadModuleRoleUsers(dataServiceDTO,
					strRequestID);
			objGetEventLandmarkWrapper.setCTIControllerDTO(
					objGetEventLandmarkMapper.convertServiceDTOtoControllerDTO(sDto));
			objGetEventLandmarkWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objGetEventLandmarkWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objGetEventLandmarkWrapper.setServerIp(ip);
			objGetEventLandmarkWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetEventLandmarkWrapper.toString());
		return objGetEventLandmarkWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @url: localhost:1003/common/CTIDataController/loadDistrictWiseUsers {
	  "districtid":3,
	        "moduleid":5, "roleId":4 }
	 */

	@RequestMapping(value = "/loadDistrictWiseUsers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response loadDistrictWiseUsers(@RequestBody CTIControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadDistrictWiseUsers():::::INPUTS ARE:::" + commonDataObj);
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		CTIDataWrapper objGetEventLandmarkWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getRoleId())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictid())) {
			throw new InSufficientInputException("");
		} else {
			CTIServiceDTO dataServiceDTO = objGetEventLandmarkMapper
					.convertforControllerDTOtoServiceDTO(commonDataObj);
			List<CTIServiceDTO> sDto = objCTIDataService.loadDistrictWiseUsers(dataServiceDTO,
					strRequestID);
			objGetEventLandmarkWrapper.setCTIControllerDTO(
					objGetEventLandmarkMapper.convertServiceDTOtoControllerDTO(sDto));
			objGetEventLandmarkWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objGetEventLandmarkWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objGetEventLandmarkWrapper.setServerIp(ip);
			objGetEventLandmarkWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetEventLandmarkWrapper.toString());
		return objGetEventLandmarkWrapper;
	}
	/**
	 * @Author: Vinod Kumar Bhavani
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @url: localhost:1003/common/CTIDataController/loadUserDetails
	 *  {
			"moduleid":4 }
	 */

	@RequestMapping(value = "/loadUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response loadUserDetails(@RequestBody CTIControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadUserDetails():::::INPUTS ARE:::" + commonDataObj);
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		CTIDataWrapper objGetEventLandmarkWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())
			) {
			throw new InSufficientInputException("");
		} else {
			CTIServiceDTO dataServiceDTO = objGetEventLandmarkMapper
					.convertforControllerDTOtoServiceDTO(commonDataObj);
			List<CTIServiceDTO> sDto = objCTIDataService.loadUserDetails(dataServiceDTO,
					strRequestID);
			objGetEventLandmarkWrapper.setCTIControllerDTO(
					objGetEventLandmarkMapper.convertServiceDTOtoControllerDTO(sDto));
			objGetEventLandmarkWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objGetEventLandmarkWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objGetEventLandmarkWrapper.setServerIp(ip);
			objGetEventLandmarkWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetEventLandmarkWrapper.toString());
		return objGetEventLandmarkWrapper;
	}

	
	@RequestMapping(value = "/updateCallDropTime", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateCallDropTime(@RequestBody CTIControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadUserDetails():::::INPUTS ARE:::" + commonDataObj);
		CTIDataMapper objGetEventLandmarkMapper = new CTIDataMapper();
		CTIDataWrapper objGetEventLandmarkWrapper = new CTIDataWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getEci_calldropeddtm())||IsEmptyUtil.isEmptyObject(commonDataObj.getCact_eventid())||IsEmptyUtil.isEmptyObject(commonDataObj.getUser_id())||IsEmptyUtil.isEmptyObject(commonDataObj.getCact_cnumber())) {
			throw new InSufficientInputException("");
		} else {
			CTIServiceDTO dataServiceDTO = objGetEventLandmarkMapper.convertforControllerDTOtoServiceDTO(commonDataObj);
			
			String response=objCTIDataService.updateCtiDropTime(dataServiceDTO, strRequestID);
			objGetEventLandmarkWrapper.setResponseCode(HttpStatus.OK.value());
			objGetEventLandmarkWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objGetEventLandmarkWrapper.setCount(response);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objGetEventLandmarkWrapper.setServerIp(ip);
			objGetEventLandmarkWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetEventLandmarkWrapper.toString());
		return objGetEventLandmarkWrapper;
	}


}
