package com.gmail.nemo31.nn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "orb-search-q")
    private WebElement searchfield;

    @FindBy(id = "orb-search-button")
    private WebElement searchButton;

    public void seachInput(String input){
        searchfield.sendKeys(input);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getSearchInput(){
        String searchText = searchfield.getText();
        return searchText;
    }
}
