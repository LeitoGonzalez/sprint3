package com.example.demo.repositories;

import com.example.demo.entities.ArticuloProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloProductoRepository extends JpaRepository<ArticuloProducto, Long>{
}
