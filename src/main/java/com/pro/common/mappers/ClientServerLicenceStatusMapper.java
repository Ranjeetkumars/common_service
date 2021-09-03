/**
 * 
 */
package com.pro.common.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.common.controllerdto.ClientServerLicenceStatusControllerDTO;
import com.pro.common.servicedto.ClientServerLicenceStatusServiceDTO;

/**
 * @author VENKAT_PRO
 *
 */
public class ClientServerLicenceStatusMapper {
	public ClientServerLicenceStatusServiceDTO convertClientServerLicenceStatusControllerDTOtoClientServerLicenceStatusServiceDTO(
			ClientServerLicenceStatusControllerDTO controllerDTO) {
		ClientServerLicenceStatusServiceDTO propertiesServiceDTO = new ClientServerLicenceStatusServiceDTO();
		BeanUtils.copyProperties(controllerDTO, propertiesServiceDTO);
		return propertiesServiceDTO;
	}
}
