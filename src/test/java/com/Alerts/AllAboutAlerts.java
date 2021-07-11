package com.Alerts;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlerts extends TestBase {
    public static void main(String[] args) {
       chromeLaunch();
        openTestURL("https://the-internet.herokuapp.com/javascript_alerts");
        //normalAlerts();
        //confirmAlerts();
        promptAlerts();

    }
    public static void normalAlerts(){
        //WebElement norAltBtn=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
        //WebElement norAltBtn=elementByCSS("#content > div > ul > li:nth-child(1) > button");
       // norAltBtn.click();
        getElementByCSSandClick("#content > div > ul > li:nth-child(1) > button");
        //driver.switchTo().alert().accept();
        alertAccept();
    }
    public static void confirmAlerts(){
        getElementByCSSandClick("#content > div > ul > li:nth-child(2) > button");
        alertCancel();

    }
    public static void promptAlerts(){
        getElementByCSSandClick("#content > div > ul > li:nth-child(3) > button");
        driver.switchTo().alert().sendKeys("Test Automation");
        alertAccept();

    }
}
