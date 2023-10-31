package com.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThirdAndFourth {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");// Redirecting to that website
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void VerifyProductPage() throws InterruptedException{
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();  //click accept cookies
		WebElement Ele=driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[1]/a"));
		Actions ac=new Actions(driver);
		ac.moveToElement(Ele).build().perform();  // Mouse hover on the products
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[1]/div/div/div/div/div[3]/ul/li[1]/ul/li/a")).click();// click the process delivery
		String str=driver.getCurrentUrl();
		String str1="https://www.automationanywhere.com/products/process-discovery";
		Assert.assertEquals(str,str1,"Both links was matched"); // validate the URL
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void VerifyRequestDemo() throws InterruptedException {
		driver.navigate().back();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[1]/div[2]/a"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		element.click();
		String str1=driver.getCurrentUrl();
		String str="https://www.automationanywhere.com/request-live-demo-2";
		Assert.assertEquals(str1, str);
		String F_name=driver.findElement(By.xpath("//*[@id=\"LblFirstName\"]")).getAttribute("for");
		String L_name=driver.findElement(By.xpath("//*[@id=\"LblLastName\"]")).getAttribute("for");
		Assert.assertEquals(F_name, "FirstName");
		Assert.assertEquals(L_name, "LastName");
		Thread.sleep(2000);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
