/**
 * 
 */
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.SocialMediaSericeDTO;


/**
 * @author Habiboon Patan
 * @Date : 21-05-2019
 *  */
public interface SocialMediaService {
	/*
	 * Social Media Related
	 */
	public List<SocialMediaSericeDTO> getFaceBookposts(SocialMediaSericeDTO datainfo, String strRequestID)throws DataNotFoundException;

	public String isGISMapViewUser(SocialMediaSericeDTO datainfo, String strRequestID)throws DataNotFoundException;
	
	
}
