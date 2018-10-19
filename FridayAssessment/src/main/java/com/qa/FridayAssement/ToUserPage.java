package com.qa.FridayAssement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToUserPage {
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement managebutton;
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[17]/a/dl/dd[1]")
	private WebElement manageusersbutton;

	public boolean clickmanage() {
		try {
			managebutton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean clickmanageusers() {
		try {
			manageusersbutton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
