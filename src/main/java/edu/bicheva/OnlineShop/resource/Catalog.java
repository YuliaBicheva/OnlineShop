package edu.bicheva.OnlineShop.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.exception.ApplicationException;
import edu.bicheva.OnlineShop.service.GoodsService;
import edu.bicheva.OnlineShop.service.ServiceFactory;


@Path("catalog")
public class Catalog {
	
	private static final Logger LOG = LoggerFactory.getLogger(Catalog.class);
	
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();

	@GET
//	@Produces("{application/xml,application/json}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Goods> getCatalog() throws ApplicationException{
		
		LOG.debug("Begin execute get catalog method");
		
		GoodsService goodsService = serviceFactory.getGoodsService();
		List<Goods> catalog = goodsService.findAll();
//		List<Goods> catalog = new ArrayList<>();
//		Goods goods = new Goods();
//		goods.setId(1);
//		goods.setName("Goods 1");
//		goods.setDescription("Goods description");
//		goods.setQuantity(300);
//		goods.setPrice(Money.valueOf(450.6));
//		catalog.add(goods);
		LOG.trace("Obtain catalog {}", catalog);
		
		LOG.debug("Finish execute get catalog method");
		return catalog;
	}
}
