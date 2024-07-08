package test_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class SignInPage {
    private final WebDriver driver;
    private final By loginButton = xpath("//button[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big mkopfmf__10hc17k']");
    private final By email = xpath("//input[@placeholder='Имя аккаунта']");
    private final By login = xpath("//span[text()='Войти']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage login(String loginEmail) throws InterruptedException {
        driver.findElement(loginButton).click();
        driver.switchTo().frame(driver.findElement(xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        driver.findElement(email).sendKeys(loginEmail);
        driver.findElement(login).click();
        // На этом моменте включена задержка для ввода кода из СМС, а также для загрузки новой страницы
        Thread.sleep(Duration.ofSeconds(30));
        return new MailPage(driver);
    }
}