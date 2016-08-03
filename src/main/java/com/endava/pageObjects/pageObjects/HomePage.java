package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lconstantin on 8/3/2016.
 */
public class HomePage {
    @FindBy(xpath = "//a[@data-category='bath-body']")
    private WebElement bodyCareLink;



    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public BodyCarePage pageCareBody(){
        bodyCareLink.click();

        BodyCarePage bodyCarePage = PageFactory.initElements(webDriver,BodyCarePage.class);

        return bodyCarePage;
    }






}