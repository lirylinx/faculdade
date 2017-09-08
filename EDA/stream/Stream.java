package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import teste.SimCard;

/**
 *
 * @author root
 */
public class Stream {

    InputStream entrada;
    OutputStream saida;
    InputStreamReader reader;

    BufferedReader bufferReader; 
    BufferedReader bufferObjReader;
    
    /* para gravacao de objectos */
    ObjectOutputStream saidaObj;
    public ObjectInputStream entradaObj;
    FileOutputStream saidaFileObj;
    public FileInputStream  entradaFileObj;
    
    public List QueryResult = new ArrayList();
    String file;
    public Stream(String file) throws IOException {
        this.file = file;
        
        if (fileExists(file)) {
            this.file = file;
            /* Carregar ficheiro na memoria */
            entrada = new FileInputStream(file);
            entradaFileObj = new FileInputStream(file);
            reader = new InputStreamReader(entrada);          
            bufferReader = new BufferedReader(reader);
            entradaObj = new ObjectInputStream(entradaFileObj);
        } 
    }

    
    /**
     * Pegar o path e verificar se existe algum ficheiro ou directorio
     * @param path - caminho relativo ou absoluto do ficheiro 
     * @return True or False dependendo da existencia ou nao de algum ficheiro
     */
    private boolean fileExists(String target) {
        return Files.exists(Paths.get(target));         
    }
    
    /**
     * Carregar um ficheiro na memoria e retornar um buffer
     * @param file - ficheiro a ser carregado para a memoria
     * @return bufferReader - buffer com dados do ficheiro; NB fechar o buffer depois de uso
     * @throws FileNotFoundException 
     */
    public String fileReader() throws FileNotFoundException {
        
        String line = null;
        try {
            line = bufferReader.readLine();
        } catch(IOException e) {
            System.err.println("[ERRO]Na leitura de caracteres: " + e);
        }
        if (line == null)
            return null;
        return line;
    }
    

    
    public int fileWriter(String path, String content) throws IOException {
        try {
            OutputStream saida = new FileOutputStream(path);
        } catch(FileNotFoundException e) {
            System.out.println("[ERRO] Na criacao de ficheiro: " + e);
        } finally {
            saida.close();
        }
        OutputStreamWriter writer = new OutputStreamWriter(saida);
        BufferedWriter bufwt = new BufferedWriter(writer);
        
        bufwt.write(content);
        bufwt.close();
        
        return 0;
    }
    
    public void fileObjWriter(Object objecto, String destino) {        
        
        try {
            saidaFileObj = new FileOutputStream(destino, true);
        } catch (FileNotFoundException ex) {
            System.err.println("[ERRO] Nao foi possivel criar ficheiro: " + ex.getMessage());
        }
        
        try {
            saidaObj = new ObjectOutputStream(saidaFileObj);//  ObjectOutputStream(saidaFileObj);
        } catch (IOException ex) {
            System.err.println("[ERRO]: " + ex.getMessage());
        }

        try {
            saidaObj.writeObject(objecto);
        } catch (IOException ex) {
            System.err.println("[ERRO] Na serializacao do objecto: " + ex.getMessage());
        }
    }
    public List fileObjReader() throws FileNotFoundException {
        
        Object obj = 0;
        while(true) {
            try {
                obj = entradaObj.readObject();
                QueryResult.add(obj);
                System.err.println(obj.toString());
            } catch (IOException ex) {
                System.err.println("[ERRO]Na leitura do ficheiro: " + ex.getMessage());
                break;
            } catch (ClassNotFoundException ex) {
                System.err.println("[ERRO] Conteudo nao suportado: " + ex.getMessage());
                break;
            }
        }    
        return QueryResult;
    }

    public void terminar() {
        try {
            entradaObj.close();
        } catch (IOException ex) {
            System.err.println("[ERRO] Ao fechar Base de Dados: " + ex.getMessage());
        }
        
    }
    
}
