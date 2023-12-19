package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    String username = "id=user-name";
    String password = "id=password";
    String clickLogin = "id=login-button";
    String clickHamburger = "//button[normalize-space()='Open Menu']";
    String clickLogout = "id=logout_sidebar_link";
    public LoginPage(Page page) {
        this.page = page;
    }

    public String verifyTitle() {
        String title = page.title();
        return title;
    }

    public void loginIntoApplication(String email, String pass) {
        enterUserName(email);
        enterPassword(pass);
        clickLoginButton();
    }

    public void logoutApplication() {
        clickOnHamburger();
        clickOnLogout();
    }

    public void enterUserName(String email) {
        page.fill(username, email);
    }

    public void enterPassword(String pass) {
        page.fill(password, pass);
    }

    public void clickLoginButton() {
        page.click(clickLogin);
    }

    public void clickOnHamburger() {
        page.click(clickHamburger);
    }

    public void clickOnLogout() {
        page.click(clickLogout);
    }

}
