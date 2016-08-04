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

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalProducts;

    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement selectFilter;

    @FindBy(xpath = "//li[@data-offset-index='2']")
    private WebElement filterByPriceHigh;

    @FindBy(xpath = "(//div[@class='w-info'])[1]/span[@class='name']")
    private WebElement firstItemName;

    @FindBy(xpath = "(//div[@class='offer'])[1]/span")
    private WebElement firstItemPrice;

    @FindBy(xpath = "(//a[@class='ui-product-box g5 isotope-item'])[1]")
    private WebElement firstItemLink;

    @FindBy(xpath = "//h1[@class='name']")
    private WebElement selectedFirstProduct;

    @FindBy(xpath = "//a[@href='/bath-body/new']")
    private WebElement newItems;

    @FindBy(xpath = "//span[@ class='total-count']")
    private WebElement newProductsNumber;

    //click on 2nd product
    @FindBy(xpath = "(//div[@class='w-info'])[2]/span[@class='name']")
    private WebElement secondProduct;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

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

    public String getItemName(){
        return firstItemName.getText();

    }

    public Float getItemPrice(){
        String itemPrice = firstItemPrice.getText();
        if(itemPrice == null){
            return 0.0f;
        }
        String transformedPrice = itemPrice.replace(',','.');
        String floatPrice = transformedPrice.replaceAll(" LEI","");
        return Float.parseFloat(floatPrice);
    }

    public ItemPage clickFirstItem(){
        firstItemLink.click();
        ItemPage itemPage = PageFactory.initElements(webDriver,ItemPage.class);
        return itemPage;
    }

    public void clickNewProductPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newItems));
        newItems.click();

    }

    public Integer getNewProductNumber(){
        String newTotalProducts = newProductsNumber.getText();
        return Integer.parseInt(newTotalProducts);
    }
    //click second item from noutati page
    public void clickSecondItem(){
        secondProduct.click();

    }


}
