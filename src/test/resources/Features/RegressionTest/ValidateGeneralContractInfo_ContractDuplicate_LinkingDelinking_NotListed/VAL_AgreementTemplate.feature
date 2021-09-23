Feature:  As an Automation Tester, I will be able to search and select the Contract template using searchable drop-down, using automated script and will be displayed a warning message if all mandatory fields are not filled.


    Scenario: Create Contract Without Selecting User Group
    
                            ### Pre Requisite Steps ###
        Given Agreement Template "LMA3113"
        Given Contract Status "Active" 
                            
                            ### Login As Broker Read Write Submit User ###
        Given Login as Contract Creator "<RowNumber>"

                            ### Agreement Template ###
        And Select Agreement Template
        And Click Continue
        Then Validate the User Group error message
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |


    Scenario: Validate user is able to delete User Group after adding it
    
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
        Then Validate user is able to delete User Group
        And Log out from Application

        Examples:
        | RowNumber |
        | 10 |