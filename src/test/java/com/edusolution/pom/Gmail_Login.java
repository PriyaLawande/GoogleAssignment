/*4.  To verify that the user is able to Sign-in into all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calender, Google+, Translate,
 	Photos)
 9.  To verify that user is able to login to Gmail*/
package com.edusolution.pom;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edusolution.base.CommonMethods;

public class Gmail_Login extends CommonMethods {
	
	@FindBy(xpath="//a[text()='Gmail']")
	WebElement gmail_btn;
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement signIn;
	@FindBy(id="identifierId")
	WebElement userid;
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement next_btn;
	@FindBy(xpath="//input[contains(@type, 'password')]")
	WebElement password;
	@FindBy(xpath="//span[text()='Next']")
	WebElement pass_btn;
	@FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img")
    WebElement profile_btn;
	@FindBy(xpath = "//div[text()='Pradip ']")
	WebElement profile_Name;
	@FindBy(xpath = "//div[text()='Sign out']")
	WebElement sign_out;
	@FindBy(xpath="//div[text()='Remove an account']")
	WebElement remove_account;
	@FindBy(css="svg[fill='currentColor']")
	List<WebElement> red_button;
	@FindBy(xpath="//span[text()='Yes, remove'] ")
	List<WebElement> yes_accountremove;


	public Gmail_Login() {
		PageFactory.initElements(driver, this);
	}
	
	public void gmail_Login(Map<Object, Object> data,ExtentTest test) {
		softassert=new SoftAssert();
		hardwait(2000);
		gmail_btn.click();
		hardwait(3000);
		signIn.click();
		hardwait(3000);
		userid.sendKeys(data.get("userID").toString());
		next_btn.click();
		hardwait(2000);
		password.sendKeys(data.get("Password").toString());
		test.log(Status.INFO, "Password entered");
		pass_btn.click();
		hardwait(4000);
		test.log(Status.INFO, "Login is succesfull");
		test.addScreenCaptureFromPath(getScreenshot("Login Successfull"));
		System.out.println(driver.getTitle());
		softassert.assertTrue(profile_btn.isDisplayed());
		profile_btn.click();
		hardwait(4000);
		driver.switchTo().frame("account");
		hardwait(2000);
		System.out.println(profile_Name.getText());
		softassert.assertEquals(profile_Name.getText(),"Pri");
		sign_out.click();
		hardwait(4000);
		remove_account.click();
		hardwait(2000);
		red_button.get(0).click();
		hardwait(2000);
		yes_accountremove.get(1).click();
		softassert.assertAll();
	}
	
}

