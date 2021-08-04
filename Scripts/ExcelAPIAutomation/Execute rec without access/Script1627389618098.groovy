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

'Sending request to Excel auth token for benake API and capturing response in Response variable'
Response = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel auth token for benake'))

'Printing Excel auth token for benake API response'
println('Excel auth token for benake API response:- ' + Response.getResponseText())

'updating the Global variable benake_auth_token  with the response token from excel auth token API response'
GlobalVariable.benake_auth_token = Response.getResponseText()

'Verifying if excel auth token API response status code is 201'
WS.verifyResponseStatusCode(Response, 201)

'Sending request to Execute rec without access API and capturing response in ExecuteRecWithoutAccessResponse variable'
ExecuteRecWithoutAccessResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Execute rec without access', [('benake_auth_token') : GlobalVariable.benake_auth_token]))

'Printing Execute rec without access API Response'
println('Execute rec without access API Response:- ' + ExecuteRecWithoutAccessResponse.getResponseText())

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Execute rec without access API Response'
def result = sluper.parseText(ExecuteRecWithoutAccessResponse.getResponseBodyContent())

'Parsing Execute rec without access API Response and extracting value of status key and verifying whether it error'
WS.verifyElementPropertyValue(ExecuteRecWithoutAccessResponse, '[0].data_items[0][0].status', 'error')

'Parsing Execute rec API Response and extracting value of message key and verifying whether user is You don\'t have access to the requested data.'
WS.verifyElementPropertyValue(ExecuteRecWithoutAccessResponse, '[0].data_items[0][0].errors[0].message', 'You don\'t have access to the requested data.')

'Parsing Execute rec without access API Response and extracting value of cid key and verifying whether it r1'
WS.verifyElementPropertyValue(ExecuteRecWithoutAccessResponse, '[0].cid', 'r1')

'Parsing Execute rec without access API Response and extracting value of status key and verifying whether it data'
WS.verifyElementPropertyValue(ExecuteRecWithoutAccessResponse, '[0].status', 'data')

