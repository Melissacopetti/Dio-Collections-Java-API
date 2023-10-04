package map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrariaMap;

    public LivrariaOnline() {
        this.livrariaMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livrariaMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        livrariaMap.entrySet().removeIf(entry -> entry.getValue().getTitulo().equals(titulo));
    }

    public List<Livro> exibirLivrosOrdenadosPorPreco() {
        List<Livro> livrosOrdenados = new ArrayList<>(livrariaMap.values());
        livrosOrdenados.sort(Comparator.comparingDouble(Livro::getPreco));
        return livrosOrdenados;
    }

    public Map<String, List<Livro>> exibirLivrosOrdenadosPorAutor() {
        Map<String, List<Livro>> livrosPorAutor = new HashMap<>();
        for (Livro livro : livrariaMap.values()) {
            livrosPorAutor.computeIfAbsent(livro.getAutor(), k -> new ArrayList<>()).add(livro);
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro livro : livrariaMap.values()) {
            if (livro.getAutor().equals(autor)) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor;
    }

    public Livro obterLivroMaisCaro() {
        return Collections.max(livrariaMap.values(), Comparator.comparingDouble(Livro::getPreco));
    }

    public Livro exibirLivroMaisBarato() {
        return Collections.min(livrariaMap.values(), Comparator.comparingDouble(Livro::getPreco));
    }

    public Map<String, Livro> getLivrariaMap() {
        return livrariaMap;
    }

    @Override
    public String toString() {
        return livrariaMap.toString();
    }


    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50.0));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/gp/product/B001TKD4R6/ref=dbs_a_def_rwt_bibl_vppi_i0", new Livro("Fit for Developing Software: Framework for Integrated Tests", "Rick Mugridge", 7.05));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/gp/product/B075LRM681/ref=dbs_a_def_rwt_bibl_vppi_i2", new Livro("Clean Architecture: A Craftsman's Guide to Software Structure and Design ", "Bob Martin", 89.99));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/gp/product/B087N8LKYB/ref=dbs_a_def_rwt_bibl_vppi_i0", new Livro("Refatoração: Aperfeiçoando o design de códigos existentes", "George Orwell", 107.55));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/gp/product/B0851R57ZL/ref=dbs_a_def_rwt_bibl_vppi_i0", new Livro("Storytelling com Dados: Um guia sobre visualização de dados para profissionais de negócios", "Cole Nussbaumer Knaflic", 67.05));


        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        String autorPesquisa = "Rick Mugridge";
        System.out.println("Livros de " + autorPesquisa + ":\n" + livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        livrariaOnline.removerLivro("1984");
        System.out.println("Livros após a remoção: \n" + livrariaOnline.getLivrariaMap());
    }


}



