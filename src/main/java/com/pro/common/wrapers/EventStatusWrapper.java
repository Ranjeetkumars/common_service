/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.EventStatusControllerDTO;
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
public class EventStatusWrapper extends Response implements Serializable {

	private static final long serialVersionUID = -2962879429665477706L;
	private List<EventStatusControllerDTO> statusControllerDTOs;
}
