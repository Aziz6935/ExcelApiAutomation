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

'Sending request to excel auth token API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel auth token', [('excel_auth_token') : GlobalVariable.excel_auth_token
            , ('username') : username, ('password') : password]))

'Printing excel auth token API response'
println("Excel auth token API response:- " + Response.getResponseText())

'updating the Global variable cloud_auth_token  with the response token from excel auth token API response'
GlobalVariable.cloud_auth_token = Response.getResponseText()

'Verifying if excel auth token API response is 201'
WS.verifyResponseStatusCode(Response, 201)

'Sending request to Add Users API and capturing response in addUserResponse variable'
addUserResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Add User', [('cloud_auth_token') : GlobalVariable.cloud_auth_token
            , ('add_user') : GlobalVariable.add_user, ('username') : newuser, ('login_id') : login_id]))

'Printing Add Users API response'
println("Add User API response:- " + addUserResponse.getResponseText())

'Verifying if Add User API response is 200'
WS.verifyResponseStatusCode(addUserResponse, 200)

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()
'Parsing Add User Response'
def result = sluper.parseText(addUserResponse.getResponseBodyContent())

'Parsing Add User Response and extracting value of success key and verifying whether it is true'
WS.verifyElementPropertyValue(addUserResponse, '[0].success', true)

/*'Parsing Add User Response and extracting value of message key and verifying whether it is as per expected value'
WS.verifyElementPropertyValue(addUserResponse, '[0].message', ('User ' + "$newuser") + ' added.')
*/
'Updating newuser GlobalVariable with the value of the username that is newly created'
GlobalVariable.newuser = "$newuser"

'Sending request to update User API and capturing response in updateUserResponse variable'
updateUserResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Update User'))

'Printing Update Users API response'
println("Update User API response:- " +updateUserResponse.getResponseText())

'Parsing Response of update User'
def updateUserResult = sluper.parseText(updateUserResponse.getResponseBodyContent())

'Parsing Update User Response and extracting value of success key and verifying whether it is true'
WS.verifyElementPropertyValue(updateUserResponse, '[0].success', true)

'Parsing Update User Response and extracting value of message key and verifying whether it is as per expected value'
WS.verifyElementPropertyValue(updateUserResponse, '[0].message', ('User ' + "$newuser") + ' updated.')

'Sending request to delete User API and capturing response in deleteUserResponse variable'
deleteUserResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Delete User', [('cloud_auth_token') : GlobalVariable.cloud_auth_token
			, ('newuser') : GlobalVariable.newuser]))

'Printing Delete User Response'
println(deleteUserResponse.getResponseText())

WS.delay(2)

