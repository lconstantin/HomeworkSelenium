package com.endava.pageObjects;

import com.endava.pageObjects.pageObjects.BodyCarePage;
import com.endava.pageObjects.pageObjects.ItemPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by lconstantin on 8/3/2016.
 */

public class TestPage extends TestBaseClass{

    @Test
    public  void verificare(){

        BodyCarePage bodyCarePage = homePage.pageCareBody();

        Integer totalProductsNumber = bodyCarePage.getTotalProductNumber();
        System.out.println("Total products: " + totalProductsNumber);
        assertTrue(totalProductsNumber > 0);

        bodyCarePage.filterField();
        bodyCarePage.orderByPrice();

       String itemName = bodyCarePage.getItemName();
        System.out.println("Name of the first product is: " + itemName);

        Float itemPrice = bodyCarePage.getItemPrice();
        if(itemPrice == 0.0f) {
            System.out.println("unspecified price");
        }
        else {
            System.out.println("The price of the first item is: " + itemPrice);
        }

        ItemPage firstItemPage = bodyCarePage.clickFirstItem();
        String firstItemName = firstItemPage.getItemName();
        Assert.assertEquals(itemName,firstItemName);



    }


}
