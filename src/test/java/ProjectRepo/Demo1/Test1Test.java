package ProjectRepo.Demo1;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class Test1Test extends DriverRun{
	@BeforeTest
	public void intialize() throws IOException {
		driver = intilals();

		driver.get(prop.getProperty("url"));

	}

	@Test
	public void Login1Test() {

		LandingPage i = new LandingPage(driver);
		try {
			i.handlePopup().click();
			System.out.println("popup was clicked");
		} catch (Exception e) {
			System.out.println("No popup");
		}

		i.ClickLogin().click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
