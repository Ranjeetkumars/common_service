package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GetEventLandmarkControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class GetEventLandmarkWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 5495441778700589262L;
	private List<GetEventLandmarkControllerDTO> objGetEventLandmarkControllerDTO;
}
