package com.qa.FridayAssement;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver = null;
	ToUserPage tup;
	LoginPage lp;
	CreateUserPage cup;
	UsersPage up;
	String text1;
	ExtentTest test;
	static ExtentReports report;
	static int testcounter = 0;

	@Before
	public void setup() {
		System.setProperty(Constants.webdriver, Constants.webdriverpath);
		driver = new ChromeDriver();
		lp = PageFactory.initElements(driver, LoginPage.class);
		tup = PageFactory.initElements(driver, ToUserPage.class);
		cup = PageFactory.initElements(driver, CreateUserPage.class);
		up = PageFactory.initElements(driver, UsersPage.class);
		if (testcounter == 0) {
			report = new ExtentReports(Constants.reportpath, true);// I don't think the reports are working
		} else {
			report.endTest(test);
		}
		testcounter++;
	}

	@After
	public void teardown() {
		driver.quit();
		report.flush();
	}

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		test = report.startTest("Test Browse Scenario");
		lp.add("root", "root");
		tup.clickmanage();
		tup.clickmanageusers();
		up.clickcreateuser();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		if (url.equals(Constants.URL4)) {
			test.log(LogStatus.PASS, "On the Create User Screen verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify being on the Create User Screen");}
		assertEquals(Constants.URL4, url);
		
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		text1="Optimus";
		String text2="Matrix1";
		String text3="Matrix1";
		String text4="Orion Pax";
		String text5="Prime@cybertronmail.com";
		test.log(null, "User details entered");
		cup.add(text1,  text2, text3,text4 ,text5 );
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		cup.submit();
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);
		assertEquals(Constants.URL3, url2);
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		if (text1.equals(up.getusername())) {
			test.log(LogStatus.PASS, "username verified");
		} else {
			test.log(LogStatus.FAIL, "Unable to verify username");}
		assertEquals(text1,up.getusername());
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(
			String arg1, String arg2, String arg3, String arg4) throws Throwable {
		String useremail=arg4+"@gmail.com"; // added an email address for each user.
		cup.add(arg1, arg2, arg3, arg4,useremail);
		test.log(null, "User details entered");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		WebElement element = null ;
		for(int i=2; i<10;i++) {
		String path="//*[@id=\"people\"]/tbody/tr["+i+"]/td[2]";
		element = driver.findElement(By.xpath(path));
		if(arg1.equals(path)){
				System.out.println(element.getText());}}
		throw new PendingException();// I couldn't get this part working.
}


	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
