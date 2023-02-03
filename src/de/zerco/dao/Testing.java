package de.zerco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Testing {
	public static String getConnection(String url, String schema, String userName, String password)
			throws SQLException {
		if (Utility.isBlankWithVarArguments(url, schema, userName, password))
			return null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url + schema, userName, password);
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("SELECT * FROM zerocode.employee");
			while (set.next()) {
				System.out.println(set.getObject("EmpLName"));
			}
			connection.close();
			return "sucess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String schema = "zerocode";
		String userName = "admin";
		String password = "Sujwal@123";
		Connection connection = DbUtils.getConnection(url, schema, userName, password);
		List<Map<String,Object>>resMap = DbUtils.get(connection, schema, "employee", Arrays.asList());
		for (Map<String, Object> map : resMap) {
			List<Object> result = new ArrayList<Object>(map.values());
			String temp = "";
			for (Object value:result) {
				temp+=","+value;
			}
			FilesUtil.appendData("D:\\nani\\database.csv", temp.substring(1));
		}
		
		
		DbUtils.getCloseConnection(connection);
	}

}
