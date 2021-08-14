package com.Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFramehtmlTest extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openTestURL("https://www.w3schools.com/html/html_iframe.asp");
        htmlFrame();
    }

    public static void htmlFrame(){
        WebElement frame= driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
        driver.switchTo().frame(frame);
        getElementByXpathAndClick("//*[@id=\"topnav\"]/div/div/a[4]");
    }
}
