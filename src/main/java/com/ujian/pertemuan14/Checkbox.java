package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Checkbox {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://formy-project.herokuapp.com/checkbox";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.id("checkbox-3")).click();
        System.out.println("Check-box Ok Clicked");

        // Verify
        System.out.println("Test Case Result: ");
        if (title.equals("FORMY")) {
            System.out.println("pass");
        } else {
            System.out.println("Filed");
        }
    }
}
