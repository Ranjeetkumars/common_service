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
import com.pro.common.controllerdto.BreakTypeControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.BreakTypeMapper;
import com.pro.common.service.BreakTypeService;
import com.pro.common.servicedto.BreakTypeServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.BreakTypeWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PURUSHOTHAM 21-05-2019
 */
@RestController
@RequestMapping("/breaktype")
@Slf4j
public class BreakDataController {

	@Autowired
	@Qualifier("objBreakTypeServiceImpl")
	private BreakTypeService objBreakTypeServiceImpl;

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	Environment environment;

	/**
	 * @author : Purushotham
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @Date : 21-5-2019
	 * @Des : insertBreakDetails
	 * @inputs : breakTypeID,intUserId,intModuleId,intRoleId
	 * @URL : http://localhost:1000/breaktype/insertBreakDetails { "breakTypeID":
	 *      "3", "intUserId":58, "intModuleId":4, "intRoleId":1 }
	 **/

	@RequestMapping(value = "/insertBreakDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertBreakDetails(@RequestBody BreakTypeControllerDTO objBreakTypeControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::insertBreakDetails()::::INPUTS ARE::" + objBreakTypeControllerDTO.toString());
		BreakTypeWrapper breakTypeWrapper = new BreakTypeWrapper();
		BreakTypeServiceDTO dataInfo = new BreakTypeServiceDTO();
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		if (IsEmptyUtil.isEmptyObject(objBreakTypeControllerDTO.getBreakTypeID())
				|| IsEmptyUtil.isEmptyObject(objBreakTypeControllerDTO.getIntUserId())
				|| IsEmptyUtil.isEmptyObject(objBreakTypeControllerDTO.getIntModuleId())
				|| IsEmptyUtil.isEmptyObject(objBreakTypeControllerDTO.getIntRoleId())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = breakTypeMapper.breakTypeControllerDTODtoToServiceFTO(objBreakTypeControllerDTO);
			String commonDataInfoResponse = objBreakTypeServiceImpl.insertBreakDetails(dataInfo, strRequestID);
			breakTypeWrapper.setResponseCode(HttpStatus.OK.value());
			breakTypeWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			breakTypeWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			breakTypeWrapper.setServerIp(ip);
			breakTypeWrapper.setPort(port);
		}
		log.info(strRequestID + ":::OUTPUT:::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/**
	 * @author : Purushotham
	 * @throws UnknownHostException 
	 * @Date : 21-5-2019
	 * @inputs :
	 * @URL : http://192.168.1.215:1003/common/breaktype/getBreakDetails
	 * 
	 **/
	@RequestMapping(value = "/getBreakDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getBreakDetails() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		BreakTypeWrapper breakTypeWrapper = new BreakTypeWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::GET METHOD:::::");
		List<BreakTypeServiceDTO> breakTypeControllerDTOs = objBreakTypeServiceImpl.getBreakDetails(strRequestID);
		breakTypeWrapper.setBreakTypeControllerDTOs(
				breakTypeMapper.convertBreakTypeServiceDTOToBreakTypeControllerDTOList(breakTypeControllerDTOs));
		breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		breakTypeWrapper.setServerIp(ip);
		breakTypeWrapper.setPort(port);
		log.info(strRequestID + ":::OUTPUT:::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/**
	 * @author : Purushotham
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @Date : 21-5-2019
	 * @Des : insertBreakDetails
	 * @inputs : breakTypeID,intUserId,intModuleId,intRoleId
	 * @URL : http://192.168.1.199:1000/breaktype/updateBreakStatus {
	 *      "breakTransId":0 }
	 **/

	@RequestMapping(value = "/updateBreakStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateBreakStatus(@RequestBody BreakTypeControllerDTO objBreakTypeControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateBreakStatus()::::INPUTS ARE::" + objBreakTypeControllerDTO.toString());
		BreakTypeWrapper breakTypeWrapper = new BreakTypeWrapper();
		BreakTypeServiceDTO dataInfo = new BreakTypeServiceDTO();
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		if (objBreakTypeControllerDTO.getBreakTransId()==null) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = breakTypeMapper.breakTypeControllerDTODtoToServiceFTO(objBreakTypeControllerDTO);
			String commonDataInfoResponse = objBreakTypeServiceImpl.updateBreakStatus(dataInfo, strRequestID);
			breakTypeWrapper.setResponseCode(HttpStatus.OK.value());
			breakTypeWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			breakTypeWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			breakTypeWrapper.setServerIp(ip);
			breakTypeWrapper.setPort(port);
		}
		log.info(strRequestID + ":::OUTPUT:::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	
}
