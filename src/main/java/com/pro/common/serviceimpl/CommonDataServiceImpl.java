/**
 * 
 */
package com.pro.common.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.mappers.BloodGroupMapper;
import com.pro.common.mappers.BreakTypeMapper;
import com.pro.common.mappers.CallTypeMapper;
import com.pro.common.mappers.CheifComplaintMapper;
import com.pro.common.mappers.ERODummyDispatchMapper;
import com.pro.common.mappers.EmGroupWiseCompMapper;
import com.pro.common.mappers.EventIdBySearchMapper;
import com.pro.common.mappers.EventStatusMapper;
import com.pro.common.mappers.GISDataMapper;
import com.pro.common.mappers.GendersMapper;
import com.pro.common.mappers.GetDistrictRelatedMapper;
import com.pro.common.mappers.GetEventLandmarkMapper;
import com.pro.common.mappers.GetModuleSpecifcAgentsMapper;
import com.pro.common.mappers.LanguageMapper;
import com.pro.common.mappers.ModulePropertiesMapper;
import com.pro.common.mappers.NoticeAlertMapper;
import com.pro.common.mappers.RelationMaper;
import com.pro.common.mappers.SaveAddressMapper;
import com.pro.common.mappers.ServityTypeMapper;
import com.pro.common.mappers.SkillsSetMapper;
import com.pro.common.mappers.StandardRemarksMapper;
import com.pro.common.mappers.VehilceIdBasedOnEmtNoMapper;
import com.pro.common.mappers.VictimDetailsMapper;
import com.pro.common.persistencedto.BloodGroupPersistenanceDTO;
import com.pro.common.persistencedto.BreakTypePersistenceDTO;
import com.pro.common.persistencedto.CallTypePersistenceDTO;
import com.pro.common.persistencedto.CheifComplaintPersistenceDTO;
import com.pro.common.persistencedto.ERODummyDispatchPersistenanceDTO;
import com.pro.common.persistencedto.EmGroupWiseCompPersistenceDTO;
import com.pro.common.persistencedto.EventIdBySearchPersistenanceDTO;
import com.pro.common.persistencedto.EventStatusPersistenceDTO;
import com.pro.common.persistencedto.GISCommonDataPersistenceDTO;
import com.pro.common.persistencedto.GendersPersistenceDTO;
import com.pro.common.persistencedto.GetDistrictRelatedPersistenanceDTO;
import com.pro.common.persistencedto.GetEventLandmarkPersistanceDTO;
import com.pro.common.persistencedto.GetModuleSpecifcAgentsPersistanceDTO;
import com.pro.common.persistencedto.LanguagePersistenceDTO;
import com.pro.common.persistencedto.ModulePropertiesPersistenceDTO;
import com.pro.common.persistencedto.NoticeAlertPersistenaceDTO;
import com.pro.common.persistencedto.RelationPersistenceDTO;
import com.pro.common.persistencedto.ServityTypePersistenceDTO;
import com.pro.common.persistencedto.SkillsSetPersistenceDTO;
import com.pro.common.persistencedto.StandardRemarksPersistenceDTO;
import com.pro.common.persistencedto.VehicleIdBasedOnEMTNoPersistenanceDTO;
import com.pro.common.persistencedto.VictimDetailPersistenanceDTO;
import com.pro.common.service.ComonDataService;
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

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO
 *
 */
@Service("objCommonDataServiceImpl")
@Slf4j
public class CommonDataServiceImpl implements ComonDataService {
	@Autowired
	@Qualifier("objCommonDataDaoImpl")
	CommonDataDao objCommonDataDaoImpl;

