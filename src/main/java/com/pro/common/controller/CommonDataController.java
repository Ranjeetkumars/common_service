
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.common.controllerdto.BloodGroupControllerDTO;
import com.pro.common.controllerdto.CheifComplaintControllerDTO;
import com.pro.common.controllerdto.EventIdBySearchControllerDTO;
import com.pro.common.controllerdto.GISCommonDataControllerDTO;
import com.pro.common.controllerdto.GetEventLandmarkControllerDTO;
import com.pro.common.controllerdto.GetModuleSpecifcAgentsControllerDTO;
import com.pro.common.controllerdto.GetRemaindersControllerDto;
import com.pro.common.controllerdto.ModulePropertiesControllerDTO;
import com.pro.common.controllerdto.NoticeAlertControllerDTO;
import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.SaveAddressControllerDTO;
import com.pro.common.controllerdto.VehicleIdBasedOnEMTNoControllerDTO;
import com.pro.common.controllerdto.VictimDetailControllerDTO;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.BloodGroupMapper;
import com.pro.common.mappers.BreakTypeMapper;
import com.pro.common.mappers.CallTypeMapper;
import com.pro.common.mappers.CheifComplaintMapper;
import com.pro.common.mappers.ERODummyDispatchMapper;
import com.pro.common.mappers.EmGroupWiseCompMapper;
import com.pro.common.mappers.EventIdBySearchMapper;
import com.pro.common.mappers.EventStatusMapper;
import com.pro.common.mappers.GISDataMapper;
import com.pro.common.mappers.GendersMapper;
import com.pro.common.mappers.GetEventLandmarkMapper;
import com.pro.common.mappers.GetModuleSpecifcAgentsMapper;
import com.pro.common.mappers.GetRemaindersMapper;
import com.pro.common.mappers.LanguageMapper;
import com.pro.common.mappers.ModulePropertiesMapper;
import com.pro.common.mappers.NoticeAlertMapper;
import com.pro.common.mappers.RelationMaper;
import com.pro.common.mappers.SaveAddressMapper;
import com.pro.common.mappers.ServityTypeMapper;
import com.pro.common.mappers.SkillsSetMapper;
import com.pro.common.mappers.StandardRemarksMapper;
import com.pro.common.mappers.VehilceIdBasedOnEmtNoMapper;
import com.pro.common.mappers.VictimDetailsMapper;
import com.pro.common.service.ComonDataService;
import com.pro.common.servicedto.BloodGroupServiceDTO;
import com.pro.common.servicedto.BreakTypeServiceDTO;
import com.pro.common.servicedto.CallTypeServiceDTO;
import com.pro.common.servicedto.CheifComplaintServiceDTO;
import com.pro.common.servicedto.ERODummyDispatchServiceDTO;
import com.pro.common.servicedto.EmGroupWiseCompServiceDTO;
import com.pro.common.servicedto.EventIdBySearchServiceDTO;
import com.pro.common.servicedto.EventStatusServiceDTO;
import com.pro.common.servicedto.GISCommonDataServiceDTO;
import com.pro.common.servicedto.GendersServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;
import com.pro.common.servicedto.GetModuleSpecifcAgentsServiceDTO;
import com.pro.common.servicedto.LanguageServiceDTO;
import com.pro.common.servicedto.ModulePropertiesServiceDTO;
import com.pro.common.servicedto.NoticeAlertServiceDTO;
import com.pro.common.servicedto.RelationServiceDTO;
import com.pro.common.servicedto.ServityTypeServiceDTO;
import com.pro.common.servicedto.SkillsSetServiceDTO;
import com.pro.common.servicedto.StandardRemarksServiceDTO;
import com.pro.common.servicedto.VehicleIdBasedOnEMTnoServiceDTO;
import com.pro.common.servicedto.VictimDetailServiceDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.BloodGroupWrapper;
import com.pro.common.wrapers.BreakTypeWrapper;
import com.pro.common.wrapers.CalltypeWrapper;
import com.pro.common.wrapers.CheifComplaintWrapper;
import com.pro.common.wrapers.ERODummyDispatchWrapper;
import com.pro.common.wrapers.EmGroupWiseCompWraper;
import com.pro.common.wrapers.EventIdBySearchWrapper;
import com.pro.common.wrapers.EventStatusWrapper;
import com.pro.common.wrapers.GISDataWrapper;
import com.pro.common.wrapers.GendersWrapper;
import com.pro.common.wrapers.GetEventLandmarkWrapper;
import com.pro.common.wrapers.GetModuleSpecifcAgentsWrapper;
import com.pro.common.wrapers.LanguageWrapper;
import com.pro.common.wrapers.ModulePropertiesWrapper;
import com.pro.common.wrapers.NoticeAlertwrapper;
import com.pro.common.wrapers.RelationWraper;
import com.pro.common.wrapers.SaveAddressWrapper;
import com.pro.common.wrapers.ServityTypeWrapper;
import com.pro.common.wrapers.SkillsSetWrapper;
import com.pro.common.wrapers.StandardRemarksWrapper;
import com.pro.common.wrapers.UpdateReminderWrapper;
import com.pro.common.wrapers.VehicleIdBasedOnEMTNoWrapper;
import com.pro.common.wrapers.VictimDetailsWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO 15-05-2019
 */
@RestController
@RequestMapping("/commondata")
@Slf4j
public class CommonDataController {
	@Autowired
	@Qualifier("objCommonDataServiceImpl")
	private ComonDataService objCommonDataServiceImpl;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	Environment environment;

