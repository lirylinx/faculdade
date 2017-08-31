
package pessoa;

/**
 *  Classe Conhecido herdando valores da super classe pessoa e possuindo 
 * @var email como atributo proprio
 * @author root
 */
public class Conhecido extends Pessoa{
     
    public String email;

    /**
     *   Construtor vazio inicializando atributo email 
     * com valor padrao "Indefinido"
     * 
     */
    public Conhecido() {
        this.email = "Indefinido";
    }

    /**
     * obter o email do objecto conhecido
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Definir um valor ao atributo email do objecto Conhecido
     * @param email - String com email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
