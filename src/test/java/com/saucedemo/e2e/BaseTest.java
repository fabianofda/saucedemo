
package com.saucedemo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static WebDriver driver;
    protected static final String URL_BASE = "https://www.saucedemo.com/";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1330, 1024));
        driver.get(URL_BASE);
    }

    @AfterEach
    public void tearDownClass(TestInfo testInfo) {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);

        String methodName = testInfo.getTestMethod().orElseThrow().getName();

        try {
            FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                    File.separator + methodName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}