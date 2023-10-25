package demo;


 import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    public static void main(String[] args) {
        AutomateSearchAmazon searchAmazonObj = new AutomateSearchAmazon();
        searchAmazonObj.searchAmazon();
        
    }
    
    
 
}
