Feature: As an Automation Tester, I want to assign/re-assign any unlocked Contract Task form My Contracts or My Teams dashboard to an Individual or Team from Task Assignments page, using an automated script.


    Scenario: Verify Individual Assignment from My Contracts Dashboard
    
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
        And Click on Save
    
        And Navigate to the My Contracts
        And Navigate to Task Assignments Page validate the dashboard Radio Button set to My Task
        And Apply Unique Identifier Filter for Assign Contract
        And Select a Contract for the assignment "<RowNumber>"
        When Click on Assign Button
        And Select Assignement to Individual and Select User for the assignment "<RowNumber>"
        And Apply Unique Identifier Filter for Assign Contract
        #Then Validate the Processing Results for the transferred Contracts
        Then Navigate to the transferred Contract and Verify the Contract Assigned To "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Team Assignment from My Contracts Dashboard
    
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
        And Click on Save
    
        And Navigate to the My Contracts
        And Navigate to Task Assignments Page validate the dashboard Radio Button set to My Task
        And Apply Unique Identifier Filter for Assign Contract
        And Select a Contract for the assignment "<RowNumber>"
        When Click on Assign Button
        And Select Assignement to Team and the Select Team workqueue "<RowNumber>"
        And Apply Unique Identifier Filter for Assign Contract
        #Then Validate the Processing Results for the transferred Contracts
        Then Navigate to a transferred Contract and Verify the Contract Assigned to Team Workqueue "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Individual Assignment from My Teams Dashboard
    
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
        And Click on Save
    
        And Navigate to the My Teams
        And Navigate to Task Assignments Page validate the dashboard Radio Button set to My Teams
        And Apply Unique Identifier Filter for Assign Contract
        And Select a Contract for the assignment "<RowNumber>"
        When Click on Assign Button
        And Select Assignement to Individual and Select User for the assignment "<RowNumber>"
        And Apply Unique Identifier Filter for Assign Contract
        #Then Validate the Processing Results for the transferred Contracts
        Then Navigate to the transferred Contract and Verify the Contract Assigned To "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Team Assignment from My Teams Dashboard
    
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
        And Click on Save
    
        And Navigate to the My Teams
        And Navigate to Task Assignments Page validate the dashboard Radio Button set to My Teams
        And Apply Unique Identifier Filter for Assign Contract
        And Select a Contract for the assignment "<RowNumber>"
        When Click on Assign Button
        And Select Assignement to Team and the Select Team workqueue "<RowNumber>"
        And Apply Unique Identifier Filter for Assign Contract
        #Then Validate the Processing Results for the transferred Contracts
        Then Navigate to a transferred Contract and Verify the Contract Assigned to Team Workqueue "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Team Assignment while creating a contract
    
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
        And Click on Save

        And Navigate to Task Assignement from Actions dropdown
        And Select Assignement to Individual and Select Team workqueue "<RowNumber>"
        And Click on Save
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        Then Verify the Contract Assigned to Team Workqueue "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Individual Assignment while creating a contract
    
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
        And Click on Save

        And Navigate to Task Assignement from Actions dropdown
        And Select Assignement to Individual and the Select User for the assignment "<RowNumber>"
        And Navigate to the Search Contracts
        And Search and Navigate to Record "<RowNumber>"
        And Navigate to Associated tasks
        And Navigate to Review Task From Search Contract "<RowNumber>"
        Then Verify the Contract Assigned to "<RowNumber>"
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |



    Scenario: Verify Notifications for Individual Assignment of a Contract
    
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
        And Click on Save
    
        And Navigate to Task Assignement from Actions dropdown
        And Select Assignement to Individual and the Select User for the assignment "<RowNumber>"
        #Then Navigate to the Search Contracts
        #And Search and Navigate to the Contract
        #Then Validate Email for the Contract now Assigned To "<RowNumber>"
        And Log out from Application 
    
        And Login as Assigned To User "<RowNumber>"
        Then Validate System Notification for Contract now Assigned To
        And Log out from Application

        Examples:
        | RowNumber |
        | 1 |