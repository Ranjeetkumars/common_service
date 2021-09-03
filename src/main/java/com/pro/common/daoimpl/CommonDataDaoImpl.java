package com.pro.common.daoimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pro.common.dao.CommonDataDao;
import com.pro.common.exception.DataNotFoundException;
import com.pro.common.multitenant.TenantContext;

/**
 * @author VENKAT_PRO 15-05-2019
 */

@Repository("objCommonDataDaoImpl")
@Transactional
public class CommonDataDaoImpl implements CommonDataDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getData(String strQuery) {

		Session session = null;
		List<Object[]> listData = null;
		session = sessionFactory.withOptions().tenantIdentifier(TenantContext.getCurrentTenant().toString())
				.openSession();
		listData = session.createSQLQuery(strQuery).list();
		session.close();
		return listData;
	}

	@Override
	public String saveData(String strQuery) {
		Session session = null;
		String strResult = null;
		session = sessionFactory.withOptions().tenantIdentifier(TenantContext.getCurrentTenant().toString())
				.openSession();
		strResult = session.createSQLQuery(strQuery).list().get(0).toString();
		session.close();
		return strResult;
	}

	@Override
	public String getSingleData(String strQuery) throws DataNotFoundException {
		Session session = null;
		String listData = null;
		session = sessionFactory.withOptions().tenantIdentifier(TenantContext.getCurrentTenant().toString())
				.openSession();
		List data = session.createSQLQuery(strQuery).list();
		if (data == null || data.isEmpty() || data.get(0) == null) {
			throw new DataNotFoundException("");
		} else {
			listData = data.get(0).toString();
		}
		session.close();
		return listData;
	}
	
	

}
