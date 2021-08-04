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
println('Excel auth token API response:- ' + Response.getResponseText())

'updating the Global variable cloud_auth_token  with the response token from excel auth token API response'
GlobalVariable.cloud_auth_token = Response.getResponseText()

'Verifying if excel auth token API response status code is 201'
WS.verifyResponseStatusCode(Response, 201)

'Sending request to ExecuteCS_CRL API and capturing response in ExecuteCS_CRLResponse variable'
ExecuteCS_CRLResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Execute CS_CRL', [('cloud_auth_token') : GlobalVariable.cloud_auth_token]))

'Printing Execute CS_CRL API response'
println('Execute CS_CRL API response:- ' + ExecuteCS_CRLResponse.getResponseText())

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Execute CS_CRL Response'
def result = sluper.parseText(ExecuteCS_CRLResponse.getResponseBodyContent())

'Parsing Execute CS_CRL Response and extracting value of value key and verifying whether it is High'
WS.verifyElementPropertyValue(ExecuteCS_CRLResponse, '[0].data_items[0][0].data.value', 'High')

'Parsing Execute CS_CRL Response and extracting value of type key and verifying whether it is string'
WS.verifyElementPropertyValue(ExecuteCS_CRLResponse, '[0].data_items[0][0].data.type', 'string')

'Parsing Execute CS_CRL Response and extracting value of status key and verifying whether it is data'
WS.verifyElementPropertyValue(ExecuteCS_CRLResponse, '[0].data_items[0][0].status', 'data')

'Parsing Execute CS_CRL Response and extracting value of type key and verifying whether it is r1'
WS.verifyElementPropertyValue(ExecuteCS_CRLResponse, '[0].cid', 'r1')

