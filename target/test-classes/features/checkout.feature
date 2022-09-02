Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search experience for product search in both home and offers page
Given User is on GreenKart landing page
When User searched with Shortname <Name> and extracted actual name of product
And added "3" items of the selected products to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And verify if user has ability to apply promo code and place the order

Examples:
| Name |
| Tom  |
