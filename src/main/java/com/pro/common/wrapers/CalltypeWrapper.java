/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.CallTypeControllerDTO;
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
public class CalltypeWrapper extends Response implements Serializable{

	private static final long serialVersionUID = 2793924013252293661L;
   private List<CallTypeControllerDTO> objTypeControllerDTOs;
}
