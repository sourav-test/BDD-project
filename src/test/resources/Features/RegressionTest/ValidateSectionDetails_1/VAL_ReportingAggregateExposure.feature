Feature: As an Automation Tester, I want to verify the Claims & Complaints,Gross Premium Income Limit and Reporting and Aggregate Exposures on Common section details of a contract, using an automated script.

    Scenario: Verify the Claims And Complaints Gross Income Limit and Reporting Accordion for Common Section

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

                            ### Coverholder/Service Company Accordion ###    
        Then Verify Section Accordian and Add Market Participant for Common Section "<RowNumber>"

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Add details to the Reporting and Aggregate Exposures for Common Section "<RowNumber>"
        Then Validate the Default Party for roles in relation to Risks Written for Common section
        Then Validate the Default Party for roles in relation to Paid Premium for Common section
        Then Validate the Default Party for roles in relation to Aggregates for Common section
        Then Validate the Participants for Risks Written Coverholder or Service Company and Underwriters Common section "<RowNumber>"
        Then Validate the Participants for Paid Premium Coverholder or Service Company and Underwriters Common section "<RowNumber>"
        Then Validate the Participants for Aggregates Coverholder or Service Company and Underwriters Common section "<RowNumber>"
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    
    Scenario: Verify Reporting And Aggregate Exposures accordion for Common And Individual Section for LMA3115M

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3115M"
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

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Validate Reporting and Aggregate Exposures Common Section "<RowNumber>"
    
                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Validate Reporting and Aggregate Exposures Individual Section "<RowNumber>"
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify the Claims And Complaints Gross Income Limit and Reporting Accordion for Individual Section
    
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
        #Then Add Market Participant for Claims Handling Individual Section "<RowNumber>"
    
                            ### Reporting and Aggregate Exposures Accordion ###     
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Add details to the Reporting and Aggregate Exposures for Individual Section "<RowNumber>"
        Then Validate the Default Party for roles in relation to Risks Written for Individual section
        Then Validate the Default Party for roles in relation to Paid Premium for Individual section
        Then Validate the Default Party for roles in relation to Aggregates for Individual section
        Then Validate the Participants for Risks Written Coverholder or Service Company and Underwriters Individual section "<RowNumber>"
        Then Validate the Participants for Paid Premium Coverholder or Service Company and Underwriters Individual section "<RowNumber>"
        Then Validate the Participants for Aggregates Coverholder or Service Company and Underwriters Individual section "<RowNumber>"
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify Reporting and Aggregate Exposures accordion for Common and Individual Section

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
        Then Select No for Claims Handling Authority Common Section

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Validate the Absence of roles in relation to Claims for Common Section

                            ### Individual Section Details ###     
        When Navigate to Individual Section Details

                            ### Claims and Complaints Accordion ###     
        And Expand Claims and Complaints for Individual Section
        Then Select No for Claims Handling Authority Individual Section "<RowNumber>"

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Validate the Absence of roles in relation to Claims for Individual Section
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify Reporting and Aggregate Exposures Participant added not in section/contract for Broker

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

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Select the Risk Written Submission as Broker for Individual Section
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the Error Message for Underwriter Not Selected
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify Reporting and Aggregate Exposures Participant added not in section/contract for Underwriter

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

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Select the Risk Written Submission as Underwriter for Individual Section
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the Error Message for Underwriter Not Selected
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify Reporting and Aggregate Exposures Participant added not in section/contract for Coverholder

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

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Select the Risk Written Submission as Coverholder for Individual Section
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the Error Message for Coverholder Not Selected
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    
    Scenario: Verify Reporting and Aggregate Exposures Participant added not in section/contract for DCA

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

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Individual Section
        Then Select Yes for Claims Handling Authority Individual Section
        Then Select Yes for Complaints Handling Authority Individual Section

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Select the Claims Submission as Delegated Claims Authority for Individual Section
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the Error Message for Delegated Claims Administrator Not Selected
        Then Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |