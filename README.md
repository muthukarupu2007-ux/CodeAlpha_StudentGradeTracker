# Student Grade Tracker

## Project Description
This project is a simple Java console application that helps a teacher or administrator manage student records. It stores student details, calculates marks statistics, and assigns grades.

## Features
- Add student ID, name, and marks
- Store students in an ArrayList
- Calculate average, highest, and lowest score
- Assign grades using the required rules
- View all student records
- Search student by ID
- Validate marks between 0 and 100
- Handle invalid input without crashing

## Technologies Used
- Java
- OOP (Student class)
- ArrayList
- Scanner

## How to Compile
Open a terminal in the project folder and run:

```bash
javac -d out src/*.java
```

## How to Run
After compiling:

```bash
java -cp out StudentGradeTracker
```

## Sample Output
```text
===== STUDENT GRADE TRACKER =====
1. Add Student
2. View All Students
3. Calculate Statistics
4. Search Student
5. Exit
Choose an option: 1
Enter Student ID: S101
Enter Student Name: Alice
Enter Marks (0-100): 85
Student added successfully.
```

This project is beginner-friendly and simple enough to explain clearly in an internship presentation.
