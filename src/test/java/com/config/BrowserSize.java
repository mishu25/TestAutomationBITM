package com.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSize extends BrowserConfig {

    public static void main(String[] args) {
        firefoxLaunch();
        Screen_PC();
        getScreenSize();
        firefoxClose();


    }
    public static void firefoxLaunch(){
        //System.setProperty("webdriver.firefox.driver","E:\\Tools\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");

        driver=new FirefoxDriver();
        driver.get("https://apple.com");
        System.out.println("Firefox launch successfully!!");
    }
    public static void getScreenSize(){
        //get screen size
        int height=driver.manage().window().getSize().getHeight();
        int width=driver.manage().window().getSize().getWidth();
        System.out.println("Screen Width: "+width +" and Height: "+height); //Screen Width: 1294 and Height: 779

    }
    public static void Screen_PC(){
        //set screen size
        driver.manage().window().setSize(new Dimension(769,400));
        driver.manage().window().setSize(new Dimension(768,400));

    }

    public static void Screen_Tablet(){

    }

}
