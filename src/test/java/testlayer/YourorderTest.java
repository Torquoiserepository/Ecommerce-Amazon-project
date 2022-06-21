package testlayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMYourOrders;

public class YourorderTest  extends BaseclassAmazon {
	POMYourOrders pom;
	public YourorderTest() {
	super();
	}

	@BeforeMethod
	public void openbrowser() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
		pom= new POMYourOrders();
		pom.YourOrdersbtn();
}
	
	@Test(priority=1)
	public void Orderhsitory() throws InterruptedException {
	pom.Historybydays();
	pom.Historybymonths();
	pom.Historybyyear();
	}
	
	@Test(priority=2)
	public void Orderoptions() throws InterruptedException {
		pom.Buyagain();
		pom.NotYetShipped();
		pom.CancelledOrders();
	}
	
@AfterMethod
public void closebrowser() {
	driver.close();
}
	
	
}
