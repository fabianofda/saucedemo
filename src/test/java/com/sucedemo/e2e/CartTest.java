package com.sucedemo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sucedemo.pages.CartPage;
import com.sucedemo.pages.InventoryPage;
import com.sucedemo.pages.LoginPage;
import com.sucedemo.support.Product;
import com.sucedemo.support.fixtures.Users;

@DisplayName("Suite Cart")
public class CartTest extends BaseTest {

        private LoginPage page;
        private InventoryPage inventoryPage;
        private CartPage cartPage;
        private Users users;

        @Test
        @DisplayName("Deve validar carrinho de compras")
        public void validarCarrinhoDeCompras() throws InterruptedException {
                page = new LoginPage(driver);
                inventoryPage = new InventoryPage(driver);
                cartPage = new CartPage(driver);
                users = new Users();

                Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
                page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
                page.submit();

                inventoryPage.buttonAddToCart("Sauce Labs Backpack");
                inventoryPage.buttonAddToCart("Sauce Labs Bike Light");
                inventoryPage.linkCart();

                assertEquals(2, cartPage.getQuantityOfItemsInCart());

                Product product1 = new Product("Sauce Labs Backpack",
                                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                                "$29.99");

                Product product2 = new Product("Sauce Labs Bike Light",
                                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                                "$9.99");

                assertEquals("Detalhes do item correspondem: Nome: " + product1.getName() + ", Descrição: "
                                + product1.getDescription()
                                + ", Preço: " + product1.getPrice(),
                                cartPage.validateCartItemDetails(product1));

                assertEquals(
                                "Detalhes do item correspondem: Nome: " + product2.getName() + ", Descrição: "
                                                + product2.getDescription()
                                                + ", Preço: " + product2.getPrice(),
                                cartPage.validateCartItemDetails(product2));
        }
}
