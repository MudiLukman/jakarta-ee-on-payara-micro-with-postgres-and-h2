package com.kontrol.javaeedemo.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        int statusCode = exception.getResponse().getStatus();
        Error error = new Error(exception.getMessage(), statusCode);
        return Response.status(statusCode)
                .entity(error)
                .build();
    }
}
