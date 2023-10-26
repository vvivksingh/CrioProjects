package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrl {
    public void getImageSrc(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> imgTags =  driver.findElements(By.xpath("//div[@class=\"style__WidgetContainerBody-sc-lnhrs7-4 YeNog\"]/div//img"));
        for(WebElement imgSrc : imgTags) {
            System.out.println("Image url of element : "+ imgSrc.getAttribute("src"));
        }
        driver.quit();
    }
    
}
