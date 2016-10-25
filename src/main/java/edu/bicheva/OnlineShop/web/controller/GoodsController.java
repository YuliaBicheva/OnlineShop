package edu.bicheva.OnlineShop.web.controller;

import javax.ws.rs.*;
import java.util.*;

import edu.bicheva.OnlineShop.entity.*;
import edu.bicheva.OnlineShop.model.*;

@Path("/catalog")
public class GoodsController {

	@Produces({"application/xml","application/json"})
	@Path("/{symbol}")
	@GET
	public Goods getGoods(@PathParam("symbol") int symb){
		return new GoodsModel().find();
	}
	
	@Produces({"application/xml","application/json"})
	@GET
	public List<Goods> getGoods(){
		return new GoodsModel().findAll();
	}
}
