package com.endava.pageObjects.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ctinl on 03-Aug-16.
 */
public class ItemPage {
    @FindBy(xpath = "//h1[@class='name']")
    private WebElement selectedItemName;

    public String getItemName(){
        return selectedItemName.getText();
    }
}
