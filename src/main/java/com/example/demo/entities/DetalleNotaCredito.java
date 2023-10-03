package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DetalleNotaCredito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DetalleNotaCredito extends Base{

    private int cantidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_ArticuloProducto")
    private ArticuloProducto articuloProducto;
}
