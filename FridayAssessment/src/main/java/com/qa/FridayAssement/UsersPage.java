package com.qa.FridayAssement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createuserbutton;
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[2]")
	
	private WebElement usernameText;
	
	public boolean clickcreateuser() {
		try {
			createuserbutton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String getusername() {
		System.out.println(usernameText.getText());
		return usernameText.getText();

}
	

}
