package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMYourOrders extends BaseclassAmazon {
	
	@FindBy(xpath="//span[contains(text(),'Your Orders')]") WebElement YourOrders;
	@FindBy(name="orderFilter") WebElement Dropdown;
	@FindBy(xpath="//span[@id='a-autoid-1-announce']//span")WebElement History;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement Orders;
	@FindBy(linkText="Buy Again") WebElement BuyAgain;
	@FindBy(linkText="Not Yet Shipped") WebElement Notyetshipped;
	@FindBy(linkText="Cancelled Orders") WebElement Cancelled;
	@FindBy (xpath="//div[@class='a-section a-spacing-none a-spacing-top-small a-padding-base a-text-center']") WebElement Buyoption;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement OrderShipped;
	
	public POMYourOrders() {
		PageFactory.initElements(driver, this);
	}
	public void YourOrdersbtn() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
		YourOrders.click();
	}
	public void Historybydays() throws InterruptedException{
		Select obj=new Select(Dropdown);
		obj.selectByVisibleText("the past 30 days");
		String actualresult = History.getText();
		System.out.println(actualresult);
		String expectedresult = "the past 30 days";
		Assert.assertEquals(actualresult, expectedresult);
		
		Thread.sleep(2000);		
		String actual= Orders.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=Orders.getText();
			System.out.println(orders);
		}

		
	}
	
	public void Historybymonths() throws InterruptedException{
		Select obj=new Select(Dropdown);
		obj.selectByVisibleText("past 3 months");
		String actualresult1=History.getText();
		System.out.println(actualresult1);
		String expectedresult1 = "past 3 months";
		Assert.assertEquals(actualresult1, expectedresult1);
		Thread.sleep(2000);	
		String actual= Orders.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=Orders.getText();
			System.out.println(orders);
		}
	}
	
	public void Historybyyear() throws InterruptedException{
		Select obj=new Select(Dropdown);
		obj.selectByVisibleText("2022");
		String actualresult2=History.getText();
		System.out.println(actualresult2);
		String expectedresult2="2022";
		Assert.assertEquals(actualresult2, expectedresult2);
		Thread.sleep(2000);
		String actual= Orders.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=Orders.getText();
			System.out.println(orders);
		}}
	
		public void Buyagain() throws InterruptedException {
			Thread.sleep(5000);
			boolean verifybutton= BuyAgain.isDisplayed();
			String abc= BuyAgain.getText();
			System.out.println(abc);
			BuyAgain.click();	
			Thread.sleep(2000);
			String actual= Buyoption.getText();
			if(actual.contains("Buy it again")) {
			Assert.assertTrue(actual.contains("Buy it again"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}
		public void NotYetShipped() throws InterruptedException {
			boolean verifybutton= Notyetshipped.isDisplayed();
			String abc= Notyetshipped.getText();
			System.out.println(abc);
			Notyetshipped.click();	
			Thread.sleep(2000);
			String actual= OrderShipped.getText();
			if(actual.contains("Arriving")) {
			Assert.assertTrue(actual.contains("Arriving"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}

		
		public void CancelledOrders() throws InterruptedException {
			boolean verifybutton= Cancelled.isDisplayed();
			String abc= Cancelled.getText();
			System.out.println(abc);
			Cancelled.click();	
			Thread.sleep(2000);
			String actual= OrderShipped.getText();
			if(actual.contains("Cancelled")) {
			Assert.assertTrue(actual.contains("Cancelled"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}

		

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


