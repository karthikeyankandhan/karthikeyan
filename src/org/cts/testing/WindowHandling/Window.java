package org.cts.testing.WindowHandling;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {

	public static void main(String[] args) //thows IO Exception
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pr soft\\eclipse-workspace\\karthikeyankandhan\\WindowHandling\\driver\\chromedriverVersion76.1.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com");
		
		WebElement search = driver.findElement(By.id("inputValEnter"));
		
		search.sendKeys("iphonex");
		
		WebElement button = driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
		
		button.click();
		
		WebElement item = driver.findElement(By.xpath("//p[@title=\"iPhone X iPhone X ( 4GB , 4 GB ) Silver\"]"));
		item.click();
		
		String parent = driver.getWindowHandle();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		for(String x:allWindow)
		{
			if(!parent.equals(x))
				
			{
				driver.switchTo().window(x);
			}
				
		}

		WebElement terms = driver.findElement(By.xpath("//a[contains(text(),'T&C')]"));
		terms.click();
		
		Set<String> allWindows1 = driver.getWindowHandles();
		
		List<String>li = new ArrayList();
		
		li.addAll(allWindows1);
		
		String s=li.get(2);
		driver.switchTo().window(s);
		
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		
		File  o = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(o);
		
		//File dest=new File("H://Fileoperation.out.png");
		//File Utils.Copy.Fies(o,dest);
		
	//	WebElement print = driver.findElement(By.xpath("//div[@class='TR_hdr']"));
		
		//String text = print.getText();
		
		//System.out.println("test");
		
		
		
		
		
		
		
	}

}
