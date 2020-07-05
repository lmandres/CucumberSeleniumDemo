Feature: Test Web Page

    The Web Page displays text and is visible through web browser.

    Scenario Outline: User with access browses site
        Given the user's username is "<username>"
        And the user's password is "<password>"
        When the user browses to the web page at "http://<username>:<password>@<webSiteAddress>"
        Then the web page should allow access
        And the user sees "This is a Test Page."

    Scenarios:
        | username | password | webSiteAddress |
        | admin | admin | localhost:8050 |

    Scenario Outline: User with access enters wrong password
        Given the user's username is "<username>"
        And the user's password is "<password>"
        And the user enters "<wrongPassword>" as their password
        And "<password>" does not equal "<wrongPassword>"
        When the user browses to the web page at "http://<username>:<wrongPassword>@<webSiteAddress>"
        Then the web page should ask the user to sign in
        And the user sees a blank page

    Scenarios:
        | username | password | webSiteAddress | wrongPassword |
        | admin | admin | localhost:8050 | chicken |
