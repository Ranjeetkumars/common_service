/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.ReminderControllerDTO;
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
public class ReminderWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 4839599321282376813L;
    private List<ReminderControllerDTO> controllerDTOs;
}
