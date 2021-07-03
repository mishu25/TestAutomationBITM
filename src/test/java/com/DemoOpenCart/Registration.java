package com.DemoOpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Registration extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        TC_003_Valid();
        TC_004_InValid();

    }
    public static void TC_003_Valid(){
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        WebElement FirstName=driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("motahara");

        WebElement LastName=driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("mishu");

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu123@gmail.com");

        WebElement Telephone=driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("012345678901");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("12345678");

        WebElement PasswordConfirm=driver.findElement(By.id("input-confirm"));
        PasswordConfirm.sendKeys("12345678");

        WebElement PrivacyPolicy=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        PrivacyPolicy.click();

        WebElement ContinueBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ContinueBtn.click();

    }
    public static void TC_004_InValid(){
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        WebElement FirstName=driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("motahara");

        WebElement LastName=driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("mishu");

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu123");

        WebElement Telephone=driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("abc");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("12345678");

        WebElement PasswordConfirm=driver.findElement(By.id("input-confirm"));
        PasswordConfirm.sendKeys("123456");

        WebElement PrivacyPolicy=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        PrivacyPolicy.click();

        WebElement ContinueBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ContinueBtn.click();

    }
}
