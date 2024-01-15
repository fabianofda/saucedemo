package com.saucedemo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.support.Commons;
import com.saucedemo.support.fixtures.Users;

@DisplayName("Suite Login")
public class LoginTest extends BaseTest {

    private LoginPage page;
    private InventoryPage inventoryPage;
    private Users users;
    private Commons commons;

    @Test
    @DisplayName("Login com sucesso")
    public void loginComSucesso() throws Exception {

        page = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        users = new Users();

        Users.UserCredentials standardUserCredentials = users.getStandardUserCredentials();
        page.loginWith(standardUserCredentials.getUsername(), standardUserCredentials.getPassword());
        page.submit();

        boolean isCartVisible = inventoryPage.isCartVisible(); // Atualização aqui
        assertTrue(isCartVisible, "Logout com sucesso.");

    }

    @Test
    @DisplayName("Tentatica de login com usuario bloqueado")
    public void loginComUsuarioBloqueado() throws Exception {
        page = new LoginPage(driver);
        users = new Users();
        commons = new Commons(driver);

        Users.UserCredentials lockedOutUserCredentials = users.getLockedOutUserCredentials();
        page.loginWith(lockedOutUserCredentials.getUsername(), lockedOutUserCredentials.getPassword());
        page.submit();

        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = commons.messageError();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    @DisplayName("Tentatica de login sem informar nome")
    public void loginSemInformarUsername() {
        page = new LoginPage(driver);
        users = new Users();
        commons = new Commons(driver);

        Users.UserCredentials usernameIsRequired = users.getUsernameIsRequired();
        page.loginWith(usernameIsRequired.getUsername(), usernameIsRequired.getPassword());
        page.submit();

        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = commons.messageError();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    @DisplayName("Tentatica de login sem informar a senha")
    public void loginSemInformarPassword() {
        page = new LoginPage(driver);
        users = new Users();
        commons = new Commons(driver);

        Users.UserCredentials passwordIsRequired = users.getPasswordIsRequired();
        page.loginWith(passwordIsRequired.getUsername(), passwordIsRequired.getPassword());
        page.submit();

        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = commons.messageError();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    @DisplayName("Tentatica de login com credenciais invalidas")
    public void loginComCredenciaisInvalidas() {
        page = new LoginPage(driver);
        users = new Users();
        commons = new Commons(driver);

        Users.UserCredentials invalidCredentials = users.getInvalidCredentials();
        page.loginWith(invalidCredentials.getUsername(), invalidCredentials.getPassword());
        page.submit();

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = commons.messageError();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
