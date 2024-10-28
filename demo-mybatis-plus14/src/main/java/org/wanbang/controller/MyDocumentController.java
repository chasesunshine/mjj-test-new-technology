package org.wanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.MyDocument;
import org.wanbang.service.MyDocumentService;

@RestController
@RequestMapping("/documents")
public class MyDocumentController {

    @Autowired
    private MyDocumentService service;

    @GetMapping("/test")
    public MyDocument insertData(@RequestParam String data) {
        return service.insertData(data);
    }
}
