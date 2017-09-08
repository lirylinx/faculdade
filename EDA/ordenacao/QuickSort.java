
package ordenacao;

/**
 * Algoritmo de ordenamento Quick sort
 * consiste em: dividir a lista do meio ate
 * @author root
 */
public class QuickSort {
    private void swap(int val1, int val2) {
        int aux;
        aux = val1;
        val1 = val2;
        val2 = aux;
    }
    
    public int sort(int[] lista, int inicio, int fim) {
        int medio, indiI, indiJ;
        int nelem = fim - inicio + 1;
        if (nelem <= 1) 
            return -1;
        if (nelem == 2) {
            if (lista[inicio] > lista[fim]) {
                swap(lista[inicio], lista[fim]);
                return 0;
            }            
        }
        medio = (inicio + fim) / 2; //  calcular o indice pivot
        
        // alterar os elemntos extremos e o pivot de modo crescente;
        if (lista[inicio] > lista[medio]) swap(lista[inicio], lista[medio]);
        if (lista[inicio] > lista[fim]) swap(lista[inicio], lista[fim]);
        if (lista[medio] > lista[fim]) swap(lista[medio], lista[fim]);
        
//         se a lista corrente contem 3 elementos entao ja esta
//        ordenada
        if (nelem == 3) {
            return 0;
        }
        
//        esconder o pivot na penultima posicao da lista
        swap(lista[medio], lista[fim-1]);
        
         return 1;       
    }
}
