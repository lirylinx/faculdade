
package pilhas;

/**
 * Exercicio 2: EDA
 *  Converter um valor (Decimal, Hexadecimal) para binario
 * @author root
 */
public class ToBinario {

    
    /* TODO */
    private String str_binario_frmt; // representacao em uma string
    private int int_binario_frmt; // representacao em numero inteiro

    
    public ArrayListPilha binario;
    
    /**
     * Tamanho 
     */
    private int _8bits = 8;
    private int _16bits = 16;
    private int _32bits = 32;
    private int _64bits = 64;

    public ToBinario() {
    }
    
    
    
    /**
     * Converter de valor decimal para binario
     * Usando recurso a pilha para armazenar os digitos [0, 1] durante a 
     * conversao do valor decimal.
     * 
     * Uma  vez que apos a conversao o passo seguinte eh inverter 
     * de traz para frente.
     * E a Estrutrara de Dados PILHA  tem como filosofia: O ultimo a entrar sera
     * o primeiro a sair. Entao so armazenar o digitos. Na hora de acessar 
     * ou imprimir o metodo pop() retornara a ordem certa dos digitos.
     * 
     * 
     * @param val - valor inteiro decimal
     * @return 
     */
    public  ArrayListPilha dec_to_bin(int val) 
    {

        binario = new ArrayListPilha(_8bits); // 8 bits
        if (val < 1)
            return null;
 
        int aux = val;
        while(aux > 0) {
            if (aux % 2 == 0)
                binario.push(0);
            else
                binario.push(1);
            System.out.println(aux);
            aux = aux/2;
        }
        return binario;
    }

}
