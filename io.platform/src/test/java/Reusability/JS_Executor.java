package Reusability;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Executor {

	// DrawBroder
	// "arguments[0].style.broder='3px solid red'"
	public static void drawBroder(WebDriver driver, WebElement element, String pixel, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='" + pixel + " " + color + "'", element);
		// js.executeScript("arguments[0].style.border='5px solid red'", element);
	}

	public static void drawBroder1(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].style.border='"+pixel+" "+color+"'", element);
		js.executeScript("arguments[0].style.border='5px solid red'", element);
	}

	// getTilte
	// "return document.title;"
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	// clickElement
	// "arguments[0].click();"

	public static void ClickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// generateAlert
	// "alert('message')"

	public static void generateAlert(WebDriver driver, String msg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + msg + "')");
	}

	// refresh
	// "history.go(0)"

	public static void refresh(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	// ScrollPageDown
	// "window.scrollTo(0,document.body.scrollHeight)"

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// ScrollPageUp
	// "window.scrollTo(0,-document.body.scrollHeight)"

	public static void scrollPageUP(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	// zoomPage
	// "document.body.style.zoom='150%'"

	public static void Zoom(WebDriver driver, String size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + size + "'");
	}

	// navigateTO
	public static void navigateTo(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'");
	}

	// send value to the filed without using sendkeymethod
	public static void sendValue(WebDriver driver, WebElement question, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + question + "').value='" + value + "';");
	}
	
	public static void scrollToelement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}
