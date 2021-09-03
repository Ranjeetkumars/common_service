/**
 * 
 */
package com.pro.common.dao;

import java.util.List;

import com.pro.common.exception.DataNotFoundException;

/**
 * @author VENKAT_PRO
 * 15-05-2019
 */
public interface CommonDataDao {
	public List<?> getData(String strQuery);
	

	public String saveData(String strQuery);

	public String getSingleData(String strQuery) throws DataNotFoundException;
}
