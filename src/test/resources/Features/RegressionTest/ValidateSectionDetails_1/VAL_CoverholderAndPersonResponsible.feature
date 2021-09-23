Feature: As an Automation Tester, I want to verify and add adequate details for the accordions available on Individual Section Details page and also want verify Copy Sections functionality while creating a contract , using an automated script.

    Scenario: Verify Coverholder and Person Responsible Accordion Common Section for Coverholder Contracts 
  
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
        Then Add Trading Name for Common Section "<RowNumber>"
        Then Delete the Trading Name "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        And Expand Person Responsible Tab for Common Section
        Then Add Person Responsible Operation and Control for Common Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Common Section
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    Scenario: Verify Coverholder and Person Responsible Accordion Individual Section for Coverholder Contracts 
  
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
        Then Add Trading Name for Individual Section "<RowNumber>"
        Then Delete the Trading Name "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        And Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Individual Section
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    @ignore155399
    Scenario: Verify Coverholder and Person Responsible Accordion Common Section for Service Company Contracts
  
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
        Then Add Trading Name for Common Section "<RowNumber>"
        Then Delete the Trading Name "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###
        And Expand Person Responsible Tab for Common Section
        Then Add Person Responsible Operation and Control for Common Section "<RowNumber>"
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    @ignore155399
    Scenario: Verify Coverholder and Person Responsible Accordion Individual Section for Service Company Contracts
  
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

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Coverholder/Service Company Accordion ###
        Then Expand Service Company Details Tab for Individual Section 
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"
        Then Add Trading Name for Individual Section "<RowNumber>"
        Then Delete the Trading Name "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###        
        And Expand Person Responsible Tab for Individual Section
        Then Add Person Responsible Operation and Control for Individual Section "<RowNumber>"
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    Scenario: Verify Person Responsible linked to Coverholder Accordion for Common Section
  
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
    
                            ### Person(s) Responsible for Operation and Control Accordion ###     
        Then Expand Person Responsible Tab for Common Section
        And Select Each Coverholder or Service Company for Common Section

                            ### Coverholder/Service Company Accordion ###    
        Then Add Person Responsible Linked Operation and Control for Common Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Common Section
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    Scenario: Verify Person Responsible linked to Coverholder Accordion for Individual Section
  
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
        And Delete Existing SectionID
        Then Add Section, Validate the SectionID and Add the description "<RowNumber>"
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        Then Expand Person Responsible Tab for Individual Section
        And Select Each Coverholder or Service Company for Individual Section

                            ### Coverholder/Service Company Accordion ###     
        Then Add Person Responsible Linked Operation and Control for Individual Section "<RowNumber>"
        Then Perform Copy Names To Bind Insurances for Individual Section
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    @ignore155399
    Scenario: Verify Person Responsible linked to Service Company Accordion for Common Section
  
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
        Then Verify Section Accordian and Add Market Participant for Common Section "<RowNumber>"
    
                            ### Person(s) Responsible for Operation and Control Accordion ###     
        Then Expand Person Responsible Tab for Common Section
        And Select Each Coverholder or Service Company for Common Section

                            ### Coverholder/Service Company Accordion ###  
        Then Add Person Responsible Linked Operation and Control for Common Section "<RowNumber>"
        Then Delete Names from Person Responsible for Operation and Control    
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |


    @ignore155399
    Scenario: Verify Person Responsible linked to Service Company Accordion for Individual Section
  
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
    
                            ### Individual Section Details ###        
        When Navigate to Individual Section Details
        And Delete Existing SectionID
        Then Add Section, Validate the SectionID and Add the description "<RowNumber>"
        Then Expand Service Company Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        Then Expand Person Responsible Tab for Individual Section
        And Select Each Coverholder or Service Company for Individual Section

                            ### Coverholder/Service Company Accordion ###
        Then Add Person Responsible Linked Operation and Control for Individual Section "<RowNumber>"
        Then Delete Names from Person Responsible for Operation and Control
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Validate Person Responsible Accordion when each coverholder is checked for Individual Section
  
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
        And Delete Existing SectionID
        Then Add Section, Validate the SectionID and Add the description "<RowNumber>"
        Then Expand Coverholder Details Tab for Individual Section
        Then Verify Section Accordian and Add Market Participant for Individual Section "<RowNumber>"

                            ### Person(s) Responsible for Operation and Control Accordion ###    
        Then Expand Person Responsible Tab for Individual Section
        And Select Each Coverholder or Service Company for Individual Section

        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details                    

        Then Validate the Person Responsible accordion when Enter for each coverholder is checked 
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify the field level validation Individual Section Details
  
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

                            ### Gross Premium Income Limit Accordion ###
        And Expand Gross Premium Income Limit Individual Section
        Then Verify the Notifiable Percentage field validation

                            ### Period Of Insurances Bound Accordion ###
        Then Expand Period Of Insurances Bound for Individual Section
        Then Verify the Period Of Insurances Bound field validation

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Verify the Signed Line and Written Line field validation "<RowNumber>"
        
    
        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 12 |