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
    private int face,totalDado;
    private boolean feated;
    
    public Dado() {
        totalDado=0;
        feated=false;
    }

    public int getTotalDado() {
        return totalDado;
    }

    public int getFace() {
        return face;
    }

    public void lancaDado() {
        this.face = 1 + (int)(Math.random() * ((6 - 1) + 1));
        totalDado += this.face;
    }
    
    public void clearSomatorio(){
        totalDado=0;
    }
    
    public boolean getFeated()
    {
        return feated;
    }
    
    public void setFeated(boolean b)
    {
        feated=b;
    }
    
    public boolean isMiss()
    {
        if(face==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Valor do Dado: " + face;
    }
    
    
    
}
