package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMShoppingCart extends BaseclassAmazon {
	
	@FindBy(id="twotabsearchtextbox") WebElement Searchbox;
	@FindBy(id="nav-search-submit-button") WebElement Submitbtn; 
	@FindBy(xpath="//span[normalize-space()='AmpliFi HD Wifi Router by Ubiquiti Labs, Seamless Whole Home Wireless Internet Coverage, HD Wifi Router with Touchscreen Display, 4 Gigabit Ethernet, 1 WAN Port, Ethernet Cable, Expandable Mesh System']") WebElement Searchitem1;
	@FindBy(xpath="//input[@name='submit.add-to-cart'and@value='Add to Cart']") WebElement addtocart;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement added; 
	@FindBy(id="nav-cart") WebElement cart;
	@FindBy(xpath="//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']") WebElement info; 
	@FindBy (name="quantity") WebElement selectbox;
	@FindBy (xpath="//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']") WebElement gettext; 
	@FindBy (xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/span[1]/span[1]/span[2]") WebElement gettext2;
	@FindBy(xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'PAWZ Road 54\" Cat Tree,Kitty Toy Cat Scratching Po')]") WebElement Searchitem2;
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]") WebElement display2;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]") WebElement delete;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]") WebElement delete1;
	@FindBy(xpath="//h1[@class='a-spacing-mini a-spacing-top-base']") WebElement cartempty; 

	public POMShoppingCart() {
		PageFactory.initElements(driver, this);
	}

	public void searchquery(String name) {
		Searchbox.sendKeys(name);
		Submitbtn.click();	
	}

	public void Searchitem1() {
		Searchitem1.click();
	}

	public void add() {
		addtocart.click();
		String actual=driver.getTitle();
		Assert.assertEquals(actual, "Amazon.ca Shopping Cart");
		System.out.println(actual);
		 String Actualtext = added.getText();
		  Assert.assertEquals(Actualtext, "Added to Cart");
		  System.out.println(Actualtext);
	}
	public void Navcart() {
		cart.click();
	}
	
	public void verifyitem1() {
		String actual = gettext2.getText();
		Assert.assertTrue(actual.contains("AmpliFi HD"));
		System.out.println(actual);
	}
	public void Increasequantity() throws InterruptedException {
	Select obj=new Select(selectbox);
	obj.selectByVisibleText("2");
	Thread.sleep(5000);
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (2 items): $494.52"));
	System.out.println(actual);
	}
	
	public void Searchitem2() {
		Searchitem2.click();
		
	}
	public void verifyprice() {
		String actual = gettext.getText();
		Assert.assertTrue(actual.contains("Subtotal (3 items): $584.51"));
		System.out.println(actual);
	}
	public void deleteitem2() {
		delete.click();
		String actual= gettext.getText();
		Assert.assertTrue(actual.contains("Subtotal (2 items): $494.52"));
		System.out.println(actual);
	}
	public void deleteall() {
		delete1.click();
		String actual= gettext.getText();
		Assert.assertTrue(actual.contains("Subtotal (0 items):"));
		System.out.println(actual);
		boolean result = cartempty.isDisplayed();
		System.out.println(cartempty.getText());
		
	}

}
