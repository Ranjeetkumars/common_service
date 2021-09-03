package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GetModuleSpecifcAgentsControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//Habiboon
@ToString
@Setter
@Getter
public class GetModuleSpecifcAgentsWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 5495441778700589262L;
	private List<GetModuleSpecifcAgentsControllerDTO> objGetModuleSpecifcAgentsControllerDTO;
}
