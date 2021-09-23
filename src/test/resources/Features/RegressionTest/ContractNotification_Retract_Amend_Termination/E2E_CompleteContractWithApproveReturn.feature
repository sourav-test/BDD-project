Feature: As an Automation Tester, I want to verify the  Create Contract workflow along with Review Task creation and assignment and Approve/Return subflows, using an automated script

    Scenario: Verify the Create Contract Workflow with Notifications
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"
        And Get Contract Creator Name "<RowNumber>"
                        
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

                            ## Broker Details ###
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
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
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

                            ### Login as Managing Agent Read Write Submit User ###
        And Login as Managing Agent Operator "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Navigate to Review Task From Ongoing Task Dashboard
        Then Validate the Document Library on Review harness for Contract Reviewer

                            ### Return Review Task as Syndicate Lead When Assigned to Default ###
        Then Return the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Navigate to Review Task From Ongoing Task Dashboard
        Then Validate the Document Library on Review harness for Contract Reviewer

                            ### Return Review Task as Service Company Lead When Assigned to Default ###
        Then Return the Review Task with comments "<RowNumber>"
        And Log out from Application

                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"
        
                            ### Navigate to Search Contracts and Review Task Returned ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        
                            ### Disagree the First Review Task Returned ###
        Then Open the Review Task Returned
        Then Disagree the Review Tasks Returned with comments "<RowNumber>"
        And Validate System Notification for Review Tasks Returned "<RowNumber>"
        And Log out from Application
        
                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"
    
                            ### Navigate to Search Contracts and Review Task Returned ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        Then Validate the Document Library on Review harness for Contract Creator
        
                            ### Disagree the Second Review Task Returned ###
        Then Open the Review Task Returned
        Then Disagree the Review Tasks Returned with comments "<RowNumber>"
        And Log out from Application
        
                            ### Login as Managing Agent Read Write Submit User ###
        And Login as Managing Agent Operator "<RowNumber>"
        And Get Managing Agent Name "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Navigate to Review Task From Ongoing Task Dashboard

                            ### Approve Review Task as Syndicate Lead When Assigned to Syndicate Lead ###
        Then Approve the Review Task For Managing Agent with comments "<RowNumber>"
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"
        And Get Service Company Name "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Navigate to Review Task From Ongoing Task Dashboard

                            ### Approve Review Task as Service Company Lead When Assigned to Service Company Lead ###
        Then Approve the Review Task For Service Company with comments "<RowNumber>"
        And Log out from Application
    
                            ### Steps For Notification Validation For Syndicate Lead ###
        And Login as Managing Agent Operator "<RowNumber>"
        Then Validate System Notification for Contract Completed "<RowNumber>"
        And Log out from Application
    
                            ### Steps For Notification Validation For Service Company Lead ###
        And Login as Service Company Operator "<RowNumber>"
        Then Validate System Notification for Contract Completed "<RowNumber>"
        And Log out from Application 

                            ### Validations Notification For Contract Owner, Contract is Completed ###
        Given Login as Contract Creator "<RowNumber>"
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to a Completed Contract
        And Validate System Notification for Review Tasks Approved "<RowNumber>"
        And Validate System Notification for Contract Completed "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 2 |



    Scenario: Verify the Review Task is not available when Contract Creator is retracting the task
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active"  
                            
                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"
        And Get Contract Creator Name "<RowNumber>"
                        
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
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
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

                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

                            ### Retract The Contract ###
        Then Retract The Contract
        And Log out from Application

                            ### Login as Managing Agent Read Write Submit User ###
        And Login as Managing Agent Operator "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract Not present on Ongoing Task Dashboard
        And Log out from Application

                            ### Login as Service Company Read Write Submit User ###
        And Login as Service Company Operator "<RowNumber>"
        
                            ### Navigate to Ongoing Tasks and then Review Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract Not present on Ongoing Task Dashboard
        And Log out from Application

        Examples:
        | RowNumber |
        | 2 |