	/**
	 * For loading of countries based on country ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getCountries
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */

	@RequestMapping(value = "/getCountries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getCountries() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getCountries:::GET::METHOD:::::");
		List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getCountries(strRequestID);
		dataWrapper.setCommonDataControllerDTOs(
				objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
		dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		dataWrapper.setCount(sDto.size() + "");
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		dataWrapper.setServerIp(ip);
		dataWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of states based on country ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getstates
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */

	@RequestMapping(value = "/getstates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStates(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getStates():::::INPUTS::ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getCountryId())) {
			throw new InSufficientInputException("");
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getStates(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of districts based on stateid ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getdistricts
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getdistricts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getDistricts(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getDistricts():::::INPUTS::ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getStateId())) {
			throw new InSufficientInputException(commonDataObj.getCountryId());
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getDistricts(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of districts based on districts ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getMandals
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getMandals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMandals(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getMandals():::::INPUTS ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictId())) {
			throw new InSufficientInputException("");
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getMandals(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of districts based on districts ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getCities
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getCities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getCities(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getCities():::::INPUTS ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getMandalId())) {
			throw new InSufficientInputException(commonDataObj.getCountryId());
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getCities(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of districts based on districts ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getLocalities
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getLocalities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLocalities(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getLocalities():::::INPUTS ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getCityId())) {
			throw new InSufficientInputException("");
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getLocalities(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of districts based on districts ID AUTHOR::::VENKAT
	 * DATE::::::16-05-2019 http://localhost:1000/commondata/getLandamarks
	 * {"countryId":1 }
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getLandamarks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLandamarks(@RequestBody GISCommonDataControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GISDataMapper objDataMapper = new GISDataMapper();
		GISDataWrapper dataWrapper = new GISDataWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getLandamarks():::::INPUTS ARE:::" + commonDataObj.toString());
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getLocalityId())) {
			throw new InSufficientInputException(commonDataObj.getCountryId());
		} else {
			GISCommonDataServiceDTO dataServiceDTO = objDataMapper
					.gISCommonDataControllerDTOtoGISCommonDataServiceDTO(commonDataObj);
			List<GISCommonDataServiceDTO> sDto = objCommonDataServiceImpl.getLandmarks(dataServiceDTO, strRequestID);
			dataWrapper.setCommonDataControllerDTOs(
					objDataMapper.convertGISCommonDataServiceDTOListToGISCommonDataControllerDTOList(sDto));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			dataWrapper.setCount(sDto.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			dataWrapper.setServerIp(ip);
			dataWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of Languages DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getLaunguageTypes
	 * 
	 * @throws UnknownHostException
	 * 
	 */
	@RequestMapping(value = "/getLaunguageTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLaunguageTypes() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		LanguageMapper languageMapper = new LanguageMapper();
		LanguageWrapper dataWrapper = new LanguageWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getLaunguageTypes:::GET::METHOD:::::");
		List<LanguageServiceDTO> languageServiceDTOs = objCommonDataServiceImpl.getLanguages(strRequestID);
		dataWrapper.setObjControllerDTOs(
				languageMapper.convertLanguageServiceDTOListToLanguageControllerDTO(languageServiceDTOs));

		dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		dataWrapper.setCount(languageServiceDTOs.size() + "");
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		dataWrapper.setServerIp(ip);
		dataWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * For loading of getCallTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getCallTypes
	 * 
	 */
	@RequestMapping(value = "/getCallTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getCallTypes() throws InSufficientInputException, DataNotFoundException {
		CallTypeMapper callTypeMapper = new CallTypeMapper();
		CalltypeWrapper calltypeWrapper = new CalltypeWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getCallTypes:::GET::METHOD:::::");
		List<CallTypeServiceDTO> languageServiceDTOs = objCommonDataServiceImpl.getCallTypes(strRequestID);
		calltypeWrapper.setObjTypeControllerDTOs(
				callTypeMapper.convertCallTypeServiceDTOListToCallTypeControllerDTOList(languageServiceDTOs));
		calltypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		calltypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		calltypeWrapper.setCount(languageServiceDTOs.size() + "");
		log.info(strRequestID + ":::::OUTPUT:::::" + calltypeWrapper.toString());
		return calltypeWrapper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getRelationTypes
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getRelationTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRelationTypes() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		RelationMaper relationMaper = new RelationMaper();
		RelationWraper relationWraper = new RelationWraper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getRelationTypes:::GET::METHOD:::::");
		List<RelationServiceDTO> relationServiceDTOs = objCommonDataServiceImpl.getRelationTypes(strRequestID);
		relationWraper.setObjRelationControllerDTOs(
				relationMaper.convertRelationServiceDTOListToRelationControllerDTO(relationServiceDTOs));
		relationWraper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		relationWraper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		relationWraper.setCount(relationServiceDTOs.size() + "");
		log.info(strRequestID + ":::::OUTPUT:::::" + relationWraper.toString());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		relationWraper.setServerIp(ip);
		relationWraper.setPort(port);
		return relationWraper;
	}

	/**
	 * For loading of getCheifComplaints DATE::::::16-05-2019
	 * http://localhost:1000//common/commondata/getCheifComplaints
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getCheifComplaints", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getCheifComplaints(@RequestBody CheifComplaintControllerDTO objCheifComplaintControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		CheifComplaintMapper complaintMapper = new CheifComplaintMapper();
		CheifComplaintServiceDTO objCheifComplaintServiceDTO = new CheifComplaintServiceDTO();
		CheifComplaintWrapper complaintWrapper = new CheifComplaintWrapper();
		objCheifComplaintServiceDTO.setEmergencyTypeID(objCheifComplaintControllerDTO.getEmergencyTypeID());
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getCheifComplaints():::::INPUTS ARE:::"
				+ objCheifComplaintControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(objCheifComplaintControllerDTO.getEmergencyTypeID())) {
			throw new InSufficientInputException("");
		} else {
			List<CheifComplaintServiceDTO> relationServiceDTOs = objCommonDataServiceImpl
					.getChiefComplaints(objCheifComplaintServiceDTO, strRequestID);
			complaintWrapper.setControllerDTOs(complaintMapper
					.convertCheifComplaintServiceDTOListToCheifComplaintControllerDTO(relationServiceDTOs));
			complaintWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			complaintWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			complaintWrapper.setCount(relationServiceDTOs.size() + "");
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			complaintWrapper.setServerIp(ip);
			complaintWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + complaintWrapper.toString());
		return complaintWrapper;
	}

	/**
	 * For loading of getGenders DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getGenders
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getGenders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getGenders() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		GendersMapper gendersMapper = new GendersMapper();
		GendersWrapper gendersWrapper = new GendersWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getGenders:::GET::METHOD:::::");
		List<GendersServiceDTO> relationServiceDTOs = objCommonDataServiceImpl.getGenders(strRequestID);
		gendersWrapper.setGendersControllerDTOs(
				gendersMapper.convertGendersServiceDTOListToGendersControllerDTOList(relationServiceDTOs));
		gendersWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		gendersWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		gendersWrapper.setCount(relationServiceDTOs.size() + "");
		log.info(strRequestID + ":::::OUTPUT:::::" + gendersWrapper.toString());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		gendersWrapper.setServerIp(ip);
		gendersWrapper.setPort(port);
		return gendersWrapper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getEmergencyGroups
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getEmergencyGroups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEmergencyGroups()
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		EmGroupWiseCompMapper groupWiseCompMapper = new EmGroupWiseCompMapper();
		EmGroupWiseCompWraper groupWiseCompWraper = new EmGroupWiseCompWraper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getEmergencyGroups:::GET::METHOD:::::");
		List<EmGroupWiseCompServiceDTO> relationServiceDTOs = objCommonDataServiceImpl.getEmegencyGroups(strRequestID);
		groupWiseCompWraper.setEmGroupWiseCompControllerDTOs(groupWiseCompMapper
				.convertEmGroupWiseCompServiceDTOToEmGroupWiseCompControllerDTOList(relationServiceDTOs));
		groupWiseCompWraper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		groupWiseCompWraper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		groupWiseCompWraper.setCount(relationServiceDTOs.size() + "");
		log.info(strRequestID + ":::::OUTPUT:::::" + groupWiseCompWraper.toString());
		String port = environment.getProperty("local.server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		groupWiseCompWraper.setServerIp(ip);
		groupWiseCompWraper.setPort(port);
		return groupWiseCompWraper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/common/commondata/getEmergencyGroupwiseCheifComp
	 */
	@RequestMapping(value = "/getEmergencyGroupwiseCheifComp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEmergencyGroups_chiefComplints()
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		EmGroupWiseCompMapper groupWiseCompMapper = new EmGroupWiseCompMapper();
		EmGroupWiseCompWraper groupWiseCompWraper = new EmGroupWiseCompWraper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getEmergencyGroupwiseCheifComp:::GET::METHOD:::::");
		List<EmGroupWiseCompServiceDTO> relationServiceDTOs = objCommonDataServiceImpl
				.getEmegencyGroupWiseChiefComp(strRequestID);
		groupWiseCompWraper.setEmGroupWiseCompControllerDTOs(groupWiseCompMapper
				.convertEmGroupWiseCompServiceDTOToEmGroupWiseCompControllerDTOList(relationServiceDTOs));
		groupWiseCompWraper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		groupWiseCompWraper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		groupWiseCompWraper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		groupWiseCompWraper.setServerIp(ip);
		groupWiseCompWraper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + groupWiseCompWraper.toString());

		return groupWiseCompWraper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getRemarks
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getRemarks/{strModuleID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRemarks(@PathVariable("strModuleID") String strModuleID)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		StandardRemarksMapper standardRemarksMapper = new StandardRemarksMapper();
		StandardRemarksWrapper standardRemarksWrapper = new StandardRemarksWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getRemarks:::::strModuleID::" + strModuleID);
		List<StandardRemarksServiceDTO> relationServiceDTOs = objCommonDataServiceImpl
				.getRemarksBasedOnModule(strModuleID, strRequestID);
		standardRemarksWrapper.setRemarksControllerDTOs(standardRemarksMapper
				.convertStandardRemarksServiceDTOListToStandardRemarksControllerDTO(relationServiceDTOs));
		standardRemarksWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		standardRemarksWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		standardRemarksWrapper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		standardRemarksWrapper.setServerIp(ip);
		standardRemarksWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + standardRemarksWrapper.toString());
		return standardRemarksWrapper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getEventStatustypes/4
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getEventStatustypes/{strModuleID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEventStatustypes(@PathVariable("strModuleID") String strModuleID)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		EventStatusMapper statusMapper = new EventStatusMapper();
		EventStatusWrapper statusWrapper = new EventStatusWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getEventStatustypes:::::strModuleID::" + strModuleID);
		List<EventStatusServiceDTO> relationServiceDTOs = objCommonDataServiceImpl.getEventStatusTypes(strModuleID,
				strRequestID);
		statusWrapper.setStatusControllerDTOs(
				statusMapper.convertEventStatusServiceDTOToEventStatusControllerDTO(relationServiceDTOs));
		statusWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		statusWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		statusWrapper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		statusWrapper.setServerIp(ip);
		statusWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + statusWrapper.toString());
		return statusWrapper;
	}

	/**
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getEventStatustypes/4
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getSeviarities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSeviarities() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		ServityTypeMapper servityTypeMapper = new ServityTypeMapper();
		ServityTypeWrapper servityTypeWrapper = new ServityTypeWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getSeviarities:::::");
		List<ServityTypeServiceDTO> relationServiceDTOs = objCommonDataServiceImpl.getSeviarities(strRequestID);
		servityTypeWrapper.setTypeControllerDTOs(
				servityTypeMapper.convertServityTypeServiceDTOListToServityTypeControllerDTO(relationServiceDTOs));
		servityTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		servityTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		servityTypeWrapper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		servityTypeWrapper.setServerIp(ip);
		servityTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + servityTypeWrapper.toString());
		return servityTypeWrapper;
	}

	/**
	 * For loading of getGenderWiseChiefComplaints DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getGenderWiseChiefComplaints
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getGenderWiseChiefComplaints/{strGenderID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getGenderWiseChiefComplaints(@PathVariable("strGenderID") String strGenderID)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		EmGroupWiseCompMapper groupWiseCompMapper = new EmGroupWiseCompMapper();
		EmGroupWiseCompWraper groupWiseCompWraper = new EmGroupWiseCompWraper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getGenderWiseChiefComplaints:::::strGenderID::" + strGenderID);
		List<EmGroupWiseCompServiceDTO> relationServiceDTOs = objCommonDataServiceImpl
				.getGenderWiseChiefComplaints(strGenderID, strRequestID);
		groupWiseCompWraper.setEmGroupWiseCompControllerDTOs(groupWiseCompMapper
				.convertEmGroupWiseCompServiceDTOToEmGroupWiseCompControllerDTOList(relationServiceDTOs));
		groupWiseCompWraper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		groupWiseCompWraper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		groupWiseCompWraper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		groupWiseCompWraper.setServerIp(ip);
		groupWiseCompWraper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + groupWiseCompWraper.toString());
		return groupWiseCompWraper;
	}

	/**
	 * For loading of getGenderWiseChiefComplaints DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getBreakTypeRemarks
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/getBreakTypeRemarks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getBreakTypeRemarks()
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		BreakTypeWrapper breakTypeWrapper = new BreakTypeWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getBreakTypeRemarks:::::");
		List<BreakTypeServiceDTO> breakTypeControllerDTOs = objCommonDataServiceImpl.getBreakTypes(strRequestID);
		breakTypeWrapper.setBreakTypeControllerDTOs(
				breakTypeMapper.convertBreakTypeServiceDTOToBreakTypeControllerDTOList(breakTypeControllerDTOs));
		breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		breakTypeWrapper.setCount(breakTypeControllerDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		breakTypeWrapper.setServerIp(ip);
		breakTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/**
	 * For loading of ModuleProperties DATE::::::16-05-2019
	 * http://localhost:1000/commondata/deploymentProperties
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/deploymentProperties", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getDeploymentProperties(@RequestBody ModulePropertiesControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getDeploymentProperties():::::INPUTS ARE:::" + commonDataObj.toString());
		ModulePropertiesMapper propertiesMapper = new ModulePropertiesMapper();
		ModulePropertiesWrapper propertiesWrapper = new ModulePropertiesWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleiD())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getInputKey())) {
			throw new InSufficientInputException("");
		} else {
			ModulePropertiesServiceDTO dataServiceDTO = propertiesMapper
					.convertModulePropertiesControllerDTOtoModulePropertiesServiceDTO(commonDataObj);
			List<ModulePropertiesServiceDTO> sDto = objCommonDataServiceImpl.getDeploymentProperties(dataServiceDTO,
					strRequestID);
			propertiesWrapper.setModulePropertiesControllerDTOs(
					propertiesMapper.convertModulePropertiesServiceDTOListToModulePropertiesControllerDTO(sDto));
			propertiesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			propertiesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/**
	 * For loading of deploymentTerminalProperties DATE::::::16-05-2019
	 * http://localhost:1000/commondata/deploymentTerminalProperties
	 * 
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/deploymentTerminalProperties", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getDeploymentterminalProperties(@RequestBody ModulePropertiesControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getDeploymentterminalProperties():::::INPUTS ARE:::" + commonDataObj.toString());
		ModulePropertiesMapper propertiesMapper = new ModulePropertiesMapper();
		ModulePropertiesWrapper propertiesWrapper = new ModulePropertiesWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleiD())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getIpAddress())) {
			throw new InSufficientInputException("");
		} else {
			ModulePropertiesServiceDTO dataServiceDTO = propertiesMapper
					.convertModulePropertiesControllerDTOtoModulePropertiesServiceDTO(commonDataObj);
			List<ModulePropertiesServiceDTO> sDto = objCommonDataServiceImpl
					.getDeploymentTerminalProperties(dataServiceDTO, strRequestID);
			propertiesWrapper.setModulePropertiesControllerDTOs(
					propertiesMapper.convertModulePropertiesServiceDTOListToModulePropertiesControllerDTO(sDto));
			propertiesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			propertiesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/**
	 * For loading of Languages DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getskillsets
	 * 
	 * @throws UnknownHostException
	 * 
	 */
	@RequestMapping(value = "/getskillsets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSkillSets() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		SkillsSetMapper objSkillsSetMapper = new SkillsSetMapper();
		SkillsSetWrapper objSkillsSetWrapper = new SkillsSetWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getskillsets::::");
		List<SkillsSetServiceDTO> skillsSetServiceDTOs = objCommonDataServiceImpl.getSkillSets(strRequestID);
		objSkillsSetWrapper.setTypeControllerDTOs(
				objSkillsSetMapper.convertSkillsSetServiceDTOToSkillsSetServiceDTOList(skillsSetServiceDTOs));
		objSkillsSetWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objSkillsSetWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		objSkillsSetWrapper.setCount(skillsSetServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		objSkillsSetWrapper.setServerIp(ip);
		objSkillsSetWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + objSkillsSetWrapper.toString());
		return objSkillsSetWrapper;
	}

	/*
	 * For getDistrictRelatedTOUser DATE::::::07-08-2019
	 * http://localhost:1003/common/commondata/getEventidbySearch
	 * 
	 */
	@RequestMapping(value = "/getEventidbySearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getEventIdBySearch(@RequestBody EventIdBySearchControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getEventIdBySearch():::::INPUTS ARE:::" + commonDataObj.toString());
		EventIdBySearchMapper propertiesMapper = new EventIdBySearchMapper();
		EventIdBySearchWrapper propertiesWrapper = new EventIdBySearchWrapper();
		String moduleId = commonDataObj.getModuleid();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getEventid())) {
			throw new InSufficientInputException("");
		} else {
			EventIdBySearchServiceDTO dataServiceDTO = propertiesMapper
					.convertEventIdSearchRelatedControllerDTOToServiceDTO(commonDataObj);
			List<EventIdBySearchServiceDTO> sDto = objCommonDataServiceImpl.getEventIdBySearch(dataServiceDTO,
					strRequestID, moduleId);
			propertiesWrapper.setObjEventBySearchControllerDTO(
					propertiesMapper.convertGetDistrictSetServiceDTOToDistrictSetServiceDTOList(sDto));
			propertiesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			propertiesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/*
	 * For loading of getRelationTypes DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getERODummyDispatch
	 */
	@RequestMapping(value = "/getERODummyDispatch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getERODummyDispatch()
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		ERODummyDispatchMapper servityTypeMapper = new ERODummyDispatchMapper();
		ERODummyDispatchWrapper servityTypeWrapper = new ERODummyDispatchWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getERODummyDispatch:::::GET::METHOD");
		List<ERODummyDispatchServiceDTO> relationServiceDTOs = objCommonDataServiceImpl
				.getERODummyDispatch(strRequestID);
		servityTypeWrapper.setObjERODummyDispatchControllerDTO(
				servityTypeMapper.convertGetDistrictSetServiceDTOToDistrictSetServiceDTOList(relationServiceDTOs));
		servityTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		servityTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		servityTypeWrapper.setCount(relationServiceDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		servityTypeWrapper.setServerIp(ip);
		servityTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + servityTypeWrapper.toString());
		return servityTypeWrapper;
	}

	/*
	 * For getNoticeAlert DATE::::::09-08-2019
	 * http://localhost:1003/common/commondata/getNoticeAlert
	 * 
	 */
	@RequestMapping(value = "/getNoticeAlert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getNoticeAlert(@RequestBody NoticeAlertControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getNoticeAlert():::::INPUTS ARE:::" + commonDataObj.toString());
		NoticeAlertMapper propertiesMapper = new NoticeAlertMapper();
		NoticeAlertwrapper propertiesWrapper = new NoticeAlertwrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())) {
			throw new InSufficientInputException("");
		} else {
			NoticeAlertServiceDTO dataServiceDTO = propertiesMapper
					.convertNoticeAlertControllerDTOToServiceDTO(commonDataObj);
			List<NoticeAlertServiceDTO> sDto = objCommonDataServiceImpl.getNoticeAlert(dataServiceDTO, strRequestID);
			propertiesWrapper.setObjNoticeAlertControllerDTO(
					propertiesMapper.convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(sDto));
			propertiesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			propertiesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/*
	 * For getVehicleIdBasedOnEMTNo DATE::::::09-08-2019
	 * http://localhost:1003/common/commondata/getVehicleIdBasedOnEMTNo
	 * 
	 */
	@RequestMapping(value = "/getVehicleIdBasedOnEMTNo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getVehicleIdBasedOnEMTNo(@RequestBody VehicleIdBasedOnEMTNoControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getVehicleIdBasedOnEMTNo():::::INPUTS ARE:::" + commonDataObj.toString());
		VehilceIdBasedOnEmtNoMapper propertiesMapper = new VehilceIdBasedOnEmtNoMapper();
		VehicleIdBasedOnEMTNoWrapper propertiesWrapper = new VehicleIdBasedOnEMTNoWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getPhoneno1())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getPhone2())) {
			throw new InSufficientInputException("");
		} else {
			VehicleIdBasedOnEMTnoServiceDTO dataServiceDTO = propertiesMapper
					.convertVehicleIdbasedOnEMTNoControllerDTOToServiceDTO(commonDataObj);
			List<VehicleIdBasedOnEMTnoServiceDTO> sDto = objCommonDataServiceImpl
					.getVehicleIdBasedOnEMTNO(dataServiceDTO, strRequestID);
			propertiesWrapper.setObjVehicleIdBasedOnEMTNO(propertiesMapper
					.convertVehicleIdbasedOnEMTNoServiceDTOToVehicleIdbasedOnEMTNoControllerDTOList(sDto));
			propertiesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			propertiesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);

		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/*
	 * @author deepak For getVehicleIdBasedOnEMTNo DATE::::::16-07-2019
	 * http://localhost:1003/common/commondata/saveAddress
	 * 
	 */
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response saveAddress(@RequestBody SaveAddressControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::saveAddress():::::INPUTS ARE:::" + commonDataObj.toString());
		SaveAddressWrapper propertiesWrapper = new SaveAddressWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getEventid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getHouseno())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLaneStreet())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLandmarkid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLocalityid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCityid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMandalid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getUserid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getRoleid())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.SaveAddress(
					new SaveAddressMapper().convertVehicleIdbasedOnEMTNoControllerDTOToServiceDTO(commonDataObj),
					strRequestID);
			propertiesWrapper.setResponseCode(HttpStatus.OK.value());
			propertiesWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			propertiesWrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			propertiesWrapper.setServerIp(ip);
			propertiesWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + propertiesWrapper.toString());
		return propertiesWrapper;
	}

	/**
	 * @Url: http://localhost:1003/common/commondata/updateRemainder
	 * @param :
	 * @return : Response
	 * @throws UnknownHostException
	 */
	@RequestMapping(value = "/updateRemainder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateRemainder(@RequestBody GetRemaindersControllerDto objGetRemaindersControllerDto)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateRemainder():::::INPUTS ARE:::" + objGetRemaindersControllerDto.toString());
		UpdateReminderWrapper wrapper = new UpdateReminderWrapper();
		if (IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getAcKnowledged())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getCreatedById())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getAcKnowledgedTime())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getReamainderWithTimeStamp())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getRemainderId())) {

			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.updateRemainder(
					new GetRemaindersMapper().conversionForControllerToServiceDTO(objGetRemaindersControllerDto),
					strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/*
	 * For loading of getBloodGroups DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getBloodGroups
	 */
	@RequestMapping(value = "/getBloodGroups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getBloodGroups() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		BloodGroupWrapper breakTypeWrapper = new BloodGroupWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getBloodGroups:::::GET::METHOD");
		List<BloodGroupServiceDTO> breakTypeControllerDTOs = objCommonDataServiceImpl.getBloodGroups(strRequestID);
		breakTypeWrapper.setObjBloodGroupcontrollerDTO(
				breakTypeMapper.convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(breakTypeControllerDTOs));
		breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		breakTypeWrapper.setCount(breakTypeControllerDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		breakTypeWrapper.setServerIp(ip);
		breakTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/*
	 * For loading of getEconomicType DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getEconomicType
	 */
	@RequestMapping(value = "/getEconomicType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEconomicType() throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		BloodGroupWrapper breakTypeWrapper = new BloodGroupWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getEconomicType:::::GET::METHOD");
		List<BloodGroupServiceDTO> breakTypeControllerDTOs = objCommonDataServiceImpl.getEconomicType(strRequestID);
		breakTypeWrapper.setObjBloodGroupcontrollerDTO(
				breakTypeMapper.convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(breakTypeControllerDTOs));
		breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		breakTypeWrapper.setCount(breakTypeControllerDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		breakTypeWrapper.setServerIp(ip);
		breakTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/*
	 * For loading of getBloodGroups DATE::::::16-05-2019
	 * http://localhost:1000/commondata/getSocialStatusType
	 */
	@RequestMapping(value = "/getSocialStatusType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSocialStatusType()
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		BloodGroupWrapper breakTypeWrapper = new BloodGroupWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::getSocialStatusType:::::GET::METHOD");
		List<BloodGroupServiceDTO> breakTypeControllerDTOs = objCommonDataServiceImpl.getSocialStatusType(strRequestID);
		breakTypeWrapper.setObjBloodGroupcontrollerDTO(
				breakTypeMapper.convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(breakTypeControllerDTOs));
		breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		breakTypeWrapper.setCount(breakTypeControllerDTOs.size() + "");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		breakTypeWrapper.setServerIp(ip);
		breakTypeWrapper.setPort(port);
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/*
	 * For getVehicleIdBasedOnEMTNo DATE::::::09-08-2019
	 * http://localhost:1003/common/commondata/getAllCheifComplaint {
	 * "emeregerncyGroupid":1
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAllCheifComplaint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllCheifComplaint(@RequestBody BloodGroupControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getAllCheifComplaint():::::INPUTS ARE:::" + commonDataObj.toString());
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		BloodGroupWrapper breakTypeWrapper = new BloodGroupWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getEmeregerncyGroupid())) {
			throw new InSufficientInputException("");
		} else {
			BloodGroupServiceDTO dataServiceDTO = breakTypeMapper
					.convertNoticeAlertControllerDTOToServiceDTO(commonDataObj);
			List<BloodGroupServiceDTO> sDto = objCommonDataServiceImpl.getAllCheifComplaint(dataServiceDTO,
					strRequestID);
			breakTypeWrapper.setObjBloodGroupcontrollerDTO(
					breakTypeMapper.convertNoticeAlertServiceDTOToNoticeAlertControllerDTOList(sDto));
			breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			breakTypeWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			breakTypeWrapper.setServerIp(ip);
			breakTypeWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/**
	 * @Url: http://localhost:1003/common/commondata/updateCheifComplaint
	 * @param :
	 * @return : Response
	 * @throws UnknownHostException
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateCheifComplaint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateCheifComplaint(@RequestBody BloodGroupControllerDTO objGetRemaindersControllerDto)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateCheifComplaint():::::INPUTS ARE:::"
				+ objGetRemaindersControllerDto.toString());
		BloodGroupWrapper wrapper = new BloodGroupWrapper();
		if (IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getEventid())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getVictimlist())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getChiefcomplaintslist())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getCreatedbyid())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getCreatedbymoduleid())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getCreatedbyrollid())
				|| IsEmptyUtil.isEmptyObject(objGetRemaindersControllerDto.getSize())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.updateCheifComplaint(
					new BloodGroupMapper().convertNoticeAlertControllerDTOToServiceDTO(objGetRemaindersControllerDto),
					strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/*
	 * @Author deepak For getVehicleIdBasedOnEMTNo DATE::::::09-08-2019
	 * http://localhost:1003/common/commondata/getVictimDetail { "victimid":1
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getVictimDetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getVictimDetail(@RequestBody VictimDetailControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::addVitals():::::INPUTS ARE:::" + commonDataObj);
		VictimDetailsMapper breakTypeMapper = new VictimDetailsMapper();
		VictimDetailsWrapper breakTypeWrapper = new VictimDetailsWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getVictimid())) {
			throw new InSufficientInputException("");
		} else {
			VictimDetailServiceDTO dataServiceDTO = breakTypeMapper.conversionForControllerToServiceDTO(commonDataObj);
			List<VictimDetailServiceDTO> sDto = objCommonDataServiceImpl.getVictimDetail(dataServiceDTO, strRequestID);
			breakTypeWrapper.setObjVictimDetailControllerDTO(breakTypeMapper.conversionForServiceTOControllerDTO(sDto));
			breakTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			breakTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			breakTypeWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			breakTypeWrapper.setServerIp(ip);
			breakTypeWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + breakTypeWrapper.toString());
		return breakTypeWrapper;
	}

	/**
	 * @Url: http://localhost:1003/common/commondata/updateVictimDetails
	 * @param : {"victimid":201907120100001,"firstname":"deepak","dob":"25-11-1996","createdbyid":1,
	 *          "createdbymoduleid":10,"createdbyroleid":1,"economictypeid":"1","socialstatustypeid":"1",
	 *          "gendertypeid":"1","currentmedication":"1","medicalPastHistroy":"1","allergy":"all",
	 *          "bloodgroupid":"1"}
	 * @return : Response
	 * @throws UnknownHostException
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateVictimDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateVictimDetails(@RequestBody VictimDetailControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::updateVictimDetails():::::INPUTS ARE:::" + commonDataObj.toString());
		VictimDetailsWrapper wrapper = new VictimDetailsWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getVictimid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getFirstname())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDob())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbyid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbymoduleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbyroleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEconomictypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getSocialstatustypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getGendertypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCurrentmedication())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMedicalPastHistroy())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getAllergy())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getBloodgroupid())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.updateVictimDetails(
					new VictimDetailsMapper().conversionForControllerToServiceDTO(commonDataObj), strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @Url: http://localhost:1003/common/commondata/insertVictimDetails
	 * @param : {"victimid":201907120100001,"firstname":"deepak","dob":"25-11-1996","createdbyid":1,
	 *          "createdbymoduleid":10,"createdbyroleid":1,"economictypeid":"1","socialstatustypeid":"1",
	 *          "gendertypeid":"1","currentmedication":"1","medicalPastHistroy":"1","allergy":"all",
	 *          "bloodgroupid":"1"}
	 * @return : Response
	 * @throws UnknownHostException
	 */
	@CrossOrigin
	@RequestMapping(value = "/insertVictimDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertVictimDetails(@RequestBody VictimDetailControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::insertVictimDetails():::::INPUTS ARE:::" + commonDataObj.toString());
		VictimDetailsWrapper wrapper = new VictimDetailsWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getVictimid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getFirstname())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDob())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbyid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbymoduleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCreatedbyroleid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEconomictypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getSocialstatustypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getGendertypeid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCurrentmedication())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMedicalPastHistroy())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getAllergy())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getBloodgroupid())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.insertVictimDetails(
					new VictimDetailsMapper().conversionForControllerToServiceDTO(commonDataObj), strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException
	 * @url: localhost:1003/common/commondata/getModuleSpecifcAgents_Supervisor {
	 *       "managerid":10001, "moduleid":4 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/getModuleSpecifcAgents_Supervisor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getModuleSpecifcAgents_Supervisor(@RequestBody GetModuleSpecifcAgentsControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getModuleSpecifcAgents_Supervisor():::::INPUTS ARE:::" + commonDataObj);
		GetModuleSpecifcAgentsMapper objGetModuleSpecifcAgentsMapper = new GetModuleSpecifcAgentsMapper();
		GetModuleSpecifcAgentsWrapper objGetModuleSpecifcAgentsWrapper = new GetModuleSpecifcAgentsWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getManagerid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getModuleid())) {
			throw new InSufficientInputException("");
		} else {
			GetModuleSpecifcAgentsServiceDTO dataServiceDTO = objGetModuleSpecifcAgentsMapper
					.convertControllerDTOtoServiceDTO(commonDataObj);
			List<GetModuleSpecifcAgentsServiceDTO> sDto = objCommonDataServiceImpl
					.getModuleSpecifcAgents_Supervisor(dataServiceDTO, strRequestID);
			objGetModuleSpecifcAgentsWrapper.setObjGetModuleSpecifcAgentsControllerDTO(
					objGetModuleSpecifcAgentsMapper.convertServiceDTOtoControllerDTO(sDto));
			objGetModuleSpecifcAgentsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objGetModuleSpecifcAgentsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			objGetModuleSpecifcAgentsWrapper.setCount(sDto.size() + "");
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			objGetModuleSpecifcAgentsWrapper.setServerIp(ip);
			objGetModuleSpecifcAgentsWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetModuleSpecifcAgentsWrapper.toString());
		return objGetModuleSpecifcAgentsWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException
	 * @url:localhost:1003/common/commondata/getSize
	 * 
	 *                                               { "emgmedicalid":2,
	 *                                               "emgpoliceid":0, "emgfireid":0,
	 *                                               "landmarkid":0, "localityid":0,
	 *                                               "city_townid":0, "mandalid":0,
	 *                                               "districtid":0, "stateid":1,
	 *                                               "countryid":1,
	 *                                               "callername":"¥",
	 *                                               "callerno":"¥", "calltypeid":0,
	 *                                               "eventstatustypeid":0,
	 *                                               "eventid":"20190718",
	 *                                               "today":"true", "stardate":"¥",
	 *                                               "endate":"¥",
	 *                                               "ordering":"true",
	 *                                               "limitcount":0, "pageno":0,
	 *                                               "agentid":0, "ambulance":"¥" }
	 */

	@CrossOrigin
	@RequestMapping(value = "/getSize", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSize(@RequestBody GetModuleSpecifcAgentsControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getSize():::::INPUTS ARE:::" + commonDataObj.toString());
		GetModuleSpecifcAgentsWrapper wrapper = new GetModuleSpecifcAgentsWrapper();
//		if (IsEmptyUtil.isEmptyObject(commonDataObj.getEmgmedicalid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEmgpoliceid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEmgfireid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLandmarkid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLocalityid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCity_townid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMandalid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getStateid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCountryid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getCalltypeid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEventstatustypeid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getEventid())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getToday())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getOrdering())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getLimitcount())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getPageno())
//				|| IsEmptyUtil.isEmptyObject(commonDataObj.getAgentid())) {
//			throw new InSufficientInputException("");
//		} else {
		String commonDataInfoResponse = objCommonDataServiceImpl.getSize(
				new GetModuleSpecifcAgentsMapper().convertControllerDTOtoServiceDTO(commonDataObj), strRequestID);
		wrapper.setResponseCode(HttpStatus.OK.value());
		wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
		wrapper.setCount(commonDataInfoResponse);
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("local.server.port");
		wrapper.setServerIp(ip);
		wrapper.setPort(port);
//		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @Date: 26-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException
	 * @url:localhost:1003/common/commondata/getEventLandmarkCount {
	 *                                                             "search_string_one":"aga",
	 *                                                             "search_string_two":"¥",
	 *                                                             "search_string_three":"¥",
	 *                                                             "mandalid":1,
	 *                                                             "districtid":1,
	 *                                                             "stateid":0,
	 *                                                             "serach_level":1
	 *                                                             }
	 */

	@CrossOrigin
	@RequestMapping(value = "/getEventLandmarkCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEventLandmarkCount(@RequestBody GetModuleSpecifcAgentsControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getSize():::::INPUTS ARE:::" + commonDataObj.toString());
		GetModuleSpecifcAgentsWrapper wrapper = new GetModuleSpecifcAgentsWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getSearch_string_one())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getStateid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMandalid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getSerach_level())) {
			throw new InSufficientInputException("");
		} else {
			String commonDataInfoResponse = objCommonDataServiceImpl.getEventLandmarkCount(
					new GetModuleSpecifcAgentsMapper().convertControllerDTOtoServiceDTO(commonDataObj), strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setCount(commonDataInfoResponse);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			wrapper.setServerIp(ip);
			wrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @Date: 25-07-2019
	 * @throws InSufficientInputException
	 * @throws DataNotFoundException
	 * @throws UnknownHostException
	 * @url: localhost:1003/common/commondata/getEventLandmark {
	 *       "search_string_one":"aga", "search_string_two":"¥",
	 *       "search_string_three":"¥", "mandalid":1, "districtid":1, "stateid":0,
	 *       "serach_level":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/getEventLandmark", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getEventLandmark(@RequestBody GetEventLandmarkControllerDTO commonDataObj)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getEventLandmark():::::INPUTS ARE:::" + commonDataObj);
		GetEventLandmarkMapper objGetEventLandmarkMapper = new GetEventLandmarkMapper();
		GetEventLandmarkWrapper objGetEventLandmarkWrapper = new GetEventLandmarkWrapper();
		if (IsEmptyUtil.isEmptyObject(commonDataObj.getSearch_string_one())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getStateid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getDistrictid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getMandalid())
				|| IsEmptyUtil.isEmptyObject(commonDataObj.getSerach_level())) {
			throw new InSufficientInputException("");
		} else {
			GetEventLandmarkServiceDTO dataServiceDTO = objGetEventLandmarkMapper
					.convertControllerDTOtoServiceDTO(commonDataObj);
			List<GetEventLandmarkServiceDTO> sDto = objCommonDataServiceImpl.getEventLandmark(dataServiceDTO,
					strRequestID);
			objGetEventLandmarkWrapper.setObjGetEventLandmarkControllerDTO(
					objGetEventLandmarkMapper.convertServiceDTOtoControllerDTO(sDto));
			objGetEventLandmarkWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objGetEventLandmarkWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = environment.getProperty("local.server.port");
			objGetEventLandmarkWrapper.setServerIp(ip);
			objGetEventLandmarkWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objGetEventLandmarkWrapper.toString());
		return objGetEventLandmarkWrapper;
	}

}