package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public ContactsPageTest() throws FileNotFoundException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//login vr click kel ki home page bhetate
	    testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		//homepage vr click kele ki contactpage
		//likewise flow runs
	}	
		
	@Test(priority = 1)
	public void verifyContactsLableTest() {
		Assert.assertTrue(contactsPage.verifyContactsLable(), "Contacts label is missing on page");
	}
	
	@Test(priority = 2)
   public void SelectContactsByNameTest() {
	   contactsPage.selectContactsByName("Manisha Bhoite");
   }
	

	@Test(priority = 3)
	public void SelectMultipleContactsTest() {
		contactsPage.selectContactsByName("Priyanka Bhoite");
		contactsPage.selectContactsByName("Dnyaneshwar Bhoite");
	}
	
	@Test(priority=4)
	public void validateCreateNewContact(){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		//contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	
	
	@AfterMethod
	public void TearDown() {
	driver.quit();
		
	}

}
