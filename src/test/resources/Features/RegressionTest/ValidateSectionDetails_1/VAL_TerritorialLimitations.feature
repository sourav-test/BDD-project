Feature: As an Automation Tester, I want to verify the Territorial Limitations accordion for Individual Section, Common Section and its related validations using an automated script

    
    Scenario: Verify the Coverholder/Service Company entered does not have approval for Risk Location Country Individual Section while Create Contract
    
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
        And Select the Primary Currency "<RowNumber>"
        Then Validate UMR number, Contract ID and Work Status
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
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

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Add and Copy Territorial Limitations for Individual Section "<RowNumber>"
        Then Validate the CH or SC enetered not approved for Risk Location

        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the error message for Risk Location approval with CH or SC
        Then Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify the Coverholder entered does not have approval for Risk Location country Common Section while Create Contract
    
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
        And Select the Primary Currency "<RowNumber>"
        Then Validate UMR number, Contract ID and Work Status
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
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

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Common Section
        Then Add and Copy Territorial Limitations for Common Section "<RowNumber>"
        Then Apply Territorial Limitations

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Validate the CH or SC enetered not approved for Risk Location
        
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the error message for Risk Location approval with CH or SC
        Then Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 12 |



    Scenario: Verify the Service Company entered does not have approval for Risk Location country Common Section while Create Contract
    
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
        And Select the Primary Currency "<RowNumber>"
        Then Validate UMR number, Contract ID and Work Status
        And I Enter Period From Date "<RowNumber>"
        Then Validate the Period To Date as per Template "<RowNumber>"
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

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Common Section
        Then Add and Copy Territorial Limitations for Common Section "<RowNumber>"
        Then Apply Territorial Limitations

                            ### Individual Section Details ###    
        When Navigate to Individual Section Details

                            ### Territorial Limitations Accordion ###
        Then Expand Territorial Limitations Section for Individual Section
        Then Validate the CH or SC enetered not approved for Risk Location
        
        And Click Continue
    
                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        Then Click on Submit For Review

        And Navigate Back to Sections Details

        Then Validate the error message for Risk Location approval with CH or SC
        Then Click on Save
        And Log out from Application


        Examples:
        | RowNumber |
        | 12 |