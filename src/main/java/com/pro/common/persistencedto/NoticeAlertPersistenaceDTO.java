package com.pro.common.persistencedto;

import lombok.Data;

@Data
public class NoticeAlertPersistenaceDTO {
	private String cca_alertid;
	private String cc_alertmessage;
	private String cc_msg_expiredate;
	private String cc_alert_name;
	private String moduleid;
}
