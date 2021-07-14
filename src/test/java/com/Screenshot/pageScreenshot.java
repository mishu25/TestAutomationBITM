package com.Screenshot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class pageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        openTestURL("https://demo.opencart.com/");
        generateScreenshot();
        chromeClose();

    }
    public static void generateScreenshot() throws IOException {
        //take screenshot
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //save screenshot
        FileUtils.copyFile(srcFile,new File("./src/test/screenshots/pageImage.png"),true);

    }
}
