package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

  
    public EstoqueProdutos(Map<Long, Produto> estoqueProdutosMap) {
        this.estoqueProdutosMap = new HashMap();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for (Produto p : estoqueProdutosMap.values()) {
          if (p.getPreco() > maiorPreco) {
            produtoMaisCaro = p;
            maiorPreco = p.getPreco();
          }
        }
        return produtoMaisCaro;
      }
    
      public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto p : estoqueProdutosMap.values()) {
          if (p.getPreco() < menorPreco) {
            produtoMaisBarato = p;
            menorPreco = p.getPreco();
          }
        }
        return produtoMaisBarato;
      }
    

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }

    public static void main(String[] args) {
        Map<Long, Produto> produtos = new HashMap<>();
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos(produtos);

        estoqueProdutos.exibirProdutos();
        System.out.println("Adicionando produtos: ");
        estoqueProdutos.adicionarProduto(12345, "papel", 200, 20);
        estoqueProdutos.adicionarProduto(13345, "papel", 100, 30);
        estoqueProdutos.adicionarProduto(5432, "pedra", 500, 0.5);
        estoqueProdutos.adicionarProduto(12345, "tesoura", 3, 55.6);
        estoqueProdutos.adicionarProduto(32223, "lagarto", 2, 22.4);
        estoqueProdutos.adicionarProduto(44343, "lajota", 20, 40);
        estoqueProdutos.exibirProdutos();
        System.out.println();
        System.out.println("Calculando o valor total do estoque");
        double valor = estoqueProdutos.calcularValorTotalEstoque();
        System.out.println(valor);
        System.out.println();
        System.out.println("obtendo produto mais caro: ");
        System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println();
        System.out.println("obtendo produto mais barato: ");
        System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println();
        System.out.println("obtendo produto com maior quantidade e valor total no estoque: ");
        System.out.println("Produto com maior quantidade e valor total no estoque: "
                + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }
}
