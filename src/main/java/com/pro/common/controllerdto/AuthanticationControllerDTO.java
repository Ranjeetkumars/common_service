package com.pro.common.controllerdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class AuthanticationControllerDTO {
	private String userName;
    private String Password;
    private String moduleId;
    private String userId;
    private String moduleName;
    private String roleId;
    private String previlageId;
    private String previlageType;
    private String  previlageName;
    private String ipAddress;
    private String port;
    private String extention;
    private String groupId;
    private String cctUserName;
    private String agentTerminalId;
    
    private String errorcode;
}
