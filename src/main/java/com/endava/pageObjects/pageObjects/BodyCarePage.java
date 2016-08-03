package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by lconstantin on 8/3/2016.
 */
public class BodyCarePage {
    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalProducts;

    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement selectFilter;

    @FindBy(xpath = "//li[@data-offset-index='2']")
    private WebElement filterByPriceHigh;

    //span[@class= 'k-dropdown-wrap k-state-default']


    public Integer getTotalProductNumber(){
        String totalProductsNumber = totalProducts.getText();
        return Integer.parseInt(totalProductsNumber);
    }

    public void filterField(){
        selectFilter.click();
    }

    public void orderByPrice(){

        filterByPriceHigh.click();

    }



}
