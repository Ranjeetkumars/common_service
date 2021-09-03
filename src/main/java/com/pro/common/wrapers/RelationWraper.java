/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.RelationControllerDTO;
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
public class RelationWraper extends Response implements Serializable{	
	private static final long serialVersionUID = -1581337240954830498L;
    private List<RelationControllerDTO> objRelationControllerDTOs;
}
