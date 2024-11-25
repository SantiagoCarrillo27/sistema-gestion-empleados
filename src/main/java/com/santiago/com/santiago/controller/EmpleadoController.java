package com.santiago.com.santiago.controller;

import com.santiago.com.santiago.model.Empleado;
import com.santiago.com.santiago.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class EmpleadoController {

    @Autowired
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public List<Empleado> listAllEmployes() {
        return empleadoService.obtenerTodos();
    }

    @PostMapping("/empleado")
    public Empleado guaradarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> getEmployeById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.obtenerPorId(id));
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<Empleado> editEmploye(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(id, detallesEmpleado));
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmploye(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
