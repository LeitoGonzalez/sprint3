package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "DetalleCompraIngrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DetalleCompraIngrediente extends Base{

    @NotNull
    @Column(name = "cantidad_comprada")
    private int cantidadComprada;

    @NotNull
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "subtotal_compra")
    private BigDecimal subtotalCompra;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_ArticuloIngrediente")
    private ArticuloIngrediente articuloIngrediente;
}
