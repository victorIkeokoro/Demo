package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	By login = By.xpath("//a/span[text()=\"Login\"]");
	By popup = By.xpath("//button [text()=\"NO THANKS\"]");

	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}



	public WebElement ClickLogin() {
		
	return  driver.findElement(login);
		
	}
	
	public WebElement handlePopup() {
		
		return  driver.findElement(popup);
			
		}
		
		
	
}


