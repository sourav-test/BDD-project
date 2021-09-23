Feature: As an Automation Tester, I want to verify the Claims & Complaints accordion on Individual section details of a contract along with validations for capacity seeker and provider, using an automated script.

    Scenario: Verify Claims & Complaints Validations for Coverholder Contracts when no coverholder is added
    
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

                            ### Common Section Details ###
        When Navigate to Common Section Details

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Common Section
        Then Select Yes for Claims Handling Authority For Coverholder Common Section
        Then Validate the claims handling authority client side error Message Common Section
        Then Validate the Currency Feild of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Add Per Claim Limit value of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Select Yes for Claims Handling Authority For DCA Common Section
        Then Search and Add DCA for Common Section "<RowNumber>"
    
                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Individual Section
        Then Select Yes for Claims Handling Authority Individual Section
        Then Validate the claims handling authority client side error Message Individual Section
        Then Validate the Currency Feild of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Add Per Claim Limit value of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Search and Add DCA for Individual Section "<RowNumber>"
    
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review
    
        And Navigate Back to Sections Details
    
        Then Validate the the claims handling authority server side error message post submission for Review
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 13 |


    @ignore155399
    Scenario: Verify Claims & Complaints Validations for Service Company Contracts when no SC is added
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3134"
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

                            ### Common Section Details ###    
        When Navigate to Common Section Details

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Common Section
        Then Select Yes for Claims Handling Authority For Coverholder Common Section
        Then Validate the claims handling authority client side error Message Common Section
        Then Validate the Currency Feild of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Add Per Claim Limit value of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Common Section "<RowNumber>"
        Then Select Yes for Claims Handling Authority For DCA Common Section
        Then Search and Add DCA for Common Section "<RowNumber>"

                            ### Individual Section Details ###     
        When Navigate to Individual Section Details
        And Expand Claims and Complaints for Individual Section
        Then Select Yes for Claims Handling Authority Individual Section
        Then Validate the claims handling authority client side error Message Individual Section
        Then Validate the Currency Feild of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Add Per Claim Limit value of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Add person authorised to exercise any claims authority of Claims and Complaints Accordion for Individual Section "<RowNumber>"
        Then Search and Add DCA for Individual Section "<RowNumber>"

        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the the claims handling authority server side error message post submission for Review
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 13 |