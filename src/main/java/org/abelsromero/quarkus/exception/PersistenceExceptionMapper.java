package org.abelsromero.quarkus.exception;

import lombok.extern.slf4j.Slf4j;

import javax.json.Json;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class PersistenceExceptionMapper implements ExceptionMapper<javax.persistence.PersistenceException> {

    @Override
    public Response toResponse(javax.persistence.PersistenceException exception) {
        logger.error("error from PersistenceExceptionMapper", exception);
        int code = 418;
        return Response.status(code)
            .entity(Json.createObjectBuilder()
                .add("message", exception.getMessage())
                .build())
            .build();
    }

}
