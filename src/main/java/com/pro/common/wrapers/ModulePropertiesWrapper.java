/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.ModulePropertiesControllerDTO;
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
public class ModulePropertiesWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -6639523289494204300L;
    private List<ModulePropertiesControllerDTO> modulePropertiesControllerDTOs;
}
