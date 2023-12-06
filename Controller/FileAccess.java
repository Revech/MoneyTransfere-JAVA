/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Login;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author User
 */
public class FileAccess {

    public void writeToFile(String fileName, String str) {
        try {
            FileWriter fw = new FileWriter(fileName + ".txt", true);
            fw.write(str);
            fw.close();
        } catch (IOException ioe) {
        }
    }

    public ArrayList<Customer> readCustomers() {

        ArrayList<Customer> allcustomers = new ArrayList();
        String line;
        String cinfo[];
        try {
            FileInputStream fs = new FileInputStream("customer.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                cinfo = line.split("\t");
                Customer r = new Customer(cinfo[0], cinfo[1], cinfo[2], Double.parseDouble(cinfo[3]));
                allcustomers.add(r);
            }
            in.close();
        } catch (IOException e) {
        }

        return allcustomers;
    }
    
    public ArrayList<Shop> readShops() {

        ArrayList<Shop> allShops = new ArrayList();
        String line;
        String cinfo[];
        try {
            FileInputStream fs = new FileInputStream("shop.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                cinfo = line.split("\t");
                Shop r = new Shop(cinfo[0], cinfo[1], Double.parseDouble(cinfo[2]));
                allShops.add(r);
            }
            in.close();
        } catch (IOException e) {
        }

        return allShops;
    }

    public ArrayList<Purchace> readPurchaces(String name) {

        ArrayList<Purchace> allpurchaces = new ArrayList();
        String line;
        String info[];
        try {
            FileInputStream fs = new FileInputStream(name + ".txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                info = line.split("\t");
                Purchace p = new Purchace(info[0], info[1], info[2], Double.parseDouble(info[3]));
                allpurchaces.add(p);
            }
            in.close();
        } catch (IOException e) {
        }
        return allpurchaces;

    }

    public void resetfile(String fileName) {
        try {
            FileWriter stdinf = new FileWriter(fileName + ".txt", false);
            stdinf.close();
        } catch (IOException ioe) {
        }
    }

   /* public String[][] getCustomerInfo(int rowCount) {
        String[][] data = new String[rowCount][4];
        String cinfo[];
        String line = "";
        int row = 0;
        try {
            FileInputStream fs = new FileInputStream("items.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                cinfo = line.split("\t");
                data[row][0] = cinfo[0];
                data[row][1] = cinfo[1];
                data[row][2] = cinfo[2];
                //  for (int j = 0; j < 3; j++)
                //    System.arraycopy(cinfo, j, data[row], j, 1);
                if (cinfo[2].equals("0")) {
                    data[row][3] = "Balance zero";
                }
                row++;
            }

            in.close();
        } catch (IOException e) {
        }
        return data;
    }*/
}
