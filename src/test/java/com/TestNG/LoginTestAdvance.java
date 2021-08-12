package com.TestNG;

import com.Base.TestBase;
import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginTestAdvance {
    WebDriver driver;
    String LoginURL="https://demo.opencart.com/index.php?route=account/login";

    @BeforeMethod
    public void initSetup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        Log.info("Chrome launch successfully!!");
        driver.get(LoginURL);
        Log.info("Login Page Open successfully!!");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        Log.info("Chrome Close successfully!!");
    }
    @Test
    public void TC_001_Valid() {
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu001@gmail.com");
        Log.info("Type Email");
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        Log.info("Type Password");
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //logic develop
        //logic pass
        String Exp_title = "My Account";
        String Act_title = driver.getTitle();
/*
        if (Exp_title.equals(Act_title)) {
            System.out.println("Test passed for valid data.");
            Log.info("Test passed for valid data.");
            WebElement Logout = driver.findElement(By.linkText("Logout"));
            Logout.click();
        } else {
            System.out.println("Test failed for valid data,yahoooo Bug found");
            Log.info("Test failed for valid data.");
        }*/
        //Assertion
        Assert.assertEquals(Exp_title, Act_title);
        WebElement Logout = driver.findElement(By.linkText("Logout"));
        Logout.click();
    }
        @Test
        public void TC_002_InValid () {
            WebElement Email = driver.findElement(By.id("input-email"));
            Email.sendKeys("user102");
            //3rd step
            WebElement Password = driver.findElement(By.id("input-password"));
            Password.sendKeys("123456");
            //step4
            WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
            //login pass
            /*String Exp_data = "My Account";
            String Act_data = driver.getTitle();
            if (!Exp_data.equals(Act_data)) {
                System.out.println("Test passed for invalid data");
            } else {
                System.out.println("Test failed for invalid data,yahooo Bug found.");
                //logout
                WebElement Logout = driver.findElement(By.linkText("Logout"));
                Logout.click();
            }*/
            LoginBtn.click();
            Log.info("Login Button Click");
            String Exp_title = "Account Login";
            String Act_title = driver.getTitle();
            Assert.assertEquals(Exp_title, Act_title);

        }
    }
