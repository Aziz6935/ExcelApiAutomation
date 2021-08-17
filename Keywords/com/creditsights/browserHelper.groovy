package com.creditsights

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver


public class browserHelper {

	@Keyword
	def getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	def navigateToUrl(String url) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(url)
	}

	def login  (String username, String password) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.setText(findTestObject('Page_CreditSights - Login Required/input_Username'),
				username)

		WebUI.setEncryptedText(findTestObject('Page_CreditSights - Login Required/input_Password'),
				password)

		WebUI.click(findTestObject('Page_CreditSights - Login Required/input_Login'))
	}
	
	def memberLogin  (String username, String password) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.setText(findTestObject('Page_CreditSights - Login Required/input_Username_field'),
				username)

		WebUI.setEncryptedText(findTestObject('Page_CreditSights - Login Required/input_Password_field'),
				password)

		WebUI.click(findTestObject('Page_CreditSights - Login Required/input_Login_field'))
	}

	def acceptOrRejectTermsAndCondition(String url, String username, String password, boolean flag) {
		navigateToUrl(url)
		WebUI.setText(findTestObject('Page_CreditSights (QA) - Login/input_username_username'), username)

		WebUI.setEncryptedText(findTestObject('Page_CreditSights (QA) - Login/input_password_password'), password)

		WebUI.click(findTestObject('Page_CreditSights (QA) - Login/button_Log In'))
		if(flag.equals(false)) {
			WebUI.click(findTestObject('Page_CreditSights (QA) - Accept Terms/div_No'))
		}
		else if (flag.equals(true)) {
			WebUI.click(findTestObject('Object Repository/Page_CreditSights (QA) - Accept Terms/div_Yes'))
		}

		WebUI.click(findTestObject('Object Repository/Page_CreditSights (QA) - Accept Terms/button_Submit'))

		WebUI.closeBrowser()
	}

	def acceptedTerms (String url, String username, String password, String loginusername) {
		navigateToUrl(url)
		//	WebUI.navigateToUrl('https://admin-qa.staging.creditsights.com/login?ReturnUrl=%2fadmin%2fmember%2flookup%2fdraft')
		memberLogin(username, password)

		WebUI.setText(findTestObject('Page_CreditSights - Member Lookup/input_LoginUsername'),
				loginusername)

		WebUI.click(findTestObject('Page_CreditSights - Member Lookup/input_Assigned Sales'))

		WebUI.click(findTestObject('Page_CreditSights - Member Lookup/a_User'))

		WebUI.scrollToElement(findTestObject('Page_CreditSights - Account Admin User/input_Excel Add-in'), 5)
		String attribute= WebUI.getAttribute(findTestObject('Page_CreditSights - Account Admin User/input_Excel Add-in'), 'value')
		println attribute

		String date = getCurrentDate()
		WebUI.verifyMatch(attribute, 'Accepted: '+date, true)
		WebUI.closeBrowser()
	}
	def reapplyUserTerms(String url, String username, String password, String loginusername, String successmessage) {
		navigateToUrl(url)
		//WebUI.navigateToUrl('https://admin-qa.staging.creditsights.com/login?ReturnUrl=%2fadmin%2fmember%2flookup%2fdraft')
		memberLogin(username, password)

		WebUI.setText(findTestObject('Page_CreditSights - Member Lookup/input_LoginUsername'), loginusername)
		WebUI.click(findTestObject('Page_CreditSights - Member Lookup/input_Assigned Sales'))
		WebUI.click(findTestObject('Page_CreditSights - Member Lookup/a_User'))
		WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Excel Add-in'))
		WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Excel Add-in'))
		WebUI.verifyElementText(findTestObject('Page_CreditSights - Account Admin User/input_Excel Add-in'),
				'')
		WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Marketing Consent Answer'))
		WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Confirm Password'))
		WebUI.click(findTestObject('Page_CreditSights - Account Admin User/div_Account Success Message'))
		WebUI.verifyElementText(findTestObject('Page_CreditSights - Account Admin User/div_Account Success Message'),
				successmessage)
		WebUI.closeBrowser()
	}
}
