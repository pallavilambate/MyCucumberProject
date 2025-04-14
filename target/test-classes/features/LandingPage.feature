Feature: search and place the order for product
Scenario: Search experience for product search in both home and offers page

Given : user is on landing page
When : user searched with <Name> and extarcted actual name of product
Then : user searched for <Name> shortname in landingpage page
Then validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom |
