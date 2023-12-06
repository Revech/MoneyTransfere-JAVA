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
public class Customer {

    private String name;
    private String pass;
    private String number;
    private double balance = 0;

    public Customer(String name, String pass, String number, double balance) {
        this.name = name;
        this.pass = pass;
        this.number = number;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getNumber() {
        return number;
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

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



   @Override
   
   public String toString(){
       return this.name + "\t" + this.pass + "\t" + this.number + "\t" + this.balance;
   }
}
