
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.ERSEventFeedServiceDTO;

/**
 * @author : Habiboon Patan
 * @Date : 16-07-2019
 *
 */
public interface ERSEventFeedService {

	public List<ERSEventFeedServiceDTO> loadErsEventFeedTypes(String strRequestID) throws DataNotFoundException;

	public String saveFeedInfo(ERSEventFeedServiceDTO dataInfo, String strRequestID) throws DataNotFoundException;

}
