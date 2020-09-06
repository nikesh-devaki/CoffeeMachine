package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;

import java.util.HashMap;

 class Stock {

    HashMap<Ingrediants,Integer> ingrediants=new HashMap<Ingrediants,Integer>();

    public Ingrediants addIngrediantToStock(String name,int qty) throws InvalidInputException {
        Ingrediants ingrediant=Ingrediants.getIngrediant(name);
        if(ingrediants.containsKey(ingrediant)){
            ingrediants.put(ingrediant,ingrediants.get(ingrediant).intValue()+qty);
        }else{
            ingrediants.put(ingrediant,qty);
        }
        return ingrediant;
    }

    public int getAvialableQty(Ingrediants ingrediant){
        return ingrediants.get(ingrediant);
    }

    //Assuming its a single outlet coffee machine
    public void consume(Ingrediants ingrediant,int qty){
        if(ingrediants.containsKey(ingrediant)){
            ingrediants.put(ingrediant,ingrediants.get(ingrediant)-qty);
        }
    }
}
