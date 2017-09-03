
package ficha4;

import java.util.Vector;

/**
 *  Exercicio 2
 * Pegar dois vetores e comparar se possuem tamanhos iguais e mesmo valores em cada posicao
 * Se sim informar que sao iguais caso contrario sao diferentes
 * 
 * @author root
 */
public class CompararVetores {

    public CompararVetores() {
    }
   
    /**
     * 
     * @param vetor1
     * @param vetor1 
     */
    public int compare(Vector<Integer> vetor1, Vector<Integer> vetor2) 
    {
        if (vetor1.size() != vetor2.size())
            return -1;
        for (int i = 0; i < vetor1.size(); i++) {
            if (vetor1.get(i) != vetor2.get(i)) {
                return -2;
            }
        }
        
        return 0;
    }
    
}
