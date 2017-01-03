package edu.bicheva.OnlineShop.dao;

import java.sql.Connection;

import edu.bicheva.OnlineShop.dao.mysql.MysqlDaoFactory;
import edu.bicheva.OnlineShop.dao.mysql.PostgresDaoFactory;
import edu.bicheva.OnlineShop.exception.DbException;

public abstract class DaoFactory {
	
	public static final int MYSQL = 1;
	public static final int POSTGRE = 2;
	
	public abstract GoodsDao getGoodsDao(Connection con) throws DbException;
	
	public static DaoFactory getDaoFactory(int whichFactory){
		DaoFactory daoFactory;
		switch(whichFactory){
			case MYSQL: daoFactory = new MysqlDaoFactory();
				break;
			case POSTGRE: daoFactory = new PostgresDaoFactory();
				break;
			default:
				daoFactory = null;
		}
		return daoFactory;
	}
	
	public abstract Connection getConnection() throws DbException;
}
