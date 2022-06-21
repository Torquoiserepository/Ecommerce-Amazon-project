package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMLoginAndSecurity;

	public class LoginAndSecurity extends BaseclassAmazon {
	
	POMLoginAndSecurity log;
	public LoginAndSecurity() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
	log= new POMLoginAndSecurity();
	log.HelloClick();
	log.loginn();
	}
	
	@Test(priority=1)
	public void name() {
	log.updatename();
	log.typename("Barun");
	log.newname();
	
}
	@Test(priority=2)
	public void addphoneno() throws InterruptedException {
	log.addphone();
	log.Typephone("2894994040");
	log.Clickbutton();
	Thread.sleep(2000);
	log.framep();
}	

	@Test(priority=3)
	public void deletephoneno() throws InterruptedException {
	log.editnumber();
	log.deletenumber();
	log.removenumber();
	log.verify();
}
	
	@AfterMethod
	public void closebrowser() {
	driver.close();
}

}
