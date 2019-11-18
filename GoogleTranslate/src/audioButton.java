import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class audioButton {

	@Test
	void test() {
		/* in this function i will check if 
		 * the audio is working
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
		
		// finding and clicking on translated audio button  
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[5]/div")).click();
		
		// stops to run for 5 seconds
		try {Thread.sleep(5000);} catch (Exception e){} 
		
		if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[5]/div")).isEnabled() == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROR");
		}
		
	}

}
