package ayushgautamLLC.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homepage {
	
	@Test
	public void homeTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jio.com");
		
		driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-center slick-current']//div//a")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='carousel-nav-right css-10ygab0']//div[@id='right-icon']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slick-slide slick-active slick-center slick-current')]//div//a")).click();
		driver.navigate().back();
	}
	
	

}
