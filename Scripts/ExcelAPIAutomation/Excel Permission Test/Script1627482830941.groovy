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
Response = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel auth token for benake'))

'Printing excel auth token for benake API response'
println('Excel auth token for benake API response:- ' + Response.getResponseText())

'updating the Global variable benake_auth_token  with the response token from excel auth token for benake API response'
GlobalVariable.benake_auth_token = Response.getResponseText()

'Verifying if excel auth token for benake API response is 201'
WS.verifyResponseStatusCode(Response, 201)

excelPermissionResponse = WS.sendRequest(findTestObject('ExcelAPIAutomation/Excel Permission', [('benake_auth_token') : GlobalVariable.benake_auth_token]))


'Printing Excel auth token for benake API response'
println('Excel auth token for benake API response - ' + excelPermissionResponse.getResponseText())

'JsonSlurper is a class that parses JSON text or reader content into Groovy data structures (objects) such as maps, lists and primitive types like Integer, Double, Boolean and String.'
def sluper = new JsonSlurper()

'Parsing Excel Permission Response Response'
def result = sluper.parseText(excelPermissionResponse.getResponseBodyContent())

'Parsing Excel Permission Response and extracting value of can_access_financials key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_financials', false)

'Parsing Excel Permission Response and extracting value of can_access_company key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_company', true)

'Parsing Excel Permission Response and extracting value of can_access_rp_company_url key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_rp_company_url', true)

'Parsing Excel Permission Response and extracting value of can_access_fas key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_fas', true)

'Parsing Excel Permission Response and extracting value of can_access_csr key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_csr', false)

'Parsing Excel Permission Response and extracting value of can_access_cre key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_cre', false)

'Parsing Excel Permission Response and extracting value of can_access_fundamental_rating key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_fundamental_rating', false)

'Parsing Excel Permission Response and extracting value of can_access_rec key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_rec', false)

'Parsing Excel Permission Response and extracting value of can_access_rec_changed_date key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_rec_changed_date', true)

'Parsing Excel Permission Response and extracting value of can_access_research_plus key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_research_plus', false)

'Parsing Excel Permission Response and extracting value of can_access_rp_coverage key and verifying whether it is false'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_rp_coverage', false)

'Parsing Excel Permission Response and extracting value of can_access_fr_coverage key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_access_fr_coverage', true)

'Parsing Excel Permission Response and extracting value of can_approve key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_approve', true)

'Parsing Excel Permission Response and extracting value of can_audit key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_audit', true)

'Parsing Excel Permission Response and extracting value of can_edit key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_edit', true)

'Parsing Excel Permission Response and extracting value of can_execute_cs_table_formula key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_execute_cs_table_formula', true)

'Parsing Excel Permission Response and extracting value of can_execute_cs_coverage_formula key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_execute_cs_coverage_formula', true)

'Parsing Excel Permission Response and extracting value of can_switch_environments key and verifying whether it is true'
WS.verifyElementPropertyValue(excelPermissionResponse, 'can_switch_environments', true)

