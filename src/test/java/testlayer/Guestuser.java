package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMGuest;


public class Guestuser extends BaseclassAmazon {
	
	POMGuest log;
	public Guestuser() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
	BaseclassAmazon.initiation();
	log=new POMGuest();
	}
	
	@Test(priority=1)
	public void searchbox() throws InterruptedException {
		log.search("CeraVe");
		log.order();
			
		}
	
	@AfterMethod
	public void closebrowser() {	
	driver.close();
	}
}
