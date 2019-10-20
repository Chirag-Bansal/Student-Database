#Student Database

This is the main file where there is public static void main () and this is where it starts executing.
I created 4 linked lists of all hostels, all departments, all students and all courses.
My motivation for creating an all student file was that it would be very complicated and inefficient to access student via any other linked list, we would have to traverse over their linked list and in every node traverse the student linked list.
#1 : bubblesort()
It takes two string arrays and the length of their array and then sorts both of them lexicographically.
#2 : bubblesort()
It takes one string array and the length of the array and sorts it lexicographically.
#3 : getLetterGrade()
As when we read the file we will get the grade as a string, this function takes that string and returns the lettergrade corresponding to the string given.
#3 : getData(String f1, String f2)
get Data functions it takes two strings which will be the file addresses of the student records file and the courses record file
It makes a file reader of file1 and reads it line by line. 
While the line read is not null it splits the line into 4 different strings.
It creates a new student, hostel and department using the given string.
It creates 4 iterators of student, hostel, courses and department
To check whether the hostel exists or not by using the iterator of the hostel. If a hostel does not exist it adds the hostel to the list allHostels(Before adding the hostel it adds the student to the hostel as well). If the hostel exists it creates an iterator of student and checks if the student exists or not. If the student exists it exits the loop and if it does not it adds the student to the hostel by getting the hostel through the iterator.
Similarly, it does it for the department.
As I am maintaining a list of students as well, I also iterate over the student list to check if the student exists or not, if it doesn't I update the student as well.
Then the file reader reads the courses file and checks the courses in a similar way as hostels and updates the list.
It also updates the student list to the course grade.
#4 AnswerQueries(String f3):
This creates an object of file reader using the string f3. It then creates a buffer reader using the file reader object and reads the buffer reader line by line till the reader becomes null. It then splits the line into 4 parts. It checks the first part to figure out the keyword.
If the keyword is INFO it iterates over the student list to find the student and then prints all its data.
In case of SHARE, it iterates over the list to find the common entity and if it matches it prints it lexicographic order, which uses the bubble sort function explained earlier.
In case of COURSETITLE it iterates over the allcourses list to print the title of the course.


Courses.java
Every class of courses has a string name, a string course num, a linked list containing the students registered for the course and an iterator that iterates over the student linked list.
#1: Courses(): It is a constructor of the class and it takes two parameters(both string) and assigns them to the name and the course num of the object of courses. It then initialises the linked list containing students by adding an empty object
#2 name(): Returns the name of the course
#3 studentList(): Returns the iterator of the student list contained in the course
#4 addstud():It takes a student as the parameter and adds it to the student list 


Hostel.java
Every class of hostel has a string name, a linked list containing the students registered for the course and an iterator that iterates over the student linked list.
#1: Hostel(): It is a constructor of the class and it takes one parameter(string) and assigns it to the name of the object of courses. It then initialises the linked list containing students by adding an empty object
#2 name(): Returns the name of the hostel
#3 studentList(): Returns the iterator of the student list contained in the hostel
#4 addstud(): It takes a student as the parameter and adds it to the student list 


Department.java
Every class of department has a string name, a linked list containing the students registered for the course and an iterator that iterates over the student linked list.
#1: Department(): It is a constructor of the class and it takes one parameter(string) and assigns it to the name of the object of courses. It then initialises the linked list containing students by adding an empty object
#2 name(): Returns the name of the department
#3 studentList(): Returns the iterator of the student list contained in the department
#4 addstud(): It takes a student as the parameter and adds it to the student list 


Position.java
It contains an object and the position of next object
#1: position(): This is a constructor of the class which takes an object as the parameter and adds makes a position
#2: value(): This returns the value of the position
#3 after(): Return the position after the current position


CouseGrade.java
It contains a title, coursenum and a lettergrade 
#1:CourseGrade(String tit,String num,GradeInfo.LetterGrade gr)
This is a constructor of the class which takes two strings and sets them 
#2:coursetitle(): This returns the course title
#3 coursenum(): Returns the course number of the course
#4 grade(): Returns the grade of the course grade


GradeInfo.java
It has a Lettergrade called grade
#1: getGrade() : It returns the lettergrade grade stored in the object of this class
#2: GradeInfo(): It takes in a LetterGrade as a parameter and then sets the grade of the gradeInfo object
#3: gradepoint(GradeInfo_.LetterGrade grade):
It returns the pointer corresponding to the LetterGrade entered as the parameter


LinkedListIterator.java
It has a position<T> curr
 #1 LinkedListIterator(position<T> head)
It takes the head as a parameter and if it is null it will set curr to head. If not it will construct curr as a new position<T> and then set curr.next to head.next 
#2 hasNext():
It returns a boolean value depending on whether the Iterator has a element after the current element
#3 next():
It returns the object curr and then set curr to its next position


LinkedListIterator2.java
It has a position<T> curr
 #1 LinkedListIterator(position<T> head)
It takes the head as a parameter and if it is null it will set curr to head. If not it will construct curr as a new position<T> and then set curr.next to head.next 
#2 hasNext():
It returns a boolean value depending on whether the Iterator has an element after the current element
#3 Next():
It returns the object curr and then set curr to its next position
#4 next():
It returns the value of the object curr and then set curr to its next position




Linkedlist.java
It contains a position<T> head and an int count
#1 add( T e):
It creates a new position called naya using the object e passed in the parameter and then it checks if the head is null or not. If it is null that means that the list is empty and given that head is the first element of the linked list it sets head to be naya.
If the head is not null it makes an object iter and assigns it to head. Then it changes iter to its next element till the next of iter is null. After that case,  it sets naya.next to null and iter.next to naya. Thus adding the position at the end of the linked list.
Also increments count by 1
#2 Iterator<Position_<T>>  positions() : 
It returns an Iterator of the linked list which iterates over Position_<T>
#3 Iterator<T>  pos() : 
It returns an Iterator of the linked list which iterates over Position_<T>
#4 count() : 
Returns the count variable


Student.java
It has string name, string entryNo, string hostel, string department, string completedCredits, string cgpa and a linkedlist courselist which iterates over the courses of the student
#1 Student(String Name, String entryno, String Hostel, String Department)
It creates a new student and sets Name to name, entryno to entryNo, Hostel to hostel and department to Department
#2 name():
It returns the name of the student
#3 entryNo():
It returns the entry number of the student
#4 hostel():
It returns the hostel of the student
#5 department():
It returns the department of the student
#6 completedCredits(): It creates an iterator over the list of courses and while the iterator has a next element, it checks the lettergrade of each of the course and then increases the credits accordingly.
#7 cgpa():It creates an iterator over the list of courses and while the iterator has a next element, it checks the lettergrade of each of the course and then increases the cgpa accordingly based on the pointers given. It then rounds off the cgpa to two decimal places.
#8 courseList(): It returns an iterator of the courses in the student
