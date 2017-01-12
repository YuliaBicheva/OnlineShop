package edu.bicheva.OnlineShop.dao;

import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.exception.DbException;

public interface GoodsDao extends EntityDao<Goods>{

	int count() throws DbException;

	Goods findBySerialNo(Long serialNo) throws DbException;

}
