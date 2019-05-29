package com.training.task.module7.yandexdisk.tests;

import com.training.task.module7.yandexdisk.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class YandexDiskTest {

    private WebDriver driver;

    @BeforeMethod(description = "Opens yandex disk")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://disk.yandex.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void moveFileToTrash() {
        boolean isMoved = new LoginPage(driver).loginUser().moveItemToTrash().itemIsMoved();
        assertThat(isMoved).isTrue();
    }

    @Test
    public void restoreFile() {
        boolean isMoved = new LoginPage(driver).loginUser().restoreItem().itemIsMoved();
        assertThat(isMoved).isTrue();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
