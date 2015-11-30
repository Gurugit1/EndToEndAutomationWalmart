public class TestMethod {

	HelperMethod helperMethod = new HelperMethod();
	// UserName and Password
	String Username = "mail2gurinder@gmail.com";
	String Password = "Guru@123";
	// Login Page Xpath
	String SignInPath = ".//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[1]/div[1]/p/span[2]/a";
	String LoginPath = ".//*[@id='login-username']";
	String PasswordPath = ".//*[@id='login-password']";
	String SubmitPath = "html/body/div[2]/section/section[4]/div/div/div/div/div/div/div/form/div/button";
	String VerifyLogin = "html/body/div[2]/section/section[4]/div/div/div/div/div[2]/div/h1";
	String WelcomeMessage = "Welcome to your Walmart account!";
	// Search Box Xpath
	String SearchPath = ".//*[@id='search']";
	// Selected Item Xpath
	String SelectedItem = ".//*[@id='tile-container']/div[1]/div/div/h4/a";
	// Cart Page Xpath
	String ItemAddedToCartPath = ".//*[@id='WMItemAddToCartBtn']";
	String ConfirmationClosePath = ".//*[@id='spa-layout']/div/div/div/button";
	String ItemPath = ".//*[@id='CartItemInfo']/span";
	
	//Verify login of authenticated user 
	public boolean Login() {

		helperMethod.waitForLoad(SignInPath);
		helperMethod.getPathLocation(SignInPath).click();
		helperMethod.waitForLoad(LoginPath);
		helperMethod.getPathLocation(LoginPath).sendKeys(Username);
		helperMethod.getPathLocation(PasswordPath).sendKeys(Password);
		helperMethod.getPathLocation(SubmitPath).click();
		try {
			if (helperMethod.getPathLocation(VerifyLogin).getText()
					.equals(WelcomeMessage)) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	// Search Item from given pool of items
	public boolean SearchItem(String Item) {
		try {
			helperMethod.getPathLocation(SearchPath).sendKeys(Item);
			helperMethod.getPathLocation(SearchPath).submit();
			return HelperMethod.driver.getCurrentUrl().endsWith(helperMethod.GetURLFormattedSearchItem(Item));
		} catch (Exception e) {
			return false;
		}
	}
	
	//Identify Item from Search Results
	public String IdentifySearchItem(String Item) {
		String ItemName = helperMethod.getPathLocation(SelectedItem).getText();
		helperMethod.getPathLocation(SelectedItem).click();
		return ItemName;
	}

	//Add Selected Item to cart
	public boolean AddItemToCart() {
		boolean flag = false;

		String ItemURL = HelperMethod.driver.getCurrentUrl();
		try {
			helperMethod.ClearCart();
			HelperMethod.driver.get(ItemURL);
			helperMethod.waitForLoad(ItemAddedToCartPath);
			helperMethod.getPathLocation(ItemAddedToCartPath).click();
			helperMethod.getPathLocation(ConfirmationClosePath).click();
			flag = true;
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	//Verify Item added and number of items in cart
	public boolean VerifyItem(String Item) {
		try {
			helperMethod.AccessCart();
			helperMethod.getPathLocation(ItemPath).click();
			String ItemDetails = helperMethod.GetItemDetails();
			if (helperMethod.GetNumberOfItemsInCart().equals("1")
					&& ItemDetails.equals(Item)) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
