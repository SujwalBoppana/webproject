package de.zerco.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import de.zerco.dao.RegistrationDao;
import de.zerco.dao.Utility;
import de.zeroco.date.DateUtilty;

public class RegistrationService {
	public static int getInsertedId(String name, String email, String phno, String dob,String pwd) {
		int age = DateUtilty.ageCalculator(dob, LocalDate.now());
		Date dateOfBirth = DateUtilty.stringToDate(dob, "yyyy-MM-dd");
		return RegistrationDao.getInsertedId(name, email, phno, dateOfBirth, age,Utility.encryptPassword(pwd));
	}

	public static int getUpdatedId(Map<String, Object> userDetails) {
		Object email =userDetails.get("verifyemail");
		userDetails.remove("verifyemail");
		if (userDetails.containsKey("date_of_birth")) {
			String dob = (String) userDetails.get("date_of_birth");
			int age = DateUtilty.ageCalculator(dob, LocalDate.now());
			Date dateOfBirth = DateUtilty.stringToDate(dob, "yyyy-MM-dd");
			userDetails.put("date_of_birth", dateOfBirth);
			userDetails.put("age", age);
		}if (userDetails.containsKey("password")) {
			String password =(String) userDetails.get("password");
			userDetails.put("password", Utility.encryptPassword(password));
		}
		List<Object> details = new ArrayList<Object>(userDetails.values());
		List<String> col = new ArrayList<String>(userDetails.keySet());
		details.add(email);
		return RegistrationDao.getUpdatedId(col,details);
	}

	public static List<Map<String, Object>> getData(String email) {
		return RegistrationDao.getdata(email);
	}

	public static List<Map<String, Object>> getAll() {
		return RegistrationDao.getAll();
	}

	public static int delete(String email) {
		return RegistrationDao.delete(email);
	}
	public static boolean checkUser(String user, String pass) {
		return RegistrationDao.checkUser(user, pass);
		
	}

}
