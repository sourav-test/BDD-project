Feature: As an Automation Tester, I want to validate that Managing Agent User have to add atleast 1 Syndicates on the contract using an automated script.

    Scenario: Verify that Managing Agent have to add one Syndicate

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
        And Click Continue

                            ### Contract Leads ###
        And Select a Syndicate "<RowNumber>"
        And Click Continue

                            ### Individual Section Details ###
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review
        And Navigate Back to Sections Details

        Then Validate the Error Message for Managing Agent Syndicate
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 14 |


    Scenario: Verify Reporting and Aggregate Exposures Contract Administrator for Managing Agent as a Contract Creator

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
        And Click Continue

                            ### Contract Leads ###
        And Click Continue

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"  

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"                  

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Verify the Contract Administrator when Managing Agent acts as a Contract Creator "<RowNumber>"
    
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 14 |