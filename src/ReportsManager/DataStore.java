/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsManager;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public class DataStore implements Serializable{
    private double totalSales;
    private double totalCosts;
    private double totalRevenue;

    public DataStore() {
        totalSales = 0;
        totalCosts = 0;
        totalRevenue = 0;
    }
    
    public void updateData(double saleAmt, double costAmt){
        totalSales = totalSales + saleAmt;
        totalCosts = totalCosts + costAmt;
        totalRevenue = totalSales - totalCosts;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getTotalCosts() {
        return totalCosts;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    
}
