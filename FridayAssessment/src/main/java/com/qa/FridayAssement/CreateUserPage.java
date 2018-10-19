package com.qa.FridayAssement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
@FindBy(name = "username")
private WebElement usernameBox;
@FindBy(name = "password1")
private WebElement password1Box;
@FindBy(name = "password2")
private WebElement password2Box;
@FindBy(name = "fullname")
private WebElement fullnameBox;
@FindBy(name = "email")
private WebElement emailBox;
@FindBy(name = "Submit")
private WebElement submitbutton;

public void add(String text, String text2, String text3, String text4, String text5) throws InterruptedException {
	try {
		usernameBox.sendKeys(text);
		password1Box.sendKeys(text2);
		password2Box.sendKeys(text3);
		fullnameBox.sendKeys(text4);
		emailBox.sendKeys(text5);
	} catch (Exception e) {
	}}

public void submit() throws InterruptedException {
	try {

		submitbutton.click();
	} catch (Exception e) {
	}}

}
