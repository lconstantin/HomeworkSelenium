package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ctinl on 03-Aug-16.
 */
public class ItemPage {

    WebDriver webDriver;

    public ItemPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //select the name of the product
    @FindBy(xpath = "//h1[@class='name']")
    private WebElement selectedItemName;

    //go back to ingrijire corp
    @FindBy(xpath = "//a[@href='/ro/bath-body?sort=pricehigh']/span")
    private WebElement backToBodycare;

    //check if cart button exists
    @FindBy(xpath = "//button[@id='addToBasketButton']")
    private WebElement checkCartButton;

    //check if autoupdate
    @FindBy(xpath = "//a[@class='k-button g11 g-center']")
    private WebElement autoUpdate;

    //cick shopping cart
    @FindBy(xpath = "//li[@class='basket right k-state-border-down']/a[@href='/shopping/basket']")
    private WebElement shoppingCart;

    public String getItemName(){
        return selectedItemName.getText();
    }

    //go back to ingrijire crorp
    public void goBack(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(backToBodycare));
        backToBodycare.click();
    }

    //check if cart button is there
    public void checkIfCartButton(){
        if (webDriver.findElement(By.xpath("//button[@id='addToBasketButton']")).isDisplayed()) {
            checkCartButton.click();}

    }

    //check if shooping cart is auto updated
    public void productUpdated(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(autoUpdate));
        if(webDriver.findElement(By.xpath("//a[@class='k-button g11 g-center']")).isDisplayed()) {
            System.out.println("The item has been added to cart");

    }
    }

    //click shopping cart
    public CartPage shoppingClick(){

        shoppingCart.click();
        CartPage cartPage = PageFactory.initElements(webDriver,CartPage.class);
        return cartPage;



    }



}
