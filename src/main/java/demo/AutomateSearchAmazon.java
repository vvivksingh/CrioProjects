package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateSearchAmazon {
    public void searchAmazon() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        WebElement textBox = driver.findElement(By.xpath("//textarea[@name = \"q\"]  "));
        textBox.sendKeys("amazon");
        textBox.sendKeys(Keys.ENTER);
        boolean flag = driver.findElement(By.xpath("//*[contains(text(), 'amazon.in')]")).isDisplayed();
        System.out.println("Amazon.in is visible in the search result : " + flag);
        driver.quit();

    }

}