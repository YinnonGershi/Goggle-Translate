import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class switchLanguage {

	@Test
	void switchLanguageToEnglish() 
	{
		/* in this function i will check if 
		 * the switch button is working
		 */

		WebDriver driver = new ChromeDriver();

		// maximize the window
		driver.manage().window().maximize();

		// go to google translate home page
		driver.get("https://translate.google.co.il");  

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		// finding the text box to type in
		driver.findElement(By.xpath("//*[@id=\"source\"]")).click(); 

		// typing in the word
		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys("Hello World"); 

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		// finding and clicking on switch language button
		Actions act = new Actions(driver);
		WebElement switchButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div/div"));
		act.click(switchButton).perform();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){}

		// finding translation word after switching and clarifying correctness
		WebElement finalFranslatedWord = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span"));
		act.click(finalFranslatedWord);
	
		// confirming switching language 
		if (finalFranslatedWord.getText().equals("Hello World") == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROR");
		}
	}

}
