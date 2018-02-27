package io.github.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void test1() throws InterruptedException {
        // WebDriverManager сам скачиваает указанный драйвер
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        final WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        final WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
        element.sendKeys("auto", Keys.ENTER);
        try {
            Assert.assertEquals(driver.findElements(By.cssSelector("#rso h3 > a")).size(), 13);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
