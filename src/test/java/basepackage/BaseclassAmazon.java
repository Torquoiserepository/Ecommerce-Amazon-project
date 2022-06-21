package basepackage;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class BaseclassAmazon {

	
	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	public BaseclassAmazon() {
		
		try {
		FileInputStream file =new FileInputStream("C:\\Users\\Test\\Desktop\\Eclipse\\Ecommerce_Amazon\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException a) {
				a.printStackTrace();
			}}


	public static void initiation() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();
			}
		
		else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage, TimeUnit.SECONDS);
		
	
		
}
	
public static void login() throws InterruptedException {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(prop.getProperty("Hello")))).build().perform();
	driver.findElement(By.xpath(prop.getProperty("Signin"))).click();
	Thread.sleep(1000);
	driver.findElement(By.id(prop.getProperty("Email"))).sendKeys(prop.getProperty("Emailid"));
	driver.findElement(By.id(prop.getProperty("CButton"))).click();
	driver.findElement(By.id(prop.getProperty("password"))).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.id(prop.getProperty("submit"))).click();
	Thread.sleep(5000);
}

}
