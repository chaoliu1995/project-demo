package com.chaoliu1995.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DbInfo {
	
	private static String dbDriver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		Properties ps = new Properties();
		String path = DbInfo.class.getResource("/").getPath() + "DbDriver.properties";
		try {
			ps.load(new FileInputStream(new File(path)));
			dbDriver = ps.getProperty("dbdriver");
			url = ps.getProperty("url");
			username = ps.getProperty("username");
			password = ps.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDbDriver() {
		return dbDriver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
	
	
}
