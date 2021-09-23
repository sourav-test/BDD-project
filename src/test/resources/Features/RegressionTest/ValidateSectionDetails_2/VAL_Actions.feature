Feature: As an Automation Tester, I want to validate the Document Upload Popup when user is not selecting Tag option, using an automated script.

    
    Scenario: Validate the error when user is not seleting tag on Document Upload Modal
    
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"
        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Validate the error when user is not selecting tag on Document Upload modal

        And Click on Save
        And Log out from Application

        Examples:
        | RowNumber |
        | 2 |