package com.DemoOpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class EndToEndTestAutomation extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openTestURL("https://demo.opencart.com/index.php?route=account/register");
        String email=FillUpRegField();
        openTestURL("https://demo.opencart.com/index.php?route=account/login");
        FillUpLoginField(email);
    }

    public static String  FillUpRegField(){
        getElementByIdandType("input-firstname","mishu");
        getElementByIdandType("input-lastname","mishu");
        WebElement Email=driver.findElement(By.id("input-email"));
        Random random = new Random();
        String email = "user"+random.nextInt(1000) + "@gmail.com";
        Email.sendKeys(email);
        getElementByIdandType("input-telephone","01234567891");
        getElementByIdandType("input-password","12345678");
        getElementByIdandType("input-confirm","12345678");
        getElementByXpathAndClick("//*[@id=\"content\"]/form/div/div/input[1]");
        getElementByXpathAndClick("//*[@id=\"content\"]/form/div/div/input[2]");
        String Exp_urlAd="https://demo.opencart.com/index.php?route=account/success";
        String Act_urlAd=driver.getCurrentUrl();
        if(Exp_urlAd.equals(Act_urlAd)){
            System.out.println("Account Has Been Created!");
        }
        else{
            System.out.println("Registration Failed, Bug Found!!!");
        }
        //logout
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();
        String Exp_urlAd2="https://demo.opencart.com/index.php?route=account/logout";
        String Act_urlAd2=driver.getCurrentUrl();
        if(Exp_urlAd2.equals(Act_urlAd2)){
            System.out.println("Account Logout!");
        }
        else{
            System.out.println("Logout Failed, Bug Found!!!");
        }
        return email;
    }

    public static void FillUpLoginField(String email){
        getElementByIdandType("input-email",email);
        getElementByIdandType("input-password","12345678");
        getElementByXpathAndClick("//*[@id=\"content\"]/div/div[2]/div/form/input");
        System.out.println("Login successfully!!");
    }
}
