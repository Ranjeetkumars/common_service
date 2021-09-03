package com.pro.common.controllerdto;

import lombok.Data;

/**
 * @author Deepak
 * 07-08-2019
 */
@Data
public class GetDistrictRelatedToUser {
	private String userid;
	private String districtid;
	private String districtName;

}
