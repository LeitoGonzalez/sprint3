package com.example.demo.repositories;

import com.example.demo.entities.ArticuloIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloIngredienteRepository extends JpaRepository<ArticuloIngrediente, Long> {
}
