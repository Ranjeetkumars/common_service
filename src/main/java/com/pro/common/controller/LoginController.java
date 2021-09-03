package com.pro.common.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
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

import com.pro.common.controllerdto.AuthanticationControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.UsersDataControllerDTO;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.AuthanticationMapper;
import com.pro.common.mappers.UsersDataMapper;
import com.pro.common.service.LoginService;
import com.pro.common.servicedto.AuthanticationServiceDTO;
import com.pro.common.servicedto.UsersDataServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.AuthanticationWrapper;
import com.pro.common.wrapers.UsersDataWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO DATE:-20-05-2019 All The login related methods are here
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("objLoginServiceImpl")
	private LoginService objLoginServiceImpl;
	@Autowired
	Environment environment;
	/*
	 * For loading of Previllages in a module AUTHOR::::VENKAT DATE::::::16-05-2019
	 * http://localhost:1000/common/login/getPrevillages {"userID":1 }
	 */

	@RequestMapping(value = "/getPrevillages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getPrevillages(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getPrevillages():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.loadPrevillages(dataServiceDTO, strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @throws UnknownHostException 
	 * @Des: For loading of Roles
	 * @AUTHOR: Habiboon
	 * @DATE: 22-05-2019
	 * @URL: http://localhost:1000/common/login/loadRoles }
	 */

	@RequestMapping(value = "/loadRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadRoles(UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::loadRoles():::::");
		UsersDataServiceDTO dataServiceDTO = mapper
				.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
		List<UsersDataServiceDTO> sDto = objLoginServiceImpl.loadRoles(dataServiceDTO, strRequestID);
		wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		wrapper.setServerIp(ip);
		wrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @throws UnknownHostException 
	 * @Des: getAsdterisdk_CCTCredentialsNew
	 * @AUTHOR: Habiboon
	 * @DATE: 22-05-2019
	 * @URL: http://localhost:1000/common/login/getAsdterisdk_CCTCredentialsNew }
	 */

	@RequestMapping(value = "/getAsdterisdk_CCTCredentialsNew", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAsdterisdk_CCTCredentialsNew(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getAsdterisdk_CCTCredentialsNew():::::INPUTS ARE::::"
				+ dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getAsdterisdk_CCTCredentialsNew(dataServiceDTO,
					strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-05-21
	 * @Des : saveInvalidCredentials
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/saveInvalidCredentials
	 */

	@CrossOrigin
	@RequestMapping(value = "/saveInvalidCredentials", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveInvalidCredentials(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::saveInvalidCredentials():::::INPUTS ARE:::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		UsersDataMapper objUsersDataMapper = new UsersDataMapper();
		UsersDataWrapper objUsersDataWrapper = new UsersDataWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExtension())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserPassword())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRemarks())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = objUsersDataMapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.saveInvalidCredentials(dataInfo, strRequestID);
			objUsersDataWrapper.setResponseCode(HttpStatus.OK.value());
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			objUsersDataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objUsersDataWrapper.setServerIp(ip);
			objUsersDataWrapper.setPort(port);
		}

		log.info(strRequestID + ":::::OUTPUT:::::" + objUsersDataWrapper.toString());
		return objUsersDataWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @throws UnknownHostException 
	 * @Date : 2019-05-22
	 * @Des : getManagerId
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/getManagerId
	 */

	@RequestMapping(value = "/getManagerId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getManagerId() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getManagerId::GET:METHOD");
		String sDto = objLoginServiceImpl.getManagerId(strRequestID);
		// wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
		wrapper.setCount(sDto);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		wrapper.setServerIp(ip);
		wrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : updateShiftTimings
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/updateShiftTimings
	 */

	@CrossOrigin
	@RequestMapping(value = "/updateShiftTimings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateShiftTimings(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateShiftTimings():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		UsersDataMapper objUsersDataMapper = new UsersDataMapper();
		UsersDataWrapper objUsersDataWrapper = new UsersDataWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getShiftID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = objUsersDataMapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.updateShiftTimings(dataInfo, strRequestID);
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			objUsersDataWrapper.setResponseCode(HttpStatus.OK.value());
			objUsersDataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objUsersDataWrapper.setServerIp(ip);
			objUsersDataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objUsersDataWrapper.toString());
		return objUsersDataWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : loadAVAYATerminalLoginDetails
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/loadAVAYATerminalLoginDetails
	 */

	@RequestMapping(value = "/loadAVAYATerminalLoginDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadAVAYATerminalLoginDetails(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(
				strRequestID + "::::loadAVAYATerminalLoginDetails():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.loadAVAYATerminalLoginDetails(dataServiceDTO,
					strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @throws UnknownHostException 
	 * @Date : 2019-05-21
	 * @Des : saveRemainder
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/saveRemainder
	 */

	@CrossOrigin
	@RequestMapping(value = "/saveRemainder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveRemainder(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::saveRemainder():::::INPUTS ARE:::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		UsersDataMapper objUsersDataMapper = new UsersDataMapper();
		UsersDataWrapper objUsersDataWrapper = new UsersDataWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_remainder_text())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_remainder_date())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_is_event_specific_or_personal())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_event_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_remainder_created_by_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = objUsersDataMapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.saveRemainder(dataInfo, strRequestID);
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			objUsersDataWrapper.setResponseCode(HttpStatus.OK.value());
			objUsersDataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			objUsersDataWrapper.setCount(commonDataInfoResponse);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objUsersDataWrapper.setServerIp(ip);
			objUsersDataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objUsersDataWrapper.toString());
		return objUsersDataWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : isUserExist
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : 192.168.1.215:1000/common/login/isUserExist
	 */

	@RequestMapping(value = "/isUserExist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response isUserExist(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		Boolean isUserExist = false;
		Integer userid;
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::isUserExist():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserName())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.isUserExist(dataServiceDTO, strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			if (sDto != null && sDto.size() > 0) {
				Iterator<UsersDataServiceDTO> userListIT = sDto.iterator();
				while (userListIT.hasNext()) {
					UsersDataServiceDTO object = userListIT.next();
					if (object != null) {
						try {
							userid = Integer.parseInt(object.getUserID().toString());
							isUserExist = true;
						} catch (NumberFormatException numberFormatException) {
							log.error("error at isUserExist", numberFormatException);
						} catch (Exception ex) {
							log.error("error at isUserExist", ex);
						}
					}
				}

			} else {
				isUserExist = false;
			}
			wrapper.setOutput(isUserExist.toString());
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
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : getUserShiftsByModule
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/login/getUserShiftsByModule
	 */

	@RequestMapping(value = "/getUserShiftsByModule", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getUserShiftsByModule(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getUserShiftsByModule():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getUserShiftsByModule(dataServiceDTO, strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @author:Deepak 21-06-2019
	 * @throws UnknownHostException 
	 * @URL: 192.168.1.49:1000/common/login/Logout { "userid":1, "moduleid":4 }
	 */
	@RequestMapping(value = "/Logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response Logout(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::Logout():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		dataInfo.setUserID(dataControllerDTO.getUserID());
		dataInfo.setModuleID(dataControllerDTO.getModuleID());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.Logout(dataInfo, strRequestID).toString();
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
	 * @author : Venkat
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : getUserShiftsByModule
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/login/getTerminalID
	 */

	@RequestMapping(value = "/getTerminalID", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTeminalID(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getTeminalID():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())) {
			throw new InSufficientInputException(dataControllerDTO.getModuleID());
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String strTerminalID = objLoginServiceImpl.getTerMinalID(dataServiceDTO, strRequestID);
			wrapper.setOutput(strTerminalID);
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
	 * @author : Venkat
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : getUserShiftsByModule
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/login/checkClientServerTime
	 */

	@RequestMapping(value = "/checkClientServerTime", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkClientServerTime(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::checkClientServerTime():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getClientSystemTime())) {
			throw new InSufficientInputException(dataControllerDTO.getModuleID());
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String strResult = objLoginServiceImpl.checkClientServerTime(dataServiceDTO, strRequestID);
			wrapper.setOutput(strResult);
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : getOffLineUserFailedEvents
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : http://localhost:1000/common/login/getOffLineUserFailedEvents
	 * 
	 */

	@RequestMapping(value = "/getOffLineUserFailedEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getOffLineUserFailedEvents(UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getOffLineUserFailedEvents:::::GET:METHOD" + dataControllerDTO.toString());
		UsersDataServiceDTO dataServiceDTO = mapper
				.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
		List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getOffLineUserFailedEvents(dataServiceDTO, strRequestID);
		wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		wrapper.setServerIp(ip);
		wrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : insertOfflineEvents
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/insertOfflineEvents {
	 *      "ear_event_id":"20190710100001","olduserID":"5","newuserID":"5"}
	 */

	@RequestMapping(value = "/insertOfflineEvents", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertOfflineEvents(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::insertOfflineEvents():::::INPUTS ARE:::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getEar_event_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getOlduserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getNewuserID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String strTerminalID = objLoginServiceImpl.insertOfflineEvents(dataServiceDTO, strRequestID);
			wrapper.setOutput(strTerminalID);
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : getLeastLoaded
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getLeastLoaded
	 * 
	 *      { "emergencyGroupID":"5"}
	 */

	@RequestMapping(value = "/getLeastLoaded", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLeastLoaded(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getLeastLoaded():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getEmergencyGroupID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getLeastLoaded(dataServiceDTO, strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : getLoggedModules
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getLoggedModules
	 * 
	 *      { "userID":"103"}
	 */

	@RequestMapping(value = "/getLoggedModules", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLoggedModules(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getLoggedModules():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getLoggedModules(dataServiceDTO, strRequestID);

			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : sp_chk_usershift
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/checkUsershift
	 * 
	 *      { "userID":"246", "moduleID":"12"}
	 */

	@RequestMapping(value = "/checkUsershift", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response sp_chk_usershift(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::sp_chk_usershift():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		dataInfo.setUserName(dataControllerDTO.getUserName());
		dataInfo.setUserPassword(dataControllerDTO.getUserPassword());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.sp_chk_usershift(dataInfo, strRequestID).toString();
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : checkForModule
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/checkForModule
	 * 
	 *      { "userID":"246", "moduleID":"12"}
	 */

	@RequestMapping(value = "/checkForModule", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkForModule(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::checkForModule():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.checkForModule(dataServiceDTO, strRequestID);

			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : getRoles
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getRoles 0 { "userID":"103",
	 *      "moduleID":"4"}
	 */

	@RequestMapping(value = "/getRoles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRoles(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getRoles():::::INPUTS ARE:::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getRoles(dataServiceDTO, strRequestID);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : getUserPrevillages
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getUserPrevillages
	 * 
	 *      { "userID":"103", "moduleID":"4","roleID":"1", "issystemPrivilege":true}
	 */

	@RequestMapping(value = "/getUserPrevillages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getUserPrevillages(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getUserPrevillages():::::INPUTS::ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {

			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getPrevillages(dataServiceDTO, strRequestID);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : checkForLogin
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/checkForLogin 0 { "userID":"103",
	 *      "moduleID":"4"}
	 */

	@RequestMapping(value = "/checkForLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkForLogin(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::checkForLogin():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.checkForLogin(dataServiceDTO, strRequestID);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : checkForLogin
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getPostgers 0 {
	 *      "strXml":"77A200A4D3DCD6EEFC6530288101D4F2",}
	 */

	@RequestMapping(value = "/getPostgers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkPostgers(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::checkPostgers():::::INPUTS ARE:::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getStrXml())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getPostgers(dataServiceDTO, strRequestID);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : login
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/login
	 * 
	 * 
	 *      { "userID":"246", "hhc_ip":"192.168.1.25","portNo":"450",
	 *      "extension":"4003","moduleID":"12", "unifiedgrouptypeId":"1"}
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response login(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::login():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		dataInfo.setUserName(dataControllerDTO.getUserName());
		dataInfo.setUserPassword(dataControllerDTO.getUserPassword());

		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPortNo())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExtension())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleID())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnifiedgrouptypeId())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.login(dataInfo, strRequestID).toString();
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : insertandUpdateCallStatus
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/insertandUpdateCallStatus
	 * 
	 * 
	 *      { "userID":"246"}
	 */

	@RequestMapping(value = "/insertandUpdateCallStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertandUpdateCallStatus(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::insertandUpdateCallStatus():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();

		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())) {

			throw new InSufficientInputException("");
		} else {
			dataInfo = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.insertandUpdateCallStatus(dataInfo, strRequestID)
					.toString();
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : insertandUpdateCallStatus
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getSupervisorId
	 * 
	 * 
	 *      { "userID":"103", "moduleID":"4"}
	 */

	@RequestMapping(value = "/getSupervisorId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSupervisorId(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getSupervisorId():::::INPUTS ARE::::" + dataControllerDTO.toString());
		UsersDataServiceDTO dataInfo = new UsersDataServiceDTO();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserID())) {
			throw new InSufficientInputException("");
		} else {
			dataInfo = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String commonDataInfoResponse = objLoginServiceImpl.getSupervisorId(dataInfo, strRequestID).toString();
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
	 * @author : Vinod Kumar Bhavani
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-07-08
	 * @Des : checkForLogin
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1003/common/login/getServerLicences 0 {
	 *      "hhc_ip":"85744239EF88D6C0077511F2A48AE729"}
	 */

	@RequestMapping(value = "/getServerLicences", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getServerLicences(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getServerLicences():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper
					.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			List<UsersDataServiceDTO> sDto = objLoginServiceImpl.getServerLicences(dataServiceDTO, strRequestID);
			wrapper.setUsersDataControllerDTOs(mapper.convertUsersDataServiceDTOListtoUsersDataControllerDTOList(sDto));
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
	 * @author : Venkat
	 * @throws UnknownHostException 
	 * @throws: DataNotFoundException
	 * @Date : 2019-05-21
	 * @Des : getUserShiftsByModule
	 * @Parameters : UsersDataControllerDTO dataControllerDTO
	 * @URL : localhost:1000/common/login/checkClientServerTime
	 */

	// localhost:1003/common/login/submitlogin
	@RequestMapping(value = "/submitlogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response submitLoginDetails(@RequestBody AuthanticationControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		AuthanticationWrapper authanticationWrapper = new AuthanticationWrapper();
		AuthanticationMapper mapper = new AuthanticationMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::submitLoginDetails():::::INPUTS ARE:::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getErrorcode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPassword())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExtention())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIpAddress())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPort())) {
			throw new InSufficientInputException("");
		} else {

			AuthanticationServiceDTO objAuthanticationServiceDTO = mapper
					.convertAuthanticationControllerDTOToAuthanticationServiceDTO(dataControllerDTO);
			List<AuthanticationServiceDTO> authanticationServiceDTOs = objLoginServiceImpl
					.authenticate(objAuthanticationServiceDTO, strRequestID);
			authanticationWrapper.setAuthenticationusers(mapper
					.convertAuthanticationServiceDTOListToAuthanticationControllerDTOList(authanticationServiceDTOs));
			authanticationWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			authanticationWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			authanticationWrapper.setServerIp(ip);
			authanticationWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + authanticationWrapper.toString());
		return authanticationWrapper;
	}

	@CrossOrigin
	@RequestMapping(value = "/weblogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response webloginDetails(@RequestBody AuthanticationControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		AuthanticationWrapper authanticationWrapper = new AuthanticationWrapper();
		AuthanticationMapper mapper = new AuthanticationMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::webloginDetails():::::INPUTS ARE:::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPassword())) {
			throw new InSufficientInputException("");
		} else {
			AuthanticationServiceDTO objAuthanticationServiceDTO = mapper
					.convertAuthanticationControllerDTOToAuthanticationServiceDTO(dataControllerDTO);
			List<AuthanticationServiceDTO> authanticationServiceDTOs = objLoginServiceImpl
					.authenticatewebLogin(objAuthanticationServiceDTO, strRequestID);
			authanticationWrapper.setAuthenticationusers(mapper
					.convertAuthanticationServiceDTOListToAuthanticationControllerDTOList(authanticationServiceDTOs));
			authanticationWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			authanticationWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			authanticationWrapper.setServerIp(ip);
			authanticationWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + authanticationWrapper.toString());
		return authanticationWrapper;
	}
	
	@RequestMapping(value = "/getRolesForOpedesk", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRolesForOpdesk(@RequestBody UsersDataControllerDTO dataControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		UsersDataMapper mapper = new UsersDataMapper();
		UsersDataWrapper wrapper = new UsersDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getServerLicences():::::INPUTS ARE::::" + dataControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getHhc_ip())) {
			throw new InSufficientInputException("");
		} else {
			UsersDataServiceDTO dataServiceDTO = mapper.convertUsersDataControllerDTOtoUsersDataServiceDTO(dataControllerDTO);
			String sDto = objLoginServiceImpl.getRolesForOperationalDesk(dataServiceDTO, strRequestID);
		
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(sDto);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

}
