package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath = "//td[contains(text(),'User: Saurabh Nangare')]")
	@CacheLookup // will create one small cache memory to save this webelement
	//it is used to improve script performance
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath = " //a[contains(text(),'Tasks')]")
	WebElement tasksLinks;
	
	
	
	
	
	//created contructor for initializing page objects
	
	public HomePage() throws FileNotFoundException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// actions/methods:
	
	public String vefifyHomepagetitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return usernameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() throws FileNotFoundException {
		contactsLink.click();
		return new ContactsPage(); //deal page object
	}
	
	public DealsPage clickOnDealLink() throws FileNotFoundException {
		DealsLink.click();
		return new DealsPage();
		
	}
	
	/*public TasksPage clickOnTaskLink() {
		tasksLinks.click();
		return new TasksPage();  //it will return the next page
	}*/
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
	
	
	
	

}
