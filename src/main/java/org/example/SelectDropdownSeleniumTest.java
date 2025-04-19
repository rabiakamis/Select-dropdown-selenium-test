package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class SelectDropdownSeleniumTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

                //sayfaya git
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //dropdown menusunu bul
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //dorpdowndan secenek sec
        select.selectByVisibleText("Option 1");

        WebElement selectedOption = select.getFirstSelectedOption();
        if (selectedOption.getText().equals("Option 1")) {
            System.out.println("✅ Doğru seçenek seçildi: " + selectedOption.getText());
        } else {
            System.out.println("❌ Seçilen seçenek doğru değil!");
        }

        try {
            Thread.sleep(3000); // 3 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tarayıcıyı kapat
        driver.quit();

    }
}