package br.com.faculdadecatolicapb.ms_pedido.exceptions;

public class ResourceNotFoundExecption extends RuntimeException {
    public ResourceNotFoundExecption(String message) {
        super(message);
    }
}
