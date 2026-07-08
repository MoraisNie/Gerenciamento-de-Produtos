package br.com.supermercado.modelos;

public class ProdutoAlimenticio extends Produto {
    private String dataValidade;
    private boolean perecivel;

    public ProdutoAlimenticio(String codigo, String nome, double precoBase, int quantidadeEstoque, String dataValidade, boolean perecivel) {
        super(codigo, nome, precoBase, quantidadeEstoque);
        this.dataValidade = dataValidade;
        this.perecivel = perecivel;
    }

    @Override
    public double calcularPrecoFinal() {
        // Produtos alimentícios não possuem taxa extra no nosso exemplo
        return this.precoBase;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(codigo + " | Alimento: " + nome + " | Validade: " + dataValidade + " | Estoque: " + quantidadeEstoque + " | Preço: R$" + String.format("%.2f", calcularPrecoFinal()));
    }
}
