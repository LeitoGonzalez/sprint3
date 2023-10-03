package com.example.demo.entities;

import com.example.demo.enums.EstadoPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "PedidoEstadoPedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PedidoEstadoPedido extends Base{

    private Date fechaHoraCambioEstado;

    @NotNull
    private EstadoPedido estadoPedido;
}
