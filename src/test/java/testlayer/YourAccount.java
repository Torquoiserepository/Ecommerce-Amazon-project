package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMYourAccount;

public class YourAccount extends BaseclassAmazon{
		POMYourAccount log;
		public YourAccount() {
			super();
		}
		
		@BeforeMethod
		public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
		log = new POMYourAccount();
		}
		
		@Test(priority=1)
		public void Yaccountlogin() {
		log.loggedin();
		}
		
		
		@Test(priority=2)
		public void Youraccount() {
		log.mousehover();
		
		}
		@Test(priority=3)
		public void Verifyaccount() {
		log.verifyoption();
		}
		
		@AfterMethod
		public void close() {
		driver.close();
		}

}
