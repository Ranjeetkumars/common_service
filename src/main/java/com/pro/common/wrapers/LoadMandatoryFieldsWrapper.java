
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.LoadMandatoryFieldsControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Habiboon Patan
 * @Date : 2019-07-17
 *
 */
@Getter
@Setter
@ToString
public class LoadMandatoryFieldsWrapper extends Response implements Serializable {
	private static final long serialVersionUID = -4055925064027662526L;
	private List<LoadMandatoryFieldsControllerDTO> objLoadMandatoryFieldsControllerDTO;
}
