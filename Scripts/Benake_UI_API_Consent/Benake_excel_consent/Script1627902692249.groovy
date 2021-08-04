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
import groovy.json.JsonSlurper as JsonSlurper

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www-qa.staging.creditsights.com/login')

WebUI.setText(findTestObject('Object Repository/Page_CreditSights (QA) - Login/input_username_username'), 'a.higherpower')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_CreditSights (QA) - Login/input_password_password'), 'BHDR9pWVXLG0HNOBuHCiHw==')

WebUI.click(findTestObject('Object Repository/Page_CreditSights (QA) - Login/button_Log In'))

//WebUI.click(findTestObject('Object Repository/Page_CreditSights (QA) - My CS/span_Member Admin'))
WebUI.navigateToUrl('https://admin-qa.staging.creditsights.com/admin/member/lookup/draft')

WebUI.setText(findTestObject('Object Repository/Page_CreditSights - Login Required/input_Username_ctl00ctl00ContentPlaceholder_161509'), 
    'a.higherpower')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_CreditSights - Login Required/input_Password_ctl00ctl00ContentPlaceholder_8e2d5c'), 
    'BHDR9pWVXLG0HNOBuHCiHw==')

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Login Required/input_Login'))

WebUI.setText(findTestObject('Object Repository/Page_CreditSights - Member Lookup/input_LoginUsername_ctl00ctl00ContentPlaceH_498f4f'), 
    'benake')

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Member Lookup/input_Assigned Sales_ctl00ctl00ContentPlace_f9c689'))

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Member Lookup/a_benake'))

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/input_Marketing Consent Answer_ctl00ctl00Co_f0ac05'))

WebUI.click(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/input_Confirm Password_ctl00ctl00ContentPla_cfdd0d'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_CreditSights - Account Admin benake/div_Account details have updated successfully'), 
    'Account details have updated successfully!')

//WebUI.closeBrowser()
'Sending request to excel auth token for benake API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('Excel auth token for benake'))

'Printing excel auth token for benake API response'
println('Excel auth token for benake API response:- ' + Response.getResponseText())

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Add User Response'
def result = sluper.parseText(Response.getResponseBodyContent())

'Parsing Response and extracting value of message key'

//WS.verifyElementPropertyValue(Response, 'message', 'You need to accept the terms & conditions in order to use the CreditSights Excel Add-in. Please contact your sales person')
'Parsing Response and extracting value of statusCode key'
WS.verifyElementPropertyValue(Response, 'statusCode', 403)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('Benake_UI_API_Consent/Benake_Terms_Condition'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Benake_UI_API_Consent/ReApply_benakeTerms'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Benake_UI_API_Consent/Agree_Benake_Terms_Condition'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Benake_UI_API_Consent/Accepted_Terms'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Excel consent for benake/Excel Permission'), [('username') : 'benake', ('password') : 'park4701'], 
    FailureHandling.STOP_ON_FAILURE)

