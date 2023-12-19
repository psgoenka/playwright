package com.pages;

import com.microsoft.playwright.Page;
public class HomePage {
    Page page;
    String productName_1 ="id=item_4_title_link";

    String clickAddToCart = "//div[.='Sauce Labs Backpack']/parent::a/parent::div/parent::div/div[3]/button";

    String clickShoppingCart = "//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']";

    public HomePage(Page page) {
        this.page =page;
    }
    public String productName() {
        String productName = page.textContent(productName_1);
        return productName;
    }

    public void clickOnAddToCart() {
        page.click(clickAddToCart);
    }

    public void clickOnShoppingCart() {
        page.click(clickShoppingCart);
    }
}
