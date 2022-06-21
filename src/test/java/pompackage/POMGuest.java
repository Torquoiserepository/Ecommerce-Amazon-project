package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMGuest extends BaseclassAmazon{
	
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; 	
	@FindBy(xpath="//span[contains(text(),'CeraVe')]") WebElement assertelement;
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//img[@alt='CeraVe FOAMING Face Cleanser, Gentle Face Wash with Hyaluronic Acid, Niacinamide, Ceramides. Makeup Remover for oily skin,...']") WebElement image1;
	@FindBy(xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'CeraVe FOAMING Face Cleanser, Gentle Face Wash wit')]") WebElement productname; // click
    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']") WebElement rating;
    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//span[@class='a-price-whole']") WebElement price;
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-size-base s-underline-text'][normalize-space()='5,813']") WebElement review;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(linkText="Previous") WebElement previous;
	@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 2']") WebElement page2;
	@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 1']") WebElement page1;
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-offscreen']") WebElement sorting;
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement ATCart;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement Checkout;
	 
	 public POMGuest () {
		PageFactory.initElements(driver, this);
	}
	public void assert1() {
		String actual= assertelement.getText();
		Assert.assertTrue(actual.contains("CeraVe"));
		System.out.println(actual);
	}
	public void search(String name) {
		Search.sendKeys(name);
		submit.click();	;
	}
	
	public void order() {
		productname.click();
		ATCart.click();
		Checkout.click();
		String actual = driver.getCurrentUrl();
		String expected = "https://www.amazon.ca/gp/buy/spc/handlers/display.html?hasWorkingJavascript=1";
		Assert.assertEquals(actual, expected);
	}
	

}
