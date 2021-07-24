package com.log4j;

import com.Base.TestBase;
import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class LoginLog4j extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        //firefoxLaunch();
        TC_001_Valid();
        chromeClose();
    }

    public static void TC_001_Valid() throws IOException {
        //1st step
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Log.info("Open Login URL");
        //2nd step
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu001@gmail.com");
        Log.info("Type Email");
        //3rd step
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        Log.info("Type Password");
        //step4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //logic develop
        //logic pass
        String Exp_title = "My Account";
        String Act_title = driver.getTitle();

        if (Exp_title.equals(Act_title)) {
            System.out.println("Test passed for valid data.");
            Log.info("Test passed for valid data.");
            WebElement Logout = driver.findElement(By.linkText("Logout"));
            Logout.click();
            captureScreenshot("login valid", ".png");
        } else {
            System.out.println("Test failed for valid data,yahoooo Bug found");
            Log.info("Test failed for valid data.");
        }
    }
}
