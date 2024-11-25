package com.santiago.com.santiago.controller;

import com.santiago.com.santiago.model.Pais;
import com.santiago.com.santiago.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("paises")
    private ResponseEntity<List<Pais>> getAllCountries(){
        return ResponseEntity.ok(paisService.obtenerTodos());
    }
}
