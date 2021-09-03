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
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.SocialMediaControllerDTO;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.exception.InSufficientInputException;
import com.pro.common.mappers.SocialMediaMapper;
import com.pro.common.service.SocialMediaService;
import com.pro.common.servicedto.SocialMediaSericeDTO;
import com.pro.common.utills.IsEmptyUtil;
import com.pro.common.wrapers.SocialMediaWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Habiboon Patan
 * @Date : 21-05-2019
 */
@RestController
@RequestMapping("/SocialMediaController")
@Slf4j
public class SocialMediaController {
	@Autowired
	@Qualifier("objSocialMediaServiceImpl")
	private SocialMediaService objSocialMediaServiceImpl;
	@Autowired
	Environment environment;
	@Autowired
	private HttpServletRequest request;

	/**
	 * For getting Facebook and Twitter tweets based on socialmedia id
	 * @throws UnknownHostException 
	 * 
	 * @AUTHOR: Habiboon Patan
	 * @DATE: 21-05-2019
	 *        http://localhost:1000/SocialMediaController/getFaceBookposts/2
	 * @input: SocialmediaID
	 */
	@RequestMapping(value = "/getFaceBookposts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getFaceBookposts(@RequestBody SocialMediaControllerDTO objSocialMediaControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		SocialMediaMapper objSocialMediaMapper = new SocialMediaMapper();
		SocialMediaWrapper objSocialMediaWrapper = new SocialMediaWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getFaceBookposts():::::INPUT ARE::::" + objSocialMediaControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(objSocialMediaControllerDTO.getMsm_socialmedia_id())) {
			throw new InSufficientInputException("");

		} else {
			SocialMediaSericeDTO dataServiceDTO = objSocialMediaMapper
					.socialMediaControllerDtoToServiceFTO(objSocialMediaControllerDTO);

			List<SocialMediaSericeDTO> sDto = objSocialMediaServiceImpl.getFaceBookposts(dataServiceDTO, strRequestID);
			objSocialMediaWrapper
					.setSocialMediaControllerDTO(objSocialMediaMapper.converterviceDTOListtoControllerDTO(sDto));
			objSocialMediaWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objSocialMediaWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objSocialMediaWrapper.setServerIp(ip);
			objSocialMediaWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objSocialMediaWrapper.toString());
		return objSocialMediaWrapper;
	}

	/**
	 * getting user count isGISMapViewUser
	 * @throws UnknownHostException 
	 * 
	 * @AUTHOR: Habiboon Patan
	 * @DATE: 21-05-2019
	 *        http://localhost:1000/SocialMediaController/isGISMapViewUser
	 * @input: userid, module id
	 */
	@RequestMapping(value = "/isGISMapViewUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response isGISMapViewUser(@RequestBody SocialMediaControllerDTO objSocialMediaControllerDTO)
			throws InSufficientInputException, DataNotFoundException, UnknownHostException {
		String sDto = null;
		SocialMediaMapper objSocialMediaMapper = new SocialMediaMapper();
		SocialMediaWrapper objSocialMediaWrapper = new SocialMediaWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::isGISMapViewUser():::::INPUT::ARE::::" + objSocialMediaControllerDTO.toString());
		if (IsEmptyUtil.isEmptyObject(objSocialMediaControllerDTO.getUr_userid())
				&& IsEmptyUtil.isEmptyObject(objSocialMediaControllerDTO.getUr_moduleid())) {
			throw new InSufficientInputException("");
		} else {
			SocialMediaSericeDTO dataServiceDTO = objSocialMediaMapper
					.socialMediaControllerDtoToServiceFTO(objSocialMediaControllerDTO);
			sDto = objSocialMediaServiceImpl.isGISMapViewUser(dataServiceDTO, strRequestID);
			objSocialMediaWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objSocialMediaWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			objSocialMediaWrapper.setCount(sDto);
			String port = environment.getProperty("local.server.port");
			String ip = InetAddress.getLocalHost().getHostAddress();
			objSocialMediaWrapper.setServerIp(ip);
			objSocialMediaWrapper.setPort(port);
		}
		log.info(strRequestID + ":::::OUTPUT:::::" + objSocialMediaWrapper.toString());
		return objSocialMediaWrapper;
	}
}
