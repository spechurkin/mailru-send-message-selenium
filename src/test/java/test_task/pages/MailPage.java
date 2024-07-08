package test_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class MailPage {

    private final WebDriver driver;
    private final By mailAddressee = xpath("(//input[@type='text'])[1]");
    private final By mailSubject = xpath("//input[@name='Subject']");
    private final By mailTextArea = xpath("//div[@role='textbox']");
    private final By sendMessage = xpath("//span[text()='Отправить']");

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendMessage(String addressee, String subject, String text) {
        // Selenium отказывался находить кнопку "Написать письмо". Спустя часы разбирательств, я так и не понял почему
        driver.get("https://e.mail.ru/compose/");
        driver.findElement(mailAddressee).sendKeys(addressee);
        driver.findElement(mailSubject).sendKeys(subject);
        driver.findElement(mailTextArea).sendKeys(text);
        driver.findElement(sendMessage).click();
    }
}