import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	String TheWebsite = "https://magento.softwaretestingboard.com/";
	String SignupPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String SingInPage = "https://magento.softwaretestingboard.com/customer/account/login";
	String SingOut = "https://magento.softwaretestingboard.com/customer/account/logout/"; 
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

}
