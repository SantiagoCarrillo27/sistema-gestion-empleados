package com.santiago.com.santiago.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    @Column(name = "apellido",length = 60,nullable = false)
    private String apellido;
    @Column(name = "email",length = 60, nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;


}
