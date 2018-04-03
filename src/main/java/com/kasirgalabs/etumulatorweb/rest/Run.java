package com.kasirgalabs.etumulatorweb.rest;

import com.kasirgalabs.etumulator.lang.Assembler;
import com.kasirgalabs.etumulator.lang.Linker;
import com.kasirgalabs.etumulator.processor.BaseProcessor;
import com.kasirgalabs.etumulator.processor.BaseProcessorUnits;
import com.kasirgalabs.etumulator.processor.LR;
import com.kasirgalabs.etumulator.processor.PC;
import com.kasirgalabs.etumulator.processor.Processor;
import com.kasirgalabs.etumulator.processor.ProcessorUnits;
import com.kasirgalabs.etumulator.processor.RegisterFile;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/run")
public class Run {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getView() {
        return Response.ok(getClass().getClassLoader().getResourceAsStream("Run.html")).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response runCode(@FormParam("code") String code) {
        ProcessorUnits processorUnits = new BaseProcessorUnits();
        Processor processor = new BaseProcessor(processorUnits);
        Assembler assembler = new Assembler(processorUnits.getMemory());
        Linker.ExecutableCode executableCode = assembler.assemble(code + "\n");
        processor.run(executableCode);
        StringBuilder stringBuilder = new StringBuilder();
        RegisterFile registerFile = processorUnits.getRegisterFile();
        for (int i = 0; i < 13; i++) {
            stringBuilder.append("r").append(i).append(":")
                    .append(registerFile.getValue("r" + i)).append("<br>");
        }
        LR lr = processorUnits.getLR();
        stringBuilder.append("lr").append(":").append(lr.getValue()).append("<br>");
        PC pc = processorUnits.getPC();
        stringBuilder.append("pc").append(":").append(pc.getValue()).append("\n");
        return Response.ok(stringBuilder.toString()).build();
    }
}
