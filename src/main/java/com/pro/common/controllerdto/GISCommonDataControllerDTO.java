/**
 * @JsonIgnoreProperties---->we can give Any One Of the input in the below mentioned class
 * @Data---->It will auto matically Generated Getters And Setters
 */
package com.pro.common.controllerdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author VENKAT_PRO
 * 15-05-2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GISCommonDataControllerDTO {
  private String countryId;
  private String countryName;
  private String stateId;
  private String stateName;
  private String districtId;
  private String districtname;
  private String mandalId;
  private String mandalName;
  private String cityId;
  private String cityName;
  private String landmarkId;
  private String landmarkname;
  private String localityId;
  private String loclaityname;  
}
