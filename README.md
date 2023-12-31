# customer-project-voltorb
customer-project-voltorb created by GitHub Classroom

## Link to Final report markdown file
- https://github.com/comp129/customer-project-voltorb/blob/111a214145211748b8f270d338961c49682c9d7b/finalreport_readme.md

**SPRINT 1:**

1. Opening page: Create new account
- First pane will ask for username
- Create Password
- Re-write password
2. Opening page: Returning user option
- Ask for Username
- Ask for Password
3. Task Board: Create overall task board/list (flow layout Gframe)
- Display empty to do list
- Search bar with filters
4. Task: Create a new task
- Create GRects to simulate a task bar
- Have pressable button to create task 
5. Task: Assign Due date
- Small panel that users can hover over to choose date
- Text box for user to input date into
6. Task: Assign Group/Project Name
- Character Limit
7. Task: Assign Priority levels when creating task
- Have Critical, important, medium, low options
8. Task: Description Text box
- Text box to input a description of task
9. Task: Due date calendar
- Small panel to represent calendar
- Arrows to adjust what month is showing 

***- Estimated total of stories completed***

- 7 stores, 44 points

***- What was completed***

1. Opening page: Returning user option
- Ask for Username
- Ask for Password
2. Task Board: Create overall task board/list (flow layout Gframe)
- Display empty to do list
- Search bar with filters
3. Task: Create a new task
- Create GRects to simulate a task bar
- Have pressable button to create task 
4. Task: Assign Due date
- Small panel that users can hover over to choose date
- Text box for user to input date into
5. Task: Assign Group/Project Name
- Character Limit
6. Task: Assign Priority levels when creating task
- Have High, medium, low options
7. Task: Description Text box
- Text box to input a description of task

***- Total of stories completed***
- 7 stories, 44 points

**- List of features**

- We had an opening page for the user to input their username and password
- We laid out the general structures of the main task board using JFrame
- There was a create new task button which allowed the user to input new task information such as Title, category, due date, priority, and description.

**SPRINT 2:**

10. Task: Date Picker
- Display month 
- Have clickable boxes
11. Task: Create Filter Search Bar
- JTextBox
- Enter “or” or “and” commands
12. Task:  Create List of Tasks view
- Title and due date of tasks
13. Task: Create checkbox option
- Can mark for deleting
14. Task: Display name of user on top of screen
- Take username and have it displayed 
15. Task: Create new pane for creating a task
- Display blank screen 
16. Task: upload garbage can and pencil pics
- Images that will represent delete and edit
17. Task: Create log out
- Button that allows you to go to preview screen

***- Estimated total of stories completed***
- 7 stories, 29 points

***- What was completed***
14. Task: Display name of user on top of screen
- Take username and have it displayed 
16. Task: upload garbage can and pencil pics
- Images that will represent delete and edit
17. Task: Create log out
- Button that allows you to go to preview screen
18. Task board: Make the layout nicer with a color theme 
- Dark & Light mode
19. Task Board: Tab Buttons
- Task Board and Calendar

***- Total of stories completed***

- 5 stories, 12 points

**- List of features**

- Based on the username, it would be displayed on the top left of the task board.
- The pressing on the buttons for create, edit, and delete were able to be detected.
- We decided on a general color schemes for the application for both light and dark mode.

**SPRINT 3:**

20. Date picker
- Display Month
- Clickable boxes
21. Icons corresponds to light and dark mode
22. Creating Task Button
23. Opening page: Check login based on saved username and password
24. Task Board: Make the layout nicer with color theme (Dark Mode)
25. Take the user name input and display it at the top
26. Add tasks to JSON file

***- Estimated total of stories completed***

- 7 stories, 44 points

**- What was completed**

20. Date picker
- Display Month
- Clickable boxes
21. Icons corresponds to light and dark mode
22. Creating Task Button
23. Opening page: Check login based on saved username and password
24. Task Board: Make the layout nicer with color theme (Dark Mode)
25. Take the user name input and display it at the top

***- Total of stories completed***

- 6 stories, 31 points

**- List of features**

- We were able to incorporate the date picker when establishing the due date of the task. 
- We have the UI correspond to the light and dark mode button.
- We were able to link the create new task button to the pane where the user can input the task information

**SPRINT 4:**

26. Dropdown box also affected by dark mode
27. Create new user button
28. Color theme button should change along with the theme
29. Save task details into JSON file
30. Clear task inputs every time the task page closes
31. Display task details on the right side of the page
32. List out the task titles on the main page
33. Delete button functionalities

***- Estimated total of stories completed***

- 8 stories, 38 points

**- What was completed**
26. Dropdown box also affected by dark mode
27. Create new user button
28. Color theme button should change along with the theme
29. Save task details into JSON file
30. Clear task inputs every time the task page closes

***- Total of stories completed***

- 5 stories, 20 points

**- List of features**

- We were able to add a dropdown box that would also correspond to the light and dark mode theme.
- To follow through the syncing light theme, we had changed all the buttons and features on the Task board.
- The tasks that were created are added into a JSON file.
- Once a task has been saved, the task inputs are cleared and ready for the next entry.

**SPRINT 5:**

26. Display task details on the right side of the page
27. Dark mode for new task page
28. Display titles of task on main page
29. Add tasks to JSON file
30. Edit button functionalities
31. Delete button functionalities

***- Estimated total of stories completed***

- 6 stories, 33 points

***- What was completed***

26. Display task details on the right side of the page
27. dark mode for new task page
28. display titles of task on main page
29. add tasks to JSON file
31. delete button functionalities

***Total of stories completed***

- 5 stories, 28 points

**- List of features**

- We were able to link the titles of the tasks to then print the overview of the task description on the right side.
- We were able to incorporate the delete function.

***How to download project***

1. Download project from Git repo

***Languages and Libracies needed***

- Download jdatepicker-1.3.4.jar (For date picker to work in newTaskPage.java file)
- Download json-simple-1.1.1.jar (For JSON files to work in newTaskPage.java file)
- go to Preferences -> Java build path -> Libraries -> Classpath -> add external jre -> press on .jar file, then apply
- java-library'
- Latest version of 'eclipse'
- 'org.openjfx.javafxplugin' version '0.0.9'
- api 'org.apache.commons:commons-math3:3.6.1'
- implementation 'com.google.guava:guava:28.2-jre'
- implementation files('lib/acm.jar')
- testImplementation('org.junit.jupiter:junit-jupiter:5.6.0')
- testImplementation 'org.mockito:mockito-core:2.+'
- testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: "5.${junit5MinorVersion}"
- testImplementation group: 'org.junit.platform', name: 'junit-platform-launcher', version: "1.${junit5MinorVersion}"
