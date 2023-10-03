package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "RubroArticuloProducto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RubroArticuloProducto extends Base{

    private String denominacion;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Date fechaBaja;
}
