package com.ndevaki.coffeeMachine.client;

import com.ndevaki.coffeeMachine.model.CoffeeMachine;
import com.ndevaki.coffeeMachine.model.exception.InvalidInputException;

import java.util.Scanner;

public class Client {
   private static CoffeeMachine machine;

   public static void main(String[] args) throws Exception {
      Scanner scanner=new Scanner(System.in);
      machine=CoffeeMachine.turnOn();
      machine.loadIngrediant("Hot_Milk",50)
             .loadIngrediant("Hot_Water",50)
             .loadIngrediant("SugarSyrup",50);

      System.out.println(machine.prepareBreverage("HotCoffee"));
      System.out.println(machine.prepareBreverage("HotTea"));
      System.out.println(machine.prepareBreverage("HotCoffee"));
   }
}
