package ProjectRepo.Demo1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends DriverRun {

	@Test(dataProvider = "getData")
	public void Home1(String username , String password) throws IOException {
	

		driver = intilals();
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		Assert.assertTrue(false);

		LandingPage i = new LandingPage(driver);
		try {
			i.handlePopup().click();
			System.out.println("popup was clicked");
		} catch (Exception e) {
			System.out.println("No popup");
		}

		i.ClickLogin().click();

		LoginPage j = new LoginPage(driver);
		j.emailAction().sendKeys(username);
		j.passwordAction().sendKeys(password);
		j.loginAction().click();
		System.out.println("done!!!");
	
	}
	
	
	@DataProvider
	public Object[][]  getData  () {
		
		 Object [] []  data = new Object [2][2];
		 data[0][0]= "User1";
		 data[0][1]="password";
		 data[1][0]= "User2";
		 data[1][1]="password2";
		 
	return data;
	}
	
	
	
	
	
	
}
