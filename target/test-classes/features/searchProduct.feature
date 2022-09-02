Feature: Search and place the order for products

@OffersPage
Scenario Outline: Search experience for product search in both home and offers page
Given User is on GreenKart landing page
When User searched with Shortname <Name> and extracted actual name of product
Then User searched the <Name> Shortname in offers page
And Validate product name in offers page matches with landing page

Examples:
| Name |
| Tom  |
| Beet |