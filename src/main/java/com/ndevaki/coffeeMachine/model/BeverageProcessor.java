package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.beverage.Beverage;
import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;
import com.ndevaki.coffeeMachine.model.ingrediant.Ingrediant;

import java.util.ArrayList;
import java.util.List;

public class BeverageProcessor {
   private static final Stock ingrediantStock =new Stock();

   public static void loadBreverage(String ingrediantName,int qty) throws InvalidInputException {
       ingrediantStock.addIngrediantToStock(ingrediantName,qty);
       return;
   }
   public static String prepare(String beverageName){
       Beverage beverage=getBeverage(beverageName);
       List<Ingrediant> lessQty=checkQuantity(beverage);
       if(!lessQty.isEmpty()){
           return constructMessage(lessQty);
       }
        updateQuantity(beverage);
        return beverageName.getName()+" is prepared";
   }

   protected static ArrayList<Ingrediant> checkQuantity(Beverage beverage){
       ArrayList<Ingrediant> lessQty=new ArrayList<>();
       for(Ingrediant ingrediant:beverage.getIngrediants()){
           int minQty=beverage.minQuantity(ingrediant);
           if(minQty>ingrediantStock.getAvialableQty(ingrediant)){
               lessQty.add(ingrediant);
           }
       }
       return lessQty;
   }

   protected static void  updateQuantity(Beverage beverage){
       for(Ingrediant ingrediant:beverage.getIngrediants()){
           ingrediantStock.consume(ingrediant,beverage.minQuantity(ingrediant));
       }
   }

   protected String constructMessage(ArrayList<Ingrediant> ingrediants){
       StringBuilder message=new StringBuilder("")
       for(Ingrediant ingrediant:ingrediants){
           message.append("")
       }
   }
}
