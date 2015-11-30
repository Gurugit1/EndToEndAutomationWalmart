import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethod {

	static WebDriver driver;
	WebDriverWait wait;
	
	//Instantiate Firefox Driver and open walmart website
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://www.walmart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//Quit Driver
	public void quit() {
		driver.quit();
	}
	// Wait until specified element is visible
	public void waitForLoad(String Xpath) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Xpath)));
	}
	// Get location of WebElement using its Xpath
	public WebElement getPathLocation(String Xpath) {
		return (driver.findElement(By.xpath(Xpath)));
	}
	//Access item cart
	public void AccessCart() {
		String CartLocation = ".//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[2]/div/a/i";
		getPathLocation(CartLocation).click();
	}
	// Removes item from the cart
	public void RemoveCartItem() {
		String RemoveItemPath = ".//*[@id='CartRemItemBtn']";
		try {
			waitForLoad(RemoveItemPath);
			getPathLocation(RemoveItemPath).click();
		} catch (Exception e) {
			
		}
	}
	//Clear item cart 
	public void ClearCart() {
		if (!GetNumberOfItemsInCart().equals("0")) {
			RemoveCartItem();
			ClearCart();
		}
	}
	//Format Search string to match with result appended in URL 
	//Space is replaced with(%20)
	public String GetURLFormattedSearchItem(String Item){
		StringBuilder result = new StringBuilder();
		for(int i =0; i<Item.length();i++){
			if(Item.charAt(i)==' '){
				result.append("%20");
			}
			else{
				result.append(Item.charAt(i));
			}
		}
		return result.toString();
	}
	//Get number of items present in cart
	public String GetNumberOfItemsInCart() {
		String NumberOfItemsPath = ".//*[@id='spa-layout']/div/div/div[1]/div/h3/span";
		AccessCart();
		waitForLoad(NumberOfItemsPath);
		String[] ItemsCount = getPathLocation(NumberOfItemsPath).getText()
				.split(" ");
		String NumberofItems = ItemsCount[0];
		System.out.println("number of items " + NumberofItems);
		return NumberofItems;
	}
	//Get Details of items to be added to cart
	public String GetItemDetails() {
		String ItemPath = "html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[4]/div/h1/span";
		return getPathLocation(ItemPath).getText();
	}
}
