Feature: search and place the order for product
Scenario: Search experience for product search in both home and offers page

Given : user is on landing page
When : user searched with <Name> and extarcted actual name of product
Then : user searched for <Name> shortname in offers page
And : validate products name in offers page matches with landing page

Examples:
| Name |
| Tom |
| Beet |
