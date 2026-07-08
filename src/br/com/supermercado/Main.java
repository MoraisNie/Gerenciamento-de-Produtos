package br.com.supermercado;

import br.com.supermercado.excecoes.EstoqueInsuficienteException;
import br.com.supermercado.modelos.ProdutoAlimenticio;
import br.com.supermercado.modelos.ProdutoEletronico;
import br.com.supermercado.servicos.GerenciadorEstoque;
import br.com.supermercado.modelos.Produto;

public class Main {
    public static void main(String[] args) {
        // 1. Iniciando o sistema
        GerenciadorEstoque estoque = new GerenciadorEstoque();

        // 2. Criando produtos
        ProdutoAlimenticio arroz = new ProdutoAlimenticio("ALM-001", "Arroz Branco 5kg", 25.50, 50, "10/12/2024", true);
        ProdutoEletronico liquidificador = new ProdutoEletronico("ELT-001", "Liquidificador Turbo", 120.00, 15, 12);

        // 3. Cadastrando no estoque
        System.out.println("--- Cadastrando Produtos ---");
        estoque.cadastrarProduto(arroz);
        estoque.cadastrarProduto(liquidificador);

        // 4. Listando estoque inicial
        estoque.listarEstoque();

        // 5. Simulando Vendas e Reposições
        try {
            System.out.println("--- Iniciando Operações do Caixa ---");
            
            // Buscando produto para venda
            Produto p1 = estoque.buscarProduto("ALM-001");
            if (p1 != null) {
                p1.vender(3); // Vende 3 sacos de arroz
            }

            Produto p2 = estoque.buscarProduto("ELT-001");
            if (p2 != null) {
                p2.vender(2); // Vende 2 liquidificadores
            }

            // Repondo estoque
            System.out.println("\n--- Reposição de Mercadoria ---");
            if (p1 != null) p1.adicionarEstoque(10);

            // Tentando vender mais do que tem (Dispara a Exceção)
            // if (p2 != null) p2.vender(20); // Descomente para testar o erro!

        } catch (EstoqueInsuficienteException e) {
            System.err.println("ERRO NA VENDA: " + e.getMessage());
        }

        // 6. Listando estoque atualizado
        estoque.listarEstoque();
    }
}
