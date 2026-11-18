package br.com.faculdadecatolicapb.ms_pedido.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PedidoResponseDTO(
    UUID id,
    UUID produtoId,
    Integer quantidade,
    LocalDateTime dataPedido,
    BigDecimal valorTotal,
    String emailComprador
) { }
