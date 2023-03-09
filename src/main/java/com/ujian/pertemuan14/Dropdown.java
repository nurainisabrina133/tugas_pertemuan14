package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Dropdown {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror

        String url = "https://formy-project.herokuapp.com/dropdown";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        //Dropdown check
        driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
        System.out.println("Select Case");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Checkbox']")).click();
        //driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Complete Web Form']")).click();

        // Verify
        System.out.println("Test Case Result: ");
        if (title.equals("FORMY")) {
            System.out.println("pass");
        } else {
            System.out.println("Filed");

        }
        System.out.println("Delay 13 s");
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}
