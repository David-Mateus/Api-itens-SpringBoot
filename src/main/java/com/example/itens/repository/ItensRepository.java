package com.example.itens.repository;

import com.example.itens.model.ItensModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItensRepository extends JpaRepository<ItensModel, UUID> {
}
