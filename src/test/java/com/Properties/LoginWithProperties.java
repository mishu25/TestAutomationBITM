package com.Properties;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LoginWithProperties extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        //firefoxLaunch();
        TC_001_Valid();
        TC_002_InValid();
        chromeClose();
    }
    public static void TC_001_Valid() throws IOException {
        //Read properties file
        FileInputStream fis=new FileInputStream("./src/test/resources/OR.properties");
        Properties proObj=new Properties();
        proObj.load(fis);
        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys(proObj.getProperty("Valid_email"));

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        //Password.sendKeys("123456");
        Password.sendKeys(proObj.getProperty("Valid_pass"));

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        //Logic Develop
        //Login Pass
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test Passed for valid Data.");
            //Logout
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();
            captureScreenshot("LoginTest_Valid_Properties",".png");
        }
        else{
            System.out.println("Test Failed for valid Data.Yahooooo Bug Found.");
        }


    }
    public static void TC_002_InValid() throws IOException {
        //Read properties file
        FileInputStream fis=new FileInputStream("./src/test/resources/OR.properties");
        Properties proObj=new Properties();
        proObj.load(fis);
        //1st step
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //2nd step
        WebElement Email=driver.findElement(By.id("input-email"));
        //Email.sendKeys("user102");
        Email.sendKeys(proObj.getProperty("Invalid_email"));
        //3rd step
        WebElement Password=driver.findElement(By.id("input-password"));
        //Password.sendKeys("123456");
        Password.sendKeys(proObj.getProperty("Invalid_pass"));

        //step4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //login pass
        String Exp_data="My Account";
        String Act_data=driver.getTitle();
        if(!Exp_data.equals(Act_data)){
            System.out.println("Test passed for invalid data");
            captureScreenshot("login_invalid_properties",".png");
        }
        else{
            System.out.println("Test failed for invalid data,yahooo Bug found.");
            //logout
            WebElement Logout=driver.findElement(By.linkText("Logout"));
            Logout.click();
        }
        LoginBtn.click();
        WebElement LogoutBtn=driver.findElement(By.id("logout"));
        LogoutBtn.click();

    }


}
