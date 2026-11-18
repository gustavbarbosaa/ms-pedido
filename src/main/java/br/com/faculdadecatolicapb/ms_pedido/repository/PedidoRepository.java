package br.com.faculdadecatolicapb.ms_pedido.repository;

import br.com.faculdadecatolicapb.ms_pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
