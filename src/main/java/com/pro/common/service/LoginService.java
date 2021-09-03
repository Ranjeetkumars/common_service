
package com.pro.common.service;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;
import com.pro.common.servicedto.AuthanticationServiceDTO;
import com.pro.common.servicedto.UsersDataServiceDTO;

/**
 * @author VENKAT_PRO
 *
 */
public interface LoginService {

	public List<UsersDataServiceDTO> loadPrevillages(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<UsersDataServiceDTO> loadRoles(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<UsersDataServiceDTO> getAsdterisdk_CCTCredentialsNew(UsersDataServiceDTO dataServiceDTO,
			String strRequestID) throws DataNotFoundException;

	public String saveInvalidCredentials(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String getManagerId(String strRequestID) throws DataNotFoundException;

	public String updateShiftTimings(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<UsersDataServiceDTO> loadAVAYATerminalLoginDetails(UsersDataServiceDTO dataServiceDTO,
			String strRequestID) throws DataNotFoundException;

	public String saveRemainder(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;

	public List<UsersDataServiceDTO> isUserExist(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<UsersDataServiceDTO> getUserShiftsByModule(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String Logout(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;

	public String getTerMinalID(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public String checkClientServerTime(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;

//	public Integer getClientServerLicenceStatus(ClientServerLicenceStatusServiceDTO dataServiceDTO, String strRequestID);
	
	public List<UsersDataServiceDTO> getOffLineUserFailedEvents(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public String insertOfflineEvents(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
			
	public List<UsersDataServiceDTO> getLeastLoaded(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<AuthanticationServiceDTO> authenticate(AuthanticationServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> getLoggedModules(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public String sp_chk_usershift(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> checkForModule(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> getRoles(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> getPrevillages(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> checkForLogin(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> getPostgers(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	public String login(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public String insertandUpdateCallStatus(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public String getSupervisorId(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public List<UsersDataServiceDTO> getServerLicences(UsersDataServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;
	
	
	public List<AuthanticationServiceDTO> authenticatewebLogin(AuthanticationServiceDTO objAuthanticationServiceDTO,
			String strRequestID) throws DataNotFoundException;
	
	public String getRolesForOperationalDesk(UsersDataServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
}
