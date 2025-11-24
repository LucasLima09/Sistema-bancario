package com.cesurg.banco.infra.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(long origem, long destino, BigDecimal valor) {}
