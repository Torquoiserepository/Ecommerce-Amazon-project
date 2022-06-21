 package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMShoppingCart;

public class ShoppingCart extends BaseclassAmazon {
	
	POMShoppingCart pom;
	public ShoppingCart() {
		super();
	}
	
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
	pom= new POMShoppingCart();
}
	@Test(priority=1)
	public void Searchitems() throws Throwable {
		pom.searchquery("Amplifi ubiquiti");
		pom.Searchitem1();
		Thread.sleep(2000);
		pom.add();
		pom.Navcart();
		pom.verifyitem1();
	}
	@Test(priority=2)
	public void  Changecart() throws Exception {
		pom.Navcart();
		pom.verifyitem1();
		pom.Increasequantity();
		pom.searchquery("Cat tree");
		pom.Searchitem2();
		pom.add();
		pom.Navcart();
		pom.verifyprice();
		pom.deleteitem2();
		pom.deleteall();
	

	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
