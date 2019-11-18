import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class copyTranslation {

	@Test
	void copyTranslationButton () 
	{
		/* in this function i will check if 
		 * the copy click button is working
		 */ 
		WebDriver driver = new ChromeDriver();

		// maximize the window
		driver.manage().window().maximize();

		// go to google translate home page
		driver.get("https://translate.google.co.il");  

		// finding the text box to type in
		driver.findElement(By.xpath("//*[@id=\"source\"]")).click(); 

		// typing in the word
		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys("Hello World"); 

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e) {}

		// finding and clicking on the copy translation button 
		WebElement copyTranslationButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[4]"));
		copyTranslationButton.click();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e) {}

		if (copyTranslationButton.isEnabled() == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROE");
		}



	}

}
