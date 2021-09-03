/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.EmGroupWiseCompControllerDTO;
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
public class EmGroupWiseCompWraper extends Response implements Serializable{
	private static final long serialVersionUID = 6637230798664599079L;
    private List<EmGroupWiseCompControllerDTO> emGroupWiseCompControllerDTOs;
}
