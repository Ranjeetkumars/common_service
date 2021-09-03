/**
 * 
 */
package com.pro.common.servicedto;

import java.util.Map;


import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class ClientServerLicenceStatusServiceDTO {
	private String IPClient;
	private String MacClient;
	private String ModuleIDClient;
	private String CustomerKeyClient;
	private String LicenceType;
	private Map<?, ?> serverKeyComponents;
}
