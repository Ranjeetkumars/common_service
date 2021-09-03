/**
 * 
 */
package com.pro.common.persistencedto;

import java.util.Map;


import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class ClientServerLicenceStatusPersistenceDTO {
	private String IPClient;
	private String MacClient;
	private String ModuleIDClient;
	private String CustomerKeyClient;
	private String LicenceType;
	private Map<?, ?> serverKeyComponents;
}
