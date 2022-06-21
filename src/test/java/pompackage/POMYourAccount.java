package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMYourAccount extends BaseclassAmazon  {
	
	@FindBy(id="nav-link-accountList") WebElement Hellobtn;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement Youraccount;
	@FindBy(xpath="//h1[contains(text(),'Your Account')]") WebElement Account;
	@FindBy(xpath="//span[contains(text(),'Hello, Varun')]") WebElement Varun;

	
	public POMYourAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(Hellobtn).build().perform();
		Youraccount.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void verifyoption() {
		Hellobtn.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	public void loggedin() {
		String actual = Varun.getText();
		String expected = "Hello, Varun";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		}


}
