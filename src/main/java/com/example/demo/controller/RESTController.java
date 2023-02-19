package com.example.demo.controller;

import com.example.demo.data.ModifiableRecord;
import com.example.demo.data.Request;
import com.example.demo.data.InternalObj;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;

@Controller
public class RESTController {
    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }


    @PostMapping("/modify")
    ResponseEntity<InternalObj> modify(@RequestBody Request request) {
        try {
            ModifiableRecord record = recordService.getById(request.getId());
            record.getObj().modify(request.getAdd());
            recordService.save(record);
            System.out.println(recordService.getAll());
            return ResponseEntity.ok(record.getObj());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @RequestMapping(  value = "/*",
            method = { RequestMethod.PUT, RequestMethod.POST,
                    RequestMethod.GET,RequestMethod.DELETE,
                    RequestMethod.HEAD,RequestMethod.OPTIONS,
                    RequestMethod.PATCH,RequestMethod.TRACE })
    public void fallback() {
    }


}
