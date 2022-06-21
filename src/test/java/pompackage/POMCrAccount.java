package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMCrAccount extends BaseclassAmazon {
	
	@FindBy(linkText="Start here.") WebElement startbutton;
	@FindBy(xpath="//input[@id='ap_customer_name']") WebElement customername;
	@FindBy(id="ap_email") WebElement email;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="ap_password_check") WebElement passwordagain;
	@FindBy(id="continue") WebElement cntbutton;
	@FindBy(xpath ="//div[contains(text(),'Enter your name')]") WebElement NameError;
	@FindBy(xpath ="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement EmailError;
	@FindBy(xpath ="//div[contains(text(),'Minimum 6 characters required')]") WebElement PasswordError;
	@FindBy(xpath ="//div[contains(text(),'Passwords do not match')]") WebElement IncorrectError;
	@FindBy(xpath ="//div[contains(text(),'Type your password again')]") WebElement ConfirmpassError;
	@FindBy(xpath ="//div[contains(text(),'Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.')]") WebElement WrongEPError;
	@FindBy(xpath = "//span[@id='auth-continue-announce']//span[text()='Continue']") WebElement Continue;
	@FindBy(xpath= "//span[@id='auth-continue-announce']//span[text()='Verify mobile number']") WebElement mnumber;
	@FindBy(xpath= "//span[@id='auth-continue-announce']//span[text()='Verify email']") WebElement Email;
	@FindBy(xpath="//span[@id='auth-continue-announce']/span") WebElement Buttons;
	@FindBy(xpath="//h4[contains(text(),'Are you a returning customer?')]") WebElement returning;
	
	public POMCrAccount() {
		PageFactory.initElements(driver, this);
	}

	public void click() {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	startbutton.click();
	}
	public void typename(String name) {
	customername.sendKeys(name);
	}
	public void typeemail(String name) {
	email.sendKeys(name);
	}
	public void typepassword(String name) {
	password.sendKeys(name);
	}

	public void typepasswordagain(String name) {
	passwordagain.sendKeys(name);
	}

	public void clickk() {
	cntbutton.click();

	}
	
	public void verifyError() {
		if(NameError.getText().equals("Enter your name")) {
	
			Assert.assertEquals(NameError.getText(), "Enter your name");
			System.out.println(NameError.getText());
			}
		
		else if(EmailError.getText().equals("Enter your e-mail address or mobile phone number")) {
			Assert.assertEquals(EmailError.getText(), "Enter your e-mail address or mobile phone number");
			System.out.println(EmailError.getText());

			}
			else if(PasswordError.getText().equals("Minimum 6 characters required")) {
			Assert.assertEquals(PasswordError.getText(), "Minimum 6 characters required");
			System.out.println(PasswordError.getText());

			}
			else if(IncorrectError.getText().equals("Passwords do not match")) {
			Assert.assertEquals(IncorrectError.getText(), "Passwords do not match");
			System.out.println(IncorrectError.getText());

			}
			else if(ConfirmpassError.getText().equals("Type your password again")) {
			Assert.assertEquals(IncorrectError.getText(), "Type your password again");
			System.out.println(IncorrectError.getText());

			}
			else if(WrongEPError.getText().equals("Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.")) {
			Assert.assertEquals(WrongEPError.getText(), "Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.");
			System.out.println(WrongEPError.getText());
			}}

			public void verifybutton() {
			if (mnumber.getText().equals("Verify mobile number")) {
			Assert.assertEquals(mnumber.getText(), "Verify mobile number", "Test failed");
			System.out.println(mnumber.getText());

			}
			else if (Email.getText().equals("Verify email")) {
			Assert.assertEquals(Email.getText(), "Verify email","Test Failed");
			System.out.println(Email.getText());
			}
			else if (Continue.getText().equals("Continue")) {
			Assert.assertEquals(Continue.getText(), "Continue","Test Failed");
			System.out.println(Continue.getText());
			}
			}
			public void returningcx() {
			String actual=returning.getText();
			String expected ="Are you a returning customer?";
			Assert.assertEquals(actual, expected);
			System.out.println(actual);

			}

}
