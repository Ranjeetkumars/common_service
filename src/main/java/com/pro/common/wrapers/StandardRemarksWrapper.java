/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.StandardRemarksControllerDTO;

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
public class StandardRemarksWrapper extends Response implements Serializable {
	private static final long serialVersionUID = -8562469852888250688L;
    private List<StandardRemarksControllerDTO>  remarksControllerDTOs;
}
