package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class AuthanticationPersistenceDTO {
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
