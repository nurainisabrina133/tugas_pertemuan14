package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Datepicker {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://formy-project.herokuapp.com/datepicker";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        //Date tes symbol bebas pass
        //driver.findElement(By.id("datepicker")).sendKeys("13.02.2020");
        driver.findElement(By.id("datepicker")).sendKeys("13-02-2020");
        //driver.findElement(By.id("datepicker")).sendKeys("13/02/2020");
        System.out.println("Date Ok");
    }
}
