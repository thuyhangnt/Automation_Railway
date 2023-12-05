package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;

public class BookTicketPage extends GeneralPage{
	
	//locator
	private final By _ddlDate = By.xpath("//select[@name='Date']");
	private final By _ddlDepartFrom = By.xpath("//select[@name='DepartStation']");
	private final By _ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
	private final By _ddlSeatType = By.xpath("//select[@name='SeatType']");
	private final By _ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By _btnBookTicket= By.xpath("//input[@value='Book ticket']");
	private final By _lblBookTicketSuccessMsg = By.xpath("//div[@id='content']//h1");
	
	//Element
	public WebElement getDdlDate() {
		return Constant.WEBDRIVER.findElement(_ddlDate);
	}
	
	public WebElement getDdlDepartFrom() {
		return Constant.WEBDRIVER.findElement(_ddlDepartFrom);
	}
	
	public WebElement getDdlArriveAt() {
		return Constant.WEBDRIVER.findElement(_ddlArriveAt);
	}
	
	public WebElement getDdlSeatType() {
		return Constant.WEBDRIVER.findElement(_ddlSeatType);
	}
	public WebElement getDdlTicketAmount() {
		return Constant.WEBDRIVER.findElement(_ddlTicketAmount);
	}
	
	public WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicket);
	}
	public WebElement BookTicketSuccessMsg() {
		return Constant.WEBDRIVER.findElement(_lblBookTicketSuccessMsg);
	}
	
	public String getBookTicketSuccessMsg() {
		return this.BookTicketSuccessMsg().getText();
	}
	
	//Methods
	
	//Bookticket from Sài Gòn to Nha Trang
	public void bookTicket() {		
		//chọn ngày 
	    Select selectDate = new Select(getDdlDate());
	    selectDate.selectByIndex(0);
	    //chọn nơi xuất phát
	    Select selectDepartfrom = new Select(getDdlDepartFrom());
	    selectDepartfrom.selectByVisibleText("Sài Gòn");
	    //chọn điểm đến
	    Select selectArriveAt = new Select(getDdlArriveAt());
	    selectArriveAt.selectByVisibleText("Nha Trang");
	    //Chọn loại ghế
	    Select selectSeatType = new Select(getDdlSeatType());
	    selectSeatType.selectByVisibleText("Soft bed with air conditioner");
	    //Chọn số lượng vé
	    Select selectTicketMount = new Select(getDdlTicketAmount());
	    selectTicketMount.selectByVisibleText("1");
	    //nhất nút BookTicket
	    this.getBtnBookTicket().click();
	}
	//Kiểm tra giá trị điểm đi đã được chọn
	public String CheckDepartFromSelected(){
		Select select = new Select(getDdlDepartFrom());
		return  select.getFirstSelectedOption().getText();
	
	}
	//Kiểm tra giá trị điểm đến đã được chọn
	public String CheckArriveAtSelected(){
		Select select = new Select(getDdlArriveAt());
		return  select.getFirstSelectedOption().getText();
	
	}
	public boolean isLoginPageDisplayed() {
		return getTabLogin().isDisplayed();
	}

}
