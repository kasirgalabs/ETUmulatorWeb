package com.kasirgalabs.etumulatorweb.pages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Homepage {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Sorry, ETUmulatorWeb is under construction. Please check back later!";
    }
}
