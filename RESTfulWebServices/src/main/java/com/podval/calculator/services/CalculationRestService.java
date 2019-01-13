package com.podval.calculator.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double addition(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a + b;
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double substruction(@PathParam("a") Double a, @PathParam("b") Double b) {
        return a - b;
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double multiplication(@PathParam("a") Double a, @PathParam("b") Double b){
        return a * b;
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double division(@PathParam("a") Double a, @PathParam("b") Double b){
        return a / b;
    }

}
