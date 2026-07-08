package br.com.supermercado.servicos;
import br.com.supermercado.modelos.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEstoque {
    private List<Produto> catalogo;

    public GerenciadorEstoque() {
        this.catalogo = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        catalogo.add(produto);
        System.out.println("Produto cadastrado com sucesso: " + produto.getNome());
    }

    public Produto buscarProduto(String codigo) {
        for (Produto p : catalogo) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null; // Retorna nulo se não encontrar
    }

    public void listarEstoque() {
        System.out.println("\n=== Inventário do Supermercado ===");
        if (catalogo.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (Produto p : catalogo) {
                p.exibirDetalhes();
            }
        }
        System.out.println("==================================\n");
    }
}
