package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginCucumberTest {

    LoginPage login;
    HomePage home;
    Playwright playwright = Playwright.create();
    BrowserType firefox = playwright.firefox();
    Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    CartPage cart  = new CartPage(page);

    @Given("User launched SwagLabs application")
    public void user_launched_swag_labs_application() {
        page.navigate("https://www.saucedemo.com/v1/");
        home = new HomePage(page);
        login = new LoginPage(page);
    }

    @When("User verify the Page title")
    public void user_verify_the_page_title() {
        String title = login.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        login.loginIntoApplication(username, password);
    }

    @Then("User verify the product name {string}")
    public void user_verify_the_product_name(String productname) {
        Assert.assertEquals(productname, home.productName());
    }

    @Then("User logout from the application")
    public void user_logout_from_the_application() {
        login.logoutApplication();
    }

    @When("User can add the product into cart")
    public void user_can_add_the_product_into_cart() {
        home.clickOnAddToCart();
    }

    @Then("assert user can view the product name {string} in the cart list")
    public void assert_user_can_view_the_product_name_in_the_cart_list(String productname) {
//        Assert.assertEquals(productname, cartPage.productName());
        Assert.assertEquals(productname, home.productName());
    }

    @When("user click on shopping cart")
    public void user_click_on_shopping_cart() {
        home.clickOnShoppingCart();
    }

    @And("User can checkout product from the shopping cart")
    public void user_can_checkout_product_from_the_shopping_cart() {
        cart.clickOnCheckout();
    }
}
