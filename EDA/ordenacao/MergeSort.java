package ordenacao;

/**
 * EDA
 * Classe com implementacao de algoritmo merge sort (dividir para conquistar)
 * 
 * Consiste na divisao de uma lista em 2 partes ate que nao 
 * @author root
 */
public class MergeSort {
    
    private int[] lista_aux;
    private int[] lista;
    
    private int size;
    
    public void ordenar(int[] lista) {
        this.lista = lista;
        size = lista.length;
        this.lista_aux = new int[size];
        mergeSort(0, size-1);
    }
    
    private void mergeSort(int esquerda, int direita) {
        /* Se esquerda for menor que direita entao a lista 
            precisa de ser ordenada
        */
        if (esquerda < direita) {
            int meio = esquerda + (esquerda - direita) / 2;
            
            // ordenar a direita do array
            mergeSort(esquerda, meio - 1);
            
            // ordenar a esquerda do array
            mergeSort(meio + 1, direita);
            
            // combinar as duas listas
            merge(esquerda, meio, direita);
        }
    }
    
    
    private void merge(int esquerda, int meio, int direita) {
        // copiar uma das parte da lista para lista auxiliar
        for (int i = esquerda; i <= direita; i++) {
            this.lista_aux[i] = lista[i];
        }
        
        int i = esquerda;
        int j = meio + 1;
        int k = esquerda;
        
        
        // copiar o valor mais pequeno das duas lista
        // e colocar na lista original
        while ( i <= meio && j <= direita) {
            if (this.lista_aux[i] < this.lista_aux[j]) {
                this.lista[k] = this.lista_aux[i];
                i++;
            } else {
                this.lista[k] = this.lista_aux[j];
                j++;
            }
            k++;
        }
        
        // copiar restantes elementos da lista a esquerda
        while (i <= meio) {
                this.lista[k] = this.lista_aux[i];
                i++;
                k++;
        }
        
    }
    
}
