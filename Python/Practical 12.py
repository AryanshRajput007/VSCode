import os


class Student:

    def __init__(self, StudentID, StudentName, StudentAge, StudentGrade):
        self.StudentID = StudentID
        self.StudentName = StudentName
        self.StudentGrade = StudentGrade
        self.StudentAge = StudentAge
        self.students = []

    def add_student(self, student):
        self.students.append(student)

    def display_info(self):
        print(
            f"Student ID: {self.StudentID}\nStudent Name: {self.StudentName}\nStudent Age: {self.StudentAge}\nStudent Grade: {self.StudentGrade}"
        )


class Teacher:

    def __init__(self, TeacherID, TeacherName, TeacherAge, TeacherSubject):
        self.TeacherID = TeacherID
        self.TeacherName = TeacherName
        self.TeacherAge = TeacherAge
        self.TeacherSubject = TeacherSubject
        self.teachers = []

    def add_teacher(self, teacher):
        self.teachers.append(teacher)

    def display_info(self):
        print(
            f"Teacher ID: {self.TeacherID}\nTeacher Name: {self.TeacherName}\nTeacher Age: {self.TeacherAge}\nTeacher Subject: {self.TeacherSubject}"
        )


class Course:

    def __init__(self, CourseID, CourseName, CourseTeacher, CourseStudents):
        self.CourseID = CourseID
        self.CourseName = CourseName
        self.CourseTeacher = CourseTeacher
        self.CourseStudents = CourseStudents
        self.courses = []

    def add_course(self, course):
        self.courses.append(course)

    def display_info(self):
        print(
            f"Course ID: {self.CourseID}\nCourse Name: {self.CourseName}\nCourse Teacher: {self.CourseTeacher}\nCourse Students: {self.CourseStudents}"
        )


students = []
teachers = []
courses = []

while True:
    os.system('cls' if os.name == 'nt' else 'clear')
    print(
        "Press 1 to add a student\nPress 2 to add a teacher\nPress 3 to add a course\nPress 4 to display all students\nPress 5 to display all teachers\nPress 6 to display all courses\nPress 7 to exit"
    )
    choice = int(input("Enter your choice: "))

    if choice == 1:
        StudentID = int(input("Enter the student ID: "))
        StudentName = input("Enter the student name: ")
        StudentAge = int(input("Enter the student age: "))
        StudentGrade = int(input("Enter the student grade: "))
        student_obj = Student(StudentID, StudentName, StudentAge, StudentGrade)
        students.append(student_obj)
        student_obj.display_info()

    elif choice == 2:
        TeacherID = int(input("Enter the teacher ID: "))
        TeacherName = input("Enter the teacher name: ")
        TeacherAge = int(input("Enter the teacher age: "))
        TeacherSubject = input("Enter the teacher subject: ")
        teacher_obj = Teacher(TeacherID, TeacherName, TeacherAge, TeacherSubject)
        teachers.append(teacher_obj)
        teacher_obj.display_info()

    elif choice == 3:
        CourseID = int(input("Enter the course ID: "))
        CourseName = input("Enter the course name: ")
        CourseTeacher = input("Enter the course teacher: ")
        CourseStudents = input("Enter the course students: ")
        course_obj = Course(CourseID, CourseName, CourseTeacher, CourseStudents)
        courses.append(course_obj)
        course_obj.display_info()

    elif choice == 4:
        for student in students:
            student.display_info()

    elif choice == 5:
        for teacher in teachers:
            teacher.display_info()

    elif choice == 6:
        for course in courses:
            course.display_info()

    elif choice == 7:
        print("Exiting...")
        exit()

    else:
        print("Invalid choice. Please try again.")

    input("Press Enter to continue...")