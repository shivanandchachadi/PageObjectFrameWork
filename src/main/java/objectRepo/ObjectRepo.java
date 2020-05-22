package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepo {
	WebDriver driver;
	
	public ObjectRepo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username= By.xpath("//*[@id='container']/div/div/div/form/div[2]/input");
	By password= By.xpath("//*[@id='container']/div/div/div/form/div[3]/input");
	By clickbutton= By.xpath("//*[@id='container']/div/div/div/form/div[4]/button");
	
	public WebElement userName() {
		
		return driver.findElement(username);
	}
	
	public WebElement passWord()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickButton()
	{
		return driver.findElement(clickbutton);
	}

}
