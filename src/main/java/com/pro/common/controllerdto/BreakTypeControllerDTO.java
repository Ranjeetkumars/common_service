/**
 * 
 */
package com.pro.common.controllerdto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class BreakTypeControllerDTO {
	private String breakTypeID;
	private String breakTypeName;
   //Added By Purushotham
	private Integer intUserId;
	private Integer intModuleId;
	private Integer intRoleId;
	private Integer breakTransId;

}
