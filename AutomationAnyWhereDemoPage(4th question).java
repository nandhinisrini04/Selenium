package com.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnyWhereDemoPage {

	@Test
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/div[1]/div/div/div/div[1]/a")).click();
		String str1=driver.getCurrentUrl();
		String str="https://www.automationanywhere.com/request-live-demo";
		if(str.equals(str1)) {
			System.out.println("Website is navigating to correct page.");
		}
		else {
			System.out.println("Website is not navigating to correct page.");
		}
		String F_name=driver.findElement(By.xpath("//*[@id=\"LblFirstName\"]")).getAttribute("for");
		String L_name=driver.findElement(By.xpath("//*[@id=\"LblLastName\"]")).getAttribute("for");
		System.out.println(F_name+" "+L_name);
		driver.close();
	}
}
