/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.CheifComplaintControllerDTO;
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
public class CheifComplaintWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 4348151873452240677L;
    private List<CheifComplaintControllerDTO> controllerDTOs;
}
