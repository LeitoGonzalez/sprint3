package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "DetallePedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DetallePedido extends Base{
    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @NotNull
    @Column(name = "subtotal_costo", precision = 10, scale = 2)
    private BigDecimal subtotalCosto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_ArticuloProducto")
    private ArticuloProducto articuloProducto;
}
