import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class flightReservation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ryanair.com/gb/en");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        // accept all cookies
        driver.findElement(By.cssSelector("div[id='cookie-popup-with-overlay'] button[class='cookie-popup-with-overlay__button']")).click();

        // choose the destination country
        driver.findElement(By.id("input-button__destination")).click();
        Thread.sleep(1000);
        List<WebElement> countries = driver.findElements(By.cssSelector("fsw-countries[class='airports__countries ng-star-inserted']"));

        for (WebElement option : countries) {
            if (option.getText().equalsIgnoreCase("Sweden")) {
                option.click();
                break;
            }
        }
        // choose the destination city, airport and dates
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[data-id='ARN']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[data-id='Dec']")).click();
        driver.findElement(By.cssSelector("div[data-id='2023-12-29']")).click();
        driver.findElement(By.cssSelector("div[data-id='2024-01-07']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("ry-tooltip[id='ry-tooltip-12'] ry-counter-button[aria-label='1Adults+1']")).click();


    }
}
