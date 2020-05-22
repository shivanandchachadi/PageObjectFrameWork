package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.Test;



public class Utilities {
	
	static WebDriver driver;
	
	public static WebDriver drivers() throws IOException
	{
	Utilities obj= new Utilities();	
	String browserFromFile=obj.readFile("browser");
	
	if(browserFromFile.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", " ");
	 driver= new ChromeDriver();
	}
	else if (browserFromFile=="FireFox")
	{
		System.setProperty("webdriver.firefox.driver", "C:\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
	 driver= new FirefoxDriver();
	}
	else if(browserFromFile=="IE")
	{
		System.setProperty("webdriver.IE.driver", "C:\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver= new InternetExplorerDriver();
	}
	
	
	
		return driver;
		
	}
	
	public String readFile(String key) throws IOException
	{
		Properties props = new Properties();
		File file= new File ("E:\\eclips\\TrainingWS\\TrainingDemo\\propertyfile.properties");
		FileInputStream fileinput=new FileInputStream(file);
		props.load(fileinput);
		String value=props.getProperty(key);
		
		
		return value;
		
		
	}

	public static String [][] excelReadData() throws IOException{
		
		File file= new File ("E:\\eclips\\TrainingWS\\TrainingDemo\\testdatafile.xls");
		FileInputStream filein= new FileInputStream(file);
		String [][] data=null;
		
		HSSFWorkbook wb= new HSSFWorkbook(filein);
		HSSFSheet sheet= wb.getSheetAt(0);
		
		int rownum=sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		data=new String[rownum][colnum];
		System.out.println(rownum +"  "+colnum);
		
		for (int i=0;i<rownum;i++)
		{
			HSSFRow row= sheet.getRow(i);
			for (int j=0;j<colnum;j++)
			{
				HSSFCell cell=row.getCell(j);
				data[i][j]=cell.toString();
			}
		}
		
		System.out.println(data);
		
		return data;
	}
	
	public ExtentTest extentReports() {
		
		
		ExtentReports report=new ExtentReports(System.getProperty("user.dir") + "\\ExtentReortsResult.html");
		ExtentTest test = report.startTest("Reporting thorugh Extent");
		
		return test;
		
	}
}
