package com.chapur.supplier.infrastructure.adapter.in.web.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
