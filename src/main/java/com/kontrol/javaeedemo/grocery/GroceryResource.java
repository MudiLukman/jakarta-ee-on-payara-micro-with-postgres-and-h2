package com.kontrol.javaeedemo.grocery;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("groceries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroceryResource {

    @Inject GroceryService groceryService;

    @GET
    public Response findAll() {
        return Response.ok(groceryService.findAll()).build();
    }

    @POST
    public Response create(@Valid Grocery grocery) {
        return Response.status(Response.Status.CREATED)
                .entity(groceryService.create(grocery))
                .build();
    }

}
