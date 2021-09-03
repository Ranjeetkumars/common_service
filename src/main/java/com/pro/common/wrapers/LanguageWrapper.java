/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.LanguageControllerDTO;
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
public class LanguageWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 4055010893532305697L;
    private List<LanguageControllerDTO> objControllerDTOs;
}
