package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class login extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        TC_001_Valid();
       // TC_002_InValid();
        //chromeClose();
    }
    public static void TC_001_Valid(){
        //1st step
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //2nd step
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user102@gmail.com");
        //3rd step
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        //step4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();



    }
    public static void TC_002_InValid(){
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
        LoginBtn.click();
        WebElement LogoutBtn=driver.findElement(By.id("logout"));
        LogoutBtn.click();

    }


}
