package objectRepo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utilities;

public class PageObject extends Utilities {
	 ExtentReports report;
	 static WebDriver driver; 
	 ExtentTest test;
	 	
	 
	 @Test(dataProvider="datasetup")
		public void loginPage(String username,String password) throws IOException {
		 	test=extentReports();
			//driver=drivers();
			ObjectRepo obj= new ObjectRepo(driver);
			/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://kite.zerodha.com/");*/
			obj.userName().sendKeys(username);
			obj.passWord().sendKeys(password);
			obj.clickButton().click();	
			test.log(LogStatus.PASS, "complted login sucessfully");
			driver.close();
			
	}
	 
	 @BeforeMethod
	 public void setup() throws IOException {
		 
			
		 
			driver=drivers();
			
			ObjectRepo obj= new ObjectRepo(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://kite.zerodha.com/"); 
	 }
	 
	 @DataProvider
	 public String[][] datasetup() throws IOException{
		 
		 String [][] dataset= excelReadData();		
		return dataset;
		 
	 }
	 
	 @BeforeClass
	 public void extentReprots() {
		 
		  report=new ExtentReports(System.getProperty("user.dir") + "\\ExtentReortsResult.html");
		  test = report.startTest("Reporting thorugh Extent");
		 
		 
	 }
	 
@AfterClass 
public void endTest()
{
	
	test.log(LogStatus.INFO, "end of test");
	report.endTest(test);
	report.flush();
	
}

}
