/**
 * 
 */
package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.SocialMediaMapper;
import com.pro.common.persistencedto.SocialMediaPersistanceDTO;
import com.pro.common.service.SocialMediaService;
import com.pro.common.servicedto.SocialMediaSericeDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Habiboon
 *
 */
@Service("objSocialMediaServiceImpl")
@Slf4j
public class SocialMediaServiceImpl implements SocialMediaService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialMediaSericeDTO> getFaceBookposts(SocialMediaSericeDTO datainfo, String strRequestID)
			throws DataNotFoundException {
		SocialMediaMapper dataMapper = new SocialMediaMapper();
		List<SocialMediaSericeDTO> socialMediaSericeDTO = null;
		String strQuery = "Select * from sp_select_mpcr_socialmedia_cntnt_trans(" + datainfo.getMsm_socialmedia_id() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<SocialMediaPersistanceDTO> socialMediaPersistanceDTOs = dataMapper.conversionForGetFacebookPost(list);
			socialMediaSericeDTO = dataMapper.convertPersistenceDTOtoServiceDTO(socialMediaPersistanceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No posts found::::::"
					+ datainfo.getMsm_socialmedia_id());
		}
		return socialMediaSericeDTO;
	}


	@Override
	public String isGISMapViewUser(SocialMediaSericeDTO datainfo, String strRequestID)
			throws DataNotFoundException {
		//SocialMediaMapper dataMapper = new SocialMediaMapper();
		//List<SocialMediaSericeDTO> socialMediaSericeDTO = null;
		StringBuffer strQuery = new StringBuffer("SELECT COUNT(ur_userid) as integer FROM amsusers_roles_xref WHERE ur_userid= " + datainfo.getUr_userid() + " AND  ur_moduleid =" + datainfo.getUr_moduleid());//" AND ur_roleid=107 AND ur_isactive=true"
        int moduleID=Integer.parseInt(datainfo.getUr_moduleid());
        if (moduleID == 4) {//CA--->107
        	strQuery.append(" AND ur_roleid=107 AND ur_isactive=true");
        } else if (moduleID == 5) {//DCA Map View Role--->108
        	strQuery.append(" AND ur_roleid=108 AND ur_isactive=true");
        } else if (moduleID == 10) {//SUPERVISOR Map View Role--->109
        	strQuery.append(" AND ur_roleid=109 AND ur_isactive=true");
        } else if (moduleID == 2) {//PDA Map View Role--->110
        	strQuery.append(" AND ur_roleid=110 AND ur_isactive=true");
        } else if (moduleID == 3) {//FDA Map View Role--->111
        	strQuery.append(" AND ur_roleid=111 AND ur_isactive=true");
        } else if (moduleID == 12) {//EP Map View Role--->112
        	strQuery.append(" AND ur_roleid=112 AND ur_isactive=true");
        } else if (moduleID == 41) {//OP Feed back Map View Role--->126
        	strQuery.append(" AND ur_roleid=126 AND ur_isactive=true");
        } else if (moduleID == 43) {//OP Help Desk Map View Role--->127
        	strQuery.append(" AND ur_roleid=127 AND ur_isactive=true");
        }
		log.info(strRequestID + ":::::::::::::" + strQuery);
		String list =  objCommonDataDaoImpl.getSingleData(strQuery.toString());
		
		return list;
	}

	
}
