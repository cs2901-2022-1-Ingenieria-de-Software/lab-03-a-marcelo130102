package lab;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.demand.Order;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TaxTest {

    @Test
    public void taxTestDefault(){
        double result = GetTax(1);
        Assert.assertEquals(result, 24.00);
    }

    @Test
    public void taxTestSpecial(){
        double result = GetTax(2);
        Assert.assertEquals(result, 40.00);
    }

    private static List<Order> buildSampleOrders() {
        List<Order> testOrders = new ArrayList<>();
        testOrders.add(new Order("PE", 10L));
        testOrders.add(new Order("PE", 20L));
        testOrders.add(new Order("CO", 10L));
        testOrders.add(new Order("BR", 10L));
        return testOrders;
    }

    private static double GetTax(int N){
        Tax tax = new Tax();
        ManageDemand mg = new ManageDemand(tax);
        List<Order> testOrders = buildSampleOrders();
        
        if(N == 1){
            return mg.calculateTotal(testOrders);
        }
        else{
            return mg.calculateTotalForWithAdditionalByCountry(testOrders, 0.10, 0.20, 0.30);
        }
    }
    
    
}
