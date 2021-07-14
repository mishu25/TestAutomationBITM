package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class login extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        //firefoxLaunch();
        TC_001_Valid();
        TC_002_InValid();
        chromeClose();
    }
    public static void TC_001_Valid() throws IOException {
        //1st step
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //2nd step
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu@gmail.com");
        //3rd step
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("12345678");
        //step4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        //logic develop
        //logic pass
        String Exp_title="My Account";
        String Act_title=driver.getTitle();

        if(Exp_title.equals(Act_title)){
            System.out.println("Test passed for valid data");
            WebElement Logout=driver.findElement(By.linkText("Logout"));
            Logout.click();
            captureScreenshot("login valid", ".png");
        }
        else{
            System.out.println("Test failed for valid data,yahoooo Bug found");
        }

    }
    public static void TC_002_InValid() throws IOException {
        //1st step
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //2nd step
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user102");
        //3rd step
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        //step4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //login pass
        String Exp_data="My Account";
        String Act_data=driver.getTitle();
        if(!Exp_data.equals(Act_data)){
            System.out.println("Test passed for invalid data");
            captureScreenshot("login invalid",".png");
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
