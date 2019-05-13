package com.afour.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import freemarker.core.ReturnInstruction.Return;

public class GlobalData {
	public static Properties config = null;

	GlobalData get() {
		return this;
	}
	
/**
 * This use to return config data Key base value 
 * @param Key This is Forst Parameter to pass the key
 * @return Value It will return the key based value
 * @throws Exception 
 * @Return Key based value
 * @author vikas Kamble
 * @since 2019-05-06
 * */
	public static String config(String Key) {
		config = new Properties();
		String configfilePath = System.getProperty("user.dir") + "/" + "config.config";
		InputStream is = null;
		try {
			is = new FileInputStream(configfilePath);
		} catch (FileNotFoundException ex) {

			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		try {
			config.load(is);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
//		System.out.println(config.getProperty("browser"));	

		if (config.getProperty(Key) != null) {
			return config.getProperty(Key);
		} else {
			System.out.println(Key + " Key Value Not Present.");
			return config.getProperty(Key);
		}
	}

	/*
	 * public static void main(String[] args) { GlobalData con = new GlobalData();
	 * System.out.println(con.config("url")); }
	 */
}
