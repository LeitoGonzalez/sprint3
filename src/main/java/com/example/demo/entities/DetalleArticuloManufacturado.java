package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "DetalleArticuloManufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DetalleArticuloManufacturado extends Base{

    @NotNull
    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_ArticuloIngrediente")
    private ArticuloIngrediente articuloIngrediente;
}
