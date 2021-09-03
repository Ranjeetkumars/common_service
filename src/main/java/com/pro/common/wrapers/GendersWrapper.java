/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GendersControllerDTO;
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
public class GendersWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -3659537726842018249L;
    private List<GendersControllerDTO> gendersControllerDTOs;
}
