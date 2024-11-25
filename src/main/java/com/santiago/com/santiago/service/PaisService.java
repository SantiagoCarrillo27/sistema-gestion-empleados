package com.santiago.com.santiago.service;

import com.santiago.com.santiago.model.Pais;
import com.santiago.com.santiago.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> obtenerTodos(){

        return paisRepository.findAll();
    }
}
