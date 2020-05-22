package stepdef;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import objectRepo.ObjectRepo;

public class Stepdef {
	
public WebDriver driver;
public ObjectRepo obj;

@Given(": the url")
public void the_url() {

	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
    driver= new ChromeDriver();
    obj= new ObjectRepo(driver);
    driver.get("https://kite.zerodha.com/");
	System.out.print("site is opened");
	
}




@When(": i enter username {string} password {string}")
public void i_enter_username_password(String string, String string2) {
	obj.userName().sendKeys(string);
	obj.userName().sendKeys(string2);
	

	System.out.print("username and password entered");
}
@Then(": login is successful")
public void login_is_successful() {
	
	obj.clickButton().click();
	System.out.print("clicked ");
	driver.close();
	
	
	
}





}
