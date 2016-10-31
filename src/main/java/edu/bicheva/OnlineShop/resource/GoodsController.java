package edu.bicheva.OnlineShop.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.entity.*;
import edu.bicheva.OnlineShop.service.GoodsService;

@Path("/")
public class GoodsController {
	
	private static final Logger LOG = LoggerFactory.getLogger(GoodsController.class);

	@GET
	@Path("catalog/{symbol}")
	@Produces({"application/xml","application/json"})
	public Goods getGoods(@PathParam("symbol") int symb){
		LOG.debug("Invoke method getGoods() with paramater symb={}", symb);
		return new GoodsService().find();
	}
	
	@GET
	@Path("catalog")
	@Produces(MediaType.TEXT_HTML)
	public Response viewCatalogPage(@Context HttpServletRequest request){
		
		UserInfo user = (UserInfo)request.getSession().getAttribute("user");
		if(user == null || !user.getRole().equals(Role.ADMIN)){
			LOG.debug("Obtain role {}", user == null ? "empty" : user.getRole().name());
			throw new SecurityException("User is unauthorized");
		}

		LOG.debug("Invoke method viewCatalogPage()");
		return Response.ok(new Viewable("/catalog")).build();
	}
	
	@POST
	@Path("/login")
	public void login(@Context HttpHeaders headers, @Context SecurityContext sc){
		for(String header : headers.getRequestHeaders().keySet()){
			LOG.debug("Obtain header parameter : {} --> {}",header, headers.getHeaderString(header));
		}
		
		LOG.debug("Obtain user principal --> {}", sc.getUserPrincipal());
	}
	
	@GET
	@Path("admin/login")
	@Produces(MediaType.APPLICATION_XML)
	public UserInfo loginAdmin(@Context HttpServletRequest req){
		HttpSession httpSession = req.getSession();
		UserInfo user = (UserInfo)httpSession.getAttribute("user");
		if(user == null){
			user = new UserInfo("Admin name", Role.ADMIN, 5);
			httpSession.setAttribute("user", user);
		}
		
		LOG.debug("User login --> {}", user);
		
		HttpSession s = req.getSession();
		UserInfo user2 = (UserInfo)s.getAttribute("user");		

		LOG.debug("User login --> {}", user2);

		return user;
	}
	
	@GET
	@Path("admin/logout")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({"application/xml","application/json"})
	public UserInfo logOut(@Context HttpServletRequest req){
		
		HttpSession s = req.getSession();
		UserInfo user2 = (UserInfo)s.getAttribute("user");
		
		if(user2 == null){
			user2 = new UserInfo("anonim", Role.ANONYM, 0);
			s.setAttribute("user", user2);
		}

		LOG.debug("User login --> {}", user2);
		
//		String username = cr.getHeaderString("user");
//		LOG.debug("Obtain herader user --> {}", username);
		
//		if(user2 == null){
//			user2 = new UserInfo("Admin", Role.ADMIN, 5);
//		}

		return user2;
	}
	
}
