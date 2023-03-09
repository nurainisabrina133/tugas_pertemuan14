package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Buttons {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror

        String url = "https://formy-project.herokuapp.com/buttons";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        //Check Button
//        driver.findElement(By.xpath("//button[normalize-space()='Primary']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Success']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Warning']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Danger']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Info']")).click();// driver.findElement(By.xpath("//button[normalize-space()='Link']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Left']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Middle']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Right']")).click();


//        driver.findElement(By.xpath("//button[normalize-space()='Middle']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Right']");


        String textFrame = driver.findElement(By.xpath("//button[@id='btnGroupDrop1']")).getText();
        System.out.println(textFrame);
        driver.switchTo().defaultContent(); //keluar dari frame
        String descFrame = driver.findElement(By.xpath("//a[normalize-space()='Dropdown link 1']")).getText();
        System.out.println(descFrame);
//        String descFrame1 = driver.findElement(By.xpath("//a[normalize-space()='Dropdown link 2']")).getText();
//        System.out.println(descFrame1);
        driver.findElement(By.id("btnGroupDrop1")).click();
        System.out.println("Button ok");


        // Verify
        System.out.println("Test Case Result: ");
        if (title.equals("FORMY")) {
            System.out.println("pass");
        } else {
            System.out.println("Filed");

        }
        System.out.println("Delay 3 s");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}

