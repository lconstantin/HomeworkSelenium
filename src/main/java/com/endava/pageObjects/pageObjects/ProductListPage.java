package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by lconstantin on 8/3/2016.
 */
public class ProductListPage
{
    @FindBy(xpath = "//span[@class= 'k-input' and contains(text(), 'Preț – Cel mai mare la Cel mai mic')]")
    private WebElement filterByPriceHigh;

    private WebDriver webDriver;


    public ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }




}
