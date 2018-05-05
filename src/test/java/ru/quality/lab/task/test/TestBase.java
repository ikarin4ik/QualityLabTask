package ru.quality.lab.task.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.quality.lab.task.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    public TestBase() throws IOException {
    }

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
