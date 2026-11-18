package br.com.faculdadecatolicapb.ms_pedido.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record PedidoRequestDTO(
    @NotNull(message = "O campo produto é obrigatório.")
    UUID produtoId,
    @NotNull(message = "O campo quantidade é obrigatório.")
    @Positive(message = "A quantidade deve ser maior que 0.")
    Integer quantidade,
    @Email(message = "O email precisa ser um email válido.")
    String emailComprador
) { }
