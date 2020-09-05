package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;

public class CoffeeMachine {
    private static CoffeeMachine coffeeMachine;
    private CoffeeMachine(){
    }

    public static CoffeeMachine turnOn(){
        if(coffeeMachine!=null){
            coffeeMachine = new CoffeeMachine();
        }
        return coffeeMachine;
    }

    //Assuming unlimited qty can be stored
    public CoffeeMachine loadIngrediant(String ingrediantName,int qty) throws InvalidInputException {
        BeverageProcessor.loadBreverage(ingrediantName,qty);
        return this;
    }

    public String prepareBreverage(String name) throws Exception{
        String message =BeverageProcessor.prepare(name);
        return message;
    }

}
