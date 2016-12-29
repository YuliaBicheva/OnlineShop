package edu.bicheva.OnlineShop.service;

import java.sql.Connection;
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
			goodsDao = daoFactory.getGoodsDao();
			connection = daoFactory.getConnection();
			goodsDao.setConnection(connection);
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
	}

	@Override
	public void delete(Long id) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Goods findById(Long id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAll() throws ApplicationException {
		List<Goods> goods = new ArrayList<>();
		GoodsDao goodsDao;
		Connection connection = null;
		try {
			goodsDao = daoFactory.getGoodsDao();
			connection = daoFactory.getConnection();
			goodsDao.setConnection(connection);
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
