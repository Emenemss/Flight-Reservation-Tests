package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Destinations {
    WebDriver driver;

    @BeforeTest
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ryanair.com/gb/en");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        // accept all cookies
        driver.findElement(By.cssSelector("div[id='cookie-popup-with-overlay'] button[class='cookie-popup-with-overlay__button']")).click();
        driver.findElement(By.id("input-button__destination")).click();
        Thread.sleep(500);
    }

    @Test
    public void Berlin() {
        driver.findElement(By.cssSelector("span[data-id='BER']")).click();
        System.out.println(driver.findElement(By.id("input-button__destination")).getText());
    }

    @Test
    public void Wroclaw() throws InterruptedException {
        // validate that greyed out destinations cannot be chosen
        Thread.sleep(200);
        driver.findElement(By.id("input-button__destination")).click();
        driver.findElement(By.cssSelector("button[class='list__clear-selection ry-button--anchor-blue ry-button--anchor']")).click();
        driver.findElement(By.cssSelector("span[data-id='WRO']")).click();
        System.out.println(driver.findElement(By.id("input-button__destination")).getText());
    }

    @Test
    public void Vienna() throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(By.id("input-button__destination")).click();
        driver.findElement(By.cssSelector("button[class='list__clear-selection ry-button--anchor-blue ry-button--anchor']")).click();
        driver.findElement(By.cssSelector("span[data-id='ARN']")).click();
        System.out.println(driver.findElement(By.id("input-button__destination")).getText());
    }
}



