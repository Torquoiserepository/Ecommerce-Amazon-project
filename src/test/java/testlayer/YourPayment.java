package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMYourPayment;

public class YourPayment extends BaseclassAmazon {
	
	POMYourPayment pom;
	public YourPayment() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
		pom= new POMYourPayment();
		pom.HelloClick();
}
@Test(priority=1)
public void verifybutton() {
	pom.Verifyoption1();
	pom.Ypayments();
	pom.Asserturl();
}

@Test(priority=2)
public void addcard() throws InterruptedException {
	pom.Ypayments();
	pom.Addpayment();
	pom.AddCard();
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	pom.Cardnopayment(prop.getProperty("cardno"));
	pom.Namepayment(prop.getProperty("name"));
	pom.Date();
	pom.Year();
	pom.CardBtn();
	pom.Savepaymentbtn();
	driver.switchTo().defaultContent();
	pom.Paymentmethod();
	pom.Successful();
	
}
@Test(priority=3)
public void Default() throws InterruptedException {
	pom.Ypayments();
	pom.Settings();
	pom.Preference();
	pom.Change();
	pom.Swapbutton();
	pom.Continuebutton();
	Thread.sleep(2000);
	pom.Wallet();
	pom.DefaultAssert();
}
@AfterMethod
public void quit() {
	driver.quit();
}

}
