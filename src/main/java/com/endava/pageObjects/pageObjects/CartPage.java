package com.endava.pageObjects.pageObjects;

import org.omg.CORBA.FloatHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by lconstantin on 8/4/2016.
 */
public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//span[@class='k-icon k-i-arrow-n']")
    private WebElement increaseProduct;

    @FindBy(xpath = "(//span[@class='price'])[1]/span")
    private WebElement productPrice;

    @FindBy(xpath = "//li[@class='total-price']/span[@class='price-box total-price-1']")
    private WebElement productIncreasedPrice;

    @FindBy(xpath = "//span[@class='value']/span[@class='total-bp']")
    private WebElement bp;

    @FindBy(xpath = "//li/a[@href='/men']")
    private WebElement forHim;

    //increase quantity
    public void increase(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(increaseProduct));
        increaseProduct.click();
        increaseProduct.click();
    }
    //takes the price of a single product
    public Float singleProdPrice(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(productPrice));
        String singleProduct = productPrice.getText();
        String transformedPrice = singleProduct.replace(',','.');
        String floatPrice = transformedPrice.replaceAll(" LEI","");
        return Float.parseFloat(floatPrice);
    }

    //takes the total price
    public Float increasedProdPrice(){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(productIncreasedPrice));
        String incProduct = productIncreasedPrice.getText();
        String transformedPrice = incProduct.replace(',','.');
        String floatPrice = transformedPrice.replaceAll(" LEI","");
        return Float.parseFloat(floatPrice);
    }


    //get bonus points
    public Float bonusPoints(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(bp));
        String bonus = bp.getText();
        String bonpoint = bonus.replace(',','.');
        return Float.parseFloat(bonpoint);
    }

    public ForHimPage clickForHim(){
        forHim.click();
        ForHimPage forHimPage = PageFactory.initElements(webDriver,ForHimPage.class);
        return forHimPage;
    }

    //accesories
   // @FindBy(xpath = "//li/a[@class='first-level toggle right-arrow']")
  //  private WebElement accesories;

    //click on watch
    @FindBy(xpath = "//a[@href='/men/accessories/watches']")
    private WebElement clickWatches;


    //click on accesories
  //  public void clickAccesories(){
  //      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  //      accesories.click();
  //  }

    //click on watches page
    public WatchesPage watchesPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(clickWatches));
        clickWatches.click();
        WatchesPage watchesPage = PageFactory.initElements(webDriver,WatchesPage.class);
        return watchesPage;
    }

    //select last watch
    @FindBy(xpath = "(//div[@class='w-info'])[3]/span[@class='name']")
    private WebElement lastElement;
    //get last watch name
    @FindBy(xpath = "(//div[@class='w-info'])[3]/span[@class='name']")
    private WebElement lastItemName;

    public String getLastName(){
       String lastName = lastElement.getText();
        return lastName;
    }

    //click on the last item
    public void watchDetails(){
        lastElement.click();
    }


    //email xpath
    @FindBy(xpath = "//a[@title='Email']")
    private WebElement emailIcon;

    //email
   // public void veridyEmailIcon(){
   //     if (webDriver.findElement(By.xpath("//button[@id='addToBasketButton']")).isDisplayed())
   // }

}
