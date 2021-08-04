<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Update User</name>
   <tag></tag>
   <elementGuidId>077e360f-d34a-43f9-8054-f86b6b664c81</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;  [ \n    {\n        \&quot;username\&quot;: \&quot;${new_user}\&quot;,\n        \&quot;login_id\&quot;: \&quot;e4305d4d-801f-46bc-88f8-8c78a037eb9a\&quot;,\n        \&quot;can_access_financials\&quot;: true,\n        \&quot;can_access_company\&quot;: true,\n        \&quot;can_access_rp_company_url\&quot;: true,\n        \&quot;can_access_fas\&quot;: true,\n        \&quot;can_access_csr\&quot;: false,\n        \&quot;can_access_cre\&quot;: false,\n        \&quot;can_access_fundamental_rating\&quot;: true,\n        \&quot;can_access_rec\&quot;: true,\n        \&quot;can_access_rec_changed_date\&quot;: true,\n        \&quot;can_access_research_plus\&quot;: true,\n        \&quot;can_access_rp_coverage\&quot;: true,\n        \&quot;can_access_fr_coverage\&quot;: true,\n        \&quot;can_approve\&quot;: true,\n        \&quot;can_audit\&quot;: true,\n        \&quot;can_edit\&quot;: true,\n        \&quot;can_execute_cs_table_formula\&quot;: true,\n        \&quot;can_execute_cs_coverage_formula\&quot;: true,\n        \&quot;can_switch_environments\&quot;: true\n    }]&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>x-api-key</name>
      <type>Main</type>
      <value>WeQTFr0Og04EN87VaO2Nd21jLTr2aKY07kHYEBtZ</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${cloud_auth_token}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <katalonVersion>7.7.2</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://cloud-qa.staging.creditsights.com/api/excel/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.cloud_auth_token</defaultValue>
      <description></description>
      <id>76a78e1a-45de-4677-a727-1bc4a0522858</id>
      <masked>false</masked>
      <name>cloud_auth_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.newuser</defaultValue>
      <description></description>
      <id>475e593a-c528-46fc-affc-000aa20f74cb</id>
      <masked>false</masked>
      <name>new_user</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
