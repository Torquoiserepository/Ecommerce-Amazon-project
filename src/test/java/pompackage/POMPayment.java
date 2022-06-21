package pompackage;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMPayment extends BaseclassAmazon {
	
	@FindBy(id="twotabsearchtextbox") WebElement Searchbox;
	@FindBy(id="nav-search-submit-button") WebElement Submitbtn; 
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Mens Logo Dad Baseball Cap']") WebElement Searchquery;
	//@FindBy(xpath="//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']") WebElement Onetime;
	@FindBy(name="submit.add-to-cart") WebElement Addtocart;
	@FindBy(id="nav-cart") WebElement Cart;
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]") WebElement Searchquery2;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement Checkout; 
	@FindBy (id="payment-information") WebElement Paymentinfo;
	@FindBy (linkText="How are shipping costs calculated?") WebElement Shippingcost;
	@FindBy(linkText="Order with Free Shipping by Amazon") WebElement Shippinginfo;
	@FindBy (xpath="//span[contains(text(),' Order of $35 or more of eligible items qualify for FREE Shipping.')]") WebElement gettext;
	@FindBy(xpath="//td[normalize-space()='$5.48']") WebElement shippingcharge;
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]") WebElement shippingfree;
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]") WebElement Change;
	@FindBy (xpath="/html[1]/body[1]/div[8]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/span[2]/span[1]/a[1]") WebElement useaddress;
	@FindBy (xpath="//p[contains(text(),'Tommy Hilfiger Men’s Cotton Logo Adjustable Baseball Cap, Tommy Black, One Size cannot be shipped to the selected address.')]") WebElement error;
	@FindBy (xpath="//span[@class='a-button a-button-dropdown a-span12 a-button-error a-button-focus']//span[@class='a-dropdown-prompt'][normalize-space()='Varun Salgotra, 199 nmnagar, JAMMU']") WebElement selection;
	@FindBy (name="continue-bottom") WebElement Continuebtn;
	@FindBy (xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[1]/div[2]/input[1]") WebElement Radiobtn;
//@FindBy(xpath="//span[@id='attachSiNoCoverage']//input[@class='a-button-input'and@type='submit']") WebElement NoThanks;

	
	public POMPayment() {
	PageFactory.initElements(driver, this);
}

	public void search(String name) {
		Searchbox.sendKeys(name);
		Submitbtn.click();	
	}
		public void searchitem() {
		Searchquery.click();
	}
	public void add() {
		//Onetime.click();
		Addtocart.click();
		Cart.click();
	}
	
	public void add2() {
		
		Addtocart.click();
		//NoThanks.click();
		Cart.click();}
	
	public void check() {
	Checkout.click();
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Place Your Order - Amazon.ca Checkout");
	System.out.println(actual);
	}
	
	public void cardpayment() {
	String actual=Paymentinfo.getText();
	Assert.assertEquals(actual, "ending in 8769");
	System.out.println(actual);
	}
	
	public void ship() throws InterruptedException {
	Shippingcost.click();
	String parentHandle = driver.getWindowHandle();
	System.out.println("parent window - "+parentHandle);
	Set<String> handles = driver.getWindowHandles();
	for(String handle : handles) {
	System.out.println(handle);
	Thread.sleep(5000);
	if(!handle.equals(parentHandle)) {
	driver.switchTo().window(handle);
	Thread.sleep(5000);
	Paymentinfo.click();
	String actual = gettext.getText();
	Assert.assertEquals(actual, "Order of $35 or more of eligible items qualify for FREE Shipping.");
	System.out.println(actual);
	driver.close();
	}
	}
	driver.switchTo().window(parentHandle);
	}

	public void shipfee() {
	String actual = shippingcharge.getText();
	Assert.assertEquals(actual, "$5.48");
	System.out.println(actual);
	}
	
	public void searchitem2() {
	Searchquery2.click();
	
	}
	
	public void shipfree() {
	Radiobtn.click();
	String actual = shippingfree.getText();
	System.out.println(actual);
	}
	
	public void clickadress() {
	Change.click();
	}
	
	public void use() {
	useaddress.click();
	}
	
	public void verifyerror() {
	String actual =error.getText();
	Assert.assertEquals(actual, "Tommy Hilfiger Men’s Cotton Logo Adjustable Baseball Cap, Tommy Black, One Size cannot be shipped to the selected address.");
	System.out.println(actual);
	}

	}
