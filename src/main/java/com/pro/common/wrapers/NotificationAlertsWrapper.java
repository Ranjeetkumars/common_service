/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.NotificationAlertsControllerDTO;
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
public class NotificationAlertsWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -5705138252506272416L;
    private List<NotificationAlertsControllerDTO> notificationAlertsControllerDTOs;
}
