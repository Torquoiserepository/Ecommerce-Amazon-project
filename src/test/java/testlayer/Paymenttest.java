package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMPayment;

public class Paymenttest extends BaseclassAmazon {
	
	POMPayment pom;
	public Paymenttest() {
		super();
	}
	@BeforeMethod
	public void initiatem() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
	pom= new POMPayment();
	}

	@Test(priority=1)
	public void search() throws InterruptedException {
		pom.search("Tommy hilfiger");
		pom.searchitem();
		pom.add();
		pom.check();
		pom.cardpayment();
		pom.ship();
		pom.shipfee();	
	}

	@Test(priority=2)
	public void Search2() throws InterruptedException {
	pom.search("chanel");	
	pom.searchitem2();
	pom.add2();
	pom.check();
	pom.shipfree();
	pom.clickadress();
	pom.use();
	Thread.sleep(5000);
	pom.verifyerror();
	}
	
	@AfterMethod
	public void close() {
	driver.close();
	}


}
