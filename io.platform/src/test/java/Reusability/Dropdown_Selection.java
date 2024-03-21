package Reusability;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Dropdown_Selection {

	public static void Dropdown_selection(List<WebElement> ele, String value) {
		for (WebElement element : ele) {
			String str = element.getText();
			if (str.equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

}
