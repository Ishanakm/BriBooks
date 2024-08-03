package fitpeo_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FitPeo
{
@Test
public void fitpeo() throws InterruptedException
{
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.fitpeo.com/");
	driver.manage().window().maximize();
	driver.navigate().to("https://fitpeo.com/revenue-calculator");
	WebElement slider=driver.findElement(By.cssSelector("span[class^='MuiSlider-rail css-3ndvyc']"));
	Point p1=slider.getLocation();
	int x=p1.getX();
	System.out.println(x);
	int y=p1.getY();
	System.out.println(y);
	JavascriptExecutor j1=driver;
    j1.executeScript("window.scrollBy("+x+",550)");
    WebElement sliderpoint=driver.findElement(By.cssSelector("span[class^='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider']"));
    Thread.sleep(3000);
	Actions a1=new Actions(driver);
	a1.dragAndDropBy(sliderpoint,94, 0).perform();
	WebElement Textfield =driver.findElement(By.id(":R57alklff9da:"));
	Textfield.click();
	Textfield.sendKeys("560");
	 String currentvalue=sliderpoint.getAttribute("value");
		System.out.println(currentvalue);
		j1.executeScript("window.scrollBy(700,550)");
		Thread.sleep(2000);
	WebElement CPT_99091=driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));
	if(CPT_99091.isSelected()==false)
	{
		CPT_99091.click();
	}
	WebElement CPT_99453=driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
	if(CPT_99453.isSelected()==false)
	{
		CPT_99453.click();
	}
	WebElement CPT_99454=driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
	if(CPT_99454.isSelected()==false)
	{
		CPT_99454.click();
	}
	Textfield.sendKeys("820");
	j1.executeScript("window.scrollBy(700,550)");
	WebElement totalamount=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]"));
	Assert.assertEquals(totalamount.getText(), "$98760");
}
}
