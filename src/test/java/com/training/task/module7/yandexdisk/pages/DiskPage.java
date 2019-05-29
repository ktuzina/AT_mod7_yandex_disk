package com.training.task.module7.yandexdisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DiskPage extends AbstractPage {

    private static final String IMAGE_XPATH = "//img[@src='//4.downloader.disk.yandex.by/preview/a6c103f58e055b4d9840fcec5c20797bd61481f18c611e6a09000327e6d24cd7/inf/61nvqgDQiJrylANdIFzxbZDX6WeJoZ8H-Wv7wd61JDhtvCA15wyTl-rH6ihtu67lIuw3h7zcNMca0cfZw-Pv3Q%3D%3D?uid=384263626&filename=0001.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&tknv=v2&size=80x80']";

    @FindBy(xpath = IMAGE_XPATH)
    private WebElement image;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[1]/div/div[2]/div[2]/div/div[1]/div[10]")
    private WebElement trash;

    @FindBy(id = "/trash")
    private WebElement trashLink;

    @FindBy(xpath = "//span[contains(text(), 'Восстановить')]")
    private WebElement restoreOption;

    public DiskPage(WebDriver driver) {
        super(driver);
    }

    public DiskPage moveItemToTrash() {
        new Actions(driver).dragAndDrop(image, trash).build().perform();
        return this;
    }

    public DiskPage restoreItem() {
        trashLink.click();
        new Actions(driver).contextClick(image).build().perform();
        restoreOption.click();
        return this;
    }

    public boolean itemIsMoved() {
        return driver.findElements(By.xpath(IMAGE_XPATH)).isEmpty();
    }
}
