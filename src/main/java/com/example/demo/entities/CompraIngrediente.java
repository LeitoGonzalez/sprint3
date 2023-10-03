package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CompraIngrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CompraIngrediente extends Base{

    private Date fechaHoraCompraIngredientes;
    private BigDecimal costoTotalCompra;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "CompraIngrediente_DetalleCompraIngrediente",
            joinColumns = @JoinColumn(name = "CompraIngrediente_id"),
            inverseJoinColumns = @JoinColumn(name = "DetalleCompraIngrediente_id")
    )
    private List<DetalleCompraIngrediente> detalleCompraIngredientes = new ArrayList<DetalleCompraIngrediente>();

}
