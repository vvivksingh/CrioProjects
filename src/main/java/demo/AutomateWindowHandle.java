package demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

public class AutomateWindowHandle {
    public void handleWindow() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        WebElement frame = driver.findElement(By.name("iframeResult"));
        driver.switchTo().frame(frame);
        WebElement ele = driver.findElement(By.xpath("//button[text()=\"Try it\"]"));
        ele.click();
        String parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Get the URL and Title of the new window
        String newWindowUrl = driver.getCurrentUrl();
        String newWindowTitle = driver.getTitle();
        System.out.println("New Window url : " + newWindowUrl);
        System.out.println("New Window Title : " + newWindowTitle);
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "F:\\JavaSeleniumWorkSpace\\JavaSeleniumPractice\\src\\screenshot.png";
        FileHandler.copy(screenshotFile, new File(screenshotPath));
        // Close the WebDriver instance
        driver.switchTo().window(parentWindow);
        String parentWindowUrl = driver.getCurrentUrl();
        String parentWindowTitle = driver.getTitle();
        System.out.println("Parent Window url : " + parentWindowUrl);
        System.out.println("Parent Window Title : " + parentWindowTitle);
        driver.quit();

    }
    
}
