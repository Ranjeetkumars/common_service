package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.VehicleIdBasedOnEMTNoControllerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class VehicleIdBasedOnEMTNoWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -558490911483572565L;

	private List<VehicleIdBasedOnEMTNoControllerDTO> objVehicleIdBasedOnEMTNO;
}
