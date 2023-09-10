package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Passengers {

    WebDriver driver;

    @BeforeTest
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ryanair.com/gb/en");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div[id='cookie-popup-with-overlay'] button[class='cookie-popup-with-overlay__button']")).click();
        driver.findElement(By.id("input-button__destination")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[data-id='GOT']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[data-id='Dec']")).click();
        driver.findElement(By.cssSelector("div[data-id='2023-12-30']")).click();
        driver.findElement(By.cssSelector("div[data-id='2024-01-06']")).click();

    }

    @Test
    // validate that the number of passengers cannot be less than 1
    public void passengersAdult() {
        String count = driver.findElement(By.cssSelector("ry-counter[data-ref='passengers-picker__adults'] [data-ref='counter.counter__value']")).getText();
        if (count.contains("0")) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void passengersChildren() {
        // validate that adding more passengers changes the count
        driver.findElement(By.cssSelector("ry-counter[data-ref='passengers-picker__children'] [class='counter__button-wrapper--enabled']")).click();
        String count = driver.findElement(By.cssSelector("ry-counter[data-ref='passengers-picker__children'] [data-ref='counter.counter__value']")).getText();
        System.out.println(count);
        if (count.contains("1")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

}
