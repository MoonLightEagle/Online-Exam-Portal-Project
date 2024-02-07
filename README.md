# Online-Exam-Portal-Project
Online Exam Portal Project using Spring Boot + React JS + PostrgesSQL | Online Quiz System Project in Spring Boot

Online Exam Portal using Spring Boot, React JS & MySQL
The Online Exam Portal or Online Quiz App Project using Spring Boot & React JS is a major  Full Stack application that can be used by any University to handle the Student Online Examination. Online Exam Portal is 3 3-module project i.e. Admin, Teacher & Student, where the Admin adds the multiple Grades in the application and after adding the Grades, he can add the Courses in the Grade for example in Grade (Engineering) multiple courses can be ther like Java, Python, Javascript, etc.

Admin can register the Teacher in the Grade which means, that the Teacher can handle that particular Grade's students, in a similar way he can add multiple Teachers in one Grade. After Teacher Registration, the Teacher can log in and register the Students in his Grade which he is handling.

The Teacher can schedule the exam by entering the details like Exam name, Schedule time, etc. So now when students log in, only students with that grade will be able to see the Exam Details in the upcoming exams section. On the Scheduled time only students will be able to start the exam and then students will be able to see the Questions now they can answer the questions and as soon as they submit the exam they will receive the Exam Result Mail on their registered email ID. Also, Students can see the result in the Exam Result section where they will be able to see the correct answers and the answers that they had submitted.

In the end Admin, Grade Teachers & Student will be able to see the student results.
# Technologies Used in Online Exam Portal
1. Spring Boot (REST APIS)
I have developed an Online Quiz App project using Spring Boot 3 and Spring Security 6.
2. React JS (Frontend)
3. PostrgesSQL for Database
4. Maven for project management
5. Bootstrap (Styling)

# Software Used in Online Quiz App Project
1. InteliJ 
For developing our backend, an Online Exam project using Spring Boot, I have used InteliJ IDE. But yes, we can use other IDEs like Intellij Idea, NetBeans, etc.
2. VS Code (Visual Studio Code)
For developing our frontend, an Online Quiz App project using React JS, we have used VS Code (Visual Studio Code).
3. PGAdmin 4
For efficient querying and manipulation of data, we have used PgAdmin4. 
Note: If we want to use databases other than Postgresql like MySQL or Oracle, etc. we can use that also, for that, we have to do the simple configuration.

#User Modules in Online Exam Portal Project
The project basically has three user modules:

1) ADMINISTRATOR MODULE
2) TEACHER MODULE
3) STUDENT MODULE

# Functional Modules in Online Exam Portal Project
1) User Authentication Module: 
The registration and Login system has been added so that only authenticated users (Admin, Teacher, or Student) can perform their functionalities. For authentication, we have used Spring Security 6 and JWT.

2) Teacher Module: 
Register Teacher, View Teachers, Delete Teacher.

3) Student Module: 
Register Student, View Students, Delete Student.

4) Grade Module: 
Add Grade, Update Grade, Delete Grade, View All Grades.

5) Course Module: 
Add Course, Update Course, Delete Course, View All Courses.

6) Exam Module: 
Add Exam, Update Exam, Delete Exam, View Exams

7) Exam Question & Answer Module: 
Add Exam Questions, View Questions, Delete Questions, Submit the Answers.

8) Exam Result: 
Calculate & Add Student Exam Results, View Exam Results, and Mail Student Exam Results.

The Online Exam Portal or Online Quiz App Project using Spring Boot & React JS is a major  Full Stack application that can be used by any University to handle the Student Online Examination. Online Exam Portal is 3 3-module project i.e. Admin, Teacher & Student, where the Admin adds the multiple Grades in the application and after adding the Grades, he can add the Courses in the Grade for example in Grade (Engineering) multiple courses can be ther like Java, Python, Javascript, etc.

Admin can register the Teacher in the Grade which means, that the Teacher can handle that particular Grade's students, in a similar way he can add multiple Teachers in one Grade. After Teacher Registration, the Teacher can log in and register the Students in his Grade which he is handling.

The Teacher can schedule the exam by entering the details like Exam name, Schedule time, etc. So now when students log in, only students with that grade will be able to see the Exam Details in the upcoming exams section. On the Scheduled time only students will be able to start the exam and then students will be able to see the Questions now they can answer the questions and as soon as they submit the exam they will receive the Exam Result Mail on their registered email ID. Also, Students can see the result in the Exam Result section where they will be able to see the correct answers and the answers that they had submitted.

# ROLES OF USER
ADMIN ROLE

1) The Admin will be able to log in to the System.


When we successfully run our spring boot application, it automatically creates a default Admin with the credential "demo.admin@demo.com" as the email and "123456" password. So by using this, the admin can log in to the system.

By using the below form, All users (Admin, Teacher & Student) can log into the system by selecting the user role.

2) Admin can add the Grade.
The Admin can add the Grades by using the below form.

3) Admin can view all the Grades.
The Admin can view all Grades & delete the Grade by using the delete button. Also Admin can view all the courses present in the particular Grade by clicking the corresponding Courses button as shown below.

4) Admin can update the Grade.
The Admin can update the Grade by using the below form.

5) Admin can add the Course.
The Admin can add the Courses in the Grade using the below form.
