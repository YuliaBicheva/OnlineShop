package edu.bicheva.OnlineShop.dao.mysql;

import java.sql.Connection;

import javax.sql.DataSource;

import edu.bicheva.OnlineShop.dao.DaoFactory;
import edu.bicheva.OnlineShop.dao.DatabaseManager;
import edu.bicheva.OnlineShop.dao.GoodsDao;
import edu.bicheva.OnlineShop.exception.DbException;

public class PostgresDaoFactory extends DaoFactory{
	
	private static final String POSTGRES_DB_RESOURCE = "jdbc/postgres";
	
	private static DataSource dataSource;
	
	static{
		dataSource = DatabaseManager.findDataSource(POSTGRES_DB_RESOURCE);
	}
	
	public PostgresDaoFactory() {
		//no op
	}
	
	@Override
	public GoodsDao getGoodsDao(){
		return new MysqlGoodsDaoImpl();
	}

	public Connection getConnection() throws DbException{
		return DatabaseManager.getConnection(dataSource);
	}
}
