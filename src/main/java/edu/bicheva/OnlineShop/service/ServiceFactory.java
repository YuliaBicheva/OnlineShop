package edu.bicheva.OnlineShop.service;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.dao.DaoFactory;

public class ServiceFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceFactory.class);
	
	private static final String MYSQL = "mysql";
	private static final String POSTGRES = "postgres";
	
	private static final String RESOURCE_FILE_NAME = "db";
	private static final String DB_TYPE = "database.type";
	
	private static ServiceFactory instance;
	
	private ResourceBundle resourceBundle;
	private DaoFactory daoFactory;
	
	private ServiceFactory(){
		LOG.debug("Initialization start Service Factory");
		this.resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
		String dbTypeSetting = getProperty(DB_TYPE);
		
		LOG.debug("Obtain settings from file -> {}", dbTypeSetting);
		
		this.daoFactory = DaoFactory.getDaoFactory(getDbIndex(dbTypeSetting));
		
		LOG.debug("Initiaalization ended");
	}
	
	public static ServiceFactory getInstance(){
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	private String getProperty(String key){
		return (String) this.resourceBundle.getObject(key);
	}
	
	private int getDbIndex(String dbName){
		int dbTypeIndex;
		switch(dbName){
			case MYSQL: dbTypeIndex = DaoFactory.MYSQL;
			break;
			case POSTGRES: dbTypeIndex = DaoFactory.POSTGRE;
			break;
			default: dbTypeIndex = DaoFactory.MYSQL;
		}
		return dbTypeIndex;
	}
	
	public GoodsService getGoodsService(){
		return new GoodsServiceImpl(daoFactory);
	}

}
