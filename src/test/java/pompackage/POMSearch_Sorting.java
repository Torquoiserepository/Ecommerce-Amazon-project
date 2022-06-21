package pompackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseclassAmazon;

public class POMSearch_Sorting extends BaseclassAmazon {
		
		@FindBy(id="twotabsearchtextbox") WebElement Searchbox;
		@FindBy(id="nav-search-submit-button") WebElement Submitbtn; // Optional
		@FindBy(xpath="//span[contains(text(),'CeraVe')]") WebElement Verifyresults;
		@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//img[@alt='CeraVe FOAMING Face Cleanser, Gentle Face Wash with Hyaluronic Acid, Niacinamide, Ceramides. Makeup Remover for oily skin,...']") WebElement Searchimage;
		@FindBy(xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'CeraVe FOAMING Face Cleanser, Gentle Face Wash wit')]") WebElement Searchname; 
	    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']") WebElement Searchrating;
	    @FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//span[@class='a-price-whole']") WebElement Searchprice;
		@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-size-base s-underline-text'][normalize-space()='5,813']") WebElement Searchreview;
		@FindBy(linkText="Next") WebElement Navigatenext;
		@FindBy(linkText="Previous") WebElement Navigateprevious;
		@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 1']") WebElement Page1;
		@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected'and@aria-label='Current page, page 2']") WebElement Page2;
		@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-offscreen']") WebElement Sorting;
		 
		
		 
		 public POMSearch_Sorting() {
		 
			PageFactory.initElements(driver, this);
		}
		public void assert1() {
			String actual= Verifyresults.getText();
			Assert.assertTrue(actual.contains("CeraVe"));
			System.out.println(actual);
		}
		public void search(String name) {
			Searchbox.sendKeys(name);
			Submitbtn.click();	;
		}
		public boolean verifyimage() {
			boolean result=Searchimage.isDisplayed();
			return result;
			
		}
		public boolean verifyname() {
			boolean result=Searchname.isDisplayed();
			return result;
			
		}
		public boolean verifyrating() {
			boolean result = Searchrating.isDisplayed();
			return result;
		}
		public boolean verifyprice() {
			boolean result= Searchprice.isDisplayed();
			return result;
		}
		public boolean verifyreview() {
			Searchname.click();
			boolean result=Searchreview.isDisplayed();
			return result;
		}
		public boolean navigatenext() throws InterruptedException {
			Navigatenext.click();
			Thread.sleep(2000);
			boolean result=Page2.isDisplayed();
		return result;
		}
		public boolean navigateprev() throws InterruptedException {
			Navigateprevious.click();
			Thread.sleep(2000);
			boolean result=Page1.isDisplayed();
			return result;
		}
		public void items() {
		int pageitems= driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']")).size();
		Assert.assertEquals(pageitems, 60);
		System.out.println(pageitems);
		}
		public void pagination() throws InterruptedException {
		 List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		WebElement Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		List<String> Totalitems= new ArrayList<String>();
		 for( WebElement item:list) {	 
		 Totalitems.add(item.getText());	 
		 System.out.println(item.getText());
		 }
		 System.out.println("------------------>");
		 while(true) {
		        Thread.sleep(3000);
		        Nextbutton.click();
		        Thread.sleep(5000);
		        list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		       
		        for( WebElement item:list) {
		       
		        String Actual= item.getText();
		            Totalitems.add(Actual);
		  			    	   
		    if(!(Actual.equals("CeraVe Renewing SA Cream 12 oz by CeraVe"))) {
		    System.out.println(Actual);
		    continue;
		    }
		    else {
		   
		    Assert.assertNotSame(Actual, "CeraVe Renewing SA Cream 12 oz by CeraVe", "Items can not be repeated");
		   
		    } }

		        System.out.println("------------->");
		        try {
		        Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		       
		        }
		        catch(Exception e) {
		        System.out.println("No more product left");
		        break;
		        }

		 		}}

			public void sortinglow2high() throws InterruptedException {

			
			List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			List<Double> beforefilterprice =new ArrayList<>();
			
			for(WebElement p: beforeFilter) {
			beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
			System.out.println(beforefilterprice);
			}
			Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
			obj.selectByVisibleText("Price: Low to High");
			List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			List<Double> afterfilterprice =new ArrayList<>();
			for(WebElement q: afterFilter) {
			Thread.sleep(5000);
			
			afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
			System.out.println("Before"+ afterfilterprice);
			}
			
			Collections.sort(afterfilterprice,Collections.reverseOrder());
			System.out.println("After" + afterfilterprice);
			Assert.assertNotEquals(afterfilterprice, beforefilterprice);
			
			}

			public void sortinghigh2low() throws InterruptedException {
			
			List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			List<Double> beforefilterprice =new ArrayList<>();
			
			for(WebElement p: beforeFilter) {
			beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
			System.out.println(beforefilterprice);
			}
			Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
			obj.selectByVisibleText("Price: High to Low");
			List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			List<Double> afterfilterprice =new ArrayList<>();
			for(WebElement q: afterFilter) {
			Thread.sleep(5000);
			
			afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
			System.out.println("Before"+ afterfilterprice);
			}
			
			Collections.sort(afterfilterprice,Collections.reverseOrder());
			System.out.println("After" + afterfilterprice);
			Assert.assertNotEquals(afterfilterprice, beforefilterprice);
			
			}
		

	}

