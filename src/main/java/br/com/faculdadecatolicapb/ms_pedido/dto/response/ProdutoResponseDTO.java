package br.com.faculdadecatolicapb.ms_pedido.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(
        UUID id,
        String nome,
        BigDecimal valor
) {
}
