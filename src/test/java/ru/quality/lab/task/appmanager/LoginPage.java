package ru.quality.lab.task.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private FirefoxDriver wd;

    public LoginPage(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void login(String email, String pass) {
        WebElement login = wd.findElement(By.cssSelector("#mailbox\\:login"));
        type(email, login);
        Select dropdomain = new Select(wd.findElement(By.cssSelector("#mailbox\\:domain")));
        dropdomain.selectByVisibleText("@list.ru");
        WebElement password = wd.findElement(By.cssSelector("#mailbox\\:password"));
        type(pass, password);
        wd.findElement(By.cssSelector("#mailbox [value='Войти']")).click();
    }

    private void type(String keys, WebElement element) {
        element.click();
        element.clear();
        element.sendKeys(keys);
    }
}
