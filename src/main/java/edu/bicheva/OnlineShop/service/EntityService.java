package edu.bicheva.OnlineShop.service;

import java.util.List;

import edu.bicheva.OnlineShop.entity.Entity;
import edu.bicheva.OnlineShop.exception.ApplicationException;

public interface EntityService<E extends Entity> {
	
	void save(E entity) throws ApplicationException;
	
	void update(E entity) throws ApplicationException;
	
	void delete(Long id) throws ApplicationException;
	
	E findById(Long id) throws ApplicationException;
	
	List<E> findAll() throws ApplicationException;
}
