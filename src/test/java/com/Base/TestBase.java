package com.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;


public class TestBase {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        chromeLaunch();
        chromeClose();
        firefoxLaunch();
        firefoxClose();
    }
    public static void chromeLaunch(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        System.out.println("Chrome launch successfully!!");
    }
    public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("Firefox launch successfully!!");
    }
    public static void chromeClose() {
        driver.close();   //close only active tab
        System.out.println("Chrome closed");
    }
    public static void firefoxClose(){
        driver.close();
        System.out.println("Firefox closed");
    }
    public static void openTestURL(String URL){
        driver.get(URL);
    }
    public static WebElement elementByCSS(String locator){
       return driver.findElement(By.cssSelector(locator));
    }
    public static WebElement elementByXpath(String locator){
        return driver.findElement(By.xpath(locator));
    }
    public static WebElement elementById(String locator){
        return driver.findElement(By.cssSelector(locator));
    }
    public static WebElement elementByName(String locator){
        return driver.findElement(By.cssSelector(locator));
    }
    public static void getElementByCSSandClick(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public static void getElementByXpathAndClick(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public static void getElementByCSSandType(String locator,String text){
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }
    public static void getElementByIdandType(String locator,String text){
        driver.findElement(By.id(locator)).sendKeys(text);
    }
    public static void getElementByTitleandClick(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    public static void alertCancel(){
        driver.switchTo().alert().dismiss();
    }

    public static void captureScreenshot(String name,String formate) throws IOException {
        //take screenshot
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //save screenshot
        FileUtils.copyFile(srcFile,new File("./src/test/screenshots/" +name +formate),true);

    }
}
