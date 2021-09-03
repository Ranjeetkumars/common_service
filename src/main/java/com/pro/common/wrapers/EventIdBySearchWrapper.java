package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.EventIdBySearchControllerDTO;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class EventIdBySearchWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 2793924013252293661L;
	   private List<EventIdBySearchControllerDTO> objEventBySearchControllerDTO;
}
