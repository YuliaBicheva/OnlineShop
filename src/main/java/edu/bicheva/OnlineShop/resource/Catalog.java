package edu.bicheva.OnlineShop.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.entity.Money;
import edu.bicheva.OnlineShop.exception.ApplicationException;
import edu.bicheva.OnlineShop.exception.Message;
import edu.bicheva.OnlineShop.service.GoodsService;
import edu.bicheva.OnlineShop.service.ServiceFactory;


@Path("/catalog")
public class Catalog {
	
	private static final Logger LOG = LoggerFactory.getLogger(Catalog.class);
	
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();

	@GET
	public Response getCatalog() throws ApplicationException {
		Map<String, Object> map = new HashMap<>();
		map.put("goodsCount", serviceFactory.getGoodsService().count());
		return Response.ok(new Viewable("/catalog", map)).build();
	}

	@GET
	@Path("/size")
	@Produces(MediaType.APPLICATION_JSON)
	public long getCatalogSize() throws ApplicationException {
		return serviceFactory.getGoodsService().count();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goods> getAll(@DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("3") @QueryParam("step") int step) throws Exception {
		return serviceFactory.getGoodsService().findAll(start, step);
	}

	@GET
	@Path("/addGoods")
	public Response addGoods() {
		Map<String,Object> map = new HashMap<>();
		map.put("formAction", "application/catalog/saveGoods");
		return Response.ok(new Viewable("/addGoods",map)).build();
	}

	@GET
	@Path("/editGoods/{id}")
	public Response editGoods(@PathParam(value = "id") Long id) throws ApplicationException {
		Map<String,Object> map = new HashMap<>();
		String viewable = "/error_page.jsp";
		Goods goods = null;
		try{
			goods = serviceFactory.getGoodsService().findById(id);
			if (goods == null) {
				String exceptionMessage = "In database doesn't exist goods with such id = " + id + "!"
						+ "<p>Please, select another goods from the catalog</p>" 
						+ "<p><a href='\\application\\catalog'>Show goods catalog</a></p>";
				map.put("message", exceptionMessage);
			}else{
				map.put("formAction", "application/catalog/updateGoods");
				map.put("goods", goods);
				viewable = "/addGoods";
			}
		} catch (ApplicationException e) {
			LOG.error("Can't edit goods with id={}", id, e);
			throw e;
		}
		return Response.ok(new Viewable(viewable, map)).build();
	}

	@GET
	@Path("/deleteGoods/{id}")
	public Response deleteGoods(@PathParam(value = "id") Long id) throws ApplicationException, URISyntaxException {
		try {
			serviceFactory.getGoodsService().delete(id);
		} catch (ApplicationException e) {
			LOG.error("Can't edit goods with id={}", id, e);
			throw e;
		}
		return Response.seeOther(new URI("/application/catalog")).build();
	}

	@GET
	@Path("/validate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateGoods(
			@NotNull(message = Message.CANNOT_BE_EMPTY)
			@Min(value = 100000, message = Message.SHOULD_BE_MORE_THAN
					+ " 100000") @QueryParam("serialNo") Long serialNo,
			@NotBlank(message = Message.CANNOT_BE_EMPTY) @QueryParam("name") String name,
			@QueryParam("description") String description,
			@Min(value = 0, message = Message.SHOULD_BE_MORE_THAN + "0") @QueryParam("quantity") int quantity,
			@Min(value = 0, message = Message.SHOULD_BE_MORE_THAN
					+ "0") @QueryParam("integralPart") int integralPart,
			@Min(value = 0, message = Message.SHOULD_BE_MORE_THAN
					+ "0") @QueryParam("fractionalPart") int fractionalPart) {
		String reponse = String.format("serialNo: %s, name: %s, description: %s, quantity: %s, price: %s.%s", serialNo,
				name, description, quantity, integralPart, fractionalPart);
		return Response.status(Response.Status.OK).entity(reponse).type(MediaType.TEXT_PLAIN).build();
	}

	@POST
	@Path("/saveGoods")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response saveGoods(@FormParam("serialNo") Long serialNo,
			@FormParam("name") String name,
			@FormParam("description") String description, @FormParam("quantity") int quantity,
			@FormParam("integralPart") int integralPart, @FormParam("fractionalPart") int fractionalPart)
			throws ApplicationException, URISyntaxException {

		LOG.debug("Begin execute save goods method");
		LOG.debug("Obtain parameters: serialNo {}, name {}, desrciption {}, quantity {}, money {}.{}", serialNo, name,
				description, quantity, integralPart, fractionalPart);

		Goods goods = serviceFactory.getGoodsService().findBySerialNo(serialNo);
		
		if (goods == null) {

			goods = new Goods();
			goods.setSerialNo(serialNo);
			goods.setName(name);
			goods.setDescription(description);
			goods.setQuantity(quantity);
			goods.setAvailability(goods.getQuantity() > 0);
			goods.setPrice(new Money(integralPart, fractionalPart));

			LOG.debug("Obtain new goods {}", goods);
			GoodsService goodsService = serviceFactory.getGoodsService();
			goodsService.save(goods);

			LOG.debug("Finish execute save goods method");
			return Response.seeOther(new URI("/application/catalog")).build();
		} else {
			String exceptionMessage = "In database exists goods with serialNo " + serialNo + "!"
					+ "<p>You can edit existing goods or create new goods with different serial No</p>"
					+ "<p><a href='\\application\\catalog\\editGoods\\" + goods.getId() + "'>Edit goods with serialNo "
					+ serialNo + "</a></p>" + "<p><a href='\\application\\catalog\\addGoods'>Add new goods</a></p>";
			Map<String, Object> map = new HashMap<>();
			map.put("message", exceptionMessage);
			return Response.ok(new Viewable("/error_page.jsp", map)).build();
		}
	}
	
	@POST
	@Path("/updateGoods")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateGoods(
			@FormParam("serialNo") Long serialNo,
			@FormParam("name") String name,
			@FormParam("description") String description, @FormParam("quantity") int quantity,
			@FormParam("integralPart") int integralPart, @FormParam("fractionalPart") int fractionalPart,
			@FormParam("id") Long id)
			throws ApplicationException, URISyntaxException {

		LOG.debug("Begin execute update goods method");
		LOG.debug("Obtain parameters: id {}, serialNo {}, name {}, desrciption {}, quantity {}, money {}.{}", id, serialNo, name,
				description, quantity, integralPart, fractionalPart);

		Goods goods = serviceFactory.getGoodsService().findById(id);
		
		if (goods != null) {
			goods.setSerialNo(serialNo);
			goods.setName(name);
			goods.setDescription(description);
			goods.setQuantity(quantity);
			goods.setAvailability(goods.getQuantity() > 0);
			goods.setPrice(new Money(integralPart, fractionalPart));

			LOG.debug("Obtain new goods {}", goods);
			GoodsService goodsService = serviceFactory.getGoodsService();
			goodsService.update(goods);

			LOG.debug("Finish execute save goods method");
			return Response.seeOther(new URI("/application/catalog")).build();
		} else {
			String exceptionMessage = "In database doesn't exist goods with such id = " + id + "!"
					+ "<p>Please, select another goods from the catalog</p>" 
					+ "<p><a href='\\application\\catalog'>Show goods catalog</a></p>";
			Map<String, Object> map = new HashMap<>();
			map.put("message", exceptionMessage);
			return Response.ok(new Viewable("/error_page.jsp", map)).build();
		}
	}
}
