
package pessoa;

/**
 * Super classe Pessoa
 * @author root
 */
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    
    public Pessoa() {
        this.nome = "Indefinido";
        this.idade = -1;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\nidade: " + idade + '\n';
    }
    
    
    
}
