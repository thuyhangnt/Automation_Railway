package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	private final By tabLogin =By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout =By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
	private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
	private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
	private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
	private final By lblWelcomMessage = By.xpath("//div[@class='account']/strong");

	
	//Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
		
	}
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);	
	}
	
	protected WebElement getTabBookTicket () {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
		
	}
	protected WebElement getTabMyTicket () {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
		
	}
	protected WebElement getTabChangePassword () {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
		
	}
	protected WebElement getTabRegister() {
		return Constant.WEBDRIVER.findElement(tabRegister);
		
	}
	protected WebElement getTabTimeTable() {
		return Constant.WEBDRIVER.findElement(tabTimeTable);
		
	}
	protected WebElement getLblWelcomMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomMessage);
		
	}
 	
	//Methods
	public String getWelcomeMessage(){
		return this.getLblWelcomMessage().getText();
	}
	
	public LoginPage gotoLoginPage(){
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public BookTicketPage gotoBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}
	
	public MyTicketPage gotoMyTicketPage() {
		this.getTabMyTicket().click();
		return new MyTicketPage();
	}
	
	public TimeTablePage gotoTimeTablePage() {
		this.getTabTimeTable().click();
		return new TimeTablePage();
	}
	
	public MyChangePasswordPage gotoMyChangePasswordPage() {
		this.getTabChangePassword().click();
		return new MyChangePasswordPage();
	}
	
	public RegisterPage gotoRegisterPage(){
		this.getTabRegister().click();
		return new RegisterPage();
	}
}
