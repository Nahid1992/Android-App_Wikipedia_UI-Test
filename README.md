# Android-App_Wikipedia_UI-Test

In this project a GUI test was done on a popular Android App (Wikipedia) using Android Studio 2.2.2 and a framework Espreso Test.

Listed below is the name of tests that was created for the GUI testing using Espresso:

### 1.	Test_History: 
One assertion was made in this test class. First, the application visits a page and checks the “History” if it was added or not.
### 2.	Test_JumpingSection: 
One assertion was made in this test class. First, the application visits a page and from the page’s option button, it clicks a section. Then, it is checked if it really jumps to the section or not.
### 3.	Test_Language: 
Two assertions were made in this test class. The application visits a page and changes the language of the page. Then it checks it the language is changed or not. Also, by going back to the default (English) language it also checks the changes. 
### 4.	Test_ManagingReadingList: 
Three assertions were made in this test class. By visiting a page, the application saves the page and checks it was successfully added in the “My lists” or not. Moreover, the added name of the page is renamed and checked again for the change. Then again, by deleting the added page, it checks for an empty list in the “My lists” section. 
### 5.	Test_Search: 
One assertion was made in this test class. Visits a page using “Search” option from the application. By clicking the option button from the page, it checks if the title matches with the name of the searched page.
### 6.	Test_SearchHistory: 
One assertion was made in this test class. The application visits a page and goes back to the home page. Now, by clicking the “Search” the application shows the recent searches. Therefore, it checks if it shows the visited page’s name as the recent search. 
### 7.	Test_SearchInArticle: 
One assertion was made in this test class. The application visits a page. A keyword was searched in the article by clicking the “Search” option from the page. Then using the web-view option the assertion was done.
### 8.	Test_Settings: 
One assertion was made in this test class. The application visits the Settings option and checks if it really visited the settings page or not. 
### 9.	Test_SettingsImageToggle: 
Two assertions were made in this test class. By visiting the Settings, the image toggle button is pressed where it makes all the images invisible. Then the application visits a page for instance “Google’ and checks if it has the title google image or not. Then again, the image show setting option is changed back and checked again if the google page’s title image is visible or not. 
### 10.	Test_SignIn: 
Two assertions were made in this test class. By clicking more option and visiting “Log In” option, a fake username and password is imported and clicked log in. As there is no account with this fake id, the application does not login also it stays in that state. An assertion was made for this state. Moreover, “Join Wikipedia” was clicked and checked if it goes to the “Create Account” page or not. 
### 11.	Test_TabDelete: 
One assertion was made in this test class. After visiting a page and going back to the home page of the application, a new button beside the “more option” button appears (“Show Tab” button). Visiting the “Show Tab” page, it checks if the previously visited page exists or not. 
### 12.	Test_TabTest: 
One assertion was made in this test class. Like previous test, it visits a page and after going to the “Show Tab” page, the existing tab was closed using the cross button. After this, it goes back to the home page of the application as there are no tabs remaining. An assertion was made if it really goes back to the home page or not if there are no tabs left after closing them. 
