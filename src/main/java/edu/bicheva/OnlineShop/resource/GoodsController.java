package edu.bicheva.OnlineShop.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.*;

import javax.ws.rs.core.Response;

//import java.util.*;

import edu.bicheva.OnlineShop.entity.*;
import edu.bicheva.OnlineShop.service.*;

@Path("catalog")
public class GoodsController {
	
//	private static final Logger LOG = LoggerFactory.getLogger(GoodsController.class);

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String sayJsonHello() {
//	    return "{'catalogPage': 'jersey'}";
//	}
	
	@Produces({"application/xml","application/json"})
	@Path("{symbol}")
	@GET
	public Goods getGoods(@PathParam("symbol") int symb){
		return new GoodsService().find();
	}
//	
//	@Produces({"application/xml","application/json"})
//	@GET
//	public List<Goods> getGoods(){
//		return new GoodsService().findAll();
//	}
	
	@GET
//	@Path("catalog")
	@Produces(MediaType.TEXT_HTML)
	public Response viewCatalogPage(){
		return Response.ok(new Viewable("/catalog")).build();
	} 
}
