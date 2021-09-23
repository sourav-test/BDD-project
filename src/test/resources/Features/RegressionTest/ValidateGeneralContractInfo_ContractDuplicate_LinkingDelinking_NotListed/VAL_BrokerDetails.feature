Feature: As an Automation Tester, I want to perform actions and validations for broker(s) within the contract for any questions that involve broker(s), using an automated script.

    Scenario: Validate the Broker details for Broker
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active" 
                            
                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"
    
                            ### Agreement Template ###
        And Select Agreement Template
        And Select Organization "<RowNumber>"
        And Select CSN "<RowNumber>"
        And Select an User Group "<RowNumber>"
        And Click Continue

                            ### General Contract Information ###
        When Enter UMR Number "<RowNumber>"
        Then Validate UMR number, Contract ID and Work Status
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
        And Select the Primary Currency "<RowNumber>"
        And Select the Tripartite Agreement as Yes
        And Click Continue

                            ### Broker Details ###
        And Enter Broker Details
        Then Validate Broker Details for Broker "<RowNumber>"
        And Click on Save
        And Log out from Application
    
        Examples:
        | RowNumber |
        | 10 |



    Scenario: Validate the Broker details for Managing Agent

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active"
        When I Enter UMR Number "<RowNumber>"
                            
                            ### Login As Managing Agent Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"

                            ### Agreement Template ###
        And Select Agreement Template
        And Select Organization "<RowNumber>"
        And Select CSN "<RowNumber>"
        And Select an User Group "<RowNumber>"
        And Click Continue

                            ### General Contract Information ###
        When Enter UMR Number "<RowNumber>"
        Then Validate UMR number, Contract ID and Work Status
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
        And Select the Primary Currency "<RowNumber>"
        And Select the Tripartite Agreement as Yes
        And Click Continue
    
                            ### Broker Details ###
        Then Validate Broker Details for Managing Agent "<RowNumber>"
        And Enter Broker Details                  
        And Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 11 |