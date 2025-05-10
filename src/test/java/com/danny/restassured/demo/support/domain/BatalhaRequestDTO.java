package com.danny.restassured.demo.support.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class BatalhaRequestDTO {
    private LocalDateTime criadoEm;
    private LocalDateTime finalizadoEm;
    private String status;
}