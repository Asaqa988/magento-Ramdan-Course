import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.domstorage.model.Item;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	String TheWebsite = "https://magento.softwaretestingboard.com/";
	String SignupPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String SingInPage = "https://magento.softwaretestingboard.com/customer/account/login";
	String SingOut = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String CheckoutPage = "https://magento.softwaretestingboard.com/checkout/";
	String[] firstNameList = { "ahmad", "ali", "anas", "mahmoud", "toqa" };
	String[] lastNameList = { "mahmoud", "noureldin", "faisal", "bahaa", "fadi" };
	String MutualPassowrd = "Asdasd123!@#";
	String theEmailToLogin;
	Random rand = new Random();
	int RandomIndex = rand.nextInt(0, 5);
	int RandomIndexForEmail = rand.nextInt(0, 100);

	String EmailUser = "user";
	String EmailComplete = "@yahoo.com";

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void myBeforeTest() {

		driver.manage().window().maximize();
		driver.get(TheWebsite);

	}

	@Test(priority = 1)
	public void SingIUp() throws InterruptedException {

		driver.get(SignupPage);
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));

		firstName.sendKeys(firstNameList[RandomIndex]);

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));

		lastName.sendKeys(lastNameList[RandomIndex]);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));

		email.sendKeys(EmailUser + RandomIndexForEmail + EmailComplete);

		theEmailToLogin = EmailUser + RandomIndexForEmail + EmailComplete;
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(MutualPassowrd);
		WebElement confirmpassword = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		confirmpassword.sendKeys(MutualPassowrd);

		WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));

		createAccount.click();

		Thread.sleep(5000);

		driver.get(SingOut);

	}

	@Test(priority = 2)
	public void SignIn() {

		driver.get(SingInPage);
		WebElement EmailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		EmailField.sendKeys(theEmailToLogin);
		WebElement PasswordField = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordField.sendKeys(MutualPassowrd);

		WebElement SingInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));

		SingInButton.click();
	}

	@Test(priority = 3)
	public void AddItems() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String[] ItemPages = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };

		for (int i = 0; i < ItemPages.length; i++) {
			driver.get(ItemPages[i]);

			Thread.sleep(5000);

			if (driver.getCurrentUrl().contains("radiant")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys("3");

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("breathe")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys("2");

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("argus")) {

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys("4");

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("hoodie")) {

				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
				int randomIndexForTheColor = rand.nextInt(0, colors.size());
				colors.get(randomIndexForTheColor).click();

				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

				int randomindex = rand.nextInt(0, sizes.size());
				sizes.get(randomindex).click();

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);

			} else if (driver.getCurrentUrl().contains("backpack")) {
				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();

				Quantity.sendKeys("5");

				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddtoCart.click();
				Thread.sleep(1000);
			}

		}

	}

	@Test(priority = 4)
	public void CheckOutProcess() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(CheckoutPage);
		Thread.sleep(3000);
		Select Selector = new Select(driver.findElement(By.xpath("//*[@id=\"VFK3BR3\"]")));

		WebElement StreetAdress = driver.findElement(By.xpath("//*[@id=\"Y5IR43M\"]"));
		WebElement City = driver.findElement(By.xpath("//*[@id=\"KMT3TST\"]"));

		StreetAdress.sendKeys("Amman");

		City.sendKeys("Amman");
		Selector.selectByIndex(RandomIndex);

		WebElement PostalCode = driver.findElement(By.xpath("//*[@id=\"I8FIYNA\"]"));

		PostalCode.sendKeys("123");

		WebElement MobileNumber = driver.findElement(By.xpath("//*[@id=\"JDTFGVR\"]"));

		MobileNumber.sendKeys("123544444");
		Thread.sleep(2000);

		WebElement FinishButton = driver
				.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		FinishButton.click();
	}

}
