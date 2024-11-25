package com.santiago.com.santiago.service;

import com.santiago.com.santiago.exception.ResourceNotFoundException;
import com.santiago.com.santiago.model.Empleado;
import com.santiago.com.santiago.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        empleado.setEmail(empleado.getEmail().toLowerCase());
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el Id " + id));
    }

    public Empleado actualizarEmpleado(Long id, Empleado detallesEmpleado) {
        Empleado empleado = obtenerPorId(id);
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());
        return empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Long id) {
        Empleado empleado = obtenerPorId(id);
        empleadoRepository.delete(empleado);
    }
}
