package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShowAutomation {
    public void bookMyShow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Step 1: Navigate to the URL
        String url = "https://in.bookmyshow.com/explore/home/chennai";
        driver.get(url);

        // Step 2: Find the image URLs for all "Recommended Movies"
        WebElement recommendedMoviesSection = driver
                .findElement(By.xpath("//div[contains(@class, 'RecommendedMovies')]"));
        // Assuming each recommended movie is represented by a div
        // You may need to adjust this XPath based on the actual structure of the page
        java.util.List<WebElement> recommendedMovieElements = recommendedMoviesSection
                .findElements(By.xpath(".//div[@class='styles__Card-ik81dc-2']"));

        for (WebElement movieElement : recommendedMovieElements) {
            WebElement imageElement = movieElement.findElement(By.tagName("img"));
            String imageURL = imageElement.getAttribute("src");
            System.out.println("Recommended Movie Image URL: " + imageURL);
        }

        // Step 3: Print the URLs (already done above)

        // Step 4: Print Name & Language of the 2nd item in the "Premiere" list
        WebElement premiereSection = driver.findElement(By.xpath("//div[contains(@class, 'Premiere')]"));
        java.util.List<WebElement> premiereItems = premiereSection
                .findElements(By.xpath(".//div[@class='styles__Container-sc-13bl2g3-0']"));

        if (premiereItems.size() >= 2) {
            WebElement secondPremiere = premiereItems.get(1); // 0-based index
            String name = secondPremiere.findElement(By.xpath(".//h1")).getText();
            String language = secondPremiere.findElement(By.xpath(".//h2")).getText();
            System.out.println("Name of the 2nd Premiere: " + name);
            System.out.println("Language of the 2nd Premiere: " + language);
        } else {
            System.out.println("Premiere list doesn't have a 2nd item");
        }

        // Close the WebDriver
        driver.quit();
    }
}
