package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By login = By.name("commit");

	public WebElement emailAction() {

		return driver.findElement(email);

	}

	public WebElement passwordAction() {

		return driver.findElement(pwd);

	}
	 public WebElement loginAction() {
		 
		return  driver.findElement(login);
		 
		 
	 }
	
	
	
	

}
