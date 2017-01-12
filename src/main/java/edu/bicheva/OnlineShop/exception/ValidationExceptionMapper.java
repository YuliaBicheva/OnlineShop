package edu.bicheva.OnlineShop.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<javax.validation.ValidationException> {

	private static final Logger LOG = LoggerFactory.getLogger(ValidationExceptionMapper.class);

	// @Override
	public Response toResponse2(javax.validation.ValidationException e) {
		final StringBuilder strBuilder = new StringBuilder();
		for (ConstraintViolation<?> cv : ((ConstraintViolationException) e).getConstraintViolations()) {
			strBuilder.append(cv.getPropertyPath().toString() + " " + cv.getMessage());
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.TEXT_PLAIN)
				.entity(strBuilder.toString()).build();
	}

	@Override
	public Response toResponse(javax.validation.ValidationException e) {
		LOG.debug("Method toResponse start");
		final List<ExceptionJSON> errors = new ArrayList<>();
		for (ConstraintViolation<?> cv : ((ConstraintViolationException) e).getConstraintViolations()) {
			String propertyPath = cv.getPropertyPath().toString();
			int index = Integer.valueOf(propertyPath.substring(propertyPath.indexOf("arg") + "arg".length()));
			errors.add(new ExceptionJSON(index, cv.getMessage(), MessageType.ERROR.getString()));
			LOG.debug(
					"Obtain ConstrainViolation object: getMessage() => {}, index => {}",
					cv.getMessage(), index);
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.APPLICATION_JSON)
				.entity(errors).build();
	}
}
