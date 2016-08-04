package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ctinl on 03-Aug-16.
 */
public class ItemPage {

    WebDriver webDriver;

    public ItemPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//h1[@class='name']")
    private WebElement selectedItemName;

    @FindBy(xpath = "//a[@href='/bath-body?sort=pricehigh']")
    private WebElement backToBodycare;

    @FindBy(xpath = "//button[@id='addToBasketButton']")
    private WebElement checkCartButton;

    @FindBy(xpath = "//a[@class=\"k-button g11 g-center\"]")
    private WebElement checkAutoUpdate;

    public String getItemName(){
        return selectedItemName.getText();
    }

    public void goBack(){
        backToBodycare.click();
    }

    public void checkIfCartButton(){
        if (webDriver.findElement(By.xpath("//button[@id='addToBasketButton']")).isDisplayed()) {
            checkCartButton.click();}

    }

    public CartPage productUpdated(){
        if(webDriver.findElement(By.xpath("//a[@class=\"k-button g11 g-center\"]")).isDisplayed()) {
            System.out.println("The item has been added to cart");
            checkAutoUpdate.click();

        }
        CartPage cartPage = PageFactory.initElements(webDriver,CartPage.class);
        return cartPage;
    }



}
