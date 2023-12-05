package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import Constant.Constant;

public class TimeTablePage extends GeneralPage{
	//Locators
	private final By _btnBookTicketRouteHuetoSG = By.xpath("//td[text()='Huế']/following-sibling::td[text()='Sài Gòn']/..//a[contains(@href,'Book')]");
	
	//Elements
	public WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicketRouteHuetoSG);
	}
	//Methods
	public void bookticketHuetoSG() {
		//cuộn trang web đến phần tử
		((JavascriptExecutor)Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", getBtnBookTicket());
		//nhấn nút 
		this.getBtnBookTicket().click();
	}
}
