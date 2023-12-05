package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage extends GeneralPage {
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id ='password']");
	private final By _btnLogin = By.xpath("//input[@value = 'Login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _lbtForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");
	private final By _lblFormForgotPw = By.xpath("//div[@id='content']//legend");
	//private final By 
	
	//Elements
	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	public WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
	}
	public WebElement getLbtForgotPassword() {
		return Constant.WEBDRIVER.findElement(_lbtForgotPassword);
	}
	public WebElement getLblFormForgotPw() {
		return Constant.WEBDRIVER.findElement(_lblFormForgotPw);
	}
		
	//Methods
	
	public String getLoginErrorMsg() {
		return this.getLblLoginErrorMsg().getText();
	}
	
	public String getFormForgotPwMsg() {
		return this.getLblFormForgotPw().getText();
	}
	public LoginPage gotoForgotPassword(){
		this.getLbtForgotPassword().click();
		return new LoginPage();
	}
	
	public HomePage login(String username , String password)
	{
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		return new HomePage();
	}
	public boolean isLoginPageDisplayed() {
		return getTabLogin().isDisplayed();
	}
	
}
