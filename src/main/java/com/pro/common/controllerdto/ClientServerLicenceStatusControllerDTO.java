package com.pro.common.controllerdto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class ClientServerLicenceStatusControllerDTO {
	private String IPClient;
	private String MacClient;
	private String ModuleIDClient;
	private String CustomerKeyClient;
	private String LicenceType;
	private Map<?, ?> serverKeyComponents;
}
