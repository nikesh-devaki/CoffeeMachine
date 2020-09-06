package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;

public enum Ingrediants {
    HOT_MILK("HotMilk"),
    HOT_WATER("HotWater"),
    SUGAR_SYRUP("SugarSyrup"),
    TEA_LEAVES_SYRUP("TeaLeavesSyrup"),
    GINGER_SYRUP("Ginger Syrup");

    String label;

    Ingrediants(String ingrediantName) {
        this.label=ingrediantName;
    }

    public static Ingrediants getIngrediant(String name) throws InvalidInputException {
        Ingrediants ingrediant;
        switch(name){
            case "hot_water":
                ingrediant= Ingrediants.HOT_WATER;
                break;
            case "hot_milk":
                ingrediant= Ingrediants.HOT_MILK;
                break;
            case "ginger_syrup":
                ingrediant= Ingrediants.GINGER_SYRUP;
                break;
            case "sugar_syrup":
                ingrediant= Ingrediants.SUGAR_SYRUP;
                break;
            case "tea_leaves_syrup":
                ingrediant=Ingrediants.TEA_LEAVES_SYRUP;
                break;
            default:
                throw new InvalidInputException("Invalid ingrediant "+name);
        }
        return ingrediant;
    }
}
