package ru.quality.lab.task.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class SendLetterTest extends TestBase {
    public static final String EMAIL = "test.test0001.test";
    public static final String PASSWORD = "mail123456";
    public static final String EMAILTO = "kassaw1@yandex.ru";
    public static final String TEXT = "Some test text";


    public SendLetterTest() throws IOException {
    }

    @Test
    public void testSendLetter() {
        app.getLoginPage().login(EMAIL, PASSWORD);
        app.getPageLetter().writeLetter(EMAILTO, TEXT);
        app.getPageLetter().sendLetter();

    }

}
