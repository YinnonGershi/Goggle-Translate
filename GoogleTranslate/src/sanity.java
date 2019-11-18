import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class sanity {

	@Test
	void _sanity() throws InterruptedException 
	{
		/* in this function i will check if 
		 * google translate can translate the word 
		 * "hello world" to hebrew
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
		try {Thread.sleep(2500);} catch (Exception e){}  
		
		// catching the translated word text box
		WebElement textOutPut = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span")); 
		
		// confirm if the result is correct 
		if(textOutPut.getText().equals("שלום עולם") == false) 
		{
			fail("ERROR");
		}
		
	}

} 

