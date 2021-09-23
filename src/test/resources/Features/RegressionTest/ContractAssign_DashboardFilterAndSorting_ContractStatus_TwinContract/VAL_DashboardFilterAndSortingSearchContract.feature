Feature: As an Automation Tester, I want to see all the contracts in-progress and assigned to me in one place, apply filter and sort on all columns in the list of contracts and also expand any contract to view the market participant details , using an automated script.

    Scenario: Validate the Filtering and Sorting On My Tasks Items
  
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Type "BAA"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Click on Save

                            ### Navigate To My Contracts ###
        And Navigate to the My Contracts

                            ### Validate Header Values Filter and Sorting of My Task Dashboard ###
        Then Validate All the Contracts are Assigned to the Logged In User "<RowNumber>"
        And Apply Filter for Contract Type
        Then Sort with UMR in Ascending Order
        Then Sort with Unique Identifier in Descending Order
        And Refresh the MyContracts List
        And Apply Filter for UMR
        Then Validate All the Header values of My Task dashboard "<RowNumber>"
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for UMR
        And Apply Filter for Unique Identifier
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for Unique Identifier
        And Apply Filter for Broker "<RowNumber>"
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for Broker
        Then Sort with Contract Type in Descending Order
        Then Sort with Broker in Ascending Order
        And Log out from Application

        Examples:
        | RowNumber |
        | 1  |



    Scenario: Validate the Filtering and Sorting On My Teams Tasks dashboard
 
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Type "BAA"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Click on Save
        
                            ### Navigate To My Teams ###
        And Navigate to the My Teams

                            ### Validate the Filter and Sorting of the My Teams Task Items ###
        Then Validate All the Contracts are Assigned to My Group "<RowNumber>"
        When Apply Filter for Broker "<RowNumber>"
        Then Sort with Broker in Descending Order
        And Refresh the MyContracts List
        Then Sort with Broker in Ascending Order
        When Apply Filter for UMR
        Then Validate All the Header values of My Teams dashboard "<RowNumber>"
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for UMR
        When Apply Filter for Unique Identifier
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for Unique Identifier
        When Apply Filter for Broker "<RowNumber>"
        Then Sort with UMR in Ascending Order
        Then Sort with Unique Identifier in Ascending Order
        Then Sort with Effective Date in Ascending Order
        And Refresh the MyContracts List
        Then Sort with Effective Date in Descending Order
        And Refresh the MyContracts List
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |


    @ignore155399
    Scenario: Validate the Filtering and Sorting on Completed Tasks dashboard
 
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3134"
        Given Contract Type "Service Company Agreement"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
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
        Then Expand Service Company Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"

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
        When Login as Managing Agent Operator "<RowNumber>"                    

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
                            
                            ### Approve Review Task as Syndicate Lead When Assigned to Default ###
        Then Approve the Review Task with comments "<RowNumber>"
        And Log out from Application
    
                            ### Validate the Contract Status as Active ###
        When Login as Contract Creator "<RowNumber>"
        And Navigate to the Search Contracts
        And Search with Unique Identifier
        And Validate Dashboard Task Status for ACTIVE "<RowNumber>"
 
                            ### Navigate To Completed Contracts ###
        And Navigate to the Completed Contracts
 
                            ### Validate the Filter and Sorting of the Completed Task Items ###
        Then Validate All the Contracts are Completed or Not Taken Up or Expired
        Then Sort with Contract Type in Descending Order
        When Apply Filter for Unique Identifier
        And Apply Filter Task Status for Completed Contracts dashboard "<RowNumber>"
        Then Validate All the Header values of Completed dashboard "<RowNumber>"
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for Unique Identifier
        When Apply Filter for UMR
        Then Validate the Details of the Contract in Expanded View "<RowNumber>"
        And Clear the Filter for UMR
        Then Sort with UMR in Ascending Order
        Then Sort with Unique Identifier in Ascending Order
        And Refresh the MyContracts List
        When Apply Filter for Contract Type
        Then Sort with UMR in Descending Order
        Then Sort with Unique Identifier in Descending Order
        And Refresh the MyContracts List
        Then Sort with Broker in Ascending Order
        Then Sort with Contract Type in Ascending Order
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |


    @ignore155399
    Scenario: Validate the Ongoing Tasks dashboard when Contract is submitted through Broker
 
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3134"
        Given Contract Type "Service Company Agreement"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
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
        Then Expand Service Company Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"

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

                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        When Apply Filter for Unique Identifier
        Then Validate All the Header values of Ongoing Task dashboard "<RowNumber>"
        And Log out from Application

                            ### Login as Managing Agent Read Write Submit User ###
        When Login as Managing Agent Operator "<RowNumber>"                    

                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        When Apply Filter for Unique Identifier
        Then Validate All the Header values of Ongoing Task dashboard "<RowNumber>"
        And Log out from Application


        Examples:
        | RowNumber |
        | 1 |


    @ignore155399
    Scenario: Validate the Search Functionality for Search Contracts
        
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3134"
        Given Contract Type "Service Company Agreement"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write Submit User ###
        When Login as Contract Creator "<RowNumber>"
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
        Then Expand Service Company Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        Then Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"

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
        When Login as Managing Agent Operator "<RowNumber>"                    

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
        
                            ### Navigate To Search Contracts ###
        And Navigate to the Search Contracts
        
                            ### Validate the Search, Filter and Sorting of Search Contracts ###
        When Search with Unique Identifier
        And Click on Search
        Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        Then Sort with Contract Status in Ascending Order
        And Click on Clear Search
        When Search with UMR
        And Click on Search
        Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        And Click on Clear Search
        When Search with Inception Date
        And Click on Search
        Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        And Click on Clear Search
        When Search with Third Party Participant "<RowNumber>"
        When Search with Inception Date
        And Click on Search
        Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        And Click on Clear Search
        #When Search with PIN as "<RowNumber>"
        #When Search with Inception Date
        #And Click on Search
        #Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        #And Click on Clear Search
        When Search with Contract Type
        When Search with Inception Date
        And Click on Search
        Then Validate the Default Sort applied on Inception Date, Third Party Participants and Unique Identifier
        And Click on Clear Search
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |