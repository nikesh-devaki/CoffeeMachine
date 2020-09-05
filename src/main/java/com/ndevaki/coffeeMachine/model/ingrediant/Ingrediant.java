package com.ndevaki.coffeeMachine.model.ingrediant;

public abstract class Ingrediant {
    private String name;
    private int quantity;

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    protected Ingrediant(String name, int qty){
        setName(this.name);
        setQuantity(quantity);
    }
//     public  abstract static createIngrediant(String name,int qty);

    private void setName(String name){
        this.name=name;
    }

    private void setQuantity(int qty){
        this.quantity=qty;
    }

}
