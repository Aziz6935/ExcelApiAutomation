import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://admin-qa.staging.creditsights.com/login?ReturnUrl=%2fadmin%2fmember%2flookup%2fdraft')

WebUI.setText(findTestObject('Page_CreditSights - Login Required/input_Username_ctl00ctl00ContentPlaceholder_161509'), 'a.higherpower')

WebUI.setEncryptedText(findTestObject('Page_CreditSights - Login Required/input_Password_ctl00ctl00ContentPlaceholder_8e2d5c'), 
    'BHDR9pWVXLG0HNOBuHCiHw==')

WebUI.click(findTestObject('Page_CreditSights - Login Required/input_Login'))

WebUI.setText(findTestObject('Page_CreditSights - Member Lookup/input_LoginUsername_ctl00ctl00ContentPlaceH_498f4f'), 'benake')

WebUI.click(findTestObject('Page_CreditSights - Member Lookup/input_Assigned Sales_ctl00ctl00ContentPlace_f9c689'))

WebUI.click(findTestObject('Page_CreditSights - Member Lookup/a_benake'))

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/input_Excel Add-in Answer_ctl00ctl00Content_9a3efd'))

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/input_Excel Add-in Answer_ctl00ctl00Content_9a3efd'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/input_Excel Add-in Answer_ctl00ctl00Content_9a3efd'), 
    '')

WebUI.click(findTestObject('Page_CreditSights - Account Admin benake/input_Marketing Consent Answer_ctl00ctl00Co_f0ac05'))

WebUI.click(findTestObject('Page_CreditSights - Account Admin benake/input_Confirm Password_ctl00ctl00ContentPla_cfdd0d'))

WebUI.click(findTestObject('Page_CreditSights - Account Admin benake/div_Account details have updated successfully'))

WebUI.verifyElementText(findTestObject('Page_CreditSights - Account Admin benake/div_Account details have updated successfully'), 
    'Account details have updated successfully!')

WebUI.closeBrowser()

