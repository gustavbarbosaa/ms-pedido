package br.com.faculdadecatolicapb.ms_pedido.service;

import br.com.faculdadecatolicapb.ms_pedido.client.ProdutoClient;
import br.com.faculdadecatolicapb.ms_pedido.domain.Pedido;
import br.com.faculdadecatolicapb.ms_pedido.dto.request.PedidoRequestDTO;
import br.com.faculdadecatolicapb.ms_pedido.dto.response.PedidoResponseDTO;
import br.com.faculdadecatolicapb.ms_pedido.dto.response.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_pedido.exceptions.ResourceNotFoundExecption;
import br.com.faculdadecatolicapb.ms_pedido.mapper.PedidoMapper;
import br.com.faculdadecatolicapb.ms_pedido.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private static final String PEDIDO_NAO_ENCONTRADO = "Pedido não encontrado.";

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ProdutoClient produtoClient;

    public PedidoResponseDTO buscarPedidoPorId(UUID id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExecption(PEDIDO_NAO_ENCONTRADO));

        return pedidoMapper.toDTO(pedido);
    }

    public List<PedidoResponseDTO> buscarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos
                .stream()
                .map(pedidoMapper::toDTO)
                .toList();
    }

    @Transactional
    public PedidoResponseDTO cadastrar(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoMapper.toEntity(pedidoRequestDTO);

        ProdutoResponseDTO produto = produtoClient.buscarProdutoPorId(pedidoRequestDTO.produtoId());

        BigDecimal valorTotalDoPedido = produto.valor().multiply(BigDecimal.valueOf(pedidoRequestDTO.quantidade()));

        pedido.setDataPedido(LocalDateTime.now());
        pedido.setValorTotal(valorTotalDoPedido);

        pedido = pedidoRepository.save(pedido);

        return pedidoMapper.toDTO(pedido);
    }

    @Transactional
    public PedidoResponseDTO editar(UUID id, PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExecption(PEDIDO_NAO_ENCONTRADO));

        pedido.setProdutoId(pedidoRequestDTO.produtoId());
        pedido.setQuantidade(pedidoRequestDTO.quantidade());
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setEmailComprador(pedidoRequestDTO.emailComprador());

        BigDecimal valorTotalDoPedido = produto.valor().multiply(BigDecimal.valueOf(pedidoRequestDTO.quantidade()));

        pedido.setValorTotal(valorTotalDoPedido);

        pedido = pedidoRepository.save(pedido);

        return pedidoMapper.toDTO(pedido);
    }

    @Transactional
    public void deletar(UUID id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExecption(PEDIDO_NAO_ENCONTRADO));

        pedidoRepository.delete(pedido);
    }
}
