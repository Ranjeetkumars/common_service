/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.SkillsSetControllerDTO;

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
public class SkillsSetWrapper extends Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2497238531431358121L;
	private List<SkillsSetControllerDTO>  typeControllerDTOs;
}
