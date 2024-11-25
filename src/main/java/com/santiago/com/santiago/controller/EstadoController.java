package com.santiago.com.santiago.controller;

import com.santiago.com.santiago.model.Estado;
import com.santiago.com.santiago.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;


    @GetMapping("estados-pais/{id}")
    private ResponseEntity<List<Estado>>getStateByCountrie(@PathVariable("id") int idPais){
        return ResponseEntity.ok(estadoService.getStateByCountrie(idPais));
    }

}
