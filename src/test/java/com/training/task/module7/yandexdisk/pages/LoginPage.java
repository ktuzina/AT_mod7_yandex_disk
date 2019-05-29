package com.training.task.module7.yandexdisk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//a[contains(@class, 'button_login')]")
    private WebElement loginLink;

    @FindBy(id = "passp-field-login")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(@class, 'passp-form-button')]")
    private WebElement signInButton;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DiskPage loginUser() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        emailField.sendKeys("edit.crypt@yandex.ru");
        signInButton.click();
        passwordField.sendKeys("editcrypt");
        signInButton.click();
        return new DiskPage(driver);
    }
}
