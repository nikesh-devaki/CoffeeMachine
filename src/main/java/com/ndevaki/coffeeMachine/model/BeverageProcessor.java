package com.ndevaki.coffeeMachine.model;

import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;

class BeverageProcessor {
   private static final Stock ingrediantStock =new Stock();

   public static void loadBreverage(String ingrediantName,int qty) throws InvalidInputException {
       ingrediantStock.addIngrediantToStock(ingrediantName,qty);
       return;
   }

   protected static String prepare(String beverageName) throws InvalidInputException {
       Beverage beverage=getBeverage(beverageName);
       List<Ingrediants> lessQty=checkQuantity(beverage);
       if(!lessQty.isEmpty()){
           return constructMessage(lessQty);
       }
        updateQuantity(beverage);
        return beverage.getName()+" is prepared";
   }

   protected static ArrayList<Ingrediants> checkQuantity(Beverage beverage){
       ArrayList<Ingrediants> lessQty=new ArrayList<>();
       for(Ingrediants ingrediant:beverage.getIngrediants()){
           int minQty=beverage.minQuantity(ingrediant);
           if(minQty>ingrediantStock.getAvialableQty(ingrediant)){
               lessQty.add(ingrediant);
           }
       }
       return lessQty;
   }

   protected static void  updateQuantity(Beverage beverage){
       for(Ingrediants ingrediant:beverage.getIngrediants()){
           ingrediantStock.consume(ingrediant,beverage.minQuantity(ingrediant));
       }
   }

   protected static String constructMessage(List<Ingrediants> ingrediants){
       StringBuilder message=new StringBuilder("");
       for(Ingrediants ingrediant:ingrediants){
           message.append(ingrediant.label+",");
       }
       message.append(" are not available in sufficent quantity");
       return  message.toString();
   }

   private static Beverage getBeverage(String name) throws InvalidInputException {
       Beverage beverage;
       switch(name){
           case "HotCoffee":
               return new HotCoffee();
           case "HotTea":
               return new HotTea();
           default:
               throw new InvalidInputException("INvalid beverage name");
       }

   }
}
