package com.endava.pageObjects;

import com.endava.pageObjects.pageObjects.BodyCarePage;
import com.endava.pageObjects.pageObjects.HomePage;
import com.endava.pageObjects.pageObjects.ProductListPage;
import org.junit.Test;

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

    }


}
