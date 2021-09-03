/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.ClientServerLicenceStatusControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author VENKAT_PRO
 *
 */
@Getter
@Setter
@ToString
public class ClientServerLicenceStatusWrapper extends Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -558490911483572565L;

	private List<ClientServerLicenceStatusControllerDTO> clientServerLicenceStatusList;

}
