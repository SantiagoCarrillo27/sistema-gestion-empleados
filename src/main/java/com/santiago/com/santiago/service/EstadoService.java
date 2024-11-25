package com.santiago.com.santiago.service;

import com.santiago.com.santiago.model.Estado;
import com.santiago.com.santiago.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    public List<Estado> obtenerTodos(){
        return estadoRepository.findAll();
    }

    public List<Estado> getStateByCountrie(int id){
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estadoConsulta = obtenerTodos();
        for (int i = 0; i <estadoConsulta.size() ; i++) {
            if (estadoConsulta.get(i).getPais().getId() == id) {
            estadosRespuesta.add(estadoConsulta.get(i));
            }
        }
        return estadosRespuesta;
    }

}

