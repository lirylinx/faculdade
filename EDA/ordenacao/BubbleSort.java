
package ordenacao;

/**
 * Algoritmo de ordenamento Bubble sort
 * consiste em:
 * @author root
 */
public class BubbleSort {
    
    public int ntrocas, inicial;

    public BubbleSort() {
        inicial = 1;
    }
    
    private void swap(int val1, int val2) {
        int aux;
        aux = val1;
        val1 = val2;
        val2 = aux;
    }
    public void sort(int[] lista, int nelem) {
        while ((inicial)  < nelem) {
            ntrocas = 0;
            for (int i = nelem - 1; i >= inicial; i--) {
                if (lista[i-1] > lista[i]) {
                    swap(lista[i-1], lista[i]); // alterar posicacao dos elementos na lista
                    ntrocas++; // contar numeros de trocas necessarios 
                }
            }
            inicial++;
        }
    }
    
    
}
