package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Main {

    private int validateFactorial(int number) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessie\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cameramatics.pythonanywhere.com/");
        WebElement textBox = driver.findElement(By.xpath("//input[@type = 'text']"));
        textBox.sendKeys(String.valueOf(number));
        WebElement calculate_button = driver.findElement(By.id("getFactorial"));
        calculate_button.click();
        Thread.sleep(4000);
        String value = driver.findElement(By.xpath("//p[@id='resultDiv']")).getText().split(":")[1].trim();
        driver.quit();
        return Integer.parseInt(value);
    }

    @DataProvider(name = "test1")
    private static Object[][] factorials() {
        return new Object[][] {{3, 6},{5,120}};
    }

    @Test(dataProvider = "test1")
    public void testFactorial(int number,int factorial) throws InterruptedException {
        Assert.assertEquals(factorial,validateFactorial(number));
    }
}

