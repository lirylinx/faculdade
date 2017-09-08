
package teste;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import stream.Stream;

/**
 *
 * @author root
 */
public class CartaoTeste {


//    private String DB_PATH = "/home/lirylinx/SIMCARD.DB" -> unix* path;
    private String DB_PATH = "SIMCARD.DB";

    public CartaoTeste() {
        try {
            this.stream = new Stream(DB_PATH);
        } catch (IOException ex) {
            System.err.println("[ERRO] Na abertura do ficheiro");
        }
    }
    
    
    
    
    /**
     * Metodo principal para execucao dos testes 
     */
    public void RUN() {
        int opt = -1;
        do {            
            this.menu();
            System.out.print("input\\> ");
            opt = input.nextInt();
            
            switch(opt) {
                case 1:
                    this.testeRegisto("Vodacom");
                    break;
                case 2:
                    this.testeRegisto("Mcel");
                    break;
                case 3:
                    if (this.cartoes.size() > 0)
                        this.testeRecarga(50.0, this.cartoes.get(0));
                    else
                        System.err.println("Sem cartoes por recarregar");
                    break;
                case 4:
                    if (this.cartoes.size() > 1)
                        this.testeTransferir(10.0, this.cartoes.get(0), this.cartoes.get(1));
                    else 
                        System.err.println("Sem cartoes suficiente para transferir");
                case 5:
//                    if (this.cartoes.size() > 1)
                        this.listaDeCartao();
//                    else 
//                        System.err.println("[!!!]Sem cartoes registado na Base de Dados!");

                    break;
                default:
                    opt = -1;
            }
        } while (opt != -1);
    }

    private List<SimCard> cartoes = new ArrayList<SimCard>();
    private Scanner input = new Scanner(System.in);
    private Stream stream;

    /**
     * Menu de opcoes com funcionalidades disponiveis
     */
    public void menu(){
      System.out.println("\t\tMenu\n\n");
      System.out.println("\t1- Registar Cartao Vodacom\n");
      System.out.println("\t2-Registar Cartao Mcel\n");
      System.out.println("\t3- Recarregar\n");
      System.out.println("\t4- Transferir\n");
      System.out.println("\t5- Listar informacao\n");
      System.out.println("\t6- Sair\n");
        
    }

    /**
     * Registando cartoes de acordo com a operadora
     * @param operadora  operadora de escolha para o cartao
     */
    public SimCard testeRegisto(String operadora) {
        SimCard obj = null;
      if (operadora.equalsIgnoreCase("mcel")) {
        int numero = this.gerador_numero(82);
        obj = new CartaoMcel(numero, "alto mae\n");
        System.out.print(obj.toString());
      } else if (operadora.equalsIgnoreCase("vodacom")) {
        int numero = this.gerador_numero(84);
        obj = new CartaoVodacom(numero, "Maputo\n");
        System.out.print(obj.toString());
      }
      this.cartoes.add(obj);
      this.insertToFile(obj);
      return obj;
    }
    
    /**
     * Testando o metodo recarregar das classes filhos de SimCard
     *  mostrando mensagem de acordo com o valor de retorno 
     * 
     * @param valor valor da recarga
     * @param cartao ou numero para onde recarregar
     */
    public void testeRecarga(double valor, SimCard cartao) {
        int rv =  cartao.recarregar(valor);
        if (rv == -1)
            System.err.printf("Erro testeRecarga para:\n" + cartao.toString()
                    + "Valor a recarregar: %2.f ", valor);
        else 
            System.out.printf("Recarregou com Sucesso\n"
                    + "%s com o valor de %.2f:\n", cartao.toString(), valor);

    }
    
    /**
     *   Teste de transferencia de saldo para um outro numero da mesma 
     * operadora e imprimir mensagem de resposta dependendo do valor de retorno
     * do metodo transferir da classe SimCard
     * @param valor valor a transferir
     * @param fonte cartao ou numero de onde o valor sera transferido
     * @param destino  cartao ou numero para onde o valor eh Transferido
     */
    public void testeTransferir(double valor, SimCard fonte, SimCard destino){
        int rv = fonte.transferir(valor, destino);
        if (rv == -1) 
            System.err.printf("[!!!]Erro testeTransferir\n"
                    + "De %d Para %d:\n"
                    + "Valor %f.2 invalido ", fonte.numero, destino.numero, valor);        
        else if (rv == -2)
            System.err.printf("[!!!]Erro testeTransferir\n"
                    + "De %d Para %d:\n"
                    + "Saldo %f.2 indisponivel para tranferir %f.2", fonte.numero,
                    destino.numero,  fonte.saldo, valor);        

        else if (rv == -3)
            System.err.printf("[!!!]Erro testeTransferir\n"
                    + "De %d Para %d:\n"
                    + "Valor nao pode ser transferido para outra operadora!", fonte.numero,
                    destino.numero,  fonte.saldo, valor);        

        else
            System.out.printf("Transferencia com Sucesso\n"
                    + "Transferiu o valor %.2f para  %d\n"
                    + "Saldo actual %.2f", valor, destino.numero, fonte.saldo);

    }
    
    /**
     * Listar todos cartoes na ordem crescente ordenado pelo valor do saldo
     */
    public void listaDeCartao(){
        System.out.println("Do Array");
        if (this.cartoes.size() > 0) {
            for(SimCard cartao : this.cartoes) {
                System.out.println(cartao.toString());
            }
        }
        System.out.println("Do ficheiro");
        cartoes = selectFromFile();
        if (this.cartoes.size() > 0) {
            for(SimCard cartao : this.cartoes) {
                System.out.println(cartao.toString());
            }
        }
    }

    /**
     * Gerador de numero de cartao SIM
     * @param prefixo - prefix da operadora Mcel --> 82 | Voda --> 84
     * @return 
     */
    private int gerador_numero(int prefixo) {
        int numero = prefixo;
        for(int i = 0; i < 7; i++) {
            numero *= 10; 
            numero += Math.random() * 9;
        }
        return numero;
    }
    
    
    
    /**
     * Gravar objecto SimCard em um ficheiro e recuperar quando necessario
     */
    
    private void insertToFile(SimCard cartao) {
        stream.fileObjWriter(cartao, DB_PATH);
    }

    private void insertToFile(List<SimCard> cartoes) {
        stream.fileObjWriter(cartoes, DB_PATH);
    }

    
    /**
     * Ler dados de SimCard armazenado no ficheiro
     */    
    private List<SimCard> selectFromFile() {
        SimCard cartao = null;
        List<SimCard> lista = new ArrayList<SimCard>();
        Object obj;
        try {
            stream.entradaFileObj = new FileInputStream(DB_PATH);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CartaoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stream.entradaObj = new ObjectInputStream(stream.entradaFileObj);
        } catch (IOException ex) {
            Logger.getLogger(CartaoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lista = stream.fileObjReader();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CartaoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}