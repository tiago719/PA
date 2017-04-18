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
public class GameData implements Constants{
    private int dificuldade, startingArea, armor, hp, gold, food, rank, areaL/*level*/, areaC;

    public int getAreaL() {
        return areaL;
    }

    public void setAreaL(int areaL) {
        this.areaL = areaL;
    }

    public int getAreaC() {
        return areaC;
    }

    public void setAreaC(int areaC) {
        this.areaC = areaC;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getStartingArea() {
        return startingArea;
    }

    public void setStartingArea(int startingArea) {
        this.startingArea = startingArea;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public GameData()
    {
        rank = 0;
        startingArea=0;
        dificuldade=2;
        coluna=1;
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }

    void setDifficultLevel(Integer dificuldade) {
        this.dificuldade = dificuldade;
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }

    void setStartingArea(Integer area) {
        startingArea = area;
    }

    public boolean intialize() {
        //TODO: iniciar variaveis necessarias (para agora nao estou a ver nenhuma)
        return true;
    }
    
    public int getNivel()
    {
        return areaL;
    }
    
    public boolean isLastArea(){
        return MapaNiveis[areaL].length == areaC;                        
    }

    public boolean addFood(int i) {
        if (food < 6){
            food += i;
            return true;
        }
        else return false;
    }

    public boolean addHealth(int i) {
        if (hp < 20){
            hp += i;
            return true;
        }
        else return false;
    }

    public boolean addXP(int i) {
        rank += i;
        return true;
        //TODO: ENTENDER A CENA DO XP E RANKS ...
    }
    
    public int getColuna()
    {
        return coluna;
    }
}
