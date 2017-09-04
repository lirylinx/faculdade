/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividade;

import java.util.ArrayList;

/**
 *
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

    public int somarVetor(int[] lista)
    {
        int soma = 0;
        for (int i = 0; i < lista.length; i++) {
            soma += lista[i];
        }
        return soma;
    }
    
    

    public int padovan(int val)
    {
        if (val <= 2 )
            return 1;
            
        return padovan(val-2) + padovan(val-3);
        
    }
}
