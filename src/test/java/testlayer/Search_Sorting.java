package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMSearch_Sorting;

public class Search_Sorting extends BaseclassAmazon {
	
	POMSearch_Sorting log;
	public Search_Sorting() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		log=new POMSearch_Sorting();
	}
	
	@DataProvider (name = "Search")
	public Object[][] detail(){
		return new Object[][] {{"CeraVe"},{"skin care"},{"B0843XSMMM"},{"skin"},{"Cera"}};
	}


	@Test(priority=1,dataProvider="Search")
	public void searchbox(String Keywords) throws InterruptedException {
		log.search(Keywords);
		Thread.sleep(5000);
		log.assert1();	
		}

	@Test(priority=2)
	public void partialitem() throws InterruptedException {
		log.search("B0843XSMM");
		Thread.sleep(5000);
		
	}
	@Test(priority=3)
	public void assert2() throws InterruptedException {
		log.search("CeraVe");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Amazon.ca : CeraVe");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		log.verifyimage();
		System.out.println("Image is Displayed");
		Thread.sleep(5000);
		log.verifyname();
		System.out.println("Name is Displayed");
		Thread.sleep(5000);
		log.verifyrating();
		System.out.println("Rating is Displayed");
		Thread.sleep(5000);
		log.verifyprice();
		System.out.println("Price is Displayed");
		Thread.sleep(5000);
		log.verifyreview();
		System.out.println("Review is Displayed");
		driver.navigate().back();
		log.navigatenext();
		Thread.sleep(5000);
		log.navigateprev();
		Thread.sleep(5000);
		log.items();
		Thread.sleep(5000);
		log.pagination();	
		}
	
	
	@Test(priority=4)
			public void sortfilter() throws InterruptedException{
		log.search("CeraVe");
		log.sortinglow2high();
		
	}
	@Test(priority=5)
	public void sotin() throws InterruptedException {
		log.search("CeraVe");
		log.sortinghigh2low();
	}
@AfterMethod
public void closebrowser() {	
driver.close();
}


}
