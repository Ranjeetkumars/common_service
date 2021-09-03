/**
 * 
 */
package com.pro.common.persistencedto;

import lombok.Data;

/**
 * @author VENKAT_PRO
 *
 */
@Data
public class BreakTypePersistenceDTO {
	private String breakTypeID;
	 private String breakTypeName;
	 
	   //Added By Purushotham
		private Integer intUserId;
		private Integer intModuleId;
		private Integer intRoleId;
		private Integer breakTransId;
}
