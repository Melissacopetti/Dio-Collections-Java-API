package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros(List<Livro> livroList) {
        this.livroList = livroList;
    }

    public void adicionarLivros(String titulo, String autor, int dataPublicacao) {
        livroList.add(new Livro(titulo, autor, dataPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livroPorAutor = new ArrayList<>();

        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livroPorAutor.add(l);
                }
            }
        }

        return livroPorAutor;
    }

    public List<Livro> pesquisarPorIntervalo(int anoInicial, int anoFinal) {


        List<Livro> livrosPorIntervalo = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervalo.add(l);
                }
            }

        }
        return livrosPorIntervalo;
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {


        List<Livro> livrosPorTitulo = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livrosPorTitulo.add(l);
                    break;
                }
            }

        }
        return livrosPorTitulo;
    }

    public static void main(String[] args) {
        // Crie uma lista de livros
        List<Livro> listaLivros = new ArrayList<>();

        // Crie uma instância de CatalogoLivros com a lista de livros
        CatalogoLivros catalogo = new CatalogoLivros(listaLivros);


        // Adicione alguns livros
        catalogo.adicionarLivros("Livro 1", " Paulo", 2000);
        catalogo.adicionarLivros("Livro 2", "Bruno", 2004);
        catalogo.adicionarLivros("Livro 3", " Ana", 2020);
        catalogo.adicionarLivros("Livro 4", "Claudia", 2015);
        System.out.println("Livros inseridos no catálogo: " + catalogo);

        System.out.println();

        // Teste o método pesquisarPorAutor
        List<Livro> livrosPorAutor = catalogo.pesquisarPorAutor("Claudia");
        System.out.println("Livros do autor Claudia: ");
        for (Livro livro : livrosPorAutor) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Ano: " + livro.getAnoPublicacao());
        }

        System.out.println();

        // Teste o método pesquisarPorIntervalo
        List<Livro> livrosPorIntervalo = catalogo.pesquisarPorIntervalo(2005, 2022);
        System.out.println("Livros no intervalo 2005-2022:");
        for (Livro livro : livrosPorIntervalo) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Ano: " + livro.getAnoPublicacao());
        }
        System.out.println();

        // Teste o método pesquisarPorTitulo
        List<Livro> livrosPorTitulo = catalogo.pesquisarPorTitulo("Livro 2");
        System.out.println("Livros com título 'Livro 2':");
        for (Livro livro : livrosPorTitulo) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Ano: " + livro.getAnoPublicacao());
        }
    }


}
