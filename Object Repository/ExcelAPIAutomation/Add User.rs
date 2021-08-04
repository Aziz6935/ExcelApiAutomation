<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Add User</name>
   <tag></tag>
   <elementGuidId>2933c98d-31c5-4489-8046-16357dd37dcd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;  [ \n    {\n        \&quot;username\&quot;: \&quot;${username}\&quot;,\n        \&quot;login_id\&quot;: \&quot;${login_id}\&quot;,\n        \&quot;can_access_financials\&quot;: true,\n        \&quot;can_access_company\&quot;: true,\n        \&quot;can_access_rp_company_url\&quot;: true,\n        \&quot;can_access_fas\&quot;: true,\n        \&quot;can_access_csr\&quot;: true,\n        \&quot;can_access_cre\&quot;: true,\n        \&quot;can_access_fundamental_rating\&quot;: true,\n        \&quot;can_access_rec\&quot;: true,\n        \&quot;can_access_rec_changed_date\&quot;: true,\n        \&quot;can_access_research_plus\&quot;: true,\n        \&quot;can_access_rp_coverage\&quot;: true,\n        \&quot;can_access_fr_coverage\&quot;: true,\n        \&quot;can_approve\&quot;: true,\n        \&quot;can_audit\&quot;: true,\n        \&quot;can_edit\&quot;: true,\n        \&quot;can_execute_cs_table_formula\&quot;: true,\n        \&quot;can_execute_cs_coverage_formula\&quot;: true,\n        \&quot;can_switch_environments\&quot;: true\n    }]&quot;,
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
      <id>eecd3223-532a-4acf-aae8-8aa552b5c40d</id>
      <masked>false</masked>
      <name>cloud_auth_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.add_user</defaultValue>
      <description></description>
      <id>098413c9-e074-4c2f-b2a8-365aa7e957a9</id>
      <masked>false</masked>
      <name>add_user</name>
   </variables>
   <variables>
      <defaultValue>'wildcat'</defaultValue>
      <description></description>
      <id>c1c90e9a-155c-4500-8179-d5905a2ff486</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'6136e7a6-7331-48a6-86c5-4c08e3f8e514'</defaultValue>
      <description></description>
      <id>d635f97d-2a1d-4953-b8e5-fcb325fd35c9</id>
      <masked>false</masked>
      <name>login_id</name>
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
