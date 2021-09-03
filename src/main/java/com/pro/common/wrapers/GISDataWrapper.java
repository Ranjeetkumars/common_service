/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GISCommonDataControllerDTO;
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
public class GISDataWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 4211593995472137370L;
	private List<GISCommonDataControllerDTO> commonDataControllerDTOs;
 
}
