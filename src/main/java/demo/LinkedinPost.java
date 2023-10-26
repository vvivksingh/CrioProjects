package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.*;

public class LinkedinPost {
    public void automatePost() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.linkedin.com/");
        driver.findElement(By.id("session_key")).sendKeys("vvivksingh@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("GMAIL@VVK23");
        driver.findElement(By.xpath("//button[contains(text() , \"Sign in\")]")).click();
        Thread.sleep(3000);
        System.out.println("Number of people who view my profile : "
                + driver.findElement(By.xpath("//a[contains(@href, \"/me/profile-views\")]//span/strong")).getText());
        System.out.println("Impression of the profile : " + driver.findElement(By.xpath(
                "//a[contains(@href, \"/in/vivek-kumar-singh-b3a28a219/recent-activity/shares/\")]//span/strong"))
                .getText());
        driver.findElement(By.xpath("//span[text()=\"Start a post\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()=\"Vivek Kumar Singh\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"CONNECTIONS_ONLY\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Done\"]")).click();
        driver.findElement(By.xpath("//div[@data-placeholder = \"What do you want to talk about?\"]"))
                .sendKeys("Strive not to be a success, but rather to be of value. –Albert Einstein");
        driver.findElement(By.xpath("//span[text()=\"Post\"]")).click();
        Thread.sleep(3000);
        boolean flag = driver.findElement(By.xpath(
                "//span[contains(text(),\"Strive not to be a success, but rather to be of value. –Albert Einstein\")]"))
                .isDisplayed();
        System.out.println("Posted Successfully : " + flag);
        driver.quit();
    }

}
