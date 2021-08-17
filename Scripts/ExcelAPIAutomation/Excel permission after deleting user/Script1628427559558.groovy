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

'Sending request to excel auth wildcat API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel_auth_wildcat', [('excel_auth_token') : GlobalVariable.excel_auth_token]))

'Printing excel auth token API response'
println('Excel auth token API response:- ' + Response.getResponseText())

'updating the Global variable wildcat_auth_token  with the response token from excel auth token API response'
GlobalVariable.wildcat_auth_token = Response.getResponseText()

'Verifying if excel auth token API response is 201'
WS.verifyResponseStatusCode(Response, 201)

excelResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel auth token', [('excel_auth_token') : GlobalVariable.excel_auth_token
	, ('username') : username, ('password') : password]))

GlobalVariable.cloud_auth_token = excelResponse.getResponseText()

'Sending request to Add User API and capturing response in addUserResponse variable'
addUserResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Add User', [('cloud_auth_token') : GlobalVariable.cloud_auth_token
            , ('add_user') : GlobalVariable.add_user, ('username') : newuser]))

'Printing Add Users API response'
println('Add User API response:- ' + addUserResponse.getResponseText())

'Verifying if Add User API response is 200'
WS.verifyResponseStatusCode(addUserResponse, 200)

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Add User Response'
def result = sluper.parseText(addUserResponse.getResponseBodyContent())

'updating the Global variable newuser with the newly created username'
GlobalVariable.newuser = "$newuser"

'Sending request to delete User API and capturing response in deleteUserResponse variable'
deleteUserResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Delete User', [('cloud_auth_token') : GlobalVariable.cloud_auth_token
            , ('newuser') : GlobalVariable.newuser]))


'Printing Delete User Response'
println(deleteUserResponse.getResponseText())

'Verifying if Delete User API response is 200'
WS.verifyResponseStatusCode(deleteUserResponse, 200)
WS.delay(30)
'Sending request to Excel permission after deleting user and capturing response in excelPermissionResponse variable'
excelPermissionResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel permission after deleting user', [('wildcat_auth_token') : GlobalVariable.wildcat_auth_token]))
'Parsing Excel permission after deleting user Response'
def excelPermission = sluper.parseText(excelPermissionResponse.getResponseBodyContent())
//println(excelPermissionResponse.getResponseText())
//'Parsing Excel permission after deleting user Response and extracting value of message key and verifying whether if it is as expected'
WS.verifyElementPropertyValue(excelPermissionResponse, 'message', 'Access Denied. Please contact your Sales person or email CreditSights support for help.')
