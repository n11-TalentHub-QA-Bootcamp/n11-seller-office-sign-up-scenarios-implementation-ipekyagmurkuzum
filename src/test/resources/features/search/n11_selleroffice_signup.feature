Feature: n11 login
#https://so.n11.com/
@selleroffice-signup
Scenario: n11 selleroffice login
Given İpek launchs browser and opens the login page
When İpek signs up selleroffice with valid credentials
And avoids the contract agreement
Then İpek should not be signed up
