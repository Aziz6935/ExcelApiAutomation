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

TestData excelData = findTestData('Data Files/Excel Consent')
for (int i = 1; i <= excelData.getRowNumbers(); i++) {

	CustomKeywords.'com.creditsights.browserHelper.navigateToUrl'('https://www-qa.staging.creditsights.com/login')
	CustomKeywords.'com.creditsights.browserHelper.login'( excelData.getValue('Username', i), excelData.getValue('Password', i))	

//WebUI.click(findTestObject('Object Repository/Page_CreditSights (QA) - My CS/span_Member Admin'))
WebUI.navigateToUrl('https://admin-qa.staging.creditsights.com/admin/member/lookup/draft')
CustomKeywords.'com.creditsights.browserHelper.memberLogin'( excelData.getValue('Username', i), excelData.getValue('Password', i))

WebUI.setText(findTestObject('Page_CreditSights - Member Lookup/input_LoginUsername'), 
    excelData.getValue('LoginUserName', i))

WebUI.click(findTestObject('Page_CreditSights - Member Lookup/input_Assigned Sales'))

WebUI.click(findTestObject('Page_CreditSights - Member Lookup/a_User'))

WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Marketing Consent Answer'))

WebUI.click(findTestObject('Page_CreditSights - Account Admin User/input_Confirm Password'))

WebUI.verifyElementText(findTestObject('Page_CreditSights - Account Admin User/div_Account Success Message'), 
    excelData.getValue('SuccessMessage', i))

//WebUI.closeBrowser()
'Sending request to excel auth token for benake API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('Excel auth token for benake'))

'Printing excel auth token for benake API response'
println('Excel auth token for benake API response:- ' + Response.getResponseText())

WebUI.closeBrowser()

//WebUI.navigateToUrl('')
CustomKeywords.'com.creditsights.browserHelper.acceptOrRejectTermsAndCondition'('https://www-qa.staging.creditsights.com/login/', excelData.getValue('LoginUserName', i), excelData.getValue('LoginUserPassword', i), false)
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.creditsights.browserHelper.reapplyUserTerms'('https://admin-qa.staging.creditsights.com/login?ReturnUrl=%2fadmin%2fmember%2flookup%2fdraft', excelData.getValue('Username', i), excelData.getValue('Password', i), excelData.getValue('LoginUserName', i),excelData.getValue('SuccessMessage', i))
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.creditsights.browserHelper.acceptOrRejectTermsAndCondition'('https://www-qa.staging.creditsights.com/login/', excelData.getValue('LoginUserName', i), excelData.getValue('LoginUserPassword', i), true)
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.creditsights.browserHelper.acceptedTerms'('https://admin-qa.staging.creditsights.com/login?ReturnUrl=%2fadmin%2fmember%2flookup%2fdraft', excelData.getValue('Username', i), excelData.getValue('Password', i), excelData.getValue('LoginUserName', i))
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Excel Consent for User/Excel Permission'), [('username') : 'benake', ('password') : 'park4701'], 
    FailureHandling.STOP_ON_FAILURE)
}
