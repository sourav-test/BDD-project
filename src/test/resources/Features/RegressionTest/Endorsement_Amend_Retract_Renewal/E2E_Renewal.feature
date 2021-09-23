Feature: As an Automation Tester, I want to verify the functionality of Renewal for Active, Expired and Registered Contract using an automated script.


    Scenario: Validate the Renewal of Active Contract
    
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
        And Select a Service Company "<RowNumber>"
        And Click Continue

                            ### Individual Section Details ###
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Individual Section
        Then Perform Copy Names To Insurances Bound for Individual Section

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Validate the Worldwide Excluding For Individual Section "<RowNumber>"

                            ### Gross Premium Income Limit Accordion ###
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"

                            ### Period Of Insurances Bound Accordion ###
        Then Expand Period Of Insurances Bound for Individual Section
        Then Add details to the Period Of Insurances Bound for Individual Section "<RowNumber>"

                            ### Commissions Accordion ###
        And Expand Commissions for Individual Section
        Then Add details to the Commission for Individual Section "<RowNumber>"

                            ### Claims and Complaints Accordion ###
        And Expand Claims and Complaints for Individual Section
        Then Select No for Claims Handling Authority Individual Section
        Then Select No for Complaints Handling Authority Individual Section
        Then Select No for Eligible Complainants Under This Contract Individual Section

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Add details to the Reporting and Aggregate Exposures for Individual Section "<RowNumber>"

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Service Company under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Individual Section
        Then Add details to the Non Schedule for Individual Section "<RowNumber>"
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"

                            ### Navigate to Search Contracts and Contract Actions ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
    
                            ### Create Contract Renewal ###
        Then Start Renewal Workflow "<RowNumber>"
        And Click Continue

                            ### General Contract Information ###
        Then Validate the new Contract ID for Duplicate Contract
        Then Enter UMR Number "<RowNumber>"
        And Click Continue
        And Navigate to Contract Leads From Broker Details
        And Navigate to Section Details From Contract Leads
        Then Select Confirmation Date on Individual Section for Renewal
        And Navigate to Non Schedule From Section Details
        And Navigate to Actions From Non Schedule
    
                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application
    

        Examples:
        | RowNumber |
        | 4 |



    Scenario: Validate the Renewal of Registered Contract and Validate Terminated Section is not present
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Registered" 
                            
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
        And Select a Service Company "<RowNumber>"
        And Click Continue

                            ### Individual Section Details ###
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Individual Section
        Then Perform Copy Names To Insurances Bound for Individual Section

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Validate the Worldwide Excluding For Individual Section "<RowNumber>"

                            ### Gross Premium Income Limit Accordion ###
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"

                            ### Period Of Insurances Bound Accordion ###
        Then Expand Period Of Insurances Bound for Individual Section
        Then Add details to the Period Of Insurances Bound for Individual Section "<RowNumber>"

                            ### Commissions Accordion ###
        And Expand Commissions for Individual Section
        Then Add details to the Commission for Individual Section "<RowNumber>"

                            ### Claims and Complaints Accordion ###
        And Expand Claims and Complaints for Individual Section
        Then Select No for Claims Handling Authority Individual Section
        Then Select No for Complaints Handling Authority Individual Section
        Then Select No for Eligible Complainants Under This Contract Individual Section

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Add details to the Reporting and Aggregate Exposures for Individual Section "<RowNumber>"

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Service Company under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Individual Section
        Then Add details to the Non Schedule for Individual Section "<RowNumber>"
    
        And Click on Save
        Then Perform Copy Section action and verify the result
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
    
                            ### Navigate to Search Contracts and Contract Actions ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
    
                            ### Create Endorsement, Terminate a Section and Submit for Review ###
        Then Start Endorsement Workflow "<RowNumber>"
        And Enter Endorsement Effective Date "<RowNumber>"
        And Enter Changes Made and Confirmation Date
        And Upload a Copy Of Signed Endorsement
        And Click Continue
        And Navigate to Broker Details From Agreement Template
        And Navigate to Contract Leads From Broker Details
        And Navigate to Section Details From Contract Leads
        Then Terminate a section on Individual Section Details
        And Navigate to Non Schedule From Section Details
        And Navigate to Actions From Non Schedule
        And Click on Submit For Review
        Then Validate WorkFlow Status Under Review
        And Log out from Application
    
                            ### Login as Managing Agent Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"
    
                            ### Navigate to Search Contracts and Endorsement Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Endorsement Review Task From Search Contract
    
                            ### Approve Endorsement Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task For Endorsement with comments "<RowNumber>"
        And Log out from Application

                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"

                            ### Navigate to Search Contracts and Contract Actions ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        Then Validate that Endorsement is Completed "<RowNumber>"
    
                            ### Create Contract Renewal ###
        Then Start Renewal Workflow "<RowNumber>"
        And Click Continue

                            ### General Contract Information ###
        Then Validate the new Contract ID for Duplicate Contract
        Then Enter UMR Number "<RowNumber>"
        And Click Continue

        And Navigate to Contract Leads From Broker Details
        And Navigate to Section Details From Contract Leads
        Then Validate Terminated Section is not present on Individual Section Details
        Then Select Confirmation Date on Individual Section for Renewal
        And Navigate to Non Schedule From Section Details
        And Navigate to Actions From Non Schedule
    
                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review
        
        Then Validate WorkFlow Status Under Review
        And Log out from Application
    
                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Validate the Contract Status as Registered ###
        When Login as Contract Creator "<RowNumber>"
        And Navigate to the Search Contracts
        And Search with Unique Identifier
        Then Validate Dashboard Task Status for REGISTERED "<RowNumber>"
        And Log out from Application
    
        Examples:
        | RowNumber |
        | 4 |




    Scenario: Validate the Renewal of Expired Contract

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Expired"
    
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
        And Select a Service Company "<RowNumber>"
        And Click Continue

                            ### Individual Section Details ###
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Individual Section
        Then Perform Copy Names To Insurances Bound for Individual Section

                            ### Authorised Class(es) of Business and Coverage(s) Accordion ###
        And Expand Authorised Class and Business Coverage
        Then Select Distribution Method Premium Level of Authority and Deductibles or Excess
        Then Add High Level Class of Business
        Then Add Regulatory Client Classification For High Level Class Of Business
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for High Level Class of Business "<RowNumber>"
        Then Select Insurance or Reinsurance and Risk Codes for Generic Class Of Business "<RowNumber>"
        Then Validate the Currency Code and Add Maximum limit of Liability Sum Insured for Generic Class Of Business "<RowNumber>"

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Validate the Worldwide Excluding For Individual Section "<RowNumber>"

                            ### Gross Premium Income Limit Accordion ###
        And Expand Gross Premium Income Limit Individual Section
        Then Validate Currency and Enter Gross Premium Income Limit Details "<RowNumber>"

                            ### Period Of Insurances Bound Accordion ###
        Then Expand Period Of Insurances Bound for Individual Section
        Then Add details to the Period Of Insurances Bound for Individual Section "<RowNumber>"

                            ### Commissions Accordion ###
        And Expand Commissions for Individual Section
        Then Add details to the Commission for Individual Section "<RowNumber>"

                            ### Claims and Complaints Accordion ###
        And Expand Claims and Complaints for Individual Section
        Then Select No for Claims Handling Authority Individual Section
        Then Select No for Complaints Handling Authority Individual Section
        Then Select No for Eligible Complainants Under This Contract Individual Section

                            ### Reporting and Aggregate Exposures Accordion ###
        And Expand Reporting and Aggregate Exposures for Individual Section
        Then Add details to the Reporting and Aggregate Exposures for Individual Section "<RowNumber>"

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Service Company under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

                            ### Non-Schedule Accordion ###
        And Expand Non Schedule for Individual Section
        Then Add details to the Non Schedule for Individual Section "<RowNumber>"
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        Then Validate WorkFlow Status Under Review
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"

                            ### Navigate to Search Contracts and Contract Actions ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
    
                            ### Create Contract Renewal ###
        Then Start Renewal Workflow "<RowNumber>"
        And Click Continue

                            ### General Contract Information ###
        Then Validate the new Contract ID for Duplicate Contract
        Then Enter UMR Number "<RowNumber>"
        And Click Continue
        And Navigate to Contract Leads From Broker Details
        And Navigate to Section Details From Contract Leads
        Then Select Confirmation Date on Individual Section for Renewal
        And Navigate to Non Schedule From Section Details
        And Navigate to Actions From Non Schedule
    
                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review
        
        Then Validate WorkFlow Status Under Review
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application
    

        Examples:
        | RowNumber |
        | 4 |