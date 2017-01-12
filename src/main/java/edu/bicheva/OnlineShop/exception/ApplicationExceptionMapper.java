package edu.bicheva.OnlineShop.exception;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionMapper.class);

	@Override
	public Response toResponse(Exception e) {
		LOG.debug("Obtain application exception -> {}", e.getMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.APPLICATION_JSON)
				.entity(new ExceptionJSON(e.getMessage(), MessageType.ERROR.getString())).build();
	}
}
