package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class BookMyShowHyperLink {
    public void hyperLinkCount(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> anchorTags =  driver.findElements(By.tagName("a"));
        System.out.println("Total Number of anchor tags are : "+ anchorTags.size());
        driver.quit();
    }
    
}
