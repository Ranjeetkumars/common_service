package com.pro.common.wrapers;



import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GetRemaindersControllerDto;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GetRemaindersWrapper extends Response  implements Serializable{
	private static final long serialVersionUID = 4211593995472137372L;
	private List<GetRemaindersControllerDto> objControllerDto; 


}
