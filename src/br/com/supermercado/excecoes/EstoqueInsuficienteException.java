package br.com.supermercado.excecoes;

public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
