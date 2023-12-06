/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Purchace {
    
    private String Name;
    private String Number;
    private String Type;
    private Double Price;

    public Purchace(String Name, String Number, String Type, Double Price) {
        this.Name = Name;
        this.Number = Number;
        this.Type = Type;
        this.Price = Price;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    @Override
    
    public String toString(){
        return this.Name + "\t" + this.Number + "\t" + this.Type + "\t" + this.Price;
    }
}
