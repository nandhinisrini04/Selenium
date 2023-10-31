package com.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnyWhereProduct {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		WebElement Ele=driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[1]/a"));
		Actions ac=new Actions(driver);
		ac.moveToElement(Ele).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[1]/div/div/div/div/div[3]/ul/li[1]/ul/li/a")).click();
		String str=driver.getCurrentUrl();
		String str1="https://www.automationanywhere.com/products/process-discovery";
		if(str.equals(str1)) {
			System.out.println("Website is navigating to correct page.");
		}
		else {
			System.out.println("Website is not navigating to correct page.");
		}
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
