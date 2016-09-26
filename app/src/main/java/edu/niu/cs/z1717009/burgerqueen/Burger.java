package edu.niu.cs.z1717009.burgerqueen;

/**
 * Created by z1717009 on 2/9/2016.
 */
public class Burger {
    // constants
    static final int BACON =86, VEGGIE = 150, TURKEY = 170 , CHICKEN = 160,
            CHEDDAR = 100, MOZZARELLA = 86;

    private int pattyCalories, baconCalories, cheeseCalories, sauceCalories;

    public Burger(){
        pattyCalories = VEGGIE;
        baconCalories=0;
        cheeseCalories=0;
        sauceCalories=0;
    }

    public void setPattyCalories(int pattyCalories) {
        this.pattyCalories = pattyCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        baconCalories=0;
        if(hasBacon)this.baconCalories = BACON;
    }

    public void setCheeseCalories(int cheeseCalories) {
        this.cheeseCalories = cheeseCalories;
    }

    public void setSauceCalories(int sauceCalories) {
        this.sauceCalories = sauceCalories;
    }

    public int getCalories(){
        return sauceCalories+pattyCalories+cheeseCalories+baconCalories;
    }
}
