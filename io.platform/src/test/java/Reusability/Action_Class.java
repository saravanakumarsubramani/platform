package Reusability;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_Class {

	public static void moveToOneElement(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}

	public static void moveToTwoElement(WebDriver driver, WebElement ele, WebElement ele1) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).moveToElement(ele1).click().perform();

	}	
}
