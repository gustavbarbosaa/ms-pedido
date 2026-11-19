package br.com.faculdadecatolicapb.ms_pedido.client;

import br.com.faculdadecatolicapb.ms_pedido.dto.response.ProdutoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        url = "http://localhost:8080",
        name = "ms-produto",
        path = "/api/produtos"
)
public interface ProdutoClient {
    @GetMapping("/{id}")
    ProdutoResponseDTO buscarProdutoPorId(@PathVariable UUID id);
}
