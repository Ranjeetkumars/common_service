package com.pro.common.utills;

import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonMethods {
	public static String validateTime(Date dateServer, Date dateClient) {
		// 0 ---> Invalid date
		// 1 ---> Year invalid
		// 2 ---> Month invalid
		// 3 ---> Day invalid
		// 4 ---> Hour invalid
		// 5 ---> Minute invalid
		// 6 ---> Second invalid
		// 10 --->Success
//		Date dateServer = new Date(strDateServer);
//		Date dateClient = new Date(strDateClient);
		String result = "10";
		if (dateServer == null || dateClient == null) {
			return result;
		}
		try {
			Calendar calServer = Calendar.getInstance();
			calServer.setTime(dateServer);
			Calendar calClient = Calendar.getInstance();
			calClient.setTime(dateClient);
			/*
			 * System.out.println("Year   : "+calServer.get(Calendar.YEAR)
			 * +" - "+calClient.get(Calendar.YEAR));
			 * System.out.println("Month  : "+(calServer.get(Calendar.MONTH)+1)
			 * +" - "+(calClient.get(Calendar.MONTH)+1));
			 * System.out.println("Day    : "+calServer.get(Calendar.DATE)
			 * +" - "+calClient.get(Calendar.DATE));
			 * System.out.println("Hour   : "+calServer.get(Calendar.HOUR_OF_DAY)
			 * +" - "+calClient.get(Calendar.HOUR_OF_DAY));
			 * System.out.println("Minute : "+calServer.get(Calendar.MINUTE)
			 * +" - "+calClient.get(Calendar.MINUTE));
			 * System.out.println("Second : "+calServer.get(Calendar.SECOND)
			 * +" - "+calClient.get(Calendar.SECOND));
			 */

			if (calServer.get(Calendar.YEAR) != calClient.get(Calendar.YEAR)) {
				result = "1";
			} else if (calServer.get(Calendar.MONTH) != calClient.get(Calendar.MONTH)) {
				result = "2";
			} else if (calServer.get(Calendar.DATE) != calClient.get(Calendar.DATE)) {
				result = "3";
			} else if (calServer.get(Calendar.HOUR_OF_DAY) != calClient.get(Calendar.HOUR_OF_DAY)) {
				result = "4";
			} else if (calServer.get(Calendar.MINUTE) != calClient.get(Calendar.MINUTE)) {
				long diffInMillis = calServer.getTimeInMillis() - calClient.getTimeInMillis();
				long sec = diffInMillis / (1000);
				log.info("----> Seconds diff : " + sec);
				if (sec > 0) {// Seconds in +ve
					if (sec > 60) {
						result = "5";
					} else {
						result = "10";
					}
				} else {// Seconds in -ve
					if (sec < -60) {
						result = "5";
					} else {
						result = "10";
					}
				}

			} else if (calServer.get(Calendar.SECOND) != calClient.get(Calendar.SECOND)) {
				result = "10";// Seconds not considerable
			}

		} catch (Exception e) {
			log.info("---->Exception at validateTime(Date dateServer, Date dateClient) : " + e);
		}
		return result;
	}
}
