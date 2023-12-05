package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class RegisterPage extends GeneralPage {
	
	//Locators
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _txtPID= By.xpath("//input[@id='pid']");	
	private final By _btnRegister= By.xpath("//input[@value='Register']");
	private final By _lblRegisterMsg = By.xpath("//div[@id='content']/p"); //****
	private final By _lblRegisterMsgError = By.xpath("//p[@class='message error']");
	private final By _lblLeavePasswordErrorMsg = By.xpath("//li[@class='password']//label[@class='validation-error']");
	private final By _lblLeavePidErrorMsg = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");
	
	//Elements
	public WebElement getTxtEmail() {
		return Constant.WEBDRIVER.findElement(_txtEmail);
	}
	
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	public WebElement getTxtComfirmPassword() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}
	
	public WebElement getTxtPID() {
		return Constant.WEBDRIVER.findElement(_txtPID);
	}
	
	public WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(_btnRegister);
	}
	
	public WebElement getLblRegisterMsg() {
		return Constant.WEBDRIVER.findElement(_lblRegisterMsg);
	}
	
	public WebElement getLblRegisterErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblRegisterMsgError);
	}
	
	public WebElement getLblLeavePasswordErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLeavePasswordErrorMsg);
	}
	
	public WebElement getLblLeavePidErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLeavePidErrorMsg);
	}
	
	//Method
	public String getRegisterMsg() {
		return this.getLblRegisterMsg().getText();
	}
	public String getRegisterErrorMsg() {
		return this.getLblRegisterErrorMsg().getText();
	}
	
	public String getLeavePasswordErrorMsg() {
		return this.getLblLeavePasswordErrorMsg().getText();
	}
	
	public String getLeavePidErrorMsg() {
		return this.getLblLeavePidErrorMsg().getText();
	}
	
	public HomePage register(String email , String password , String confirmpassword , String PID){
		this.getTxtEmail().sendKeys(email);
		this.getTxtPassword().sendKeys(password);
		this.getTxtComfirmPassword().sendKeys(confirmpassword);
		this.getTxtPID().sendKeys(PID);
		this.getBtnRegister().click();
		return new HomePage();
	}

}
