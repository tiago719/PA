/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author edu_f
 */
public class Dado {
    private int face;
    private int somatorio;
    
    public Dado() {
        somatorio=0;
    }

    public int getFace() {
        return face;
    }

    public void setValor(int valor) {
        this.face = valor;
    }
    
    public void addSomatorio(int i){
        somatorio+=i;
    }
    
    public void clearSomatorio(){
        somatorio=0;
    }
    
    @Override
    public String toString(){
        return "Valor do Dado: " + face;
    }
    
    
    
}
