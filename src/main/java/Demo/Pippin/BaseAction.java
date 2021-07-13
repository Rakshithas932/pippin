package Demo.Pippin;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public abstract class BaseAction implements Contants  {
	public static WebDriver driver;
	@Test
	public void setup()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
}
