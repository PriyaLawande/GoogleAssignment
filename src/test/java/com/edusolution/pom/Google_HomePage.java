/*1.  To verify that the Google web page is launched successfully 
 2.  To verify all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Google+, Translate, Photos) 
 	in the dialog box 
 3.  To verify that all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calender, Google+, Translate, Photos) 
 	are launched properly
 6.  To open and close the browser */

package com.edusolution.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.edusolution.base.CommonMethods;

public class Google_HomePage extends CommonMethods {

	@FindBy(className = "YacQv")
	WebElement google_SearchBox;
	@FindBy(css = "input[role='button']")
	List<WebElement> googleSearch;
	@FindBy(name = "btnI")
	List<WebElement> iAMFeelingLucky;
	@FindBy(xpath = " //div//a[contains(@aria-label, 'Google')]")
	WebElement google_apps;

	// Account
	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;
	@FindBy(className = "h-c-header__lockup")
	WebElement account_logo;

	// Maps
	@FindBy(xpath = "//span[text()='Maps']")
	WebElement maps;
	@FindBy(css = "input[autofocus='autofocus']")
	WebElement maps_Search;
	@FindBy(xpath = "//*[@id=\"runway-expand-button\"]/div/div/button[3]/div[1]")
	WebElement runWay_Btn;

	// YouTube
	@FindBy(xpath = "//span[text()='YouTube']")
	WebElement youTube;
	@FindBy(css = "a[title='YouTube Home']")
	List<WebElement> yt_logo;
	@FindBy(css = "input[autocapitalize='none']")
	WebElement yt_SearchOption;

	// Play
	@FindBy(xpath = "//span[text()='Play']")
	WebElement play;
	@FindBy(xpath = "//span[text()='google_logo Play']")
	WebElement play_logo;
	@FindBy(xpath = "//span[text()='Apps']")
	WebElement appsOption;
	@FindBy(xpath = "//i[text()='search']")
	WebElement searchOption;

	// News
	@FindBy(xpath = "//span[text()='News']")
	WebElement news;
	@FindBy(id = "sdgBod")
	WebElement news_logo;
	@FindBy(linkText = "Top stories")
	WebElement topStories;

	// Gmail
	@FindBy(xpath = "//span[text()='Gmail']")
	WebElement gmail;
	@FindBy(css = "span[class='mobile-before-hero-only']")
	WebElement gmail_logo;
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	@FindBy(xpath = "//span[text()='Create an account']")
	List<WebElement> createAccount;

	// Drive
	@FindBy(xpath = "//span[text()='Drive']")
	WebElement drive;
	@FindBy(xpath = "//a[@title='Google Drive']")
	List<WebElement> drive_logo;
	@FindBy(linkText = "Go to Drive")
	WebElement goToDrive;

	// Translate
	@FindBy(xpath = "//span[text()='Translate']")
	WebElement translate;
	@FindBy(id = "sdgBod")
	WebElement translate_logo;

	// Photos
	@FindBy(xpath = "//span[text()='Photos']")
	WebElement photos;
	@FindBy(className = "header__logo")
	WebElement photos_logo;
	@FindBy(linkText = "Go to Google Photos")
	WebElement goToGooglePhoto;

	public Google_HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void get_HomePage() {
		hardwait(2000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(google_SearchBox.isDisplayed());
		System.out.println(googleSearch.get(1).getText());
		System.out.println(iAMFeelingLucky.get(1).getText());
		waitForDisplay(google_apps);
		google_apps.click();

		driver.switchTo().frame(1);
		waitForDisplay(account);
		account.click();
		hardwait(3000);
		softAssert.assertTrue(account_logo.isDisplayed());
		repetable();

		waitForDisplay(maps);
		maps.click();
		hardwait(3000);
		softAssert.assertTrue(maps_Search.isDisplayed());
		waitForDisplay(runWay_Btn);
		softAssert.assertTrue(runWay_Btn.isDisplayed());
		repetable();

		waitForDisplay(youTube);
		youTube.click();
		hardwait(3000);
		softAssert.assertTrue(yt_logo.get(0).isDisplayed());
		System.out.println(yt_SearchOption.getText());
		repetable();

		waitForDisplay(play);
		play.click();
		hardwait(3000);
		softAssert.assertTrue(play_logo.isDisplayed());
		System.out.println(appsOption.getTagName());
		System.out.println(searchOption.getAttribute("class"));
		repetable();

		waitForDisplay(news);
		news.click();
		hardwait(3000);
		softAssert.assertTrue(news_logo.isDisplayed());
		System.out.println(topStories.getText());
		repetable();

		waitForDisplay(gmail);
		gmail.click();
		hardwait(3000);
		softAssert.assertTrue(gmail_logo.isDisplayed());
		System.out.println(signIn.getText());
		System.out.println(createAccount.get(0).getText());
		repetable();

		waitForDisplay(drive);
		drive.click();
		hardwait(3000);
		softAssert.assertTrue(drive_logo.get(0).isDisplayed());
		System.out.println(goToDrive.getText());
		repetable();

		waitForDisplay(translate);
		translate.click();
		hardwait(3000);
		softAssert.assertTrue(translate_logo.isDisplayed());
		repetable();

		waitForDisplay(photos);
		photos.click();
		hardwait(3000);
		softAssert.assertTrue(photos_logo.isDisplayed());
		softAssert.assertTrue(goToGooglePhoto.isDisplayed());
		softAssert.assertAll();
		// repetable();
	}
}
