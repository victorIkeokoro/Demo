package ProjectRepo.Demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DriverRun {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports extent;
	public ExtentTest test;
	@Test
	public WebDriver intilals() throws IOException {
		 prop = new Properties();
	FileInputStream fis =new FileInputStream("C:\\Users\\Hugo-Tech-1775\\eclipse-workspace2\\Demo1\\src\\main\\java\\data.properties");
	prop.load(fis);
	//System.out.println(prop.getProperty("browser"));
	String browsername= prop.getProperty("browser");
	//String browsername= System.getProperty("browser");
	if ((browsername.equals("chrome"))) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Hugo-Tech-1775\\eclipse-workspace2\\Demo1\\Driver\\chromedriver.exe");
		 driver =new ChromeDriver();	
		
	}
	else if (browsername.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver","path");
		driver =new FirefoxDriver();
		
		
		
	}
	else if (browsername=="IE") {
		System.setProperty("wwebdriver.edge.driver", "path");
	driver =new InternetExplorerDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.manage().window().maximize();
	return driver;
	
	
	}
	
	public  String getScreenShotPath( String testCaseName, WebDriver driver) throws IOException {
		 File src =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destination =System.getProperty("user.dir")+"\\reports\\"+testCaseName+ ".png";
		   FileUtils.copyFile(src,new File(destination));

		return destination;
	}
	
	public static ExtentReports configReport() {
		
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web automation");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Victor");
		
		
		return extent;
		
	}
	

}
