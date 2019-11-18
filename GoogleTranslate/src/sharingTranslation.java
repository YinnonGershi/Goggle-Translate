import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class sharingTranslation {

	@Test
	void sharingTranslationInEmail () 
	{
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

		// finding and clicking on sharing button
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div")).click();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){} 

		// finding and clicking on email sharing button
		WebElement emailSharingButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div/div/ul/li[1]/a/span[1]"));
		emailSharingButton.click();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){} 
		
		String firstTab = driver.getWindowHandle();
		
		for (String secondTab : driver.getWindowHandles())
		{
			driver.switchTo().window(secondTab);
		}
		
		if (driver.getCurrentUrl().contains("mail") == true)
		{
			driver.close();
			driver.switchTo().window(firstTab);
			driver.close();
		}
		else
		{
			fail("ERROE");
		}
	}

	@Test
	void sharingTranslationInTwitter () 
	{
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

		// finding and clicking on sharing button
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div")).click();

		// stops to run for 2.5 seconds
		try {Thread.sleep(2500);} catch (Exception e){} 

		// finding and clicking on twitter sharing button
		WebElement twitterSharingButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div/div/ul/li[2]/a/span[1]"));
		twitterSharingButton.click();

		// stops to run for 5 seconds
		try {Thread.sleep(5000);} catch (Exception e){}
		
		// Store the current window handle
		String firsrTab = driver.getWindowHandle();
		
		// Switch to new window opened
		for(String secondTab : driver.getWindowHandles())
		{
			driver.switchTo().window(secondTab);
		}
		
		// verify twitter tab is opened  
		if (driver.getCurrentUrl().contains("twitter") == true)
		{
			driver.close();
			driver.switchTo().window(firsrTab);
			driver.close();
		}
		else
		{
			fail("ERROE");
		}
	}

}
