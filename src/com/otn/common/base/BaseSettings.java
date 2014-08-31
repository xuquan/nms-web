package com.otn.common.base;

import org.apache.log4j.Logger;


public class BaseSettings {

	private static final String LOG_CONFIG = "conf/log/log4j.properties";
	
	private static BaseSettings instance = new BaseSettings();
	
	static Logger log4j = Logger.getLogger(BaseSettings.class.getClass());  
	
	private BaseSettings(){/*
		File cfgFile = new File(LOG_CONFIG);
		InputStream is = null;
		try {
			is = new FileInputStream(cfgFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicConfigurator.configure();  
        if(cfgFile.exists()){
			PropertyConfigurator.configure(prop);
		}  
          
//        DOMConfigurator.configure("");
        log4j.debug("log4j debug");  
        log4j.info("log4j info");  
        log4j.warn("log4j warn");  
        log4j.error("log4j error");  
        log4j.fatal("log4j fatal");  
	*/}
	
	public static BaseSettings getInstance(){
		return instance;
	}
	
}
