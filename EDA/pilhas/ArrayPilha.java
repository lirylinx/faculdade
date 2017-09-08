
package pilhas;

/**
 *  Implementando metodos para estrutura de dados pilha 
 * usando array como estrutura de dado
 * 
 * @author root
 */
public class ArrayPilha implements Pilha{
    Object[] pilha;
    int n_elemento;  // controlar numero de elementos empilhados
    int realoc = 2; // quando o array chegar ao tamanho maximo realocar o dobro do espaco

    public ArrayPilha(int capacidade) {
        pilha = new Object[capacidade];
        n_elemento = 0;
    }

    
    private int copiar_pilha(Object[] to) {
        int size_to = to.length;
        int size_from = pilha.length;
        if (size_to <= 0 || size_to <= 0)
            return -1;
        if (size_to <= size_from) // destino sem espaco insuficiente para copiar elementos
            return -2;
        
        for (int i = 0; i < size_from; i++)
            to[i] = pilha[i];
        
        pilha = to.clone();
        return 0;
    }
    private int aumentar_array() {
        
        int total_size = pilha.length;
        Object[] tmp;
        if (total_size <= 0)
            return -1;
        tmp = new Object[total_size * realoc];
        
        copiar_pilha(tmp);
        return 0;   
    }
    
    
    /**
     * Adicionar elemento na pilha
     * @param elem objecto a ser empilhado
     */
    
    @Override
    public void push(Object elem) {
        int size_pilha = pilha.length;
        if (size_pilha <= n_elemento)
            if (aumentar_array() != 0)
                System.err.println("Ocorreu um erro no push");
        pilha[n_elemento++] = elem;
    }

    
    /**
     * Remover ultimo elemento da pilha e retornar o mesmo
     * @return  objecto removido
     */
    @Override
    public Object pop() {
        Object elem = peek();
        if (empty() || elem == null)
            return null;

        pilha[n_elemento-1] = null;
        n_elemento--;
        return elem;
    }

    /**
     *  Retornar o ultimo elemento da pilha
     * @return objecto localizado na ultima posicao da pilha
     */
    @Override
    public Object peek() {
        if (empty())
            return null;
        return pilha[n_elemento-1];
    }
    
    
    /**
     *  Procurar por um objecto na pilha e retornar a posicao 
     * @param elem - objecto chave a procurar
     * @return  posicao do elemento na pilha
     */

    @Override
    public int search(Object elem) {
        int pos = 1;
        for(int i = n_elemento-1; i >= 0; i--)
            if (pilha[i].equals(elem))
                return pos;
            else
                pos++;
 
        return -1;
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
            System.out.print(pilha[i] + "|");
        
        System.out.println();
    }    
    
    
    
    
}
