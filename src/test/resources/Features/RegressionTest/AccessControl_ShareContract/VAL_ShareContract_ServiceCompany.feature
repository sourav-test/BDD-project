Feature: As an Automation Tester, I want to verify the Share Contract funtionality for Service Company,using an automated script.

    @ignore155399
    Scenario: Validate Share Contract funtionality for Service Company Added as a Capacity Seeker
      
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3134"
        Given Contract Status "Active"
                            
                            ### Login As Lloyds DA Read Write Submit User ###
        Given Login as Lloyds User "<RowNumber>"
                        
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        And Click on Share visibility of contract
        And Click on Save
        And Log out from Application

                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract on Ongoing Task Dashboard

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

        And Click on Manage Share Gear Icon
        When Select User Group to Share "<RowNumber>"
        And Log out from Application
    
                            ### Login As Child Group User For Selected Service Company ###
        And Login as Additional Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract on Ongoing Task Dashboard
        
                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        And Log out from Application

                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        
        And Click on Manage Share Gear Icon
        And Remove the User Group "<RowNumber>"
        And Log out from Application

                            ### Login As Child Group User For Selected Service Company ###
        And Login as Additional Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract Not present on Ongoing Task Dashboard
        And Log out from Application


        Examples:
        | RowNumber |
        | 18 |


    Scenario: Validate Share Contract funtionality for Service Company Added as a Capacity Lead
                            
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active"
                            
                            ### Login As Lloyds DA Read Write Submit User ###
        Given Login as Lloyds User "<RowNumber>"
                        
                            ### Agreement Template ###
        And Select Agreement Template
        And Select Organization "<RowNumber>"
        And Select CSN "<RowNumber>"
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Service Company under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        Then Upload Copy of Signed Contract
        And Click on Share visibility of contract
        And Click on Save
        And Log out from Application
   
                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract on Ongoing Task Dashboard

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"

        And Click on Manage Share Gear Icon
        When Select User Group to Share "<RowNumber>"
        And Log out from Application
    
                            ### Login As Child Group User For Selected Service Company ###
        And Login as Additional Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract on Ongoing Task Dashboard
        
                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        And Log out from Application

                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        
        And Click on Manage Share Gear Icon
        And Remove the User Group "<RowNumber>"
        And Log out from Application

                            ### Login As Child Group User For Selected Service Company ###
        And Login as Additional Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract Not present on Ongoing Task Dashboard
        And Log out from Application
 
        
        Examples:
        | RowNumber |
        | 17 |



    Scenario: Remove participant after Draft Contract Share and validate the Ongoing Task for removed participant
                            
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active"
                            
                            ### Login As Broker Read Write User ###
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

                            ### Capacity Details Accordion ###
        And Expand Capacity Section Section for Individual Section
        Then Add Syndicate under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Add Service Company under Capacity Details for Lead Individual Section "<RowNumber>"
        Then Enter Confirmation Date For Capacity for Individual Section "<RowNumber>"

        And Click Continue

                            ### Non Schedule Data ###
        Then Enter Order Heron Percenatge
        And Click Continue

                            ### Actions ###
        #Then Upload Copy of Signed Contract
        And Click on Share visibility of contract
        And Click on Save
        And Log out from Application
   
                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract on Ongoing Task Dashboard
        And Log out from Application

                            ### Login As Broker Read Write User ###
        Given Login as Contract Creator "<RowNumber>"

                            ### Navigate to Search Contracts and Review Task ###
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        
        And I Click on Begin
        And Navigate Back to Non Schedule from Actions
        And Navigate back to Section Details from Non Schedule
        Then Remove a Participant from the Endorsement
        And Click on Save
        And Log out from Application

                            ### Login As Managerial Group User For Selected Service Company ###
        And Login as Default Shared User "<RowNumber>"
        
                            ### Navigate to Ongoing Task ###
        And Navigate to Ongoing Tasks Dashboard
        Then Validate the Shared Contract Not present on Ongoing Task Dashboard
        And Log out from Application
 
        
        Examples:
        | RowNumber |
        | 17 |