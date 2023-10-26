package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrl {
    public void getImageSrc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://in.bookmyshow.com/explore/home/chennai");
        driver.manage().window().maximize();
        List<WebElement> imgTags = driver
                .findElements(By.xpath("//div[@class=\"style__WidgetContainerBody-sc-lnhrs7-4 YeNog\"]/div//img"));
        for (WebElement imgSrc : imgTags) {
            System.out.println("Image url of element : " + imgSrc.getAttribute("src"));
        }
        Thread.sleep(3000);
        List<WebElement> moviesTitle = driver.findElements(By.xpath(
                "//h2[text() = \"Premieres\"]/ancestor::div[@class=\"sc-133848s-3 cZuToi\"]/following-sibling::div[@class=\"sc-lnhrs7-0 ihaPEr\"]//h3"));
        System.out.println("Title of movie which is at 2 : " + moviesTitle.get(1).getText());
        driver.quit();
    }
}
