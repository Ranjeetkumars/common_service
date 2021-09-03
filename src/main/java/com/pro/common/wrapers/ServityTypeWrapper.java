/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.ServityTypeControllerDTO;

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
public class ServityTypeWrapper extends Response implements Serializable {
	private static final long serialVersionUID = -3973612568780213471L;
	private List<ServityTypeControllerDTO>  typeControllerDTOs;

}
