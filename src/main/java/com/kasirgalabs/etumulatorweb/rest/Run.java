package com.kasirgalabs.etumulatorweb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.inject.Inject;
import com.kasirgalabs.etumulator.document.Document;
import com.kasirgalabs.etumulator.lang.Assembler;
import com.kasirgalabs.etumulator.lang.LabelError;
import com.kasirgalabs.etumulator.lang.Linker.ExecutableCode;
import com.kasirgalabs.etumulator.lang.SyntaxError;
import com.kasirgalabs.etumulator.processor.GUISafeProcessor;
import com.kasirgalabs.etumulator.processor.Memory;
import com.kasirgalabs.etumulator.processor.ProcessorUnits;
import javafx.event.ActionEvent;
import javax.ws.rs.core.Response;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/run")
public class Run {
    @Inject
    private Document document;
    @Inject
    private ProcessorUnits processorUnits;
    @Inject
    private GUISafeProcessor processor;
    @Inject
    private Memory memory;
    
    
    String r0="0";
    String r1="0";
    String r2="0";
    String r3="0";
    String r4="0";
    String r5="0";
    String r6="0";
    String r7="0";
    String r8="0";
    String r9="0";
    String r10="0";
    String r11="0";
    String r12="0";
    String LR="0";
    String PC="0";

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response jsonResult() {
      
    return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity("\"r0\":\""+r0+"\""+"\n"+"\"r1\":\""+r1+"\""+"\n"+"\"r2\":\""+r2+"\""+"\n"+"\"r3\":\""+r3+"\""+"\n"+"\"r4\":\""+r4+"\""+"\n"+"\"r5\":\""+r5+"\""+"\n"+"\"r6\":\""+r6+"\""+"\n"+"\"r7\":\""+r7+"\""+"\n"+"\"r8\":\""+r8+"\""+"\n"+"\"r9\":\""+r9+"\""+"\n"+"\"r10\":\""+r10+"\""+"\n"+"\"r11\":\""+r11+"\""+"\n"+"\"r12\":\""+r12+"\""+"\n"+"\"PC\":\""+PC+"\""+"\n"+"\"LR\":\""+LR+"\"")
            .build();
    
  }
  
  
  
}