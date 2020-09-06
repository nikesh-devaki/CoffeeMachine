package com.ndevaki.coffeeMachine.model;

import java.util.HashMap;
import java.util.Set;

 abstract class Beverage {
    private String name;
    private HashMap<Ingrediants,Integer> ingrediants=new HashMap<Ingrediants, Integer>();

    Beverage createBeverage(String name,Ingrediants ingrediant,int minQuantity){
      this.name=name;
      addRecepie(ingrediant,minQuantity);
      return this;
    }
    private Beverage addRecepie(Ingrediants ingrediant,int minQuantity){
        ingrediants.put(ingrediant,minQuantity);
        return this;
    }

    int minQuantity(Ingrediants ingrediant){
        return ingrediants.get(ingrediant);
    }
    Set<Ingrediants> getIngrediants(){
        return ingrediants.keySet();
    }

    String getName(){
        return name;
    }
}
