import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//Run test in ascending order of name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WalmartTest {
	static TestMethod testMethod;
	static String SearchItem;
	static HelperMethod helperMethod;
	static String SelectedItem;

	// Set up before running the test cases
	@BeforeClass
	public static void setUp() throws Exception {
		testMethod = new TestMethod();
		helperMethod = new HelperMethod();
		helperMethod.setup();
		String[] SearchPool = { "tv", "socks", "dvd", "toys", "iPhone" };
		int idx = new Random().nextInt(SearchPool.length-2);
		SearchItem = (SearchPool[idx]);
	}
	// Test for valid user
	@Test
	public void test1Login() {
		Assert.assertTrue("Not valid User", testMethod.Login());
	}
	// Test for searching item from given pool
	@Test
	public void test2SearchItem() {
		Assert.assertTrue("Search Failed : An Error Occured while searching",
				testMethod.SearchItem(SearchItem));
	}
	// Test for identifying and adding item to cart 
	@Test
	public void test3IndetifyAndAddItem() {
		SelectedItem = testMethod.IdentifySearchItem(SearchItem);
		Assert.assertTrue("An Error occured while adding item to cart",
				testMethod.AddItemToCart());
	}
	
	// Test for verifying the added item and number of items in the cart
	@Test
	public void test4VerifyItem() {
		Assert.assertTrue("Desired product is not present",
				testMethod.VerifyItem(SelectedItem));
	}

	@AfterClass
	public static void tearDown() {
		helperMethod.quit();
	}

}
