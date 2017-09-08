
package pilhas;

/**
 * Assinatura de metodos por implementar em uma pilha
 * 
 * 
 * @author root
 */
public interface Pilha {
   
    public void push(Object elem); // adicionar objecto na pilha
    public Object pop(); // remover e retornar o ultimo objecto da pilha
    public Object peek(); // retornar o ultimo objecto da pilha
    public int search(Object elem); // retornar a posicao do elemento na pilha
    public boolean empty(); // True se a lista estiver vazia 
}
