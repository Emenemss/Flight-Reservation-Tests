import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
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

        // add another passenger
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("ry-counter[data-ref='passengers-picker__adults'] div[class='counter__button-wrapper--enabled']")).click();
        driver.findElement(By.cssSelector("button[class='flight-search-widget__start-search ng-tns-c2080360900-3 ry-button--gradient-yellow']")).click();

        // confirm flight selection
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='flight-card-summary__select-btn ng-tns-c2051464752-16 ry-button--gradient-blue']")));
        driver.findElement(By.cssSelector("button[class='flight-card-summary__select-btn ng-tns-c2051464752-16 ry-button--gradient-blue']")).click();
        driver.findElement(By.cssSelector("button[class='flight-card-summary__select-btn ng-tns-c2051464752-13 ry-button--gradient-blue']")).click();

        // confirm flight plan
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='fare-table__fare-column-border'])[1]")));
        driver.findElement(By.xpath("(//div[@class='fare-table__fare-column-border'])[1]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='fare-footer__submit-btn ry-button--outline-light-blue'])[1]")));
        driver.findElement(By.xpath("(//button[@class='fare-footer__submit-btn ry-button--outline-light-blue'])[1]")).click();

        Thread.sleep(500);
        driver.close();

    }
}
