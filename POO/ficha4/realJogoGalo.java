
package ficha4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class realJogoGalo {

    private char BLANK = '_';
    private int COL = 3;
    private int LIN = 3;
    char[][] tabela = new char[LIN][COL];
//    coordenadas do tabuleiro
    int[] x = new int[] {0, 1, 2};
    int[] y = new int[] {0, 1, 2};

    private Scanner input = new Scanner(System.in);

    public realJogoGalo()
    {
    }

    private void printXO()
    {
        for (int i = 0; i < LIN; i++){
            for (int j = 0; j < COL; j++) 
                System.out.print(tabela[i][j] + " ");
            System.out.println();
        }
        

    }
    
    private void restaurar_tabela(){
        for (int i = 0; i < LIN; i++)
            for (int j = 0; j < COL; j++) 
                tabela[i][j] = BLANK;
    }
    
    public void play()
    {
        
        System.out.println("\t\t### JOGO DO GALO ###\n");
        registarJogador();
        Jogador player = registarJogador();        
        restaurar_tabela();
        // mostar tabela
        printXO();
        char jogador = definirJogador();
        int jogada;
        /* Terminar quando houver um vencedor ou empate */
        while(true) {
            if (player.dado == jogador) {
                System.out.println("Joga Humano");
                // movimento usuario
                jogada = usuarioJogada( );                
                //atualizar tabela com novo movimento
                actualizar_tabela(jogada, jogador);
            } else {
                System.out.println("Joga Computador");

                // definir movimento para computador
                int[] jogadaComp = computador_jogada_a();

                // atualizar tabela com novo movimento
                actualizar_tabela(jogadaComp, jogador);
            }
            
            /* Imprimir a tabela */
            printXO();
            // checar vencedor ou empate            
            if (vencedor(jogador) || empate())
                break;
            
            // alterar jogador
            jogador = troca_jogador(jogador);
        }
        
        // mensagem final
        if (!vencedor(jogador))
            System.out.println("[!!!] Epah empate, fica para proxima [!!!]");
        else
            congratulation(jogador, player);
    }

    private void congratulation(char dado, Jogador jogador) 
    {
        System.out.println("\t************** VENCEDOR *********************\n");
        if (dado == jogador.getDado())
            System.out.println("[!!!] Parabens Humano voce ganhou [!!!]\n"
                    + "Dados\n" + jogador.toString());
        else
            System.out.println("[!!!] Parabens ao Computador [!!!]");
    }

    private char definirJogador()
    {
        char[] escolha = new char[] {'X', 'O'};
        return escolha[(int)(Math.random() * 1)];
        
    }
    
    private int usuarioJogada()
    {
        System.out.print("Tua jogada\\> ");
        int jogada = input.nextInt();
        while(!possivel(jogada)){
            System.out.println("Jogada Illegal ");
            System.out.print("Tua jogada\\> ");
            jogada = input.nextInt();
            
        }        
       return jogada;
    }

    /**
     * Escolher o primeiro lugar disponivel
     * @return 
     */
    private int[] computador_jogada_a() {
        for (int i = 0; i < LIN; i++)
            for (int j = 0; j < COL; j++) 
                if (tabela[i][j] == BLANK)
                    return new int[]{i, j};
        return null;
    }

    
    /**
     * Escolher qualquer lugar aleatorio disponivel
     * 
     * @return matriz com coordenadas de onde colocar dados
     */
    
    
    private char troca_jogador(char dado)
    {
        if (dado == 'X') // humano
            return 'O';
       
        return 'X';
    }
    private int[][] computador_jogada_b() {
        int[][] array = null;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) 
                if (tabela[i][j] == BLANK)
                    array[i] = new int[]{i, j};
        return array;
    }

    public Jogador registarJogador()
    {
        char dado;
        System.out.print("Jogador nome: \\> ");
        String nome = input.next();
        Jogador player = new Jogador(nome);

        System.out.println("Escolha Dados"
                + "\n1 -- X"
                + "\n2 -- O");
        if(input.nextInt() == 1)
            dado = 'X';
        else
            dado = 'O';
        player.setDado(dado);
        
        return player;
    }

    private int[] getCoordenadas(int jogada)
    {
        switch(jogada) {
            /* retornar -- linha -- coluna*/
            case 1: return new int[]{0, 0};
            case 2: return new int[]{0, 1};
            case 3: return new int[]{0, 2};
            case 4: return new int[]{1, 0};
            case 5: return new int[]{1, 1};
            case 6: return new int[]{1, 2};
            case 7: return new int[]{2, 0};
            case 8: return new int[]{2, 1};
            case 9: return new int[]{2, 2};

        }
        return null;
    }
    
    /**
     * 
     * @param jogada
     * @return 
     */
    private boolean possivel(int jogada) {
        int[] coordenda;
        if ((coordenda = getCoordenadas(jogada)) == null)
            return false;
        return tabela[coordenda[0]][coordenda[1]] == '_';
    }
    
    
    
    /**
     * movimentar dado para uma posicao e 
     * actualizar tabela
     */
    
    private void actualizar_tabela(int jogada, char jogador)
    {
        int[] xy = getCoordenadas(jogada);
        if (jogador == 'X')
            this.tabela[xy[0]][xy[1]] = 'X';
        else 
            this.tabela[xy[0]][xy[1]] = 'O';            
    }
    
    private void actualizar_tabela(int[] xy, char jogador)
    {
        if (jogador == 'X')
            this.tabela[xy[0]][xy[1]] = 'X';
        else 
            this.tabela[xy[0]][xy[1]] = 'O';            
    }
    
    private boolean vencedor(char jogador)
    {
        return vence_linha(jogador) || vence_coluna(jogador) ||
                vence_diagonais(jogador);
    }

    private boolean vence_diagonais(char jogador) {
        boolean vence_diag1 = true;
        boolean vence_diag2 = true;
        for (int i = 0; i < LIN; i++) {
            vence_diag1 = vence_diag1 && (tabela[i][i] == jogador);
            vence_diag2 = vence_diag2 && (tabela[i][(COL-1)-i] == jogador);
        }
        return vence_diag1 || vence_diag2;
    }

    /**
     * Percorrer todas as linhas verificando se o jogador ganhou
     * @param jogador -- computador ou humano ( X - O) ou (O - X)
     * @return 
     */
    private boolean vence_linha(char jogador) {
        for (int i = 0; i < LIN; i++) {
            boolean vence = true;
            for (int j = 0; j < COL; j++) {
                vence = vence && (tabela[i][j] == jogador); //(Hackeando a Logica) Sera true apenas se o dado do jogador estiver em todas posicoes                 
                
            }
            if (vence)
                return true;
        }
        return false;
    }

    /**
     * Percorrer cada coluna verificando se o jogador ganhou
     * @return true - Se tiver ganho
     */
    private boolean vence_coluna(char jogador) {
        for (int i = 0; i < COL; i++) {
            boolean vence = true;
            for (int j = 0; j < LIN; j++)
                vence = vence && (tabela[j][i] == jogador); //(Hackeando a Logica) Sera true apenas se o dado do jogador estiver em todas posicoes                 
            if (vence)
                return true;
        }

        
        return false;
    }

    
    /**
     * Percorrer a matriz procurando por algum espaco vazio
     * se encontrado, entao o jogo continua caso 
     * contrario empate (depois de verificado se houve algum vencedor)
     * @return true - Se for empate ou o jogo continua
     */
    private boolean empate(){
        for (int i = 0; i < COL; i++) 
            for (int j = 0; j < LIN; j++)
                if (tabela[i][j] == BLANK)
                    return false;
        return true;
    }
    
    
    
    
    /***
     * Exercicio final: fazer com que o computador sempre ganhe
     * 
     * Montar uma estrategia para melhorar o desempenho do computador
     * antes de escolher uma posicao. Verificar algumas hipoteses de movimentos
     * possiveis dependendo do estado actual do jogo
     */
    
    
    private int[] computador_jogada_c() {
        int[] xy = new int[] {0};
        if (computadorGanha())
            // jogar nessa possicao
            System.out.println("jogar ai");
        else if (humanoGanha())
            // bloquear
            System.out.println("bloquear");
        else if (livreCentro())
            // jogar no centro
            System.out.println("jogar no canto");
        else if (livreCanto())
            // canto
            System.out.println("jogar no canto");
        
       return xy;
    }

    
    /**
     * Em breve
     * @return 
     */
    private boolean computadorGanha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean humanoGanha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean livreCanto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean livreCentro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


/**
 * Dados dos jogadores tanto humano como computador
 * @author root
 */
class Jogador {
    String tipo;
    String nome;
    int pontos;
    int perdas;
    int totalJogo;
    char dado;


    public Jogador(String nome) {
        this.nome = nome;
    }

    public char getDado() {
        return dado;
    }

    public void setDado(char dado) {
        this.dado = dado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }


    public int getPerdas() {
        return perdas;
    }

    public void setPerdas(int perdas) {
        this.perdas = perdas;
    }

    public int getTotalJogo() {
        return totalJogo;
    }

    private String string;

    public void setTotalJogo(int totalJogo) {
        this.totalJogo = totalJogo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Jogador{" + "tipo=" + tipo + ", nome=" + nome + ", pontos=" + pontos + ", perdas=" + perdas + ", totalJogo=" + totalJogo + ", dado=" + dado + ", string=" + string + '}';
    }
    
    
   
    
}
