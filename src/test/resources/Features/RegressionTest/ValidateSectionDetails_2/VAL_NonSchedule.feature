Feature: As an Automation Tester, I want to verify the Non Schedule accordion on Individual and common section details of a contract as per the user selection of template and value for, using an automated script.


    Scenario: Verify Non-Schedule accordion Platform defaults Not Listed for Individual and Common Section

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

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Common Section
        Then Verify the Non Schedule Platform as per template for Common Section "<RowNumber>"
        Then Delete Platform

                            ### Individual Section Details ###     
        When Navigate to Individual Section Details

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Individual Section
        Then Verify the Non Schedule Platform as per template for Individual Section "<RowNumber>"
        Then Delete Platform

        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 13 |




    Scenario: Verify Non-Schedule accordion Platform defaults LMA3113AT-B London Capacity for Individual and Common Section

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113AT-B"
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

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Common Section
        Then Verify the Non Schedule Platform as per template for Common Section "<RowNumber>"
        Then Delete Platform

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Non-Schedule Accordion ###    
        And Expand Non Schedule for Individual Section
        Then Verify the Non Schedule Platform as per template for Individual Section "<RowNumber>"
        Then Delete Platform

        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 13 |



    Scenario: Validate Non-Schedule accordion Platform defaults LMA3113-TA Brussels Capacity Individual Section

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113AT-B"
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
        And Select Syndicate For Brussels "<RowNumber>"
        And Click Continue

                            ### Individual Section Details ###     
        When Navigate to Individual Section Details
        Then Validate the Syndicate Type Individual

                            ### Non-Schedule Accordion ###      
        And Expand Non Schedule for Individual Section
        Then Verify the Non Schedule Platform for Brussels Capacity Individual Section "<RowNumber>"
        And Click on Save

        And Log out from Application

        Examples:
        | RowNumber |
        | 13 |




    Scenario: Verify Non Schedule accordion Lloyd's brokerage fields for Managing Agent

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3114"
        Given Contract Status "Active"
                            
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
        And Click Continue

                            ### Contract Leads ###
        And Select a Syndicate "<RowNumber>"
        And Click Continue

                            ### Common Section Details ### 
        When Navigate to Common Section Details

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Common Section
        Then Validate the absence of Total Lloyds Brokerage and Lloyds Brokerage Amount for Common Section

                            ### Individual Section Details ### 
        When Navigate to Individual Section Details
        
                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Individual Section
        Then Validate the absence of Total Lloyds Brokerage and Lloyds Brokerage Amount for Individual Section
        
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 14 |