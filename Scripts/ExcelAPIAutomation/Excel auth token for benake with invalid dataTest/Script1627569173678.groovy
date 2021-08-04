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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

'Sending request to excel auth token for benake API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel auth token for benake with invalid credientials'))

'Printing excel auth token for benake API response'
println('Excel auth token for benake API response:- ' + Response.getResponseText())

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Add User Response'
def result = sluper.parseText(Response.getResponseBodyContent())

'Parsing Response and extracting value of message key'
WS.verifyElementPropertyValue(Response, 'message', 'The username or password is incorrect, please check your information and try again.')

'Parsing Response and extracting value of statusCode key'
WS.verifyElementPropertyValue(Response, 'statusCode', 403)

WebUI.callTestCase(findTestCase('ExcelAPIAutomation/Add User Test'), [('username') : 'a.sales', ('password') : 'park4701'
        , ('newuser') : 'wildcat', ('login_id') : '6136e7a6-7331-48a6-86c5-4c08e3f8e514'], FailureHandling.STOP_ON_FAILURE)

