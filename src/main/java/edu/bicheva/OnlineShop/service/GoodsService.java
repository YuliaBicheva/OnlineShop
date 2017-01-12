package edu.bicheva.OnlineShop.service;

import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.exception.ApplicationException;

public interface GoodsService extends EntityService<Goods> {

	int count() throws ApplicationException;

	Goods findBySerialNo(Long serialNo) throws ApplicationException;
}
