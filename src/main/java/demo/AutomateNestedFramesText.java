package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateNestedFramesText {
    public void iFrames() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        int frameCount = driver.findElements(By.tagName("frame")).size();
        // Loop through the frames
        for (int i = 0; i < frameCount; i++) {
            // Switch to the current frame
            driver.switchTo().frame(i);
            // Print the text in the frame
            WebElement frameElement = driver.findElement(By.tagName("body"));
            String frameText = frameElement.getText();
            System.out.println("Text in Frame " + i + ":\n" + frameText);

            // Switch back to the main content (out of the frame)
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement frameElement = driver.findElement(By.tagName("body"));
        String frameText = frameElement.getText();
        System.out.println("Text in Buttom Frame " + ":\n" + frameText);

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.quit();

    }
    
    
}
