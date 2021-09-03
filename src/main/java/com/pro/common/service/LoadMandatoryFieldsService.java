
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.LoadMandatoryFieldsServiceDTO;

/**
 * @author : Habiboon Patan
 * @Date : 17-07-2019
 *
 */
public interface LoadMandatoryFieldsService {

	public List<LoadMandatoryFieldsServiceDTO> loadModuleFields(LoadMandatoryFieldsServiceDTO dataInfo,
			String strRequestID) throws DataNotFoundException;

	public List<LoadMandatoryFieldsServiceDTO> loadScreenMandatoryFields(LoadMandatoryFieldsServiceDTO dataInfo,
			String strRequestID) throws DataNotFoundException;
}
