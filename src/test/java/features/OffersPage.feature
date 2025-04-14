Feature:  Search product on offers page

    Scenario: User searches for a product on the offers page
        Given I am on the offers page
        When search for "Tom" and extract the actual name of the product
        Then I should see "Tom" in the search results
        Then search on offers page and validate the product name matches with the landing page
         
         