Feature: As an Automation Tester, I want to verify and add adequate details for the accordions available on Common Section Details page and also want verify "Apply to All" functionality while creating a contract , using an automated script.


    Scenario: Verify Apply to All Sections for Binding Authority Agreement
    
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
        Then Apply CoverHolder or Service Company Details

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        And Expand Person Responsible Tab for Common Section
        Then Validate Person Responsible For Operation and Control Apply is Disabled
        Then Add Person Responsible Operation and Control for Common Section "<RowNumber>"
        Then Add Person Authorised to Bind Insurances for Common Section "<RowNumber>"
        Then Add Person Overall Responsibility for Common Section "<RowNumber>"
        Then Apply Person Responsible for Operation and Control

                            ### Territorial Limitations Accordion ###    
        And Expand Territorial Limitations Section for Common Section
        Then Validate Territorial Limitations Apply is Disabled
        Then Add and Copy Territorial Limitations for Common Section "<RowNumber>"
        Then Apply Territorial Limitations

                            ### Period Of Insurances Bound Accordion ###    
        And Expand Period Of Insurances Bound for Common Section
        Then Validate Period Of Insurances Bound Apply is Disabled
        Then Add details to the Period Of Insurances Bound for Common Section "<RowNumber>"
        Then Apply Period Of Insurances Bound

                            ### Commissions Accordion ###   
        And Expand Commissions for Common Section
        Then Validate Commissions Apply is Disabled
        Then Add details to the Commission for Common Section "<RowNumber>"
        Then Apply Commission

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Common Section
        Then Validate Claims and Complaints Apply is Disabled
        Then Select No for Claims Handling Authority Common Section
        Then Select No for Complaints Handling Authority Common Section
        Then Select No for Eligible Complainants Under This Contract Common Section
        Then Apply Claims and Complaints

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Validate Reporting and Aggregate Exposures Apply is Enabled
        Then Add details to the Reporting and Aggregate Exposures for Common Section "<RowNumber>"
        Then Apply Reporting and Aggregate Exposures

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Common Section
        Then Validate Capacity Details Apply is Disabled
        Then Add Syndicate under Capacity Details for Lead Common Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Common Section
        Then Apply Capacity Details
    
                            ### Non-Schedule Accordion ###    
        And Expand Non Schedule for Common Section
        #Then Validate Non Schedule Apply is Disabled
        Then Add details to the Non Schedule for Common Section "<RowNumber>"
        Then Apply Non Schedule

                            ### Individual Section Details ### 
        When Navigate to Individual Section Details

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"
    
                            ### Gross Premium Income Limit Accordion ###    
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"
    
                            ### Commissions Accordion ###    
        And Expand Commissions for Individual Section
        Then Enter Maximum Retail Broker Commission

                            ### Reporting and Aggregate Exposures Accordion ###    
        #And Expand Reporting and Aggregate Exposures for Individual Section
        #Then Add Delegated Data Manager "<RowNumber>"
        #And Click on Save
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

        Examples:
        | RowNumber |
        | 7 |
    
    
    @ignore155399
    Scenario: Verify Apply to All Sections for Service Company Contracts
    
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

                            ### Coverholder/Service Company Accordion ###    
        Then Verify Section Accordian and Add Market Participant for Common Section "<RowNumber>"
        Then Apply CoverHolder or Service Company Details

                            ### Person(s) Responsible for Operation and Control Accordion ###     
        And Expand Person Responsible Tab for Common Section
        Then Add Person Responsible Operation and Control for Common Section "<RowNumber>"
        Then Apply Person Responsible for Operation and Control

                            ### Territorial Limitations Accordion ###    
        And Expand Territorial Limitations Section for Common Section
        Then Validate the Worldwide Excluding For Common Section "<RowNumber>"
        Then Apply Territorial Limitations

                            ### Period Of Insurances Bound Accordion ###    
        And Expand Period Of Insurances Bound for Common Section
        Then Add details to the Period Of Insurances Bound for Common Section "<RowNumber>"
        Then Apply Period Of Insurances Bound

                            ### Commissions Accordion ###    
        And Expand Commissions for Common Section
        Then Add details to the Commission for Common Section "<RowNumber>"
        Then Apply Commission

                            ### Claims and Complaints Accordion ###     
        And Expand Claims and Complaints for Common Section
        Then Select No for Claims Handling Authority Common Section
        Then Select No for Complaints Handling Authority Common Section
        Then Select No for Eligible Complainants Under This Contract Common Section
        Then Apply Claims and Complaints

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Add details to the Reporting and Aggregate Exposures for Common Section "<RowNumber>"
        Then Apply Reporting and Aggregate Exposures

                            ### Capacity Details Accordion ###    
        And Expand Capacity Section Section for Common Section
        Then Add Syndicate under Capacity Details for Lead Common Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Common Section
        Then Apply Capacity Details
    
                            ### Non-Schedule Accordion ###    
        And Expand Non Schedule for Common Section
        Then Add details to the Non Schedule for Common Section "<RowNumber>"
        Then Apply Non Schedule

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###    
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"
    
                            ### Gross Premium Income Limit Accordion ###    
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"
    
                            ### Commissions Accordion ###    
        And Expand Commissions for Individual Section
        Then Enter Maximum Retail Broker Commission
    
                            ### Reporting and Aggregate Exposures Accordion ###    
        #And Expand Reporting and Aggregate Exposures for Individual Section
        #Then Add Delegated Data Manager "<RowNumber>"
        #And Click on Save
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

        Examples:
        | RowNumber |
        | 7 |



    Scenario: Verify Apply to All Sections for Coverholder Appointment Agreement
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LBS0001A"
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
        Then Apply CoverHolder or Service Company Details

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        And Expand Person Responsible Tab for Common Section
        Then Add Person Responsible Operation and Control for Common Section "<RowNumber>"
        Then Add Person Authorised to Bind Insurances for Common Section "<RowNumber>"
        Then Add Person Overall Responsibility for Common Section "<RowNumber>"
        Then Apply Person Responsible for Operation and Control

                            ### Territorial Limitations Accordion ###    
        And Expand Territorial Limitations Section for Common Section
        Then Validate the Worldwide Excluding For Common Section "<RowNumber>"
        Then Apply Territorial Limitations

                            ### Period Of Insurances Bound Accordion ###     
        And Expand Period Of Insurances Bound for Common Section
        Then Add details to the Period Of Insurances Bound for Common Section "<RowNumber>"
        Then Apply Period Of Insurances Bound

                            ### Commissions Accordion ###     
        And Expand Commissions for Common Section
        Then Add details to the Commission for Common Section "<RowNumber>"
        Then Apply Commission

                            ### Claims and Complaints Accordion ###    
        And Expand Claims and Complaints for Common Section
        Then Select No for Claims Handling Authority Common Section
        Then Select No for Complaints Handling Authority Common Section
        Then Select No for Eligible Complainants Under This Contract Common Section
        Then Apply Claims and Complaints

                            ### Reporting and Aggregate Exposures Accordion ###    
        And Expand Reporting and Aggregate Exposures for Common Section
        Then Add details to the Reporting and Aggregate Exposures for Common Section "<RowNumber>"
        Then Apply Reporting and Aggregate Exposures

                            ### Capacity Details Accordion ###    
        And Expand Capacity Section Section for Common Section
        Then Add Syndicate under Capacity Details for Lead Common Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Common Section
        Then Apply Capacity Details
    
                            ### Non-Schedule Accordion ###    
        And Expand Non Schedule for Common Section
        Then Add details to the Non Schedule for Common Section "<RowNumber>"
        Then Apply Non Schedule

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###    
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"
    
                            ### Gross Premium Income Limit Accordion ###    
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"
    
                            ### Commissions Accordion ###     
        And Expand Commissions for Individual Section
        Then Enter Maximum Retail Broker Commission
    
                            ### Reporting and Aggregate Exposures Accordion ###    
        #And Expand Reporting and Aggregate Exposures for Individual Section
        #Then Add Delegated Data Manager "<RowNumber>"
        And Click on Save
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application
    
        Examples:
        | RowNumber |
        | 8 |