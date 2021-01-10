package com.example.demo.resources;

import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martin
 */
@RestController
public class ServerController {

    @Autowired
    private BaseService baseService;

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(this.baseService.generateAndGetUsers());
    }
}
