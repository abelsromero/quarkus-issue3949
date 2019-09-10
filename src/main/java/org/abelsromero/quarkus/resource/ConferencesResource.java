package org.abelsromero.quarkus.resource;

import lombok.extern.slf4j.Slf4j;
import org.abelsromero.quarkus.dto.ResultsCollection;
import org.abelsromero.quarkus.model.Conference;
import org.abelsromero.quarkus.service.ConferenceService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collections;

import static org.abelsromero.quarkus.exception.ErrorMessages.CONFERENCE_NOT_FOUND;

@Slf4j
@Path("/conferences")
public class ConferencesResource {

    @Inject
    ConferenceService conferenceService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid Conference conference) {
        final String id = conferenceService.create(conference);
        return Response
            .status(Response.Status.CREATED)
            .entity(Collections.singletonMap("id", id))
            .location(URI.create("/conferences/" + id))
            .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Conference get(@PathParam("id") String id) {
        return conferenceService.findById(id)
            .orElseThrow(() -> new NotFoundException(CONFERENCE_NOT_FOUND + id));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResultsCollection<Conference> list() {
        return conferenceService.filter();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        conferenceService.delete(id);
        return Response
            .status(Response.Status.NO_CONTENT)
            .build();
    }

}


