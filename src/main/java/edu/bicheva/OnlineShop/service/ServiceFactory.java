package edu.bicheva.OnlineShop.service;

import java.util.ResourceBundle;

import edu.bicheva.OnlineShop.dao.DaoFactory;

public class ServiceFactory {
	
	private static final String MYSQL = "mysql";
	private static final String POSTGRES = "postgres";
	
	private static final String RESOURCE_FILE_NAME = "db";
	private static final String DB_TYPE = "database.type";
	
	private static ServiceFactory instance;
	
	private ResourceBundle resourceBundle;
	private DaoFactory daoFactory;
	
	private ServiceFactory(){
		this.resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
		String dbTypeSetting = getProperty(DB_TYPE);
		int dbTypeIndex;
		switch(dbTypeSetting){
			case MYSQL: dbTypeIndex = DaoFactory.MYSQL;
			case POSTGRES: dbTypeIndex = DaoFactory.POSTGRE;
			default: dbTypeIndex = DaoFactory.MYSQL;
		}
		this.daoFactory = DaoFactory.getDaoFactory(dbTypeIndex);
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
	
	public GoodsService getGoodsService(){
		return new GoodsServiceImpl(daoFactory);
	}

}
