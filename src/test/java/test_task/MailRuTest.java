package test_task;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test_task.pages.SignInPage;

import java.time.Duration;

/*
@param login — подставьте свою почту для логина
@param addressee — подставьте почту своего адресата
 */
public class MailRuTest {
    private static final String login = "login";
    private static final String addressee = "addressee";
    private static final String subject = "TestSubject";
    private static final String message = "TestMessage";
    private static SignInPage signInPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        signInPage = new SignInPage(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mail.ru/");
    }

    @AfterClass
    public static void close() {
        driver.close();
    }

    @Test
    public void testLogin() throws InterruptedException {
        signInPage.login(login)
                .sendMessage(addressee, subject, message);
    }
}