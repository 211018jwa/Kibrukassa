package com.revature.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/kibru.html");

		// Locate the 2 input elements and button for adding numbers

		WebElement addinput1 = driver.findElement(By.id("AddNum1"));
		WebElement addinput2 = driver.findElement(By.id("AddNum2"));
		WebElement addButton = driver.findElement(By.id("AddBtn"));

		addinput1.sendKeys("10.5"); // type 10.5 into the first input element
		addinput2.sendKeys("15.3"); // type 15.3 into the second input element
		addButton.click(); // Click the button

		driver.switchTo().frame("result");
		WebElement addoutput = driver.findElement(By.tagName("pre"));
		System.out.println("The result of adding 10.5 and 15.3 is " + addoutput.getText());

		driver.switchTo().defaultContent();
		// driver.switchTo().parentFrame();

	// Subtraction

		WebElement Subinput1 = driver.findElement(By.id("SubNum1"));
		WebElement Subinput2 = driver.findElement(By.id("SubNum2"));
		WebElement SubButton = driver.findElement(By.id("SubBtn"));

		Subinput1.sendKeys("100");
		Subinput2.sendKeys("15.3");
		SubButton.click();

		driver.switchTo().frame("difference");
		WebElement suboutput = driver.findElement(By.tagName("pre"));
		System.out.println("The result of adding 10.5 and 15.3 is " + suboutput.getText());

		driver.switchTo().defaultContent();
		// driver.switchTo().parentFrame();

		// Multiplication	

		WebElement Mulinput1 = driver.findElement(By.id("MulNum1"));
		WebElement Mulinput2 = driver.findElement(By.id("MulNum2"));
		WebElement MulButton = driver.findElement(By.id("MulBtn"));

		Mulinput1.sendKeys("10.5");
		Mulinput2.sendKeys("15.3");
		MulButton.click();

		driver.switchTo().frame("multiply");

		WebElement muloutput = driver.findElement(By.tagName("pre"));
		System.out.println("The result of adding 10.5 and 15.3 is " + muloutput.getText());

		driver.switchTo().defaultContent();
		// driver.switchTo().parentFrame();

		// Division

		WebElement Divinput1 = driver.findElement(By.id("DivNum1"));
		WebElement Divinput2 = driver.findElement(By.id("DivNum2"));
		WebElement DivButton = driver.findElement(By.id("DivBtn"));

		Divinput1.sendKeys("100.5");
		Divinput2.sendKeys("15.3");
		DivButton.click();

		driver.switchTo().frame("divide");

		WebElement divoutput = driver.findElement(By.tagName("pre"));
		System.out.println("The result of adding 10.5 and 15.3 is " + divoutput.getText());

		 //driver.switchTo().defaultContent();

		driver.switchTo().parentFrame();

		Thread.sleep(5000); // Pausing for 5 seconds

		driver.quit();

	}

}