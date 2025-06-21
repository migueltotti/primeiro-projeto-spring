package com.praticando_spring.primeiro_projeto_spring.domain;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record TokenResponseDTO(String token, OffsetDateTime expiration) {
}
