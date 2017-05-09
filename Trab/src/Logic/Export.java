/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author edu_f
 */
public class Export {

    public ObjectOutputStream abreFObjectosEscrita(String nome) throws IOException {
        try {
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome));
            return out;
        } catch (IOException e) {
            System.out.println("Erro ao abrir o ficheiro " + nome);
            throw e;
        }
    }

    public ObjectInputStream abreFObjectosLeitura(String nome) throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome));
            return in;
        } catch (IOException e) {
            System.out.println("Erro ao abrir o ficheiro " + nome);
            throw e;
        }
    }
    
    
    public void asd(){
        
    }
}
