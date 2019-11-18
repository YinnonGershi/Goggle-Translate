import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class trnslationTo 
{
	 @Test
	void trnslationToHebrew()  
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

		// stops to run for five seconds
		try {Thread.sleep(5000);} catch (Exception e){}  

		// catching the translated word text box
		WebElement textOutPut = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span")); 

		// confirm if the result is correct 
		if(textOutPut.getText().equals("שלום עולם") == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROR");
		}

	}

	 @Test
	void trnslationToArabic ()
	{
		/* in this function i will see if the function 
		 * to translate to arabic is working
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

		// stops to run for 1.5 seconds 
		try {Thread.sleep(1500);} catch (Exception e) {}

		// finding and clicking on arabic button
		Actions act = new Actions(driver) ;
		WebElement arabicButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[3]"));
		act.click(arabicButton).perform();

		// stops to run for 1.5 seconds 
		try {Thread.sleep(1500);} catch (Exception e) {}

		// catching the translated word
		WebElement arabicTrasnlation = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span"));

		// confirming translation 
		if (arabicTrasnlation.getText().equals("مرحبا بالعالم") == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROR");
		}
	}
	 
	@Test
	void translateToRussian () 
	{
		/* in this function i will see if the function 
		 * to translate to russian is working
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

		// stops to run for 1.5 seconds 
		try {Thread.sleep(1500);} catch (Exception e) {}

		// finding and clicking on the small arrow
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]")).click();

		// finding and clicking on russian translation button
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/div[102]/div[2]")).click();

		// stops to run for 1.5 seconds 
		try {Thread.sleep(1500);} catch (Exception e) {}

		// catching the translation word
		WebElement translationWord = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span"));

		// confirming translation correctness 
		if (translationWord.getText().equals("Привет, мир") == true)
		{
			driver.close();
		}
		else
		{
			fail("ERROE");
		}
	}

}
