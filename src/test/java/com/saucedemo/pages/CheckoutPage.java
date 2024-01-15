package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.support.Checkout;


public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFormCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    public void buttonContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public Checkout validateInformationNoCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement qtyElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_quantity']")));
        WebElement descElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_desc']")));
        WebElement priceElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_price']")));

        Checkout checkout = new Checkout(
                qtyElement.getText(),
                descElement.getText(),
                priceElement.getText());

        return checkout;
    }

    public void buttonFinish() {
        driver.findElement(By.id("finish")).click();
    }

    public String confirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement confirmationMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

        return confirmationMessageElement.getText();
    }

}
