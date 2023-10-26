package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrl {
    public void automatePost(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.linkedin.com/");
        List<WebElement> anchorTags =  driver.findElements(By.tagName("a"));
        System.out.println("Total Number of anchor tags are : "+ anchorTags.size());
        driver.quit();
    }
    
}
