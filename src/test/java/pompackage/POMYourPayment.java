package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMYourPayment extends BaseclassAmazon {
	
@FindBy(id="nav-link-accountList") WebElement Hellobtn;
@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement YourPayments;
@FindBy(linkText="Add a payment method") WebElement AddPayment;
@FindBy(id="apx-add-credit-card-action-test-id") WebElement AddCard; 
@FindBy(xpath="//input[@type='tel'and@class='a-input-text a-form-normal pmts-account-Number'and@name='addCreditCardNumber']") WebElement CardNumber;
@FindBy(xpath="//input[@type='text'and@class='a-input-text a-form-normal apx-add-credit-card-account-holder-name-input'and@name='ppw-accountHolderName']") WebElement NameonCard; 
@FindBy(name="ppw-expirationDate_month") WebElement MonthDropdown;
@FindBy(name="ppw-expirationDate_year") WebElement YearDropdown;
@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']") WebElement AddCartBtn;
@FindBy(name="ppw-widgetEvent:SelectAddressEvent") WebElement Usethisaddress;
@FindBy(name="ppw-widgetEvent:SavePaymentMethodDetailsEvent") WebElement SavePayment;
@FindBy(xpath="//span[contains(text(),'Payment method added')]") WebElement Success;
@FindBy(xpath="//body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[2]/span[1]") WebElement Gettext; 
@FindBy(xpath="//a[contains(text(),'Settings')]") WebElement Settings;
@FindBy(xpath="//a[contains(text(),'Change Preference')]") WebElement Preference;
@FindBy(xpath="//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]/input[1]") WebElement Change;
@FindBy(name="ppw-instrumentRowSelection") WebElement radio;
@FindBy(xpath="//input[@name='ppw-widgetEvent:PreferencePaymentOptionSelectionEvent']") WebElement POption;
@FindBy(xpath="//a[contains(text(),'Wallet')]") WebElement Wallet;
@FindBy(xpath="//div[contains(text(),'Default')]") WebElement Card; 

public POMYourPayment() {
	PageFactory.initElements(driver, this);
}


public void HelloClick() {
	Hellobtn.click();
}

public void Verifyoption1() {
	String actual= YourPayments.getText();
	String expected = "Your Payments";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);	
}
public void Ypayments() {
	YourPayments.click();
}
public void Asserturl() {
	String actual= driver.getCurrentUrl();
	String expected ="https://www.amazon.ca/cpe/yourpayments/wallet?ref_=ya_d_c_pmt_mpo";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);	
}
public void Addpayment() {
	AddPayment.click();
}
public void AddCard() {
	AddCard.click();	
}
public void Cardnopayment(String number) {
	CardNumber.click();
	CardNumber.sendKeys(number);
}
public void Namepayment(String name) {
	NameonCard.sendKeys(name);
}
public void Date() {
	Select obj=new Select(MonthDropdown);
	obj.selectByVisibleText("05");
}
public void Year() {
	Select obj1=new Select(YearDropdown);
	obj1.selectByVisibleText("2024");
}
public void CardBtn() {
	AddCartBtn.click();
}

public void Savepaymentbtn() {
	SavePayment.click();
}
public void Paymentmethod() {
	String actual =Success.getText();
	String expected= "Payment method added";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
}
public void Successful() {
	String actual= Gettext.getText();
	String expected ="Debit card ending in •••• 8769";
	Assert.assertEquals(actual, expected);
	System.out.println("Visa Credit card ending in •••• 8769 successfully added");
}
public void Settings() {
	Settings.click();
}
public void Preference() {
	Preference.click();
}
public void Change() {
	Change.click();
}
public void Swapbutton() {
	radio.click();
}
public void Continuebutton() {
	POption.click();
}
public void Wallet() {
	Wallet.click();
}
public void DefaultAssert () {
	String actual = Card.getText();
	Assert.assertEquals(actual, "Default");
	System.out.println(actual);
}

}
