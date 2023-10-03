package com.example.demo.repositories;

import com.example.demo.entities.RubroArticuloProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloProductoRepository extends JpaRepository<RubroArticuloProducto, Long> {
}
