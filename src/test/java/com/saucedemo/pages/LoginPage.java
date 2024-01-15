package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginWith(String username, String password) {

        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);

        return this;
    }

    public void submit() {
        driver.findElement(By.id("login-button")).click();
    }

    public boolean loginContainer() {
        
        WebElement loginContainer = driver.findElement(By.cssSelector(".login_container"));
        return loginContainer.isDisplayed();
    }

}
