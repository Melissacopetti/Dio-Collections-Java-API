package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        // Implemente a lógica de ordenação por altura aqui
        Collections.sort(pessoaPorAltura, new ComparadorPorAltura()); // Usando um comparador externo
        return pessoaPorAltura;
    }

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas(listaPessoas);

        // Adicionando pessoas à lista
        ordenacaoPessoas.adicionarPessoa("Alice", 25, 1.70);
        ordenacaoPessoas.adicionarPessoa("Bob", 30, 1.80);
        ordenacaoPessoas.adicionarPessoa("Carol", 20, 1.65);
        System.out.println("Adicionadas as seguintes pessoas à lista: "+ listaPessoas);
        System.out.println();
        System.out.println("Aplicando o método de ordenação por idade:");
        // Ordenando por idade
        List<Pessoa> pessoasOrdenadasPorIdade = ordenacaoPessoas.ordenarPorIdade();
        System.out.println("Pessoas ordenadas por idade:");
        for (Pessoa pessoa : pessoasOrdenadasPorIdade) {
            System.out.println(pessoa);
        }
        System.out.println();
        System.out.println("Aplicando o método de ordenação por idade:");
        // Ordenando por altura
        List<Pessoa> pessoasOrdenadasPorAltura = ordenacaoPessoas.ordenarPorAltura();
        System.out.println("Pessoas ordenadas por altura: ");
        for (Pessoa pessoa : pessoasOrdenadasPorAltura) {
            System.out.println(pessoa);
        }
    }
}
