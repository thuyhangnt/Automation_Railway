package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class MyChangePasswordPage extends GeneralPage {

	//Locators
	
	private final By _txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
	private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _btnChangePassword= By.xpath("//input[@value='Change Password']");
	private final By _lblChangePasswordMsgSuccess = By.xpath("//p[@class='message success']");
	
	//Elements
	public WebElement getTxtCurrentPw() {
		return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
	}
	
	public WebElement getTxtNewPw() {
		return Constant.WEBDRIVER.findElement(_txtNewPassword);
	}
	
	public WebElement getTxtComfirmPw() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}
	
	public WebElement getBtnChangePw() {
		return Constant.WEBDRIVER.findElement(_btnChangePassword);
	}
	
	public WebElement getLblChangePasswordMsgSuccess() {
		return Constant.WEBDRIVER.findElement(_lblChangePasswordMsgSuccess);
	}
	
	//Method
	
	public String getChangePwMsg() {
		return this.getLblChangePasswordMsgSuccess().getText();
	}	
	
	public boolean isMyChangePasswordPageDisplayed() {
		return getTabChangePassword().isDisplayed();
	}
	
	//Hàm đổi mật khẩu
	public MyChangePasswordPage changePasswordPage( String CurrentPassword, String NewPassword, String ComfirmPassword )
	{
		this.getTxtCurrentPw().sendKeys(CurrentPassword);
		this.getTxtNewPw().sendKeys(NewPassword);
		this.getTxtComfirmPw().sendKeys(ComfirmPassword);
		this.getBtnChangePw().click();
		return new MyChangePasswordPage();
	}
}