	@Override
	public List<GISCommonDataServiceDTO> getStates(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_allstatesbycountyid(" + controllerDTO.getCountryId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListStates(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No states found For the given Country ID::::::"
					+ controllerDTO.getCountryId());
		}
		return commonDataServiceDTOs;
	}

	@Cacheable("Districts")
	@Override
	public List<GISCommonDataServiceDTO> getDistricts(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_alldistrictsbystateid(" + controllerDTO.getStateId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListDistricts(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No Districts found For the given stateid ID::::::"
					+ controllerDTO.getStateId());
		}
		return commonDataServiceDTOs;
	}

	@Override
	@Cacheable(value="mandals", key="#controllerDTO.districtId")
	public List<GISCommonDataServiceDTO> getMandals(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_allmandalbydistrictid(" + controllerDTO.getDistrictId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListMandals(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No Mandals found For the given Districts ID::::::"
					+ controllerDTO.getDistrictId());
		}
		return commonDataServiceDTOs;
	}

	@Override
	@Cacheable(value="cities", key="#controllerDTO.mandalId")
	public List<GISCommonDataServiceDTO> getCities(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = new StringBuilder("select * from sp_select_allcitiesbymandalid(")
				.append(controllerDTO.getMandalId()).append(")").toString();
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListCities(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No Cities found For the given Mandals ID::::::"
					+ controllerDTO.getMandalId());
		}
		return commonDataServiceDTOs;
	}

	@Override
	@Cacheable(value="localities", key="#controllerDTO.cityId")
	public List<GISCommonDataServiceDTO> getLocalities(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_alllocalitiescitiesid(" + controllerDTO.getCityId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListLocalities(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No localities found For the given City ID::::::"
					+ controllerDTO.getCityId());
		}
		return commonDataServiceDTOs;
	}

	@Override
	@Cacheable(value="landmarkes", key="#controllerDTO.localityId")
	public List<GISCommonDataServiceDTO> getLandmarks(GISCommonDataServiceDTO controllerDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_alllandmarkbylocalitionid(" + controllerDTO.getLocalityId() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListLandmarks(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No Landmark found For the given loality ID::::::"
					+ controllerDTO.getLocalityId());
		}
		return commonDataServiceDTOs;
	}

	@Cacheable("countries")
	@Override
	public List<GISCommonDataServiceDTO> getCountries(String strRequestID) throws DataNotFoundException {
		GISDataMapper dataMapper = new GISDataMapper();
		List<GISCommonDataServiceDTO> commonDataServiceDTOs = null;
		String strQuery = "select * from sp_select_allcountries()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GISCommonDataPersistenceDTO> gisPersDTOs = dataMapper
					.convertObjetsArraytoGISCommonDataPersistenceDTOListCountries(list);
			commonDataServiceDTOs = dataMapper
					.convertGISCommonDataPersistenceDTOListToGISCommonDataServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + "::::::getCountries():::::::");
		}
		return commonDataServiceDTOs;
	}

	@Cacheable("languages")
	@Override
	public List<LanguageServiceDTO> getLanguages(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		LanguageMapper languageMapper = new LanguageMapper();
		List<LanguageServiceDTO> languageServiceDTOs = null;
		String strQuery = "select * from sp_select_hm_co_language_dropdown()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<LanguagePersistenceDTO> gisPersDTOs = languageMapper
					.convertObjetsArraytoLanguagePersistenceDTOList(list);
			languageServiceDTOs = languageMapper.convertLanguagePersistenceDTOListToLanguageServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getLanguages ID::::::");
		}
		return languageServiceDTOs;
	}

	@Cacheable("callTypes")
	@Override
	public List<CallTypeServiceDTO> getCallTypes(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		CallTypeMapper callTypeMapper = new CallTypeMapper();
		List<CallTypeServiceDTO> callTypeServiceDTOs = null;
		String strQuery = "select * from sp_select_erscalltypes_ref()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CallTypePersistenceDTO> gisPersDTOs = callTypeMapper
					.convertObjetsArraytoGISCallTypePersistenceDTOList(list);
			callTypeServiceDTOs = callTypeMapper.convertCallTypePersistenceDTOListToCallTypeServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getCallTypes::::::");
		}
		return callTypeServiceDTOs;
	}

	@Cacheable("relationTypes")
	@Override
	public List<RelationServiceDTO> getRelationTypes(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		RelationMaper relationMaper = new RelationMaper();
		List<RelationServiceDTO> relationServiceDTOs = null;
		String strQuery = "select * from sp_select_ersrelationtypes_ref()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<RelationPersistenceDTO> persistenceDTOs = relationMaper
					.convertObjetsArraytoRelationPersistenceDTOList(list);
			relationServiceDTOs = relationMaper.convertRelationServiceDTOListToRelationServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getRelationTypes::::::");
		}
		return relationServiceDTOs;
	}

	@Override
	public List<CheifComplaintServiceDTO> getChiefComplaints(CheifComplaintServiceDTO objCheifComplaintServiceDTO,
			String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		CheifComplaintMapper complaintMapper = new CheifComplaintMapper();
		List<CheifComplaintServiceDTO> complaintServiceDTOs = null;
		String strQuery = "select * from sp_select_ersca_chiefcomptypes_ref("
				+ objCheifComplaintServiceDTO.getEmergencyTypeID() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CheifComplaintPersistenceDTO> persistenceDTOs = complaintMapper
					.convertObjetsArraytoCheifComplaintPersistenceDTOList(list);
			complaintServiceDTOs = complaintMapper
					.convertCheifComplaintPersistenceDTOListToCheifComplaintServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getChiefComplaints::::::");
		}
		return complaintServiceDTOs;
	}

	@Cacheable("genders")
	@Override
	public List<GendersServiceDTO> getGenders(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		GendersMapper gendersMapper = new GendersMapper();
		List<GendersServiceDTO> gendersServiceDTOs = null;
		String strQuery = "select * from sp_select_active_Genders()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GendersPersistenceDTO> persistenceDTOs = gendersMapper
					.convertObjetsArraytoGendersPersistenceDTOList(list);
			gendersServiceDTOs = gendersMapper.convertGendersPersistenceDTOListToGendersServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getGenders ID::::::");
		}
		return gendersServiceDTOs;
	}

	@Cacheable("Emergencygroups")
	@Override
	public List<EmGroupWiseCompServiceDTO> getEmegencyGroupWiseChiefComp(String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		EmGroupWiseCompMapper gendersMapper = new EmGroupWiseCompMapper();
		List<EmGroupWiseCompServiceDTO> emGroupWiseCompServiceDTOs = null;
		String strQuery = "SELECT * FROM sp_select_emergency_group_wise_chiefcomplaints()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<EmGroupWiseCompPersistenceDTO> persistenceDTOs = gendersMapper
					.convertObjetsArraytoEmGroupWiseCompPersistenceDTOList_cheifcomp(list);
			emGroupWiseCompServiceDTOs = gendersMapper
					.convertEmGroupWiseCompPersistenceDTOListToEmGroupWiseCompServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getEmegencyGroupWiseChiefComp::::::");
		}
		return emGroupWiseCompServiceDTOs;
	}

	@Cacheable("EmergencyGroupwisechiefcompl")
	@Override
	public List<EmGroupWiseCompServiceDTO> getEmegencyGroups(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		EmGroupWiseCompMapper groupWiseCompMapper = new EmGroupWiseCompMapper();
		List<EmGroupWiseCompServiceDTO> emGroupWiseCompServiceDTOs = null;
		String strQuery = "select * from  sp_select_ersemergencygroups_ref()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<EmGroupWiseCompPersistenceDTO> persistenceDTOs = groupWiseCompMapper
					.convertObjetsArraytoEmGroupWiseCompPersistenceDTOList(list);
			emGroupWiseCompServiceDTOs = groupWiseCompMapper
					.convertEmGroupWiseCompPersistenceDTOListToEmGroupWiseCompServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getEmegencyGroups::::::");
		}
		return emGroupWiseCompServiceDTOs;
	}

	@Override
	public List<StandardRemarksServiceDTO> getRemarksBasedOnModule(String strModuleID, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		StandardRemarksMapper standardRemarksMapper = new StandardRemarksMapper();
		List<StandardRemarksServiceDTO> standardRemarksServiceDTOs = null;
		String strQuery = "select * from  sp_select_ersgroupwisestandardremarks_ref(" + strModuleID + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<StandardRemarksPersistenceDTO> persistenceDTOs = standardRemarksMapper
					.convertObjetsArraytoStandardRemarksPersistenceDTOList(list);
			standardRemarksServiceDTOs = standardRemarksMapper
					.convertStandardRemarksPersistenceDTOListToStandardRemarksServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getRemarksBasedOnModule::::::");
		}
		return standardRemarksServiceDTOs;
	}

	@Override
	public List<EventStatusServiceDTO> getEventStatusTypes(String strModuleID, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		EventStatusMapper eventStatusMapper = new EventStatusMapper();
		List<EventStatusServiceDTO> serviceDTOs = null;
		String strQuery = "select * from sp_select_module_wise_erseventstatus_type(" + strModuleID + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<EventStatusPersistenceDTO> persistenceDTOs = eventStatusMapper
					.convertObjetsArraytoEventStatusPersistenceDTOList(list);
			serviceDTOs = eventStatusMapper
					.convertEventStatusPersistenceDTOListToEventStatusServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getEventStatusTypes::::::");
		}
		return serviceDTOs;
	}

	@Cacheable("seviarities")
	@Override
	public List<ServityTypeServiceDTO> getSeviarities(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		ServityTypeMapper typeMapper = new ServityTypeMapper();
		List<ServityTypeServiceDTO> serviceDTOs = null;
		String strQuery = "Select * from sp_select_ersseveritytypes_ref()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<ServityTypePersistenceDTO> persistenceDTOs = typeMapper
					.convertObjetsArraytoRelationPersistenceDTOList(list);
			serviceDTOs = typeMapper.convertServityTypePersistenceDTOListToServityTypeServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSeviarities::::::");
		}
		return serviceDTOs;
	}

	@Override
	public List<EmGroupWiseCompServiceDTO> getGenderWiseChiefComplaints(String strGenderID, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		EmGroupWiseCompMapper groupWiseCompMapper = new EmGroupWiseCompMapper();
		List<EmGroupWiseCompServiceDTO> emGroupWiseCompServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder(
				"select * from  sp_select_ersca_chiefcompltypes_ref_basedonGenderId(").append(strGenderID).append(")");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<EmGroupWiseCompPersistenceDTO> persistenceDTOs = groupWiseCompMapper
					.convertObjetsArraytoEmGroupWiseCompPersistenceDTOListForGenderWiseChiefCompl(list);
			emGroupWiseCompServiceDTOs = groupWiseCompMapper
					.convertEmGroupWiseCompPersistenceDTOListToEmGroupWiseCompServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getGenderWiseChiefComplaints::::::");
		}
		return emGroupWiseCompServiceDTOs;
	}

	@Override
	@Cacheable("breakTypes")
	public List<BreakTypeServiceDTO> getBreakTypes(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		BreakTypeMapper breakTypeMapper = new BreakTypeMapper();
		List<BreakTypeServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("select * from sp_select_ams_breaktyperef()");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BreakTypePersistenceDTO> persistenceDTOs = breakTypeMapper
					.convertObjetsArraytoBreakTypePersistenceDTOList(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertBreakTypePersistenceDTOListToBreakTypeServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getBreakTypes::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	public List<ModulePropertiesServiceDTO> getDeploymentProperties(ModulePropertiesServiceDTO dto, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		ModulePropertiesMapper mapper = new ModulePropertiesMapper();
		List<ModulePropertiesServiceDTO> modulePropertiesServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("SELECT  * FROM sp_admin_select_ams_deployment_properties_ref(")
				.append(dto.getModuleiD()).append(",").append(dto.getInputKey()).append(")");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<ModulePropertiesPersistenceDTO> persistenceDTOs = mapper
					.convertObjetsArraytoModulePropertiesPersistenceDTOList(list);
			modulePropertiesServiceDTOs = mapper
					.convertModulePropertiesPersistenceDTOListToModulePropertiesServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getDeploymentProperties::::::");
		}
		return modulePropertiesServiceDTOs;
	}

	@Override
	public List<ModulePropertiesServiceDTO> getDeploymentTerminalProperties(ModulePropertiesServiceDTO dto,
			String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		ModulePropertiesMapper mapper = new ModulePropertiesMapper();
		List<ModulePropertiesServiceDTO> modulePropertiesServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder(
				"SELECT adtp_key, adtp_value  FROM ams_deployment_terminal_properties_trans   WHERE adtp_isactive = true AND adtp_module_id=")
						.append(dto.getModuleiD()).append(" AND adtp_ipaddress = '").append(dto.getIpAddress())
						.append("'");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<ModulePropertiesPersistenceDTO> persistenceDTOs = mapper
					.convertObjetsArraytoModulePropertiesPersistenceDTOList(list);
			modulePropertiesServiceDTOs = mapper
					.convertModulePropertiesPersistenceDTOListToModulePropertiesServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getDeploymentTerminalProperties::::::");
		}
		return modulePropertiesServiceDTOs;
	}

	@Cacheable("skillgroups")
	@Override
	public List<SkillsSetServiceDTO> getSkillSets(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		SkillsSetMapper mapper = new SkillsSetMapper();
		List<SkillsSetServiceDTO> skillsSetServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("SELECT * from sp_select_skillsetgroup()");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<SkillsSetPersistenceDTO> persistenceDTOs = mapper
					.convertObjetsArraytoSkillsSetPersistenceDTOList(list);
			skillsSetServiceDTOs = mapper.convertSkillsSetPersistenceDTOListToSkillsSetServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSkillSets::::::");
		}
		return skillsSetServiceDTOs;
	}

	@Override
	public List<GetDistrictRelatedServiceDTO> getDistrictRelatedToUsers(
			GetDistrictRelatedServiceDTO objDistrictServiceDTO, String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		GetDistrictRelatedMapper objGetDistrict = new GetDistrictRelatedMapper();
		List<GetDistrictRelatedServiceDTO> districtServiceDTO = null;
		StringBuilder strQuery = new StringBuilder(
				"select * from sp_select_districts_on_userid_ers_center_user_zone_xref("
						+ objDistrictServiceDTO.getUserid() + ")");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<GetDistrictRelatedPersistenanceDTO> persistenceDTOs = objGetDistrict
					.convertObjetsArraytoDistrictRelatedToUserPersistenceDTOList(list);
			districtServiceDTO = objGetDistrict
					.convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSkillSets::::::");
		}
		return districtServiceDTO;
	}

	@Cacheable("callTypes")
	@Override
	public List<CallTypeServiceDTO> getCallType(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		CallTypeMapper callTypeMapper = new CallTypeMapper();
		List<CallTypeServiceDTO> callTypeServiceDTOs = null;
		String strQuery = "select * from sp_select_calltypes_forcommon_search()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<CallTypePersistenceDTO> gisPersDTOs = callTypeMapper
					.convertObjetsArraytoGISCallTypePersistenceDTOList(list);
			callTypeServiceDTOs = callTypeMapper.convertCallTypePersistenceDTOListToCallTypeServiceDTOList(gisPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getCallTypes::::::");
		}
		return callTypeServiceDTOs;
	}

	@Override
	public List<EventIdBySearchServiceDTO> getEventIdBySearch(EventIdBySearchServiceDTO objDistrictServiceDTO,
			String strRequestID, String moduleId) throws DataNotFoundException {
		// TODO Auto-generated method stub
		EventIdBySearchMapper objEventMapper = new EventIdBySearchMapper();
		String strQuery = null;
		List<EventIdBySearchServiceDTO> districtServiceDTO = null;
		if (moduleId.equalsIgnoreCase("5")) {
			log.info("getEventIdBysearch  in MDA");
			strQuery = "select * from sp_select_mda_eventsearch('" + objDistrictServiceDTO.getEventid() + "')";
		} else if (moduleId.equalsIgnoreCase("2")) {
			log.info("getEventIdBysearch  in PDA");
			strQuery = "select * from sp_select_pda_eventsearch('" + objDistrictServiceDTO.getEventid() + "')";
		} else if (moduleId.equalsIgnoreCase("3")) {
			log.info("getEventIdBysearch  in FDA");
			strQuery = "select * from sp_select_fda_eventsearch('" + objDistrictServiceDTO.getEventid() + "')";
		} else if (moduleId.equalsIgnoreCase("10")) {
			log.info("getEventIdBysearch  in supervisor");
			strQuery = "select * from sp_select_mda_eventsearch('" + objDistrictServiceDTO.getEventid() + "')";
		}
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<EventIdBySearchPersistenanceDTO> persistenceDTOs = objEventMapper
					.convertObjetsArraytoEventIdSearch(list);
			districtServiceDTO = objEventMapper
					.convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSkillSets::::::");
		}
		return districtServiceDTO;
	}

	@Override
	public List<ERODummyDispatchServiceDTO> getERODummyDispatch(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		ERODummyDispatchMapper eventStatusMapper = new ERODummyDispatchMapper();
		List<ERODummyDispatchServiceDTO> serviceDTOs = null;
		String strQuery = "select *from sp_select_dummy_dispatches()";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<ERODummyDispatchPersistenanceDTO> persistenceDTOs = eventStatusMapper.ConvertERODummyDispatch(list);
			serviceDTOs = eventStatusMapper
					.convertGetDistrictSetPersistenceDTOListToDistrictSetServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getEventStatusTypes::::::");
		}
		return serviceDTOs;
	}

	@Override
	public List<NoticeAlertServiceDTO> getNoticeAlert(NoticeAlertServiceDTO objNoticeAlertService, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		NoticeAlertMapper objNoticeAlertMapper = new NoticeAlertMapper();
		List<NoticeAlertServiceDTO> objNoticeAlert = null;
		StringBuilder strQuery = new StringBuilder("select * from sp_select_em_hm_contactcenter_alerts_trans("
				+ objNoticeAlertService.getModuleid() + ")");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<NoticeAlertPersistenaceDTO> persistenceDTOs = objNoticeAlertMapper.convertNoticeAlert(list);
			objNoticeAlert = objNoticeAlertMapper
					.convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getNoticeAlert::::::");
		}
		return objNoticeAlert;
	}

	@Override
	public List<VehicleIdBasedOnEMTnoServiceDTO> getVehicleIdBasedOnEMTNO(
			VehicleIdBasedOnEMTnoServiceDTO objVehicleServiceDTO, String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		VehilceIdBasedOnEmtNoMapper objMapper = new VehilceIdBasedOnEmtNoMapper();
		List<VehicleIdBasedOnEMTnoServiceDTO> objVehicleService = null;
		StringBuilder strQuery = new StringBuilder(
				"select vd_vehicleid from fmsvehicledetails_ref where (trim(both ' ' from fmsvehicledetails_ref.vd_phoneno1) like ('%'||'"
						+ objVehicleServiceDTO.getPhoneno1()
						+ "')   or trim(both ' ' from fmsvehicledetails_ref.vd_phoneno2) like ('%'||'"
						+ objVehicleServiceDTO.getPhone2() + "') )and vd_isactive=true");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<VehicleIdBasedOnEMTNoPersistenanceDTO> persistenceDTOs = objMapper.convertVehicleIdBasedOnEMTNO(list);
			objVehicleService = objMapper
					.convertVehicleIdbasedOnEMTNoPersistenceDTOListToVehicleIdbasedOnEMTNoServiceDTOList(
							persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getVehicleIdBasedOnEMTNO`::::::");
		}
		return objVehicleService;
	}

	@Override
	public String SaveAddress(SaveAddressServiceDTO objVehicleServiceDTO, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		SaveAddressMapper objMapper = new SaveAddressMapper();
		List<SaveAddressServiceDTO> objVehicleService = null;
		String strQuery = "select * from sp_update_erseventinfo_trans(" + objVehicleServiceDTO.getEventid() + ",'"
				+ objVehicleServiceDTO.getHouseno() + "','" + objVehicleServiceDTO.getLaneStreet() + "',"
				+ objVehicleServiceDTO.getLandmarkid() + "," + objVehicleServiceDTO.getLocalityid() + ","
				+ objVehicleServiceDTO.getCityid() + "," + objVehicleServiceDTO.getMandalid() + ","
				+ objVehicleServiceDTO.getDistrictid() + "," + objVehicleServiceDTO.getUserid() + ","
				+ objVehicleServiceDTO.getModuleid() + "," + objVehicleServiceDTO.getRoleid() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		String returnStmt = objCommonDataDaoImpl.getSingleData(strQuery);

		return returnStmt;
	}

	@Override
	public String updateRemainder(GetRemaindersServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException {

		String strQuery = "select * from sp_upd_ers_agent_remainder_trans(" + dataServiceDTO.getAcKnowledged() + ","
				+ dataServiceDTO.getCreatedById() + ",'" + dataServiceDTO.getAcKnowledgedTime() + "'," + "'"
				+ dataServiceDTO.getReamainderWithTimeStamp() + "'," + dataServiceDTO.getRemainderId() + ")";

		log.info(strRequestID + "::::::::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override
	@Cacheable("breakTypes")
	public List<BloodGroupServiceDTO> getBloodGroups(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		List<BloodGroupServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder(
				"SELECT bg_bloodgrouptypeid, bg_bloodgrouptype FROM ersbloodgrouptype_ref WHERE bg_isactive= TRUE ORDER BY bg_orderby");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BloodGroupPersistenanceDTO> persistenceDTOs = breakTypeMapper.conversionofBloodgroup(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getBloodGroups::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	@Cacheable("EconomicTypes")
	public List<BloodGroupServiceDTO> getEconomicType(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		List<BloodGroupServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("select * from sp_select_hm_co_economictypes_dropdown()");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BloodGroupPersistenanceDTO> persistenceDTOs = breakTypeMapper.conversionOfEconomicType(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getEconomicType::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	@Cacheable("SocialStatusTypes")
	public List<BloodGroupServiceDTO> getSocialStatusType(String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		List<BloodGroupServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder("select * from sp_select_socialstatus()");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BloodGroupPersistenanceDTO> persistenceDTOs = breakTypeMapper.conversionSocicalType(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSocialStatusType::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override	
	public List<BloodGroupServiceDTO> getAllCheifComplaint(BloodGroupServiceDTO objBloodGroupServiceDTO,
			String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		BloodGroupMapper breakTypeMapper = new BloodGroupMapper();
		List<BloodGroupServiceDTO> breakTypeServiceDTOs = null;
		StringBuilder strQuery = new StringBuilder(
				"SELECT chct_chiefcomptypeid, chct_chiefcompltype,chct_cc_sec_lang,chct_cc_third_lang,chct_chief_comp_type_lang4 FROM ersca_chiefcomptypes_ref WHERE  chct_isactive=TRUE and chct_emergency_group_id="
						+ objBloodGroupServiceDTO.getEmeregerncyGroupid() + " ORDER BY chct_chiefcompltype ");
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery.toString());
		if (null != list && !list.isEmpty()) {
			List<BloodGroupPersistenanceDTO> persistenceDTOs = breakTypeMapper.conversionAllCheifComplaints(list);
			breakTypeServiceDTOs = breakTypeMapper
					.convertNoticeAlertPersistenceDTOListToNoticeAlertServiceDTOList(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSocialStatusType::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	public String updateCheifComplaint(BloodGroupServiceDTO objBloodGroupServiceDTO, String strRequestID)
			throws DataNotFoundException {

		String strQuery = "select * from sp_update_event_wise_victim_wise_ersvictimdetails_trans("
				+ objBloodGroupServiceDTO.getEventid() + ",'" + objBloodGroupServiceDTO.getVictimlist() + "','"
				+ objBloodGroupServiceDTO.getChiefcomplaintslist() + "'," + objBloodGroupServiceDTO.getCreatedbyid()
				+ "," + objBloodGroupServiceDTO.getCreatedbymoduleid() + ","
				+ objBloodGroupServiceDTO.getCreatedbyrollid() + "," + objBloodGroupServiceDTO.getSize() + ")";

		log.info(strRequestID + "::::::::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override	
	public List<VictimDetailServiceDTO> getVictimDetail(VictimDetailServiceDTO objVictimDetailServiceDTO,
			String strRequestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		VictimDetailsMapper breakTypeMapper = new VictimDetailsMapper();
		List<VictimDetailServiceDTO> breakTypeServiceDTOs = null;
		String strQuery = "select * from sp_triage_victimdetails(" + objVictimDetailServiceDTO.getVictimid() + ")";
		log.info(strRequestID + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<VictimDetailPersistenanceDTO> persistenceDTOs = breakTypeMapper.conversionOfgetVictimDetails(list);
			breakTypeServiceDTOs = breakTypeMapper.conversionpersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getSocialStatusType::::::");
		}
		return breakTypeServiceDTOs;
	}

	@Override
	public String updateVictimDetails(VictimDetailServiceDTO objVictimDetailServiceDTO, String strRequestID)
			throws DataNotFoundException {

		String strQuery = "select * from sp_upd_ersvictimdetails_trans(" + objVictimDetailServiceDTO.getVictimid()
				+ ",'" + objVictimDetailServiceDTO.getFirstname() + "','" + objVictimDetailServiceDTO.getDob() + "',"
				+ objVictimDetailServiceDTO.getCreatedbyid() + "," + objVictimDetailServiceDTO.getCreatedbymoduleid()
				+ "," + objVictimDetailServiceDTO.getCreatedbyroleid() + ",'"
				+ objVictimDetailServiceDTO.getEconomictypeid() + "','"
				+ objVictimDetailServiceDTO.getSocialstatustypeid() + "','"
				+ objVictimDetailServiceDTO.getGendertypeid() + "','" + objVictimDetailServiceDTO.getCurrentmedication()
				+ "','" + objVictimDetailServiceDTO.getMedicalPastHistroy() + "','"
				+ objVictimDetailServiceDTO.getAllergy() + "','" + objVictimDetailServiceDTO.getBloodgroupid() + "')";

		log.info(strRequestID + "::::::::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override
	public String insertVictimDetails(VictimDetailServiceDTO objVictimDetailServiceDTO, String strRequestID)
			throws DataNotFoundException {

		String strQuery = "select * from sp_ins_ersvictimdetails_trans(" + objVictimDetailServiceDTO.getVictimid()
				+ ",'" + objVictimDetailServiceDTO.getFirstname() + "','" + objVictimDetailServiceDTO.getDob() + "',"
				+ objVictimDetailServiceDTO.getCreatedbyid() + "," + objVictimDetailServiceDTO.getCreatedbymoduleid()
				+ "," + objVictimDetailServiceDTO.getCreatedbyroleid() + ",'"
				+ objVictimDetailServiceDTO.getEconomictypeid() + "','"
				+ objVictimDetailServiceDTO.getSocialstatustypeid() + "','"
				+ objVictimDetailServiceDTO.getGendertypeid() + "','" + objVictimDetailServiceDTO.getCurrentmedication()
				+ "','" + objVictimDetailServiceDTO.getMedicalPastHistroy() + "','"
				+ objVictimDetailServiceDTO.getAllergy() + "','" + objVictimDetailServiceDTO.getBloodgroupid() + "')";

		log.info(strRequestID + "::::::::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override
	public List<GetModuleSpecifcAgentsServiceDTO> getModuleSpecifcAgents_Supervisor(
			GetModuleSpecifcAgentsServiceDTO dataInfo, String strRequestId) throws DataNotFoundException {
		System.out.println("dataInfo:::::"+dataInfo);
		GetModuleSpecifcAgentsMapper objGetModuleSpecifcAgentsMapper = new GetModuleSpecifcAgentsMapper();
		List<GetModuleSpecifcAgentsServiceDTO> objGetModuleSpecifcAgentsServiceDTO = null;
		String strQuery = "select * from sp_select_userundermanager_modules(" + dataInfo.getManagerid() + ","
				+ dataInfo.getModuleid() + ")";
		log.info(strRequestId + ":::::::::::::" + strQuery);
		
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
	
		if (null != list && !list.isEmpty()) {
			List<GetModuleSpecifcAgentsPersistanceDTO> persistenceDTOs = objGetModuleSpecifcAgentsMapper
					.conversiongetModuleSpecifcAgents(list);
			objGetModuleSpecifcAgentsServiceDTO = objGetModuleSpecifcAgentsMapper
					.convertPersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestId + ":::::::No getSocialStatusType::::::");
		}
		return objGetModuleSpecifcAgentsServiceDTO;
	}

	@Override
	public String getSize(GetModuleSpecifcAgentsServiceDTO dataInfo, String strRequestId) throws DataNotFoundException {
		String strQuery = "select count(*) from sp_get_mainsearch_temp4(" + dataInfo.getEmgmedicalid() + ","
				+ dataInfo.getEmgpoliceid() + "," + dataInfo.getEmgfireid() + "," + dataInfo.getLandmarkid() + ","
				+ dataInfo.getLocalityid() + "," + dataInfo.getCity_townid() + "," + dataInfo.getMandalid() + ","
				+ dataInfo.getDistrictid() + "," + dataInfo.getStateid() + "," + dataInfo.getCountryid() + ",'"
				+ dataInfo.getCallername() + "','" + dataInfo.getCallerno() + "'," + dataInfo.getCalltypeid() + ","
				+ dataInfo.getEventstatustypeid() + ",'" + dataInfo.getEventid() + "'," + dataInfo.getToday() + ",'"
				+ dataInfo.getStardate() + "','" + dataInfo.getEndate() + "'," + dataInfo.getOrdering() + ","
				+ dataInfo.getLimitcount() + "," + dataInfo.getPageno() + "," + dataInfo.getAgentid() + ",'"
				+ dataInfo.getAmbulance() + "')";
		log.info(strRequestId + ":::::strQuery:::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override
	public String getEventLandmarkCount(GetModuleSpecifcAgentsServiceDTO dataInfo, String reqId)
			throws DataNotFoundException {
		String strQuery = "SELECT count(*) FROM  sp_ers_select_vw_landmark_search_with_diff_levels('"
				+ dataInfo.getSearch_string_one() + "','" + dataInfo.getSearch_string_two() + "','"
				+ dataInfo.getSearch_string_three() + "'," + dataInfo.getStateid() + "," + dataInfo.getDistrictid()
				+ "," + dataInfo.getMandalid() + "," + dataInfo.getSerach_level() + ")";
		log.info(reqId + ":::::strQuery:::::" + strQuery);
		String rtnQueryValue = objCommonDataDaoImpl.getSingleData(strQuery);
		return rtnQueryValue;
	}

	@Override
	public List<GetEventLandmarkServiceDTO> getEventLandmark(GetEventLandmarkServiceDTO dataInfo, String reqId)
			throws DataNotFoundException {
		GetEventLandmarkMapper objGetEventLandmarkMapper = new GetEventLandmarkMapper();
		List<GetEventLandmarkServiceDTO> getEventLandmarkServiceDTO = null;
		String strQuery = "SELECT * FROM  sp_ers_select_vw_landmark_search_with_diff_levels('" + dataInfo.getSearch_string_one() + "','"
				+ dataInfo.getSearch_string_two() + "','" + dataInfo.getSearch_string_three() + "',"
				+ dataInfo.getStateid() + "," + dataInfo.getDistrictid() + " ," + dataInfo.getMandalid() + ","
				+ dataInfo.getSerach_level() + ")";
		log.info(reqId + ":::::::::::::" + strQuery);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objCommonDataDaoImpl.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GetEventLandmarkPersistanceDTO> persistenceDTOs = objGetEventLandmarkMapper
					.conversiongetEventLandmark(list);
			getEventLandmarkServiceDTO = objGetEventLandmarkMapper.convertPersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(reqId + ":::::::No getSocialStatusType::::::");
		}
		return getEventLandmarkServiceDTO;
	}

	
	
	
}
