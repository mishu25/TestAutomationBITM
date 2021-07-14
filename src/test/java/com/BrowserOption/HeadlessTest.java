package com.BrowserOption;

import com.Base.TestBase;
import com.OpenCart.login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class HeadlessTest extends TestBase {
    public static void main(String[] args) throws IOException {
        ChromeBrowserHeadless();
        FirefoxBrowserHeadless();

    }
    public static void ChromeBrowserHeadless() throws IOException {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions crobj=new ChromeOptions();
        crobj.setHeadless(true);
        driver=new ChromeDriver(crobj);
        login.TC_001_Valid();
        System.out.println("Headless Chrome Test done");

    }
    public static void FirefoxBrowserHeadless() throws IOException {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions frobj=new FirefoxOptions();
        frobj.setHeadless(true);
        driver=new FirefoxDriver(frobj);
        login.TC_002_InValid();
        System.out.println("Headless Firefox Test done");

    }
}
