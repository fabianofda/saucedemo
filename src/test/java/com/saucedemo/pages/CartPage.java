package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.support.Product;


public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getQuantityOfItemsInCart() {
        return getCartItems().size();
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(By.cssSelector("#cart_contents_container .cart_item"));
    }

    public String validateCartItemDetails(Product product) {
        for (WebElement cartItem : getCartItems()) {
            String actualItemName = cartItem.findElement(By.cssSelector(".inventory_item_name")).getText();
            String actualItemDescription = cartItem.findElement(By.cssSelector(".inventory_item_desc")).getText();
            String actualItemPrice = cartItem.findElement(By.cssSelector(".inventory_item_price")).getText();

            if (actualItemName.equals(product.getName()) &&
                    actualItemDescription.equals(product.getDescription()) &&
                    actualItemPrice.replaceAll("\\s", "").equals(product.getPrice().replaceAll("\\s", ""))) {
                return "Detalhes do item correspondem: Nome: " + product.getName() + ", Descrição: "
                        + product.getDescription() + ", Preço: " + product.getPrice();
            }
        }

        throw new AssertionError(
                "Detalhes do item não correspondem ao produto fornecido. Nenhum item no carrinho corresponde ao produto fornecido.");
    }

    public void buttonCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout"))).click();
    }

}
