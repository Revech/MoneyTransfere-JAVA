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
public class Shop {
    
    private String name;
    private String pass;
    private double balance = 1000000;

    public Shop(String name, String pass, Double balance) {
        this.name = name;
        this.pass = pass;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    
    public String toString(){
        return this.name + "\t" + this.pass + "\t" + this.balance;
    }
}
