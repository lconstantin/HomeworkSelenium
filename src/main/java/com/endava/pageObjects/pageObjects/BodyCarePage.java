package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lconstantin on 8/3/2016.
 */
public class BodyCarePage {
    WebDriver webDriver;

    //Get total number of products
    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalProducts;

    //Select filter
    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement selectFilter;

    //select highes price from filter
    @FindBy(xpath = "//li[@data-offset-index='2']")
    private WebElement filterByPriceHigh;

    //select the name of the first item
    @FindBy(xpath = "(//div[@class='w-info'])[1]/span[@class='name']")
    private WebElement firstItemName;

    //select the price of the first item
    @FindBy(xpath = "(//div[@class='offer'])[1]/span")
    private WebElement firstItemPrice;

    //go to detail item page
    @FindBy(xpath = "(//a[@class='ui-product-box g5 isotope-item'])[1]")
    private WebElement firstItemLink;


    //@FindBy(xpath = "//h1[@class='name']")
   // private WebElement selectedFirstProduct;

    //click on noutati
    @FindBy(xpath = "//a[@href='/bath-body/new']")
    private WebElement newItems;

    //select number of products from noutati
    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement newProductsNumber;

    //click on 2nd product
    @FindBy(xpath = "(//div[@class='w-info'])[2]/span[@class='name']")
    private WebElement secondProduct;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //get the number of products from ingrijire corp page
    public Integer getTotalProductNumber(){
        String totalProductsNumber = totalProducts.getText();
        return Integer.parseInt(totalProductsNumber);
    }
    //click on filter field method
    public void filterField(){
        selectFilter.click();
    }

    //select highest price filter
    public void orderByPrice(){

        filterByPriceHigh.click();

    }

    //get the name of the first item method
    public String getItemName(){
        return firstItemName.getText();

    }

    //get price of the first item method
    public Float getItemPrice(){
        String itemPrice = firstItemPrice.getText();
        if(itemPrice == null){
            return 0.0f;
        }
        String transformedPrice = itemPrice.replace(',','.');
        String floatPrice = transformedPrice.replaceAll(" LEI","");
        return Float.parseFloat(floatPrice);
    }

    //go to item detail page
    public ItemPage clickFirstItem(){
        firstItemLink.click();
        ItemPage itemPage = PageFactory.initElements(webDriver,ItemPage.class);
        return itemPage;
    }

    //click on noutati link
    public void clickNewProductPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newItems));
        newItems.click();

    }

    //get the number of products from noutati page
    public Integer getNewProductNumber(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newProductsNumber));
        String newTotalProducts = newProductsNumber.getText();
        return Integer.parseInt(newTotalProducts);
    }
    //click second item from noutati page
    public void clickSecondItem(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(secondProduct));
        secondProduct.click();

    }


}
