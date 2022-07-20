package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() throws FileNotFoundException {
		super();
	}

	// test cases should be separated or independent with each other
	// before each test case launch the browser and login
	// @test---execute test case
	// after each test case---close the browser
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// login() method ne next landing page kont bhetnare tr
		// homepage mhnun tyacha object banvla

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.vefifyHomepagetitle();
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());

	}
	
	@Test(priority = 3)
    public void verifyContactsLinkTest() throws FileNotFoundException {
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink(); //will navigate to contactpage
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
