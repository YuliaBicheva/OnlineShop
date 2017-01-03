package edu.bicheva.OnlineShop.resource;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.entity.Money;
import edu.bicheva.OnlineShop.exception.ApplicationException;
import edu.bicheva.OnlineShop.service.GoodsService;
import edu.bicheva.OnlineShop.service.ServiceFactory;


@Path("/")
public class Catalog {
	
	private static final Logger LOG = LoggerFactory.getLogger(Catalog.class);
	
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();

	@GET
	@Path("catalog")
	public Response getCatalog(@Context HttpServletRequest request)
			throws ApplicationException, URISyntaxException, UnsupportedEncodingException {
		
		LOG.debug("Begin execute get catalog method");
		
		GoodsService goodsService = serviceFactory.getGoodsService();
		List<Goods> catalog = goodsService.findAll();
		LOG.trace("Obtain catalog {}", catalog);
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("catalog", catalog);

		LOG.debug("Finish execute get catalog method");
		return Response.ok(new Viewable("/catalog.jsp")).build();
	}

	@POST
	@Path("addGoods")
	public Response saveGoods(@FormParam("serialNo") String serialNo, @FormParam("name") String name,
			@FormParam("description") String description, @FormParam("quantity") String quantity,
			@FormParam("integralPart") String integralPart, @FormParam("fractionalPart") String fractionalPart)
			throws ApplicationException, URISyntaxException, UnsupportedEncodingException {

		LOG.debug("Begin execute save goods method");
		LOG.debug("Obtain parameters: serialNo {}, name {}, desrciption {}, quantity {}, money {}.{}", serialNo, name,
				description, quantity, integralPart, fractionalPart);

		Goods goods = new Goods();
		goods.setSerialNo(Long.valueOf(serialNo));
		goods.setName(name);
		goods.setDescription(description);
		goods.setQuantity(Integer.valueOf(quantity));
		goods.setAvailability(goods.getQuantity() > 0);
		goods.setPrice(new Money(Integer.valueOf(integralPart), Integer.valueOf(fractionalPart)));

		LOG.debug("Obtain new goods {}", goods);
		GoodsService goodsService = serviceFactory.getGoodsService();
		goodsService.save(goods);

		LOG.debug("Finish execute save goods method");
		return Response.seeOther(new URI("/application/catalog")).build();
	}
}
