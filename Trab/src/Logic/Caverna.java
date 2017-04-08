/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Tiago Coutinho
 */
public class Caverna {
    private int area, nivel;
    
    public Caverna()
    {
        area=1;
        nivel=1;
    }
    
    public Caverna(int area)
    {
        this.area=area;
        //TODO: como fazer a cena dos niveis??
    }
    
    public int getArea()
    {
        return area;
    }
    
    public int getNivel()
    {
        return nivel;
    }
}
