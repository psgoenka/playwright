package com.pages;

import com.microsoft.playwright.Page;
public class CartPage {
    Page page;
    String clickCheckout = "//div[@class='cart_footer']/a[2]";

    public CartPage(Page page) {
        this.page = page;
    }
    public void clickOnCheckout() {
        page.click(clickCheckout);
    }
}
