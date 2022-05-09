## Project Title: 
- Task It (Voltorb x Leavenworth)
## Link to Sprint Markdown file
- https://github.com/comp129/customer-project-voltorb/blob/2f29018bf41adccf2f199b84623ae21d9d1b7379/README.md
## Team Members (specify the role and responsibility of each member)
- Laila (Scrum Master): Kept track of what tasks were completed each sprint and assigned tasks to team members
- Eustolio (Development Team): Completed tasks that were given from the Scrum Master, focused on the program and UI such as the JSON file
- Ben (Development Team):Completed tasks that were given from the Scrum Master, focused on the program and UI such as the JDatePicker
- Michelle (Product Owner): Communicated with the Customer and team members, maintained focus on customer’s desired features
## Project Objectives
- Value delivered to your client:
	- Login Page: Create new users, Check for correct user information
	- Task Board Page: Light/Dark Mode, Listed out tasks, Create Task ability, and delete task ability
	- Create Task Page: User is able to input Title, Category, Due Date, Priority Level, and Description
## Project Design
- Team goals
	- Create a simple UI layout with dark and light mode
	- Apply similar color theme to all pages
	- Display all saved tasks in a list and being able to delete them
	- Apply JDatePicker to the create task page
- User stories completed:
 
| --- | Expected | Actual |
| --- | -------- | ------ |
| Sprint 1 | 7 for 44 | 7 for 44 |
| Sprint 2 | 7 for 29 | 4 for 12 |
| Sprint 3 | 7 for 44 | 6 for 31 |
| Sprint 4 | 8 for 38 | 5 for 20 |
| Sprint 5 | 6 for 33 | 5 for 28 |
 
## Implementation Details
- Programming Languages Used: Java
- Libraries or Tools Used: JDatePicker, JSON, Mockito
- Challenges and Solutions: Storing task data in json files
## Testing
- Testing Plan and Strategies (revised/updated)
	- Testing plan: Test the crucial functions that are needed for the program: switching panels, placing GImages, reading JSON files
	- Strategies: JUnit testing was used to test whether panels are successfully switching, and if the JSON files are readable. Mockito was used to create a mock mouseevent that would click on where the GImage should be, and check if the GImage is actually on the panel. 
- Test Cases
  - Test 1: Check that program is switching between “Main page” and “Some pane”
  - Test 2: Check that on “Some pane”, the item that’s being clicked on is a GImage. This is to check that there exists a GImage that we have positioned. 
  - Test 3: Check if it’s possible to read from the task json file
## Project Highlights (Retrospective)
- Parts of the actual software you are proud of
  - The login/sign up is a part of something we are proud of because the software is meant for anyone to use and will remember each user’s account and tasks. Second, being able to implement the JDatePicker when the user creates a task. The JDatePicker shows future months and years which was an essential addition to the due date of a task. Lastly, saving the new task to a JSON file and displaying it to the home page. The main purpose of the project is for the user to view an entire list of all of their tasks and being able to delete them. 
- Things you guys did as a team that you think worked really well
  - We were able to follow our task board and be honest about tasks that we were comfortable with. As a team, we communicated well through our Discord and met up when group mates needed help. In addition, we also used pair programming which made tasks easier and more efficient to complete on time before the deadline. 
- Troubles that you ended up solving or finding. 
  - Troubles that we had throughout the project was displaying the task and working with JSON files. We needed a way to save details of the tasks that belonged to different users. However, the details had to be saved even if the program wasn't open, so an arraylist wouldn’t work. JSON files could work because we would be able to access and edit them whether the program is open or not. Once we started working on the JSON file, we struggled a bit with the format of JSON arrays and JSON objects. We wanted to be able to save multiple users with multiple tasks that had different details. We decided best that all the details would be saved in a JSON object which holds a JSON array of JSON object. Each user will be their own JSON object while their tasks are saved in a JSON array. Each task will be their own JSON object with each key representing different details: title, priority, due date, category, and description. 
## Things To Be Improved (Also Retrospective)
- Parts of the software that you would improve: 
	- Edit button functionality: We were not able to incorporate the edit button for the user to make changes to a task
	- Highlight tasks when clicked on so that the user is able to detect which task is currently being looked at in the list. 
	- Filter: Sorting the task using the drop down based on the Date Created, Closest to Due Date, and Priority Level. This would have been a feature for the user to prioritize certain tasks. 
- Parts of your teamwork/process that you would improve on in the future
	- Incorporate more core hours where we were all able to focus on the project and be able to contact each other with any questions. This would be especially beneficial when having to combine all of our individual contributions.
	- Schedule more meetings throughout the week of each Sprint instead of meeting a couple days before the Retrospective. This would allow us to gain feedback from each other and apply more pair programming. 
## Lessons Learned
- Advice you have for future COMP 129 students
	- Make sure to ask your customer lots of questions during the demos, and take notice of the initial actions without any context.
	- Try Pair Programming since it can lead to better communication and more efficiency in completing tasks. 
	- Focus on your customer’s wants and needs, not your own. As an engineer, you should not make additional features that the customer did not ask for. The purpose of project is to make the customer happy with the product. 
