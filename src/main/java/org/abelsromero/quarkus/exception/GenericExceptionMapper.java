package org.abelsromero.quarkus.exception;

import lombok.extern.slf4j.Slf4j;

import javax.json.Json;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Generic `ExceptionMapper` to avoid issues with accidentally leaked exceptions.
 */
@Slf4j
// @Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        logger.error("error from GenericExceptionMapper", exception);
        int code = 418;
        if (exception instanceof WebApplicationException) {
            code = ((WebApplicationException) exception).getResponse().getStatus();
        }
        // TODO define proper error format (e.g. add request-id)
        return Response.status(code)
            .entity(Json.createObjectBuilder()
                .add("message", exception.getMessage())
                .build())
            .build();
    }

}
