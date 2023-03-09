package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = " https://formy-project.herokuapp.com/fileupload";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        //file upload
        driver.findElement(By.xpath("//button[normalize-space()='Choose']")).click();
        WebElement upload_file = driver.findElement(By.xpath("//button[normalize-space()='Choose']"));
        upload_file.sendKeys("C:/Users/Sonali/Desktop/upload.png");
        driver.findElement(By.id("file-upload-field")).sendKeys("gg88.png");
        System.out.println("File Berhasil di upload");
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
        System.out.println("...........................................................");
        System.out.println("File berhasil di hapus");

        // Verify
        System.out.println("Test Case Result: ");
        if (title.equals("FORMY")) {
            System.out.println("pass");
        } else {
            System.out.println("Filed");

        }
        System.out.println("Delay 15 s");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
