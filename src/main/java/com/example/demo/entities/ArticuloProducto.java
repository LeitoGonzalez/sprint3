package com.example.demo.entities;

import com.example.demo.enums.TipoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ArticuloProducto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ArticuloProducto extends Base{

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @NotNull
    private TipoProducto tipoProducto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "ArticuloProducto_DetalleArticuloManufacturado",
            joinColumns = @JoinColumn(name = "ArticuloProducto_id"),
            inverseJoinColumns = @JoinColumn(name = "DetalleArticuloManufacturado_id")
    )
    private List<DetalleArticuloManufacturado> detalleArticuloPedidos = new ArrayList<DetalleArticuloManufacturado>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_RubroArticuloProducto")
    private RubroArticuloProducto rubroArticuloProducto;
}
