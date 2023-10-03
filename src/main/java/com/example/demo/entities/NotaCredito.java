package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NotaCredito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NotaCredito extends Base{
    private Date fechaHoraEmision;
    private Date fechaHoraVencimiento;
    private int totalImporteCredito;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_Factura")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "NotaCredito_DetalleNotaCredito",
            joinColumns = @JoinColumn(name = "NotaCredito_id"),
            inverseJoinColumns = @JoinColumn(name = "DetalleNotaCredito_id")
    )
    private List<DetalleNotaCredito> detalleNotaCreditos = new ArrayList<DetalleNotaCredito>();

}
