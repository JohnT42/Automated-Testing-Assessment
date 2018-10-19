package com.qa.FridayAssement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
@FindBy(name = "j_username")
private WebElement usernameBox;
@FindBy(name = "j_password")
private WebElement passwordBox;
@FindBy(name = "Submit")
private WebElement submit;

public void add(String text, String text2) throws InterruptedException {
	try {
		usernameBox.sendKeys(text);
		passwordBox.sendKeys(text2);
		submit.click();
	} catch (Exception e) {
	}}

}
