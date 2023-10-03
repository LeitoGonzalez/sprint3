package com.example.demo.entities;

import com.example.demo.enums.EstadoPedido;
import com.example.demo.enums.FormaPago;
import com.example.demo.enums.TipoEnvio;
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
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Pedido extends Base{

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_costo", precision = 10, scale = 2)
    private BigDecimal totalCosto;

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
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "Pedido_DetallePedido",
            joinColumns = @JoinColumn(name = "Pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "DetallePedido_id")
    )
    private List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "Pedido_PedidoEstadoPedido",
            joinColumns = @JoinColumn(name = "Pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "PedidoEstadoPedido_id")
    )
    private List<PedidoEstadoPedido> pedidoEstadoPedidos = new ArrayList<PedidoEstadoPedido>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_Usuario")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_Domicilio")
    private Domicilio domicilio;

}
