package com.sucedemo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sucedemo.pages.InventoryPage;
import com.sucedemo.pages.LoginPage;
import com.sucedemo.support.FilterList;
import com.sucedemo.support.fixtures.Users;

@DisplayName("Suite Inventory")
public class InventoryTest extends BaseTest {

    private LoginPage page;
    private InventoryPage inventoryPage;
    private Users users;
    private FilterList list;

    @Test
    @DisplayName("Deve fazer logout com sucesso")
    public void DeveDeslogarComSucesso() {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();

        Users.UserCredentials visualUserCredentials = users.getVisualUserCredentials();
        page.loginWith(visualUserCredentials.getUsername(), visualUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonBurguer();

        inventoryPage.linkLogout();

        boolean isLoginContainerVisible = page.loginContainer();
        assertTrue(isLoginContainerVisible, "Logout com sucesso.");
    }

    @Test
    @DisplayName("Deve inserir umm produto no carrinho")
    public void inserirUmProdutoNoCarrinho() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.buttonAddToCart("Sauce Labs Backpack");

        int quantityInCart = inventoryPage.getQuantityOfItemsInCart();
        assertEquals(1, quantityInCart);

    }

    @Test
    @DisplayName("Deve remover um produto do carrinho")
    public void removerUmProdutoDoCarrinho() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        String produto = "Sauce Labs Backpack";

        inventoryPage.buttonAddToCart(produto);
        inventoryPage.buttonRemoveFromCart(produto);

        int quantityInCart = inventoryPage.getQuantityOfItemsInCart();
        assertEquals(0, quantityInCart);

    }

    @Test
    @DisplayName("Deve filtrar por nome de A to Z")
    public void filtarPorNameAZ() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();
        list = new FilterList();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.selectSortOptionByNameAZ();

        List<String> itemNames = inventoryPage.getItemNames();

        assertTrue(list.isListInAscendingOrder(itemNames), "A lista não está em ordem crescente após a ordenação AZ.");

    }

    @Test
    @DisplayName("Deve filtrar por nome de Z to A")
    public void filtarPorNameZA() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();
        list = new FilterList();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.selectSortOptionByNameZA();

        List<String> itemNames = inventoryPage.getItemNames();

        assertTrue(list.isListInDescendingOrder(itemNames), "A lista não está em ordem decrescente.");

    }

    @Test
    @DisplayName("Deve filtrar por preço de Low to High")
    public void filtarPorPriceLowToHigh() throws InterruptedException {

        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();
        list = new FilterList();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.selectSortOptionByPriceLowToHigh();

        List<String> priceList = inventoryPage.getItemPrices();

        assertTrue(list.isPriceListInAscendingOrder(priceList),
                "A lista de preços não está em ordem crescente após a ordenação Low to High.");

    }

    @Test
    @DisplayName("Deve filtrar por preço de High to Low")
    public void filtarPorPriceHighToLow() throws InterruptedException {
        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();
        list = new FilterList();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        inventoryPage.selectSortOptionByPriceHighToLow();

        List<String> priceList = inventoryPage.getItemPrices();

        assertTrue(list.isPriceListInDescendingOrder(priceList),
                "A lista de preços não está em ordem decrescente após a ordenação High to Low.");
    }

}
