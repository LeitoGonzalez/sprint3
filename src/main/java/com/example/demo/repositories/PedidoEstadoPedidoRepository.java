package com.example.demo.repositories;

import com.example.demo.entities.PedidoEstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEstadoPedidoRepository extends JpaRepository<PedidoEstadoPedido, Long> {
}
