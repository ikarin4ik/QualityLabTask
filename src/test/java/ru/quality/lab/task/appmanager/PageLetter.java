package ru.quality.lab.task.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertEquals;

public class PageLetter {
    private FirefoxDriver wd;


    public PageLetter(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void sendLetter() {
        wd.findElement(By.xpath("//div[@data-name='send']")).click();
        assertEquals("Ваше письмо отправлено. Перейти во Входящие",
                wd.findElement(By.cssSelector("div.message-sent__title")).getText());
    }

    public void writeLetter(String emailTo, String text) {
        wd.findElement(By.cssSelector("div.b-toolbar__item a")).click();
        WebElement to = wd.findElement(By.xpath("//textarea[@data-original-name='To']"));
        to.click();
        to.clear();
        to.sendKeys(emailTo);
        WebElement tinyMce = wd.findElement(By.cssSelector("td.mceIframeContainer > iframe"));
        wd.switchTo().frame(tinyMce);
        WebElement body = wd.findElement(By.cssSelector("body"));
        body.click();
        body.sendKeys(text);
        wd.switchTo().parentFrame();
    }
}
