package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRatings {
    public void imdbRatings() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(" https://www.imdb.com/chart/top");
        Select dropDown = new Select(driver.findElement(By.id("sort-by-selector")));
        dropDown.selectByVisibleText("IMDb rating");
        Thread.sleep(3000);
//        WebElement element = driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]"));

        System.out.println("Movie Name with highest rating : " + driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]//h3")).getText());
        System.out.println("Number of Movies in the list : " + driver.findElements(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li")).size());
        dropDown.selectByVisibleText("Release date");
        Thread.sleep(3000);
        System.out.println("Most Recent Movie Name: " + driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]//h3")).getText());
        driver.findElement(By.id("swap-sort-order-button")).click();
        Thread.sleep(3000);
        System.out.println("Oldest Movie Name: " + driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]//h3")).getText());
        dropDown.selectByVisibleText("Number of ratings");
        Thread.sleep(3000);
        System.out.println("Movie with most user ratings: " + driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]//h3")).getText());
        driver.quit();


    }
    
}
