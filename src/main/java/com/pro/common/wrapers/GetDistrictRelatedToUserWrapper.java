package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.GetDistrictRelatedToUser;
import com.pro.common.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetDistrictRelatedToUserWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 6637230798664599079L;
    private List<GetDistrictRelatedToUser> objDistrictRelatedToUser;
}
