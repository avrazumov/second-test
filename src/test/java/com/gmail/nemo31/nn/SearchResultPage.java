package com.gmail.nemo31.nn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = "li[data-result-number='1'] a:nth-child(1)")
    private WebElement firstSearchResult;

    @FindBy(id = "orb-search-q")
    private static WebElement searchfield;


    public void resultClickButton(){
        firstSearchResult.click();
    }
    public void seachInput(String input){
        searchfield.sendKeys(input);
    }

    public static String getSearchInput(){
        String searchText = searchfield.getText();
        return searchText;
    }
}
