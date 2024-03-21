package ai.iamneo.automation.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	private static final String PROXY = null;
	public static WebDriver driver;
	
	@BeforeSuite
	public static void select_Browser() throws IOException {
		
		FileInputStream fis = new FileInputStream("../io.platform/src/test/java/Properties/data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String myURL = prop.getProperty("url");
		String arg = prop.getProperty("arguments");
		String cap = prop.getProperty("Capability");
		String captype = prop.getProperty("CapabilityType");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
		    ops.addArguments(arg);
			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(myURL);	
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(myURL);
		}
		else if(browser.equalsIgnoreCase("edge")) {

        EdgeOptions options = new EdgeOptions();
        options.setCapability(captype, true);
        options.addArguments(arg);
        options.setCapability(cap, true); 
        WebDriverManager.edgedriver().avoidResolutionCache().proxy(PROXY).setup();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(myURL);
		}
	}
	
	@AfterSuite
	public void close_browser() {
		driver.quit();
	}

}
