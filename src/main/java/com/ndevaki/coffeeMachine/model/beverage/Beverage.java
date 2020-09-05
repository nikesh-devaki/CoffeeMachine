package com.ndevaki.coffeeMachine.model.beverage;

import com.ndevaki.coffeeMachine.model.ingrediant.Ingrediant;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class Beverage {
    private String name;
    private HashMap<Ingrediant,Integer> ingrediants=new HashMap<Ingrediant, Integer>();

    public Beverage(String name){
        this.name=name;
    }

    public Beverage createBeverage(String name,Ingrediant ingrediant,int minQuantity){
      this.name=name;
      addRecepie(ingrediant,minQuantity);
      return this;
    }
    private Beverage addRecepie(Ingrediant ingrediant,int minQuantity){
        ingrediants.put(ingrediant,minQuantity);
        return this;
    }

    public int minQuantity(Ingrediant ingrediant){
        return ingrediants.get(ingrediant);
    }
    public Set<Ingrediant> getIngrediants(){
        return ingrediants.keySet();
    }

    public String getName(){
        return name;
    }
}
