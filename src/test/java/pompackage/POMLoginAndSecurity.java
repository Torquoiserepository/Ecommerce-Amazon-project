package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMLoginAndSecurity extends BaseclassAmazon {
	
	@FindBy(id="nav-link-accountList") WebElement Hellobtn;	
	@FindBy (xpath="//h2[contains(text(),'Login & security')]") WebElement Login; 
	@FindBy (xpath="//input[@id='auth-cnep-edit-name-button']") WebElement Editname;
	@FindBy (name ="customerName") WebElement Namebox;
	@FindBy (xpath="//input[@id='cnep_1C_submit_button']") WebElement Submitbtn;
	@FindBy (xpath ="//span[contains(text(),'You successfully changed your account!')]") WebElement Successmsg;
	@FindBy (xpath="//div[contains(text(),'Barun')]") WebElement Newname;
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement Editphonebtn;
	@FindBy (name="newMobilePhoneNumber") WebElement Newnumber; 
	@FindBy (xpath="//input[@id='auth-continue']") WebElement Continuebtn;
	@FindBy (css="#auth-verification-ok-announce") WebElement OKbtn;
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement Editphonebtn2;
	@FindBy (xpath="//button[contains(text(),'Delete')]") WebElement Deletenumber;
	@FindBy (xpath="//input[@id='ap-remove-mobile-claim-submit-button']") WebElement Remove;
	@FindBy (xpath= "//span[normalize-space()='You have successfully deleted your phone number.']") WebElement Verifymsg;


	public POMLoginAndSecurity() {
	PageFactory.initElements(driver, this);
	}

	public void HelloClick() {
	Hellobtn.click();
	}

	public void loginn() {
	boolean result =Login.isDisplayed();
	System.out.println(result);
	Login.click();
	}
	public void updatename() {
	Editname.click();
	}

	public void typename(String name) {
	Namebox.clear();
	Namebox.sendKeys(name);
	}
	public void newname() {
	Submitbtn.click();
	
	String actual= Successmsg.getText();
	String expected= "You successfully changed your account!";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	String result= Newname.getText();
	Assert.assertEquals(result, "Barun");
	System.out.println(result);
	}
	public void addphone() throws InterruptedException {
	Thread.sleep(5000);

		  Editphonebtn.click();
	}
	public void Typephone(String number) {
	Newnumber.sendKeys(number);
	}
	public void Clickbutton() {
	Continuebtn.click();

	}
	public void framep() throws InterruptedException {
	OKbtn.click();
		String actualtit=driver.getTitle();
		String expectedtit= "Amazon Phone Verification";
		Assert.assertEquals(actualtit, expectedtit);
		System.out.println(actualtit);
	
	}
	public void editnumber() throws InterruptedException {
	Thread.sleep(5000);
	Editphonebtn2.click();	
	}
	public void deletenumber() {
	Deletenumber.click();
	}

	public void removenumber() {
	Remove.click();
	}
	public void verify() {
	String actual= Verifymsg.getText();
			String expected="You have successfully deleted your phone number.";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	}

	}
