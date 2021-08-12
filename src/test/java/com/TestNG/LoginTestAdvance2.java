package com.TestNG;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestAdvance2 {
    WebDriver driver;
    String LoginURL="https://demo.opencart.com/index.php?route=account/login";

    @BeforeSuite
    public void initSetup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        Log.info("Chrome launch successfully!!");
        driver.get(LoginURL);
        Log.info("Login Page Open successfully!!");
    }
    @AfterSuite
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
        //Assertion
        Assert.assertEquals(Exp_title, Act_title);
        WebElement Logout = driver.findElement(By.linkText("Logout"));
        Logout.click();
        driver.findElement(By.linkText("Login")).click();
    }
        @Test
        public void TC_002_InValid () {
            WebElement Email = driver.findElement(By.id("input-email"));
            Email.sendKeys("user102");
            WebElement Password = driver.findElement(By.id("input-password"));
            Password.sendKeys("123456");
            WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
            LoginBtn.click();
            Log.info("Login Button Click");
            String Exp_title = "Account Login";
            String Act_title = driver.getTitle();
            Assert.assertEquals(Exp_title, Act_title);

        }
    }
