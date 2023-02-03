package de.zerco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RegistrationDao {
	final static String URL = "jdbc:mysql://localhost:3306/";
	final static String SCHEMA = "zerocode";
	final static String USERID = "admin";
	final static String PASSWORD = "Sujwal@123";
	final static String TABLENAME = "user_details";
	final static List<String> TABLECOL = Arrays.asList("name", "phno", "email", "date_of_birth", "age");

	public static int getInsertedId(String name, String email, String phno, Date dob, int age, String pwd) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.getGenertedId(connection, SCHEMA, TABLENAME,
					Arrays.asList("name", "phno", "email", "date_of_birth", "age", "password"),
					Arrays.asList(name, phno, email, dob, age, pwd));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return 0;
	}

	public static int getUpdatedId(List<String> col, List<Object> data) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.updateData(connection, SCHEMA, TABLENAME, col, data, "email");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return 0;
	}

	public static List<Map<String, Object>> getdata(String email) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.list(connection, SCHEMA, TABLENAME, TABLECOL, "email", "=", email);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return null;
	}

	public static List<Map<String, Object>> getAll() {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.get(connection, SCHEMA, TABLENAME, TABLECOL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return null;
	}

	public static int delete(String email) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.deleteData(connection, SCHEMA, TABLENAME, "email", "=", Arrays.asList(email));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return 0;
	}

	public static boolean checkUser(String user, String pwd) {
		try {
			Connection connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM `zerocode`.`user_details` WHERE email = ? AND password = ? ;");
			statement.setObject(1, user);
			statement.setObject(2, Utility.encryptPassword(pwd));
			ResultSet resultSet = statement.executeQuery();
			boolean hasValue = resultSet.next();
			DbUtils.getCloseConnection(connection);
			return hasValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkPhoneEmail(String phno, String email) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			if (Utility.hasData(phno) || Utility.hasData(email)) {
				if (Utility.hasData(
						DbUtils.list(connection, SCHEMA, TABLENAME, new ArrayList<String>(), "phno", "=", phno))
						|| Utility.hasData(DbUtils.list(connection, SCHEMA, TABLENAME, new ArrayList<String>(), "email",
								"=", email)))
					return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return false;
	}
}
