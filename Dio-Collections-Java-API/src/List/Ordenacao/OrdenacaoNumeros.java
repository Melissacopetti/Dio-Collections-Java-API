package List.Ordenacao;

import List.Pesquisa.SomaNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros implements Comparable<OrdenacaoNumeros> {
    private List<Integer> numeros = new ArrayList<>();

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    @Override
    public int compareTo(OrdenacaoNumeros n) {
        return 0;
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(numeros);
        Collections.sort(numerosAscendentes);
        return numerosAscendentes;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendentes = new ArrayList<>(numeros);
        Collections.sort(numerosDescendentes, Collections.reverseOrder());
        return numerosDescendentes;
    }


    public static void main(String[] args) {
        OrdenacaoNumeros numerosLista = new OrdenacaoNumeros();

        System.out.println("Adicionando números à lista: ");
        numerosLista.adicionarNumero(2);
        numerosLista.adicionarNumero(24);
        numerosLista.adicionarNumero(14);
        numerosLista.adicionarNumero(43);
        numerosLista.adicionarNumero(6);
        numerosLista.adicionarNumero(1);
        numerosLista.adicionarNumero(234);
        numerosLista.adicionarNumero(8);

        List<Integer> numeros = numerosLista.numeros; // Obtém a lista ordenada

        System.out.println(numeros);
        System.out.println();
        System.out.println("Numeros ordenados de forma ascendente: ");
        List<Integer> ordenadosAscendentes = numerosLista.ordenarAscendente();

        for (int numero : ordenadosAscendentes) {
            System.out.print(numero + " ");
        }

        System.out.println();
        System.out.println("Numeros ordenados de forma descendente: ");
        List<Integer> ordenadosDescendentes = numerosLista.ordenarDescendente();

        for (int numero : ordenadosDescendentes) {
            System.out.print(numero + " ");
        }
    }

}

