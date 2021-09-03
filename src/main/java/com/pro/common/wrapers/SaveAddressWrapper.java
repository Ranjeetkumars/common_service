package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;


import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.SaveAddressControllerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SaveAddressWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -4055925064027662526L;
    private List<SaveAddressControllerDTO> objSaveAddressControllerDTO;
}
