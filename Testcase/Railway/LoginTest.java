package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.DataRegister;
import Constant.User_NoActivationTest;

public class LoginTest {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		
		//System.setProperty("webdriver.chrome.driver",Utilities.getProjectPath()+"\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	

	@Test
	public void TC01() {
		System.out.println("TC01-User can log into Railway with valid username and password");
		HomePage homePage = new HomePage();
		homePage.open();
	
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome "+Constant.USERNAME;
		
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is not displayed as expected");
	
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02-User can't login with blank 'Username' textbox");
		HomePage homePage = new HomePage();
		homePage.open();
		
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.login("",Constant.PASSWORD);
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is not displayed as expected");
		
	
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03-User cannot log into Railway with invalid password");
		HomePage homePage = new HomePage();
		homePage.open();
		
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.login(Constant.USERNAME, Constant.PASSWORD + "123");
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC04 ()
	{
		System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
		HomePage homePage = new HomePage();
		homePage.open();
		
		BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
	
		LoginPage loginPage = bookTicketPage.gotoLoginPage();
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	}
		
	
	
	@Test
	public void TC05()
	{
		System.out.println("TC05 - System shows message when user enters wrong password several times");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		int numberlogintimes = 3;
		for (int i=0 ; i<numberlogintimes; i++ ) {
			loginPage.login(Constant.USERNAME, Constant.PASSWORD +"123");
			loginPage.getTxtUsername().clear();
		}
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is not displayed as expected");
	}
	
	@Test 
	public void TC06 ()
	{
		 System.out.println("TC06 - Additional pages display once user logged in");
		 HomePage homePage = new HomePage();
		 homePage.open();

		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		 
		 	 
		 Assert.assertTrue(homePage.getTabMyTicket().isDisplayed(),"tab my ticket is not displayed");
		 Assert.assertTrue(homePage.getTabBookTicket().isDisplayed(),"tab bookticket is not displayed");
		 Assert.assertTrue(homePage.getTabLogout().isDisplayed(),"tab log out is not displayed");
		 
		 homePage.getTabMyTicket();
		 MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
		 Assert.assertTrue(myTicketPage.isMyTicketPageDisplayed());
		 
		 homePage.getTabChangePassword();
		 MyChangePasswordPage myChangePasswordPage = homePage.gotoMyChangePasswordPage();
		 Assert.assertTrue(myChangePasswordPage.isMyChangePasswordPageDisplayed());
	}
	
	@Test 
	public void TC07 ()
	{
		System.out.println("TC07 - User can create new account");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 
		 RegisterPage registerPage = homePage.gotoRegisterPage();
		 registerPage.register(DataRegister.EMAIL,DataRegister.PASSWORD,DataRegister.ConfirmPasswordEMAIL,DataRegister.PID);
		 
		 String actualMsg = registerPage.getRegisterMsg();
		 String expectedMsg = "Thank you for registering your account";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
	}
	
	
	@Test
	public void TC08 ()
	{
		System.out.println("TC08 - User can't login with an account hasn't been activated");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(User_NoActivationTest.EMAIL,User_NoActivationTest.PASSWORD);
		 
		 String actualMsg = loginPage.getLoginErrorMsg();
		 String expectedMsg = "Invalid username or password. Please try again.";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
	}

	@Test
	public void TC09 ()
	{
		System.out.println("TC09 - User can change password");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(Constant.USERNAME,Constant.PASSWORD);
		 
		 homePage.getTabChangePassword();
		 MyChangePasswordPage myChangePasswordPage = homePage.gotoMyChangePasswordPage();
		 myChangePasswordPage.changePasswordPage(Constant.PASSWORD, Constant.PASSWORD +"@", Constant.PASSWORD +"@");
		 
		 String actualMsg = myChangePasswordPage.getChangePwMsg();
		 String expectedMsg = "Your password has been updated";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
	}
	
	
	@Test
	public void TC10 ()
	{
		System.out.println("TC10 - User can't create account with 'Confirm password' is not the same with 'Password'");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 
		 RegisterPage registerPage = homePage.gotoRegisterPage();
		 registerPage.register(DataRegister.EMAIL2,DataRegister.PASSWORD2,DataRegister.ConfirmPasswordEMAIL2+"123",DataRegister.PID2);
		 
		 String actualMsg = registerPage.getRegisterErrorMsg();
		 String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");

	}
	
	
	@Test
	public void TC11 ()
	{
		System.out.println("TC11 - User can't create account while password and PID fields are empty");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 
		 RegisterPage registerPage = homePage.gotoRegisterPage();
		 registerPage.register(DataRegister.EMAIL,"","","");
		 
		 String actualMsg = registerPage.getRegisterErrorMsg();
		 String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
		 String actualMsg1 = registerPage.getLeavePasswordErrorMsg();
		 String expectedMsg1 = "Invalid password length.";
		 String actualMsg2 = registerPage.getLeavePidErrorMsg();
		 String expectedMsg2 = "Invalid ID length.";
		 
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
		 Assert.assertEquals(actualMsg1, expectedMsg1,"Message is not displayed as expected");
		 Assert.assertEquals(actualMsg2, expectedMsg2,"Message is not displayed as expected");
	}
	//Testcase12,13 bị lỗi không send instructions, nên chỉ làm được tới ngang bước này.
	@Test
	public void TC12 ()
	{
		System.out.println("TC12 - Errors display when password reset token is blank");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.gotoForgotPassword();
		 
		 String actualMsg = loginPage.getFormForgotPwMsg();
		 String expectedMsg = "Password Change Form";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
		 
	}
	@Test
	public void TC13 ()
	{
		System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.gotoForgotPassword();
		 
		 String actualMsg = loginPage.getFormForgotPwMsg();
		 String expectedMsg = "Password Change Form";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
		 
	}

	@Test
	public void TC14 ()
	{
		System.out.println("TC14 - User can book 1 ticket at a time");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(Constant.USERNAME1,Constant.PASSWORD1);
		 
		 BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
		 bookTicketPage.bookTicket();
		 
		 String actualMsg = bookTicketPage.getBookTicketSuccessMsg();
		 String expectedMsg = "Ticket booked successfully!";
		 Assert.assertEquals(actualMsg, expectedMsg,"Message is not displayed as expected");
	}
	@Test
	public void TC15 ()
	{
		 System.out.println("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(Constant.USERNAME1, Constant.PASSWORD1);
		 
		 TimeTablePage timeTablePage = homePage.gotoTimeTablePage();
		 timeTablePage.bookticketHuetoSG();
		 
		 BookTicketPage bookTicketPage = new BookTicketPage();
		 Assert.assertEquals(bookTicketPage.CheckDepartFromSelected(),"Huế");
		 Assert.assertEquals(bookTicketPage.CheckArriveAtSelected(),"Sài Gòn");
		 
	}
	
	@Test
	public void TC16 ()
	{
		System.out.println("TC16 - User can cancel a ticket");
		 HomePage homePage = new HomePage();
		 homePage.open();
		 LoginPage loginPage = homePage.gotoLoginPage();
		 loginPage.login(Constant.USERNAME, Constant.PASSWORD);		 
	}
}	

