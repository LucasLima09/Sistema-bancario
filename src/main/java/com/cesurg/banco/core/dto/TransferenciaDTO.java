package com.cesurg.banco.core.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(long origem, long destino, BigDecimal valor) {}
