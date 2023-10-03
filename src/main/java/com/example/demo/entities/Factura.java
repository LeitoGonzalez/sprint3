package com.example.demo.entities;

import com.example.demo.enums.EstadoFactura;
import com.example.demo.enums.FormaPago;
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
@Table(name = "Factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Factura extends Base{

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    private EstadoFactura estadoFactura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Pedido")
    private Pedido pedido;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "Factura_DetalleFatura",
            joinColumns = @JoinColumn(name = "Factura_id"),
            inverseJoinColumns = @JoinColumn(name = "DetalleFactura_id")
    )
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

}
