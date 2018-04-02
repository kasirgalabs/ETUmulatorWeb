package com.kasirgalabs.etumulatorweb.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/run")
public class Run {
    String r0 = "0";
    String r1 = "0";
    String r2 = "0";
    String r3 = "0";
    String r4 = "0";
    String r5 = "0";
    String r6 = "0";
    String r7 = "0";
    String r8 = "0";
    String r9 = "0";
    String r10 = "0";
    String r11 = "0";
    String r12 = "0";
    String LR = "0";
    String PC = "0";

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getView() {
        return Response.ok(getClass().getClassLoader().getResourceAsStream("Run.html")).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response runCode(@FormParam("code") String code) {
        return Response.ok("\"r0\":\"" + r0 + "\"" + "\n" + "\"r1\":\"" + r1 + "\"" + "\n" + "\"r2\":\"" + r2 + "\"" + "\n" + "\"r3\":\"" + r3 + "\"" + "\n" + "\"r4\":\"" + r4 + "\"" + "\n" + "\"r5\":\"" + r5 + "\"" + "\n" + "\"r6\":\"" + r6 + "\"" + "\n" + "\"r7\":\"" + r7 + "\"" + "\n" + "\"r8\":\"" + r8 + "\"" + "\n" + "\"r9\":\"" + r9 + "\"" + "\n" + "\"r10\":\"" + r10 + "\"" + "\n" + "\"r11\":\"" + r11 + "\"" + "\n" + "\"r12\":\"" + r12 + "\"" + "\n" + "\"PC\":\"" + PC + "\"" + "\n" + "\"LR\":\"" + LR + "\"").build();
    }
}
