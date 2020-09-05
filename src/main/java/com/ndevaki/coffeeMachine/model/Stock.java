package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;
import com.ndevaki.coffeeMachine.model.ingrediant.*;

import java.util.HashMap;

public class Stock {

    HashMap<Ingrediant,Integer> ingrediants=new HashMap<Ingrediant,Integer>();

    public Ingrediant addIngrediantToStock(String name,int qty) throws InvalidInputException {
        Ingrediant ingrediant;
        switch(name){
            case "hot_water":
                ingrediant= new HotWater(name,qty);
                break;
            case "hot_milk":
                ingrediant= new HotMilk(name,qty);
                break;
            case "ginger_syrup":
                ingrediant= new GingerSyrup(name,qty);
                break;
            case "sugar_syrup":
                ingrediant= new SugarSyrup(name,qty);
                break;
            case "tea_leaves_syrup":
                ingrediant= new TeaLeavesSyrup(name,qty);
                break;
            default:
                throw new InvalidInputException("Invalid ingrediant");
        }
        if(ingrediants.containsKey(ingrediant)){
            ingrediants.put(ingrediant,ingrediants.get(ingrediant).intValue()+qty);
        }else{
            ingrediants.put(ingrediant,qty);
        }
        return ingrediant;
    }

    public int getAvialableQty(Ingrediant ingrediant){
        return ingrediants.get(ingrediant);
    }

    public void consume(Ingrediant ingrediant,int qty){
        //TODO: should not go negative.
        if(ingrediants.containsKey(ingrediant)){
            ingrediants.put(ingrediant,ingrediants.get(ingrediant)-qty);
        }
    }
}
