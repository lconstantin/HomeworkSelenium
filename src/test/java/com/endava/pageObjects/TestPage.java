package com.endava.pageObjects;

import com.endava.pageObjects.pageObjects.BodyCarePage;
import com.endava.pageObjects.pageObjects.CartPage;
import com.endava.pageObjects.pageObjects.ForHimPage;
import com.endava.pageObjects.pageObjects.ItemPage;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by lconstantin on 8/3/2016.
 */

public class TestPage extends TestBaseClass{

    @Test
    public  void verificare(){

        //enter homepage
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
        //check if we clicked on the first item
        ItemPage firstItemPage = bodyCarePage.clickFirstItem();
        String firstItemName = firstItemPage.getItemName();
        Assert.assertEquals(itemName,firstItemName);

        //go back to body care page
        firstItemPage.goBack();

        //go to noutati
      bodyCarePage.clickNewProductPage();

        //check and prints number of products
        Integer numberOfNewProducts = bodyCarePage.getNewProductNumber();
        System.out.println("Number of the new produtcs is : " + numberOfNewProducts);
        assertTrue(numberOfNewProducts > 0);

        bodyCarePage.clickSecondItem();

        //check if the cart button exists
        firstItemPage.checkIfCartButton();

        //auto update cart
         firstItemPage.productUpdated();

        //click shopping cart
         CartPage cartPage = firstItemPage.shoppingClick();

        //increase quantity
         cartPage.increase();

        //verify if the total price is correct
        Float singleItemPrice = cartPage.singleProdPrice();
        Float multiply = singleItemPrice * 3;
        Float multipleItemPrice = cartPage.increasedProdPrice();
        Assert.assertEquals(multiply,multipleItemPrice);

        //print bonus points
        Float bonusP = cartPage.bonusPoints();
        System.out.println("Bonus points: " + bonusP);

        //click on the for him tab
         cartPage.clickForHim();

        //click accesories
       // cartPage.clickAccesories();

        //click on watches apge
        cartPage.watchesPage();

        String getLastWatchName=cartPage.getLastName();
        System.out.println("Name of the last watch is:" + getLastWatchName);

        cartPage.watchDetails();


    }


}
