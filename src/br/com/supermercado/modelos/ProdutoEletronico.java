package br.com.supermercado.modelos;

public class ProdutoEletronico extends Produto {
    private int mesesGarantia;
    private static final double IMPOSTO_IPI = 0.15; // 15% de imposto

    public ProdutoEletronico(String codigo, String nome, double precoBase, int quantidadeEstoque, int mesesGarantia) {
        super(codigo, nome, precoBase, quantidadeEstoque);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public double calcularPrecoFinal() {
        // Eletrônicos sofrem acréscimo de imposto
        return this.precoBase + (this.precoBase * IMPOSTO_IPI);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(codigo + " | Eletrônico: " + nome + " | Garantia: " + mesesGarantia + " meses | Estoque: " + quantidadeEstoque + " | Preço Final: R$" + String.format("%.2f", calcularPrecoFinal()));
    }
}
