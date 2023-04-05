package com.edusolution.runner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.edusolution.base.CommonMethods;
import com.edusolution.base.Constants;
import com.edusolution.pom.Gmail_Login;
import com.edusolution.pom.Google_HomePage;
import com.edusolution.pom.Google_languages;
import com.edusolution.pom.Google_search;
import com.edusolution.utilitils.ExcelReader;
import com.edusolution.utilitils.ExtentReporter;
import com.edusolution.utilitils.PropertyReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNGRunner extends CommonMethods {
  Google_HomePage hp;
  Gmail_Login gm;
  Google_search gs;
  Google_languages gl;
  static Logger log=LogManager.getLogger(TestNGRunner.class);
	 ExtentReports report;
	
	 @BeforeTest
		public void beforeTest() {
			report=ExtentReporter.initReport();
			log.info("Execution has started");
		}
	 
  @BeforeMethod
  public void beforeMethod() {
	  hardwait(5000);
	  browserLaunch(PropertyReader.getPropValue(Constants.BROWSER));
	  driver.get(PropertyReader.getPropValue(Constants.URL));
	  hardwait(2000);
	  System.out.println("test has started");
	  System.out.println(driver.getTitle());
  }

  
  @Test(enabled= false)
  public void login()  {
	  System.out.println("test is started");
	  hp = new Google_HomePage();
	  hp.get_HomePage();
  }
	  
  @DataProvider(name="dp")
	public Object[][] dataSupplier()
	{
		Object[][] finaldata=ExcelReader.readExcel();  	
	//	Object[][] finaldata=DBHelper.getDBdata(); 
		return finaldata;		
	}
  
  @Test(dataProvider= "dp",enabled = true)
  public void gmail(Map<Object, Object> data) {
  
  test=report.createTest(stringValue(data, "TestCaseObjective"));
	if(stringValue(data, "Execute").equals("Yes")){
		gm=new Gmail_Login();
       gm.gmail_Login(data,test);
  }
  }

  @Test(enabled = false)
  public void google_search() {
	  gs=new Google_search();
	  gs.searching_Google();
  }
  
  @Test(enabled = false)
  public void language_test() {
	  gl=new Google_languages();
	  gl.get_language();
  }
  
  
  @AfterMethod
  public void afterMethod() {
	 //driver.quit();
  }

  @AfterTest
  public void afterTest() {
	  report.flush();
  }
}
