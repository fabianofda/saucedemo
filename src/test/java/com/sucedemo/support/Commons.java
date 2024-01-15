package com.sucedemo.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Commons {

    public WebDriver driver;

    public Commons(WebDriver driver) {
        this.driver = driver;
    }

    public String messageError() {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }
    
}
