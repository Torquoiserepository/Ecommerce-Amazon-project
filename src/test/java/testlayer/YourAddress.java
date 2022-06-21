package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMYourAddress;
import testdata.ExcelSheet;

public class YourAddress extends BaseclassAmazon {
	
	POMYourAddress obj;
	public YourAddress() {
		super();
	}
	
	@BeforeMethod
	public void initiateelement() throws InterruptedException {
		BaseclassAmazon.initiation();
		BaseclassAmazon.login();
		obj=new POMYourAddress();
		obj.HelloClick();
			
	}
	@Test(priority=1)
	public void verifyaddress() {
		obj.Useraddress();
		
	}
	@Test(priority=2)
	public void verifyaadress() throws InterruptedException {	
		obj.clickaddress();
		obj.addaddress();
	
	}
	@Test(priority=3)
	public void verifycountry() throws InterruptedException {
		obj.clickaddress();
		obj.clickaadress();
		obj.country();
	}
	@Test(priority=4)
	public void verifyprovince() throws InterruptedException {
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(5000);
		obj.verifyprovince();
	}
	
	@DataProvider
		public Object[][] Details2(){
		Object result[][]= ExcelSheet.readdata("Your Address");
		return result;}
	
		@Test(priority=5, dataProvider="Details2")
		public void address(String Condition, String Name, String Phone,String Address,String City, String Postal) throws InterruptedException {
	
	if(Condition.equals("Invalidname")) {
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(2000);
		obj.typename(Name);
		obj.typephone(Phone);
		obj.typeaddress(Address);
		obj.typecity(City);
		obj.province();
		obj.Postalcode(Postal);
		obj.submit();
		Thread.sleep(2000);
		obj.nameError();
	
	
	
	}
	if(Condition.equals("Invalidphone")) {
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(2000);
		obj.typename(Name);
		obj.typephone(Phone);
		obj.typeaddress(Address);
		obj.typecity(City);
		obj.province();
		obj.Postalcode(Postal);
		obj.submit();
		Thread.sleep(2000);
		obj.phonerror();
	}
	if(Condition.equals("Invalidaddress")) {
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(2000);
		obj.typename(Name);
		obj.typephone(Phone);
		obj.typeaddress(Address);
		obj.typecity(City);
		obj.province();
		obj.Postalcode(Postal);
		obj.submit();
		Thread.sleep(2000);
		obj.addresserror();
	}
	if(Condition.equals("Invalidcity")) {
		obj.clickaddress();
		obj.clickaadress();
	    Thread.sleep(2000);
	    obj.typename(Name);
	    obj.typephone(Phone);
	    obj.typeaddress(Address);
	    obj.typecity(City);
	    obj.province();
	    obj.Postalcode(Postal);
	    obj.submit();
	    Thread.sleep(2000);
	    obj.cityerror();
	}
	if(Condition.equals("Invalidpostal")) {
			
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(2000);
		obj.typename(Name);
		obj.typephone(Phone);
		obj.typeaddress(Address);
		obj.typecity(City);
		obj.Postalcode(Postal);
		obj.submit();
		Thread.sleep(2000);
		obj.provinceerror();
		}
		else if (Condition.equals("Validcase")) {
		Thread.sleep(2000);
		obj.clickaddress();
		obj.clickaadress();
		Thread.sleep(2000);
		obj.typename(Name);
		obj.typephone(Phone);
		obj.typeaddress(Address);
		obj.typecity(City);
		obj.province();
		obj.Postalcode(Postal);
		obj.check();
		Thread.sleep(2000);
		obj.submit();
		obj.suggestion();
		Thread.sleep(2000);
		obj.suggested();
		Thread.sleep(5000);
		obj.savedaddress();
		Thread.sleep(2000);
		obj.defaultaddress();
		}
		}
		
	
	@AfterMethod
	public void close() {
	driver.close();
	}
	
	
	}
