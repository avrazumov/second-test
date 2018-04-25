package com.gmail.nemo31.nn;

import com.gmail.nemo31.nn.MainPage;
import com.gmail.nemo31.nn.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static SearchResultPage searchResultPage;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bbc.com");
    }

    @Test
    public void searchTest(){
        mainPage.seachInput("telegram");
        mainPage.clickSearchButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.bbc.co.uk/search?q=telegram");
        searchResultPage.resultClickButton();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
