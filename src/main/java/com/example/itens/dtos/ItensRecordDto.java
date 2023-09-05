package com.example.itens.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ItensRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
