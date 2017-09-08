package pilhas;

import java.util.Vector;

/**
 *  Implementando metodos para estrutura de dados pilha 
 * usando Vetor como estrutura de dado
 * 
 * @author root
 */
public class VetorPilha implements Pilha{

    Vector pilha;
    int n_elemento; // numero de elementos ja empilhados

    public VetorPilha(int capacidade) {
        pilha = new Vector(capacidade, 2);
        n_elemento = 0;
    }
    
    /**
     * Adicionar elemento na pilha
     * @param elem objecto a ser empilhado
     */

    @Override
    public void push(Object elem) {
        if (elem != null)
            pilha.add(n_elemento++, elem);
    }

    /**
     * Remover ultimo elemento da pilha e retornar o mesmo
     * @return  objecto removido
     */
    
    @Override
    public Object pop() {
        Object elem = peek();
        if (empty())
            return null;
        pilha.remove(n_elemento-1); 
        return elem;
    }
    
    /**
     * Pegar o ultimo elemento
     * @return ultimo objecto da pilha
     */

    @Override
    public Object peek() {
        if (empty())
            return null;
        return pilha.lastElement();
    }


    /**
     *  Procurar por um objecto na pilha e retornar a posicao 
     * @param elem - objecto chave a procurar
     * @return  posicao do elemento na pilha
     */
    @Override
    public int search(Object elem) {
        if (empty())
            return -1;
        int pos = 1;
        for(int i = n_elemento-1; i >= 0; i--)
            if (pilha.get(i).equals(elem))
                return pos;
            else
                pos++;
        
        return pos;
    }

    /** 
     * Se pilha esta vazia 
     * @return 
     */
    @Override
    public boolean empty() {
        return n_elemento <= 0;
    }
    
    
    public void imprimi() 
    {
        System.out.print("|");
        for (int i = n_elemento; i >= 0; i--)
            System.out.print(pilha.get(i) + "|");
        
        System.out.println();

    }    
    
}
