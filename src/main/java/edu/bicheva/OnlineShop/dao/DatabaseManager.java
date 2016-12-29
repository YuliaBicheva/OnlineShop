package edu.bicheva.OnlineShop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.exception.DbException;

public class DatabaseManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(DatabaseManager.class);
	private static final String ENVIRONMENT = "java:/comp/env";
	
	private DatabaseManager(){
		//no op
	}
	
	public static Connection getConnection(DataSource dataSource) throws DbException{
		Connection connection = null;
		if(dataSource != null){
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				String msg = "Cannot create connection";
				LOG.error(msg,e);
				throw new DbException(msg,e);
			}
		}
		return connection;
	}
	
	
	public static void close(Connection con) throws DbException{
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				String msg = "Cannot close connection";
				LOG.error(msg,e);
				throw new DbException(msg,e);
			}
		}
	}
	
	public static void close(Statement st) throws DbException{
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				String msg = "Cannot close statement";
				LOG.error(msg,e);
				throw new DbException(msg,e);
			}
		}
	}
	
	public static void close(ResultSet rs) throws DbException{
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				String msg = "Cannot close result set";
				LOG.error(msg,e);
				throw new DbException(msg,e);
			}
		}
	}
	
	public static void close(ResultSet rs, Statement st) throws DbException{
		close(rs);
		close(st);
	}

	public static void rollback(Connection con) throws DbException{
		if(con != null){
			try{
				con.rollback();
			}catch(SQLException e){
				String msg = "Cannot rollback connection";
				LOG.error(msg,e);
				throw new DbException(msg,e);
			}
		}
	}

	public static DataSource findDataSource(String resource){
		DataSource dataSource = null;
		try {
			Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup(ENVIRONMENT);
            dataSource = (DataSource) envContext.lookup(resource);
		} catch (NamingException e) {
			LOG.error("Cannot initialize data source {}",resource,e);
		}
		return dataSource;
	}
}
