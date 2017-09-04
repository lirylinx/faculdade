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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Stream {

    InputStream entrada;
    OutputStream saida;
    InputStreamReader reader;
    BufferedReader bufferReader; 
    
    /* para gravacao de objectos */
    ObjectOutputStream saidaObj;
    ObjectInputStream entradaObj;
    FileOutputStream saidaFileObj;
    FileInputStream  entradaFileObj;
    String file;

    
    public Stream(String file) {
        this.file = file;
        
        if (fileExists(file)) {

            try {
                /* Carregar ficheiro na memoria */
                entrada = new FileInputStream(file);
                entradaFileObj = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Stream.class.getName()).log(Level.SEVERE, null, ex);
            }

            reader = new InputStreamReader(entrada);          
            bufferReader = new BufferedReader(reader);

            try {
                entradaObj = new ObjectInputStream(entradaFileObj);
            } catch (IOException ex) {
                Logger.getLogger(Stream.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            OutputStream saida = new FileOutputStream(path, true);
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
            System.err.println("[ERRO]: Ao criar objecto saidaObj" + ex.getMessage());
        }

        try {
            saidaObj.writeObject(objecto);
        } catch (IOException ex) {
            System.err.println("[ERRO] fileObjWriter\nNa serializacao do objecto: " + ex.getMessage());
        }
        
    }
    public Object fileObjReader() throws FileNotFoundException {
        Object obj = 0;

        try {
            obj = (Object) entradaObj.readObject();
        } catch (IOException ex) {
            System.err.println("[ERRO] Na entrada e Saida: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("[ERRO] Classe nao encontrada: " + ex.getMessage());
        }
        
        return obj;
    }

    
    public void terminar(){
        try {
            bufferReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Stream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
