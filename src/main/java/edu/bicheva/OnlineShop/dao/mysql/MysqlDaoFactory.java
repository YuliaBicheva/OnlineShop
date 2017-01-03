package edu.bicheva.OnlineShop.dao.mysql;

import java.sql.Connection;

import javax.sql.DataSource;

import edu.bicheva.OnlineShop.dao.DaoFactory;
import edu.bicheva.OnlineShop.dao.DatabaseManager;
import edu.bicheva.OnlineShop.dao.GoodsDao;
import edu.bicheva.OnlineShop.exception.DbException;

public class MysqlDaoFactory extends DaoFactory {
	
	private static final String MYSQL_DB_RESOURCE = "jdbc/mysql";
	
	private static DataSource dataSource;
	
	static{
		dataSource = DatabaseManager.findDataSource(MYSQL_DB_RESOURCE);
	}
	
	public MysqlDaoFactory() {
		//no op
	}
	
	@Override
	public GoodsDao getGoodsDao(Connection con){
		return new MysqlGoodsDaoImpl(con);
	}

	public Connection getConnection() throws DbException{
		return DatabaseManager.getConnection(dataSource);
	}

}
