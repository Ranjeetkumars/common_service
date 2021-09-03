/**
 * 
 */
package com.pro.common.wrapers;

import java.io.Serializable;
import java.util.List;

import com.pro.common.controllerdto.Response;
import com.pro.common.controllerdto.SocialMediaControllerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Habiboon Patan
 *
 */
@Getter
@Setter
@ToString
public class SocialMediaWrapper extends Response implements Serializable{
	private static final long serialVersionUID = -4055925064027662526L;
    private List<SocialMediaControllerDTO> socialMediaControllerDTO;

}
