
package ficha4;

import java.util.Scanner;
import java.util.Vector;

/**
 * Exercicio 3
 * Faculdade DMI
 *  Ler numero de estudante de uma turma registar os estudantes
 * e as notas dos tres 3 testes feitos de cada estudante.
 * De seguida calcular e exibir as medias das notas de cada turma
 * e exibir a melhor ou melhores media(em caso de empate) dos estudantes 
 *  
 * @author root
 */
public class UemDmiEx3 {
    /* Lista de turma que a DMI possui */
    Vector<Turma> Turmas;    
    
    /* lista dos estudantes para turma */
    private Vector<Estudante> Estudantes;
//    Scanner input;
    Scanner input;

    public UemDmiEx3() {
    }
    
    public double calcular_media(Vector<Double> notas)
    {
        if (notas.size() < 1)
            return -1;
        double media = 0.0;
        Double soma = 0.0;
        int nr_teste = notas.size();
        for (int i = 0; i < notas.size(); i++){
            soma += notas.get(i);
        }
        media = soma / nr_teste;
        return (double) media;
    }
    
    public void registar()
    {
        input = new Scanner(System.in);
        System.out.println("Quantas turmas a registar ?");
        int qtdTurma = input.nextInt();
        Turmas = new Vector<>(qtdTurma);
        for (int i = 0; i < qtdTurma; i++) {
            System.out.println("Quantos Estudantes para turma " + (i+1));
            int qtdEstudante = input.nextInt();
            Estudantes = new Vector<>(qtdEstudante);
            for (int j = 0; j < qtdEstudante; j++) {
                Estudante estudante = new Estudante(j);
                System.out.println("Nota para estudante " + (j+1) + " \\> ");
                for (int k = 0; k < 3; k++) {
                    System.out.print("Nota[" + (k+1) + "] \\> ");
                    double nota = input.nextDouble();
                    estudante.getNotas().add(k, nota);
                }
                estudante.setMedia(calcular_media(estudante.getNotas()));
//                Estudante estudante = new Estudante(i, Turmas, i)
                Estudantes.add(estudante);
            }
            Turma turma = new Turma(i, Estudantes);
            Turmas.add(turma);
        }
        

    }
}


/**
 * Cada turma possui um vetor ou lista de estudantes registado
 * @author root
 */
class Turma {
    int id;
    Vector<Estudante> estudantes;
    int totalEstudantes;
    public Turma() {
    }

    public Turma(int id, Vector<Estudante> estudantes) {
        this.id = id;
        this.estudantes = estudantes;
        
        totalEstudantes = this.estudantes.size();
    }

    public Vector<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(Vector<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void printEstudantes()
    {
        for(Estudante estud : this.estudantes) 
            System.out.println(estud.toString());
    }
    
    /**
     * Percorrer a lista de estudante filtrando estudante com melhor
     * media ou estudantes em caso de empate
     * @return 
     */
    public Vector<Estudante> getEstudanteMelhorMedia()
    {
        int count = 0; // contar numero de estudantes com melhor media
        Vector posicao = new Vector(); // armazenar as posicoes do array com melhores estudante
        double maxMedia = 0.0;
        Vector<Estudante> melhores = new Vector<>();
        for(int i = 0; i < this.estudantes.size(); i++)         
            if (estudantes.get(i).getMedia() > maxMedia) {
                maxMedia = estudantes.get(i).getMedia();
                
                // Se o estudante actual for melhor que o anterior
                // limpar a lista e regravar o novo estudante com melhor media
                if (melhores.size() > 0)
                    melhores.removeAllElements();
                melhores.add(0, estudantes.get(i)); 
                count = 0;
                posicao.removeAllElements();
            } else if (estudantes.get(i).getMedia() == maxMedia) 
                melhores.add(++count, estudantes.get(i));
            
        
        /* Se count for igual a 0
            A turma so possui um Estudante com melhor media sem empate
        */        
//        
//        if (count == 0)
//            melhores.add(null)
     
        
        return melhores;
    }
    
    public void showEstudanteMelhorMedia() 
    {
        System.out.println("Melhor(es) estudante(s)");        
        for (Estudante estudante : getEstudanteMelhorMedia())
        {
            System.out.println(estudante.toString());
        }
    }
    
    

    @Override
    public String toString() {
        return "\tTurma" + 
                "\nID: " + id + 
                "\ntotalEstudantes: " + totalEstudantes;
    }

    

}


/**
 * Cada Estudante tem um id nome as notas dos testes feitos e a sua Media
 * 
 * @author root
 */
class Estudante {
    public int id;
    public String nome;
    public Vector<Double> notas;
    double media;

    public Estudante(int id) {
        this.id = id;
        this.nome = "#TODO";
        this.notas = new Vector<Double>();
        this.media = 0.0;
    }

    
    
    public Estudante(int id, Vector notas, double media) {
        this.id = id;
        this.nome = nome = "#TODO";
        this.notas = notas;
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vector<Double> getNotas() {
        return notas;
    }

    public void setNotas(Vector<Double> notas) {
        this.notas = notas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "\tEstudante" + 
                "\tid: " + id +
                "\nnome: " + nome + 
                "\nnotas: " + notas.get(0) + " " + notas.get(1) + " " + notas.get(2) +
                "\nmedia: " + media;
    }

    


}


