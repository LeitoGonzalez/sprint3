package com.example.demo.repositories;

import com.example.demo.entities.DetalleNotaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleNotaCreditoRepository extends JpaRepository<DetalleNotaCredito, Long> {
}
