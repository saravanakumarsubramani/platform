package ai.iamneo.automation.testcases;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.annotations.Test;


public class demo extends LaunchBrowser {
	
	
    demo d = new demo();
	@Test
	public void admin_Login_with_valid_cridentials() throws IOException, InterruptedException {
		user_name.sendKeys("wwwsagdahshdasjdjasjldas");
		pass.sendKeys("asfasfasdf");
		login_btn.click();
		System.out.println(d.user_name);
	}

	@FindBy(xpath = "//input[@id='emailAddress']")
	public WebElement user_name;
	
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pass;
	
	@FindBy(xpath ="//span[contains(text(),' Login ')]")
	public static WebElement login_btn;
	
}
