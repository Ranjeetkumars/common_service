package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.AuthanticationControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthanticationWrapper extends Response implements Serializable {
	private static final long serialVersionUID = -1298458696412425120L;
	private List<AuthanticationControllerDTO> authenticationusers;
}
