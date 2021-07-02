package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args){
        chromeLaunch();
        //chromeClose();
        //firefoxLaunch();
        //firefoxClose();
    }
   public static void chromeLaunch(){
        //set chrome driver path

        //static path
        //System.setProperty("webdriver.chrome.driver","E:\\Tools\\chromedriver.exe");

        //dynamic path
       System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");

        driver=new ChromeDriver();

        //online
        //driver.get("https://google.com");

        //offline
       // driver.get("file:///C:/Users/DOLPHIN/Downloads/SQA 7th class/Your Store.html");

       //localhost
       driver.get("http://localhost:8080/myapplication.html");

        System.out.println("Chrome launch successfully!!");
        driver.manage().window().maximize();
    }
    public static void firefoxLaunch(){
        //System.setProperty("webdriver.firefox.driver","E:\\Tools\\geckodriver.exe");
         System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");

        driver=new FirefoxDriver();
        driver.get("https://apple.com");
        System.out.println("Firefox launch successfully!!");
    }
    public static void chromeClose(){
       driver.close();   //close only active tab
       System.out.println("Chrome closed");
        //driver.quit();    //close all tab
        //System.out.println("Chrome quit");

    }
    public static void firefoxClose(){
        driver.close();
        System.out.println("Firefox closed");
        //driver.quit();
        //System.out.println("Firefox quit");
    }
}
