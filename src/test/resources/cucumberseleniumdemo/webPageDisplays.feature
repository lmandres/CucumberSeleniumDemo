Feature: Test Web Page

    The Web Page displays text and is visible through web browser.

    Scenario Outline: User with access browses site
        Given the user's username is "<username>"
        And the user's password is "<password>"
        When the user browses to the web page at "<webSiteAddress>"
        And the user is asked to log on
        And the user enters their username
        And the user enters their password
        And the user clicks the accept button
        Then the web page should allow access
        And the user sees "This is a Test Page."

    Scenarios:
        | username | password | webSiteAddress |
        | admin | admin | http://localhost:8050 |

    Scenario Outline: User with access enters wrong password
        Given the user's username is "<username>"
        And the user's password is "<password>"
        When the user browses to the web page at "<webSiteAddress>"
        And the user is asked to log on
        And the user enters their username 
        And the user enters "<wrongPassword>" as their password
        And the user entry does not equal their password
        And the user clicks the accept button
        Then the web page should deny access
        And the user sees the login box again

    Scenarios:
        | username | password | webSiteAddress | wrongPassword |
        | admin | admin | http://localhost:8050 | chicken |
