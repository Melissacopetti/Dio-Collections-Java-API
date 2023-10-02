package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
  private Set<Produto> produtoSet;

  public CadastroProdutos() {
    this.produtoSet = new HashSet<>();
  }

  public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
    produtoSet.add(new Produto(cod, nome, preco, quantidade));
  }

  public Set<Produto> exibirProdutosPorNome() {
    Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
    if (!produtoSet.isEmpty()) {
      return produtosPorNome;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public Set<Produto> exibirProdutosPorPreco() {
    Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
    if (!produtoSet.isEmpty()) {
      produtosPorPreco.addAll(produtoSet);
      return produtosPorPreco;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }


    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        System.out.println("Adicionando produtos");
        cadastroProdutos.adicionarProduto(1L, "Mesa", 25.0, 2);
        cadastroProdutos.adicionarProduto(3L, "Lâmpada", 5.0, 10);
        cadastroProdutos.adicionarProduto(3L, "Mesa", 35.0, 1);
        cadastroProdutos.adicionarProduto(4L, "Caneta", 1.0, 14);
        cadastroProdutos.adicionarProduto(5L, "Cigarro", 20.0, 2);

        System.out.println();
        System.out.println("Exibindo lista de produtos por nome");
        cadastroProdutos.exibirProdutosPorNome().forEach(System.out::println);

        System.out.println();
        System.out.println("Exibindo lista de produtos por preço");
        cadastroProdutos.exibirProdutosPorPreco().forEach(System.out::println);
    }
}
