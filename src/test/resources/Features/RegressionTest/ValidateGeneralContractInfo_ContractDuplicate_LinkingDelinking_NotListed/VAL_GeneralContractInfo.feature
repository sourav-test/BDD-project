Feature:  As an Automation Tester, I will be able to enter a Valid UMR No. while creating a contract, using an automated scripts and should be able see the UMR number, Contract ID and Work Status on the contract.

    Scenario: Validate the error for Invalid UMR and when UMR characters 2-5 does not match broker CSN

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
        When Enter Invalid UMR Number
        Then Validate the invalid UMR error message
        Then Edit the UMR and Validate the absence of UMR does not match with Broker error
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate Additional General Contract Information Fields
    
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
        And I Enter the Agreement Number "<RowNumber>"
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
        Then Select Any Time Zone "<RowNumber>"
        Then Select Both Days Inclusive Time Period "<RowNumber>"
        Then Select Sub Contract "<RowNumber>"
        And Select the Tripartite Agreement as Yes
        Then Select Lloyds Direct Reporting
        And Select the Primary Currency "<RowNumber>"
        
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |



    Scenario: Validate the Period To Date for Multi Year Contract
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113M"
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
        
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate the Confirmation Date field on General Contract Information after entering the same on Section Details
    
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Navigate back to Contract Leads from Section Details
        And Navigate back to Broker Details from Contract Leads
        And Navigate back to General Contract Information from Broker Details
        Then Validate the Confirmation Date field

        And Click on Save
        And Log out from Application

         Examples:
        | RowNumber |
        | 10 |