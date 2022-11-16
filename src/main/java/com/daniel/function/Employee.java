package com.daniel.function;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @EqualsAndHashCode.Include
    private Integer idEmpleado;
    private String nombre;
    private String trabajo;
    private LocalDate cumpleaños;
    private double salario;
    private String departamento;
}
