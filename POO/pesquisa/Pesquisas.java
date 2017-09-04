
package pesquisa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author root
 */
public class Pesquisas {
    int[] lista;

    public Pesquisas(int[] lista) {
        this.lista = lista;
//        Arrays.sort(this.lista);
        this.printLista();
    }

    public int[] getLista() {
        return lista;
    }

    public void setLista(int[] lista) {
        this.lista = lista;
    }

    public int sequencial(int key) {
        for (int i = 0; i < this.lista.length; i++)
            if (lista[i] == key)
                return i;
        
        return -1;
    }

    
    public int sequencialRecursivo(int key, int pos) {
        if (this.lista[pos] == key)
            return pos;
        else if ((this.lista.length-1) == pos) {
            return -1;
        }
        pos += 1;
        return sequencialRecursivo(key, pos);

    }
    
    public int sequencialSentinela(int key) {
        boolean found = false;
        int pos = -1;
        while(!found && (this.lista.length - 1)  >= pos) {
            if (this.lista[++pos] == key)
                found = true;
            
        }
        return pos;
    }
    
    
    public int binaria(int key) {
            
            Arrays.sort(this.lista);
            int inicio = 0;
            int fim = this.lista.length -1;
            int meio = (int) (inicio + fim) / 2;
            while (inicio <= fim) {
            System.out.printf("inicio = %d meio = %d fim = %d\n", inicio, meio, fim);
                if (this.lista[meio] == key) {
                    return meio;
                } else {
                    if (key < this.lista[meio])
                        fim = meio - 1;
                    else if (key > this.lista[meio])
                        inicio =  meio+1;
                }
                meio = (int) (inicio + fim) / 2;
            }
        return -1;        
    }

    public int binariaRecursivo(int key, int inicio, int fim) {
        Arrays.sort(this.lista);
        int meio;
        if (inicio <= fim) {
            meio = (int) (inicio + fim) / 2;
            System.out.printf("inicio = %d meio = %d fim = %d\n", inicio, meio, fim);
            if (this.lista[meio] == key) {
                return meio;
            } else {
                if (key < this.lista[meio])
                    return binariaRecursivo(key, inicio, meio - 1);
                else if (key > this.lista[meio])
                    return binariaRecursivo(key, meio+1, fim);
            }
        }    
        return -1;
        
    }
    
    
    
    public void encontrarOcorrencia(int key) {
        int found = 0;
//        int pos = 0;
        System.out.println("Chave " + key);
        while ((found = this.sequencialRecursivo(key, found)) != -1) {
            System.out.println("Na posicao: " + found++);
        }
    }
    
    
        /**
     *
     * @param key
     * @return
     */
    public int encontrarMaiorOcorrencia(int key) {
        int found = 0;
        int count = 0;
        while (found < this.lista.length && ((found = this.sequencialRecursivo(key, found)) != -1)) {
            found ++;
            count++;
        }
        
        return count;
    }


    public void printLista() {
        for(int item: this.lista) {
            System.out.print("| "+item );
        }
        System.out.println("  |\nsize: " + this.lista.length);
    }
    
    

}
