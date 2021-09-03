/**
 * 
 */
package com.pro.common.servicedto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class BreakTypeServiceDTO {
	private String breakTypeID;
	 private String breakTypeName;
	   //Added By Purushotham
		private Integer intUserId;
		private Integer intModuleId;
		private Integer intRoleId;
		private Integer breakTransId;
}
