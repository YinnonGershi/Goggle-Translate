import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class documentsTranslation {

	@Test
	void _documentsTranslation() 
	{
		/* in this function i will see if the translation 
		 * integration with computer uploading files is working
		 */

		WebDriver driver = new ChromeDriver();

		// maximize the window
		driver.manage().window().maximize();

		// go to google translate home page
		driver.get("https://translate.google.co.il");   

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		// finding and clicking on "documents" button
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div[2]")).click();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		// finding and clicking on "search in computer" button
		WebElement searchInComputerButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/form/div[1]/label"));
		searchInComputerButton.click();
		
		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		if (searchInComputerButton.isEnabled() == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROE");
		}

	}

}
