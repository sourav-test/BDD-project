Feature: As an Automation Tester, I want to verify the Contract Lead Question and its related validations using an automated script

    
    Scenario: Validate The Syndicate Wildcard Search
    
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
        Then I enter Syndicate search criteria as "<RowNumber>" and validate the results

        And Click on Save
        And Log out from Application

        Examples:
        |RowNumber |
        | 11 |


    Scenario: Validate user is able to search Syndicate using Syndicate Number and Managing Agent

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113A"
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
        Then Select Syndicate using Syndicate Number "<RowNumber>"
        Then Select Syndicate using Managing Agent "<RowNumber>"

        And Click on Save
        And Log out from Application

        Examples:
        |RowNumber |
        | 10 |



    Scenario: Validate the Contract Lead Question for LMA3113A
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113A"
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
        Then Select a Syndicate "<RowNumber>"
        Then Select a Service Company "<RowNumber>"
        Then Select a Non-Llyods Insurer "<RowNumber>"
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    @ignore155399
    Scenario: Validate the Contract Lead Question for LMA3134
    
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
        Then Select a Syndicate "<RowNumber>"
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate the Contract Lead Question for LMA3113AT-B
    
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
        Then Select a Syndicate "<RowNumber>"
        Then Select Syndicate For Brussels "<RowNumber>"
        Then Select a Service Company "<RowNumber>"
        Then Select a Non-Llyods Insurer "<RowNumber>"
        
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |

        

    Scenario: Validate Non-Lloyd's insurer can't be the only Contract Lead
    
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
        Then Select a Non-Llyods Insurer "<RowNumber>"
        Then Validate the Non-Lloyd's insurer being the only lead
        Then Select a Syndicate "<RowNumber>"
        Then Validate the absence of Non-Lloyd's insurer being the only lead
        And Click Continue
    
                            ### Individual Section Details ###
        When Navigate to Individual Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Non-Lloyd's Insurer under Capacity Details for Lead Individual Section "<RowNumber>"
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review
    
        And Navigate Back to Sections Details
    
        And Validate the NonLloyds Insurer only Contract Lead Error
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate Service Company is not present for LBS0001A
    
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
        Then Verify Service Company and Non Lloyds Insurer is not present
        And Click Continue

                            ### Common Section Details ###
        When Navigate to Common Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Common Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Common Section

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Individual Section
    
        And Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate Service Company and Non Lloyds Insurer is not present for LBS0067A
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LBS0067A"
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
        Then Verify Service Company and Non Lloyds Insurer is not present
        And Click Continue

                            ### Common Section Details ###
        When Navigate to Common Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Common Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Common Section

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Individual Section
    
        And Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 10 |


    @ignore155399
    Scenario: Validate Service Company and Non Lloyds Insurer is not present for LMA3134
 
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
        Then Verify Service Company and Non Lloyds Insurer is not present
        And Click Continue

                            ### Common Section Details ###
        When Navigate to Common Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Common Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Common Section

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Verify Service Company and Non Lloyds Insurer is not present for Individual Section
    
        And Click on Save
        And Log out from Application
  
        Examples:
        | RowNumber |
        | 10 |



    Scenario: Validate user is not able to select Duplicate Syndicate and Non Lloyds Insurer

                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113A"
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
        Then Select a Syndicate "<RowNumber>"
        Then Validate that user is not able to select Duplicate Syndicate "<RowNumber>"
        Then Select a Non-Llyods Insurer "<RowNumber>"
        Then Validate that user is not able to select Duplicate Non-Llyods Insurer "<RowNumber>"
        And Click on Save
        And Log out from Application

        Examples:
        |RowNumber |
        | 10 |