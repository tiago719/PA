package Logic;

import java.io.Serializable;


public class Dado implements Serializable {
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
    
    public void setDado(int val)
    {
        face=val;
        totalDado+=face;
    }
    
    public void clearSomatorio(){
        totalDado=0;
    }
    
    public void addSomatorio(int i){
        totalDado+=i;
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
        return "Face do Dado: " + face + " | Somatorio: " + totalDado;
    }
    
    
    
}
