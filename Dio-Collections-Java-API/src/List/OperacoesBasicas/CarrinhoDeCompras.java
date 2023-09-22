package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, int quantidade, double preco) {
        carrinhoDeCompras.add(new Item(nome, quantidade, preco));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!carrinhoDeCompras.isEmpty()) {
            for (Item i : carrinhoDeCompras) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            carrinhoDeCompras.removeAll(itensParaRemover);
        } else {
            System.out.println("O carrinho está vazio");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Item item : carrinhoDeCompras) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens() {
        if (carrinhoDeCompras.isEmpty()) {
            System.out.println("O carrinho está vazio");
        } else {
            System.out.println("Itens no carrinho:");
            for (Item item : carrinhoDeCompras) {
                System.out.println("Nome: " + item.getNome() + ", Quantidade: " + item.getQuantidade() + ", Preço: " + item.getPreco());
            }
        }
    }


    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Produto A", 2, 10.0);
        carrinho.adicionarItem("Produto B", 1, 5.0);
        carrinho.adicionarItem("Produto C", 4, 5.45);


        System.out.println("Itens no carrinho:");
        carrinho.exibirItens();

        System.out.println("Valor total do carrinho: R$" + carrinho.calcularValorTotal());

        carrinho.removerItem("Produto A");

        System.out.println("Itens no carrinho após remover produto:");
        carrinho.exibirItens();

        System.out.println("Valor total do carrinho após remover produto: R$" + carrinho.calcularValorTotal());

    }
}





