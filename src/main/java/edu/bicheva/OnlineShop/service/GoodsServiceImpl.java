package edu.bicheva.OnlineShop.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.dao.DaoFactory;
import edu.bicheva.OnlineShop.dao.DatabaseManager;
import edu.bicheva.OnlineShop.dao.GoodsDao;
import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.exception.ApplicationException;
import edu.bicheva.OnlineShop.exception.DbException;

public class GoodsServiceImpl implements GoodsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(GoodsServiceImpl.class);
	
	private DaoFactory daoFactory;
	
	public GoodsServiceImpl(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void save(Goods entity) throws ApplicationException {
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			connection = daoFactory.getConnection();
			goodsDao = daoFactory.getGoodsDao(connection);
			goodsDao.save(entity);
		} catch (DbException e) {
			LOG.error("Cannot save goods {}",entity,e);
			DatabaseManager.rollback(connection);
			throw new ApplicationException("Cannot save goods",e);
		}finally {
			DatabaseManager.close(connection);
		}
	}

	@Override
	public void update(Goods entity) throws ApplicationException {
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			connection = daoFactory.getConnection();
			goodsDao = daoFactory.getGoodsDao(connection);
			goodsDao.update(entity);
		} catch (DbException e) {
			LOG.error("Cannot update goods {}",entity,e);
			DatabaseManager.rollback(connection);
			throw new ApplicationException("Cannot update goods",e);
		}finally {
			DatabaseManager.close(connection);
		}
	}

	@Override
	public void delete(Long id) throws ApplicationException {
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			connection = daoFactory.getConnection();
			goodsDao = daoFactory.getGoodsDao(connection);
			goodsDao.delete(id);
		} catch (DbException e) {
			LOG.error("Cannot delete goods with id={}",id,e);
			DatabaseManager.rollback(connection);
			throw new ApplicationException("Cannot delete goods",e);
		}finally {
			DatabaseManager.close(connection);
		}
	}

	@Override
	public Goods findById(Long id) throws ApplicationException {
		Goods goods;
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			connection = daoFactory.getConnection();
			goodsDao = daoFactory.getGoodsDao(connection);
			goods = goodsDao.findById(id);
		} catch (DbException e) {
			LOG.error("Cannot find goods by id={}",id,e);
			DatabaseManager.rollback(connection);
			throw new ApplicationException("Cannot finds goods",e);
		}finally {
			DatabaseManager.close(connection);
		}
		return goods;
	}

	@Override
	public List<Goods> findAll() throws ApplicationException {
		List<Goods> goods = new ArrayList<>();
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			connection = daoFactory.getConnection();
			goodsDao = daoFactory.getGoodsDao(connection);
			goods = goodsDao.findAll();
		} catch (DbException e) {
			LOG.error("Cannot find all goods",e);
			DatabaseManager.rollback(connection);
			throw new ApplicationException("Cannot find all goods",e);
		}finally {
			DatabaseManager.close(connection);
		}
		return goods;
	}
	
	
}
