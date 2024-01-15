package com.sucedemo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartVisible() {
        try {
            WebElement cartContainer = driver.findElement(By.id("shopping_cart_container"));
            return cartContainer.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void buttonBurguer() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-burger-menu-btn"))).click();
    }

    public void linkLogout() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout_sidebar_link"))).click();
    }

    public void buttonAddToCart(String text) {
        driver.findElement(By.xpath(
                "//div[contains(@class, 'inventory_item_description') and contains(., '" + text +
                        "')]//button[contains(text(), 'Add to cart')]"))
                .click();
    }

    public void buttonRemoveFromCart(String text) {
        driver.findElement(By.xpath(
                "//div[contains(@class, 'inventory_item_description') and contains(., '" + text +
                        "')]//button[contains(text(), 'Remove')]"))
                .click();
    }

    public int getQuantityOfItemsInCart() {
        try {
            WebElement cartBadge = driver.findElement(By.cssSelector("a.shopping_cart_link span.shopping_cart_badge"));
            return Integer.parseInt(cartBadge.getText());
        } catch (org.openqa.selenium.NoSuchElementException | NumberFormatException e) {
            return 0;
        }
    }

    public void linkCart() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    public void selectSortOptionByNameAZ() {
        selectSortOption("az");
    }

    public void selectSortOptionByNameZA() {
        selectSortOption("za");
    }

    public void selectSortOptionByPriceLowToHigh() {
        selectSortOption("lohi");
    }

    public void selectSortOptionByPriceHighToLow() {
        selectSortOption("hilo");
    }

    private void selectSortOption(String value) {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(value);
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        List<WebElement> itemElements = driver.findElements(By.className("inventory_item_name"));

        for (WebElement element : itemElements) {
            itemNames.add(element.getText());
        }

        return itemNames;
    }

    public List<String> getItemPrices() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".inventory_item_price"));
        List<String> priceList = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText();
            priceList.add(price);
        }

        return priceList;
    }

}
