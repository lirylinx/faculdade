
package recursividade;

import java.util.ArrayList;

/**
 *  Exercicios  sobre recursividade
 * @author root
 */
public class Recursividade
{
 
    public int inverterInteiro(int origem, int destino)
    {
        if (origem  > 0){
            destino *= 10;
            destino += origem % 10;
            origem = (int) origem / 10;
        } else {
            return destino;
        }
        
        return inverterInteiro(origem, destino);
    }
    
    private int pop(ArrayList lista) {
        if (lista.isEmpty())
            return -1;
        
        return lista.lastIndexOf(lista.size() - 1);
    }

    public int somarVetor(ArrayList lista)
    {
        if ((lista.size()) > 1) {
            
            lista.add(lista.size()-1, this.pop(lista) + this.pop(lista));
        } else {
            return lista.indexOf(0);
        }
        System.out.println("media size: " + lista.size());
        
        return somarVetor(lista);
    }
    
    
    public int padovan(int val)
    {
        if (val <= 2 )
            return 1;
            
        return padovan(val-2) + padovan(val-3);
        
    }
}
