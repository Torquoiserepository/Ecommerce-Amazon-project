package testlayer;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseclassAmazon;
import pompackage.POMCrAccount;
import testdata.ExcelSheet;

public class CrAccounttest extends BaseclassAmazon {
	
	POMCrAccount pom;

	public CrAccounttest() {
	super();
	}


	@BeforeMethod
	public void initelement() throws Throwable  {
		BaseclassAmazon.initiation();
	pom=new POMCrAccount();
	pom.click();
	Thread.sleep(5000);
	}
	
		  @DataProvider public Object[][] Details(){ Object
		  result[][]=ExcelSheet.readdata("Sheet1"); return result; }
		  
		  
		  @Test(priority=1,dataProvider="Details") public void Yourname(String
		  Condition, String name, String Email, String Password, String PasswordAgain)
		  throws InterruptedException {
		  
		  if(Condition.equals("Invalid")) { 
	      pom.typename(name); 
		  pom.typeemail(Email);
		  pom.typepassword(Password);
		  pom.typepasswordagain(PasswordAgain);
		  pom.clickk();
		  pom.verifyError();
		  pom.verifybutton(); }
		  
		  else if (Condition.equals("newcx")|| Condition.equals("Inphone")) {
		  pom.typename(name); 
		  pom.typeemail(Email); 
		  pom.typepassword(Password);
		  pom.typepasswordagain(PasswordAgain); 
		  Thread.sleep(5000); 
		  pom.verifybutton();
		  pom.clickk(); 
		  String CurrentURL= driver.getCurrentUrl(); 
		  String ExpectedURL ="https://www.amazon.ca/ap/register"; 
		  String ExpectedURL1="https://www.amazon.ca/ap/pv?forceMobileLayout=false&previousUrl=%2Fap%2Fregister%3Farb%3D847cdc7f-6c89-484f-8b7d-347ecb829b9d&openid.assoc_handle=caflex&phoneId=P-NA-SINTKTKC6I6GBNGSLXOCIN7RUE&returnTo=%2Fap%2Fregister%3Farb%3D847cdc7f-6c89-484f-8b7d-347ecb829b9d&ref_=ap_mmoar_pv_get_other&fromRegistrationFlag=1&pageId=caflex&accessToken=eyJ6aXAiOiJERUYiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiQTI1NktXIn0.5uTtR6YRFf61qn8fV98nejlCLH9b7uVNa6J1LX6acDbJkwfoOIftrw.OSn58V4NZrDybYtE.mnHOW7qmxN1KTd8qkuFw60XLiR6Nv1W0gvLuyUd_li36jiY-n7VPertb5qftwnpBUq4dYZK4U05nhI4HL93s4igmpYHqL1t_hXD07QaU4xRcc_O6tHA.XnuIzaMYGDqd-I4EEJLeeQ&showNav=FALSE";
		  if(CurrentURL.equals(ExpectedURL)) { Assert.assertEquals(CurrentURL,ExpectedURL); 
		  System.out.println(CurrentURL); }
		  
		  else if(CurrentURL.equals(ExpectedURL1)) 
		  { Assert.assertEquals(CurrentURL,ExpectedURL1);
		  System.out.println(CurrentURL);
		  
		  }} 
		  
		  else if(Condition.equals("Alreadyregd")) { 
	      pom.typename(name);
		  pom.typeemail(Email); 
		  pom.typepassword(Password);
		  pom.typepasswordagain(PasswordAgain); 
		  pom.clickk(); 
		  pom.returningcx(); 
		  } }
		  
		  
		  @AfterMethod public void close() { driver.close(); }
		 
	
	

}
