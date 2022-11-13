Feature: Currency list Get API and property carousel Post API

Scenario Outline: Verify base currency name and code using currency list	get API 
	When User calls "<API_Name>" get request and validate "currencyListSchema.json" schema 
	Then API is success with 200 status code
	And "<Response_body_Key>" is "<Response_body_value>" in response body
	And "<Response_body_Key2>" is "<Response_body_value2>" in response body
		
Examples:
|API_Name         |Response_body_Key|Response_body_value|Response_body_Key2|Response_body_value2|
|currencyListPath |base.name        |Saudi Riyal        |base.code         |SAR                 |


Scenario Outline: Verify if user is able search property carousel
	Given User search property for "<CheckIn>" "<Checkout>" by "rank" and "DESC"
	When User calls "<API_Name>" post request
	Then API is success with <status_code>
	And "<Response_body_Key>" is "<Response_body_value>" in response body
	And "<Response_body_Key2>" is "<Response_body_value2>" in response body	
Examples:
|API_Name        |status_code|CheckIn   |Checkout  | Response_body_Key|Response_body_value|Response_body_Key2|Response_body_value2|
|propertyCarousel| 200       |2022-11-17|2022-11-18|count             |4                  |carousels.titleEn |[Most booked, Chalets with water games, New chalets, Khalid’s picks]|
|propertyCarousel| 400       |2022-11-10|2022-11-18|httpStatusCode    |400                |message           |Invalid check-in date: Should not be in the past         |