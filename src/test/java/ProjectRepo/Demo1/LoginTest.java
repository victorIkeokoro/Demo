package ProjectRepo.Demo1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class LoginTest extends DriverRun {
	 static Logger logger =LogManager.getLogger(LoginTest.class);
	@BeforeTest
	public void intialize() throws IOException {
		driver = intilals();

		driver.get(prop.getProperty("url"));
		logger.info("URL Loaded");
	}

	@Test
	public void Login1Test() {

		LandingPage i = new LandingPage(driver);
		try {
			i.handlePopup().click();
			System.out.println("popup was clicked");
			logger.info("popup was clicked");
		} catch (Exception e) {
			System.out.println("No popup");
		}

		i.ClickLogin().click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		logger.info("Browser closed");
	}

}
