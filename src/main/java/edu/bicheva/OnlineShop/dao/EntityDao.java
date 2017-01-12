package edu.bicheva.OnlineShop.dao;

import java.sql.Connection;
import java.util.List;

import edu.bicheva.OnlineShop.entity.Entity;
import edu.bicheva.OnlineShop.exception.DbException;

public interface EntityDao<E extends Entity> {

    void setConnection(Connection connection);

	E save(E e) throws DbException;
	
	E update(E e) throws DbException;
	
	E findById(Long id) throws DbException;
	
	List<E> findAll() throws DbException;

	List<E> findAll(int start, int step) throws DbException;

	void delete(Long id) throws DbException;
}
