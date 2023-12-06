/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Login;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author User
 */
public class AppControl {
    
    FileAccess fA;
 
    public AppControl() {
        fA = new FileAccess();
    }
    
    public boolean addCustomer(String name, String number, String pass, Double balance) {
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i < allcustomers.size(); i++) {
            if (allcustomers.get(i).getName().equals(name) || allcustomers.get(i).getNumber().equals(number)) 
                return (false);
        }
        Customer c = new Customer(name, pass, number, balance);
        fA.writeToFile("customer", c.toString() + "\n");
        return (true);
        
    }
    
    public boolean addShop(String name, String pass, double balance) {
        ArrayList<Shop> allshops = fA.readShops();
        for (int i = 0; i < allshops.size(); i++) {
            if (allshops.get(i).getName().equals(name)) 
                return (false);
        }
        Shop s = new Shop(name, pass, balance);
        fA.writeToFile("shop", s.toString() + "\n");
        return (true);
        
    }
    
    public void reduceBalance (String name, Double amount){
        
        ArrayList<Customer> c = fA.readCustomers();
        fA.resetfile("customer");
        for (int i = 0; i < c.size(); i++){
            if (c.get(i).getName().equals(name))
            {
                Double b = c.get(i).getBalance();
                b = b - amount;
                c.get(i).setBalance(b);
            }
            fA.writeToFile("customer", c.get(i).toString() + "\n");
        }
    }
    
    public void reduceShopBalance (String name, Double amount){
        
        ArrayList<Shop> s = fA.readShops();
        fA.resetfile("shop");
        for (int i = 0; i < s.size(); i++){
            if (s.get(i).getName().equals(name))
            {
                Double b = s.get(i).getBalance();
                b = b - amount;
                s.get(i).setBalance(b);
            }
            fA.writeToFile("shop", s.get(i).toString() + "\n");
        }
    }
    
    public String getCustomerName(String number){
        String s = "";
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i<allcustomers.size(); i++)
            if(allcustomers.get(i).getNumber().equals(number))
                s =  allcustomers.get(i).getName();
        return s;
    }
    
    public String getCustomerNumber(String name){
        String s = "";
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i<allcustomers.size(); i++)
            if(allcustomers.get(i).getName().equals(name))
                s =  allcustomers.get(i).getNumber();
        return s;
    }
   
    public boolean CheckCustomer(String name, String pnumber, String pass) {
        boolean r = false;
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i < allcustomers.size(); i++) {
            if (allcustomers.get(i).getName().equals(name) || allcustomers.get(i).getNumber().equals(pnumber)) {
                if (allcustomers.get(i).getPass().equals(pass))
                 r = true;
            }
        }
        return r;
    }
    
    public boolean CheckShop(String name, String pass) {
        boolean r = false;
        ArrayList<Shop> allshops = fA.readShops();
        for (int i = 0; i < allshops.size(); i++) {
            if (allshops.get(i).getName().equals(name) && allshops.get(i).getPass().equals(pass)) {
                 r = true;
            }
        }
        return r;
    }
    
    public boolean CheckCust(String pnumber) {
        boolean r = false;
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i < allcustomers.size(); i++) {
            if (allcustomers.get(i).getNumber().equals(pnumber)) {
                 r = true;
            }
        }
        return r;
    }
    
    public Double getBalance(String name){
        Double b = 0.0;
        ArrayList<Customer> allcustomer = fA.readCustomers();
        for (int i = 0; i<allcustomer.size(); i++)
            if (allcustomer.get(i).getName().equals(name))
                b = allcustomer.get(i).getBalance();
        return b;
    }
    
    public Double getShopBalance(String name){
        double b = 1000000;
        ArrayList<Shop> allshops = fA.readShops();
        for (int i = 0; i<allshops.size(); i++)
            if (allshops.get(i).getName().equals(name))
                b = allshops.get(i).getBalance();
        return b;
    }
    
    public void addBalance(String name, String number, Double balance){
        ArrayList<Customer> allcustomers = fA.readCustomers();
        fA.resetfile("customer");
        for (int i = 0; i<allcustomers.size(); i++){
            if (allcustomers.get(i).getName().equals(name))
            {
                Double n = allcustomers.get(i).getBalance();
                n += balance;
                allcustomers.get(i).setBalance(n);
            }
        fA.writeToFile("customer", allcustomers.get(i).toString() + "\n");}
    }
    
    public void addShopBalance(String name, Double balance){
        ArrayList<Shop> allshops = fA.readShops();
        fA.resetfile("shop");
        for (int i = 0; i<allshops.size(); i++){
            if (allshops.get(i).getName().equals(name))
            {
                Double n = allshops.get(i).getBalance();
                n += balance;
                allshops.get(i).setBalance(n);
            }
        fA.writeToFile("shop", allshops.get(i).toString() + "\n");}
    }
    
    public boolean checkNumber (String number){
        boolean s = false;
        ArrayList<Customer> allcustomers = fA.readCustomers();
        for (int i = 0; i < allcustomers.size(); i++){
            if (allcustomers.get(i).getNumber().equals(number))
                s = true;
           }
       return s;
    }
    
    public boolean checkNum(String number){
        try {
        int Value = Integer.parseInt(number);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }
    public void addPurchace(String name, String number, String type, Double price){
        Purchace p = new Purchace(name, number, type,  price);
        fA.writeToFile(Login.activeShop + ".shop", p.toString() + "\n");
    }
    
    public void addCustomerPurchace(String name, String number, String type, Double price){
        Purchace p = new Purchace(name, number, type,  price);
        fA.writeToFile(Login.activeCustomer + ".customer", p.toString() + "\n");
    }
    
    public String PrintAllShopPurchaces(String name) {
        String s = "";
        ArrayList<Purchace> allpurchaces = fA.readPurchaces(name+".shop");
        for (int i = 0; i < allpurchaces.size(); i++) {
            s = s + allpurchaces.get(i).toString() + "\n";
        }
        return s;
    }
    public String PrintAllCustomerPurchaces(String name) {
        String s = "";
        ArrayList<Purchace> allpurchaces = fA.readPurchaces(name+".customer");
        for (int i = 0; i < allpurchaces.size(); i++) {
            s = s + allpurchaces.get(i).toString() + "\n";
        }
        return s;
    }
}
