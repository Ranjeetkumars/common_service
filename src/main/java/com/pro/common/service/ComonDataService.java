/**
 * 
 */
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.BloodGroupServiceDTO;
import com.pro.common.servicedto.BreakTypeServiceDTO;
import com.pro.common.servicedto.CallTypeServiceDTO;
import com.pro.common.servicedto.CheifComplaintServiceDTO;
import com.pro.common.servicedto.ERODummyDispatchServiceDTO;
import com.pro.common.servicedto.EmGroupWiseCompServiceDTO;
import com.pro.common.servicedto.EventIdBySearchServiceDTO;
import com.pro.common.servicedto.EventStatusServiceDTO;
import com.pro.common.servicedto.GISCommonDataServiceDTO;
import com.pro.common.servicedto.GendersServiceDTO;
import com.pro.common.servicedto.GetDistrictRelatedServiceDTO;
import com.pro.common.servicedto.GetEventLandmarkServiceDTO;
import com.pro.common.servicedto.GetModuleSpecifcAgentsServiceDTO;
import com.pro.common.servicedto.GetRemaindersServiceDto;
import com.pro.common.servicedto.LanguageServiceDTO;
import com.pro.common.servicedto.ModulePropertiesServiceDTO;
import com.pro.common.servicedto.NoticeAlertServiceDTO;
import com.pro.common.servicedto.RelationServiceDTO;
import com.pro.common.servicedto.SaveAddressServiceDTO;
import com.pro.common.servicedto.ServityTypeServiceDTO;
import com.pro.common.servicedto.SkillsSetServiceDTO;
import com.pro.common.servicedto.StandardRemarksServiceDTO;
import com.pro.common.servicedto.VehicleIdBasedOnEMTnoServiceDTO;
import com.pro.common.servicedto.VictimDetailServiceDTO;

/**
 * @author VENKAT_PRO 15-05-2019
 */
public interface ComonDataService {
	/*
	 * GIS Related Methods
	 */
	public List<GISCommonDataServiceDTO> getCountries(String strRequestID) throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getStates(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getDistricts(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getMandals(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getCities(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getLocalities(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GISCommonDataServiceDTO> getLandmarks(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException;

	/*
	 * Language Related Methods
	 */
	public List<LanguageServiceDTO> getLanguages(String strRequestID) throws DataNotFoundException;

	/*
	 * CallType Related method
	 */
	public List<CallTypeServiceDTO> getCallTypes(String strRequestID) throws DataNotFoundException;

	/*
	 * Relation Related methods
	 */
	public List<RelationServiceDTO> getRelationTypes(String strRequestID) throws DataNotFoundException;

	public List<CheifComplaintServiceDTO> getChiefComplaints(CheifComplaintServiceDTO objCheifComplaintServiceDTO,
			String strRequestID) throws DataNotFoundException;

	public List<GendersServiceDTO> getGenders(String strRequestID) throws DataNotFoundException;

	public List<EmGroupWiseCompServiceDTO> getEmegencyGroups(String strRequestID) throws DataNotFoundException;

	public List<EmGroupWiseCompServiceDTO> getEmegencyGroupWiseChiefComp(String strRequestID)
			throws DataNotFoundException;

	public List<StandardRemarksServiceDTO> getRemarksBasedOnModule(String strModuleID, String strRequestID)
			throws DataNotFoundException;

	public List<EventStatusServiceDTO> getEventStatusTypes(String strModuleID, String strRequestID)
			throws DataNotFoundException;

	public List<ServityTypeServiceDTO> getSeviarities(String strRequestID) throws DataNotFoundException;

	public List<EmGroupWiseCompServiceDTO> getGenderWiseChiefComplaints(String strGenderID, String strRequestID)
			throws DataNotFoundException;

	public List<BreakTypeServiceDTO> getBreakTypes(String strRequestID) throws DataNotFoundException;

	/*
	 * For loading of deployment properties
	 */
	public List<ModulePropertiesServiceDTO> getDeploymentProperties(ModulePropertiesServiceDTO dto, String strRequestID)
			throws DataNotFoundException;

	public List<ModulePropertiesServiceDTO> getDeploymentTerminalProperties(ModulePropertiesServiceDTO dto,
			String strRequestID) throws DataNotFoundException;

	public List<SkillsSetServiceDTO> getSkillSets(String strRequestID) throws DataNotFoundException;

	public List<GetDistrictRelatedServiceDTO> getDistrictRelatedToUsers(
			GetDistrictRelatedServiceDTO objDistrictServiceDTO, String strRequestID) throws DataNotFoundException;

	public List<CallTypeServiceDTO> getCallType(String strRequestID) throws DataNotFoundException;

	public List<EventIdBySearchServiceDTO> getEventIdBySearch(EventIdBySearchServiceDTO dto, String strRequestID,
			String moduleId) throws DataNotFoundException;

	public List<ERODummyDispatchServiceDTO> getERODummyDispatch(String strRequestID) throws DataNotFoundException;

	public List<NoticeAlertServiceDTO> getNoticeAlert(NoticeAlertServiceDTO objNoticeAlertService, String strRequestID)
			throws DataNotFoundException;

	public List<VehicleIdBasedOnEMTnoServiceDTO> getVehicleIdBasedOnEMTNO(
			VehicleIdBasedOnEMTnoServiceDTO objVehicleIdServiceDTO, String strRequestID) throws DataNotFoundException;

	public String SaveAddress(SaveAddressServiceDTO objVehicleIdServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String updateRemainder(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<BloodGroupServiceDTO> getBloodGroups(String strRequestID) throws DataNotFoundException;

	public List<BloodGroupServiceDTO> getEconomicType(String strRequestID) throws DataNotFoundException;

	public List<BloodGroupServiceDTO> getSocialStatusType(String strRequestID) throws DataNotFoundException;

	public List<BloodGroupServiceDTO> getAllCheifComplaint(BloodGroupServiceDTO objBloodGroupServiceDTO,
			String strRequestID) throws DataNotFoundException;

	public String updateCheifComplaint(BloodGroupServiceDTO objBloodGroupServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<VictimDetailServiceDTO> getVictimDetail(VictimDetailServiceDTO objVictimDetailServiceDTO,
			String strRequestID) throws DataNotFoundException;

	public String updateVictimDetails(VictimDetailServiceDTO objVictimDetailServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String insertVictimDetails(VictimDetailServiceDTO objVictimDetailServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<GetModuleSpecifcAgentsServiceDTO> getModuleSpecifcAgents_Supervisor(
			GetModuleSpecifcAgentsServiceDTO dataInfo, String strRequestId) throws DataNotFoundException;

	public String getSize(GetModuleSpecifcAgentsServiceDTO dataInfo, String strRequestId) throws DataNotFoundException;

	public String getEventLandmarkCount(GetModuleSpecifcAgentsServiceDTO dataInfo, String reqId)
			throws DataNotFoundException;

	public List<GetEventLandmarkServiceDTO> getEventLandmark(GetEventLandmarkServiceDTO dataInfo, String reqId)
			throws DataNotFoundException;

	
}
