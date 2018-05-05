package ru.quality.lab.task.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;
    public static final String URL = "https://mail.ru/";

    private LoginPage loginPage;
    private PageLetter pageLetter;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get(URL);
        pageLetter = new PageLetter(wd);
        loginPage = new LoginPage(wd);
    }

    public void stop() {
        wd.quit();
    }

    public PageLetter getPageLetter() {
        return pageLetter;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
