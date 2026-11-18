package br.com.faculdadecatolicapb.ms_pedido.mapper;

import br.com.faculdadecatolicapb.ms_pedido.domain.Pedido;
import br.com.faculdadecatolicapb.ms_pedido.dto.request.PedidoRequestDTO;
import br.com.faculdadecatolicapb.ms_pedido.dto.response.PedidoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    Pedido toEntity(PedidoRequestDTO dto);

    PedidoResponseDTO toDTO(Pedido entity);
}
