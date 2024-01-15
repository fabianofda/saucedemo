package com.sucedemo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sucedemo.pages.CartPage;
import com.sucedemo.pages.CheckoutPage;
import com.sucedemo.pages.InventoryPage;
import com.sucedemo.pages.LoginPage;
import com.sucedemo.support.Checkout;
import com.sucedemo.support.Commons;
import com.sucedemo.support.fixtures.Users;


@DisplayName("Suite Checkout")
public class CheckoutTest extends BaseTest {

    private LoginPage page;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private Users users;
    private CheckoutPage checkout;
    private Commons commons;

    @Test
    @DisplayName("Deve finalizar uma compra com sucesso")
    public void finalizarUmaCompraComSucesso() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        users = new Users();
        checkout = new CheckoutPage(driver);
        commons = new Commons(driver);

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonAddToCart("Sauce Labs Backpack");
        inventoryPage.linkCart();

        cartPage.buttonCheckout();

        checkout.fillFormCheckout("a", "a", "a");
        checkout.buttonContinue();

        Checkout checkoutInfo = checkout.validateInformationNoCheckout();

        assertEquals("1", checkoutInfo.getQty());
        assertEquals(
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                checkoutInfo.getDescription());
        assertEquals("$29.99", checkoutInfo.getPrice());

        checkout.buttonFinish();

        assertEquals("Thank you for your order!", checkout.confirmationMessage());
    }

    @Test
    @DisplayName("Tentativa de checkout sem informar first name")
    public void validarCheckoultSemFirstName() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        users = new Users();
        checkout = new CheckoutPage(driver);
        commons = new Commons(driver);

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonAddToCart("Sauce Labs Backpack");
        inventoryPage.linkCart();

        cartPage.buttonCheckout();

        checkout.fillFormCheckout("", "a", "a");
        checkout.buttonContinue();

        String expectedErrorMessage = "Error: First Name is required";

        assertEquals(expectedErrorMessage, commons.messageError());
    }

    @Test
    @DisplayName("Tentativa de checkout sem informar last name")
    public void validarCheckoultSemLastName() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        users = new Users();
        checkout = new CheckoutPage(driver);
        commons = new Commons(driver);

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonAddToCart("Sauce Labs Backpack");
        inventoryPage.linkCart();

        cartPage.buttonCheckout();

        checkout.fillFormCheckout("Q", "", "a");
        checkout.buttonContinue();

        String expectedErrorMessage = "Error: Last Name is required";

        assertEquals(expectedErrorMessage, commons.messageError());
    }

    @Test
    @DisplayName("Tentativa de checkout sem informar zip postal code")
    public void validarCheckoultSemZipPostalCode() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        users = new Users();
        checkout = new CheckoutPage(driver);
        commons = new Commons(driver);

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonAddToCart("Sauce Labs Backpack");
        inventoryPage.linkCart();

        cartPage.buttonCheckout();

        checkout.fillFormCheckout("Q", "A", "");
        checkout.buttonContinue();

        String expectedErrorMessage = "Error: Postal Code is required";

        assertEquals(expectedErrorMessage, commons.messageError());
    }

}
