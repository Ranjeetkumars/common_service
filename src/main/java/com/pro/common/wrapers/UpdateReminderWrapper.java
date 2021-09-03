package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.CTIControllerDTO;
import com.pro.common.controllerdto.GetRemaindersControllerDto;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UpdateReminderWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -4055925064027662526L;
    private List<GetRemaindersControllerDto> objGetRemaindersControllerDto;
}
