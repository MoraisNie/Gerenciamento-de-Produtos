package br.com.supermercado.modelos;
import br.com.supermercado.excecoes.EstoqueInsuficienteException;

public abstract class Produto {
    protected String codigo;
    protected String nome;
    protected double precoBase;
    protected int quantidadeEstoque;

    public Produto(String codigo, String nome, double precoBase, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
            System.out.println(quantidade + " unidades adicionadas ao estoque de: " + nome);
        }
    }

    public void vender(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > this.quantidadeEstoque) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + nome + ". Disponível: " + this.quantidadeEstoque);
        }
        this.quantidadeEstoque -= quantidade;
        System.out.println("Venda realizada: " + quantidade + "x " + nome);
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    // Método abstrato: cada tipo de produto calcula seu preço final de uma forma (impostos, descontos, etc.)
    public abstract double calcularPrecoFinal();
    
    public abstract void exibirDetalhes();
}
