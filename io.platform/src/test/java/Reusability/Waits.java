package Reusability;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void elementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void elementToVisibility(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void visibilityAllelements(WebDriver driver, List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
	public static void alertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.alertIsPresent());
	}
}