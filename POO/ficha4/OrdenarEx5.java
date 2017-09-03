package ficha4;

import java.util.Vector;

/**
 *  Exercicio 5
 * Ordenar uma vetor e remover o maior valor e guardar na ultima posicao de uma
 * novo vetor
 * 
 * @author root
 */
public class OrdenarEx5 {
    Vector<Integer> ordenado;

    public OrdenarEx5() {
        ordenado = new Vector<Integer>();
    }
    public static void printLista(Vector<Integer> lista) {
            for (int elem: lista)
                System.out.print("|" + elem +"");
            System.out.println("|");
    }

    
    /**
     * Ordenar uma lista passado por parametro para uma nova lista
     * em ordem decrescente
     * @param desordenado - lista ou vetores com valores inteiros por ordenar
     */
    public void sort(Vector<Integer> desordenado)
    {
        
        int maior;
        int pos; // posicao do vetor que contem maior valor encontrado
        
        System.out.println("Lista a ordenar");
        printLista(desordenado);
        while(true) {
            maior = 0;
            pos = -1;
            // percorrer a lista guardando maior valor  e a sua posicao 
            // entre os elementos da  lista
            for (int i = 0; i < desordenado.size(); i++) {
                if (desordenado.get(i) > maior) {
                    maior = desordenado.get(i);
                    pos = i;
                } 
            }
            /* Se a lista estiver vazia terminar  */
            if (desordenado.size() < 1)
                break;
            /* Se encontrado uma posicao no array que contem maior valor
                remover o elemento e armazenar em uma nova lista 
            */
            if (pos >= 0)
                desordenado.remove(pos);
            ordenado.add(maior);
        }
        System.out.println("Lista ja ordenada");
        printLista(ordenado);
    }
    
    
    
}
