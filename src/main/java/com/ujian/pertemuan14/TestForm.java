package com.ujian.pertemuan14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestForm{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //untuk mengetahui misal ada eror
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String TitleHeader = driver.getTitle();
        System.out.println("title header: " + TitleHeader);
        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("ini header judul website: " + title);

        //form identty text
        driver.findElement(By.id("first-name")).sendKeys("Sambo");
        driver.findElement(By.id("last-name")).sendKeys("ferdo");
        driver.findElement(By.id("job-title")).sendKeys("Tukang bass");

        // input identity just number
//        driver.findElement(By.id("first-name")).sendKeys(";;.;.;'");
//        driver.findElement(By.id("last-name")).sendKeys(";.';.';");
//        driver.findElement(By.id("job-title")).sendKeys("][]-[;.;, ");

        // input identity just symbol
//        driver.findElement(By.id("first-name")).sendKeys("87876876");
//        driver.findElement(By.id("last-name")).sendKeys("765758978");
//        driver.findElement(By.id("job-title")).sendKeys("786787 ");
        System.out.println( "Form identity can input number, symbol, text and combination of the three");

//................................................................................
        //radio-button check

        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("radio-button-3")).click();
        System.out.println("Radio button Ok Clicked");

        // check-box
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.id("checkbox-3")).click();
        System.out.println("Check-box Ok Clicked");
        // Scroll by pixel (Vertical)
        js.executeScript("window.scrollBy(0, 500)");

        // Check select menu
        WebElement selectExperience = driver.findElement(By.id("select-menu"));
        Select experience = new Select(selectExperience);
        experience.selectByValue("4");
        experience.selectByIndex(1);
//        experience.selectByIndex(2);
//        experience.selectByIndex(3);
//        experience.selectByIndex(4);

        System.out.println("Test Select ");


        //Check-Date
        driver.findElement(By.id("datepicker")).sendKeys("13/02/2020");;
        System.out.println("Date Ok");

        // Submit
        driver.findElement(By.xpath("//a[@role='button']")).click();
        System.out.println("Data berhasil disimpan");
        System.out.println("=====Delay 5 second=====");


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