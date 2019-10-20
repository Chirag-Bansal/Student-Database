import java.util.Iterator;

public class Student implements Student_ {

	String name;
	String entryNo;
	String hostel;
	String department;
	String completedCredits;
	String cgpa;
	linkedlist<CourseGrade> courseslist = new linkedlist<CourseGrade>();
	
	
	public Student(String Name, String entryno, String Hostel, String Department){
		name = Name;
		entryNo = entryno;
		hostel = Hostel;
		department = Department;
	}
	
	public String name() {
		return name;
	}

	public String entryNo() {
		return entryNo;
	}

	public String hostel() {
		return hostel;
	}

	public String department() {
		return department;
	}

	public String completedCredits() {
		int kaudi =  0;
		Iterator<CourseGrade> itr = courseslist.pos();
		
		while(itr.hasNext()) {
		CourseGrade lol = itr.next();
		
			if(lol != null) {
				if (lol.grade == GradeInfo_.LetterGrade.A) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.Aminus) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.B) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.Bminus) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.C) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.Cminus) kaudi += 3;
				else if (lol.grade == GradeInfo_.LetterGrade.D) kaudi += 3;
			}
			}
		completedCredits = Integer.toString(kaudi);
		return completedCredits;
	}

	public String cgpa() {
		int count = 0;
		float cgpa = 0.0f;
		Iterator<CourseGrade> itr = courseslist.pos();
		
		while(itr.hasNext()) {
		CourseGrade lol = itr.next();
		
			if(lol != null && lol.grade != GradeInfo_.LetterGrade.I) {	
				int pointer = 0;
				if (lol.grade == GradeInfo_.LetterGrade.A) pointer = 10;
				else if (lol.grade == GradeInfo_.LetterGrade.Aminus) pointer = 9;
				else if (lol.grade == GradeInfo_.LetterGrade.B) pointer = 8;
				else if (lol.grade == GradeInfo_.LetterGrade.Bminus) pointer = 7;
				else if (lol.grade == GradeInfo_.LetterGrade.C) pointer = 6;
				else if (lol.grade == GradeInfo_.LetterGrade.Cminus) pointer = 5;
				else if (lol.grade == GradeInfo_.LetterGrade.D) pointer = 4;
				else pointer = 0;
				cgpa = cgpa + pointer;
				count++;
			}
		}
		int b;
		cgpa = cgpa/count;
		cgpa = cgpa*100;
		cgpa = Math.round(cgpa);
		b=(int)cgpa;
		cgpa = (b)/100.0f;
		return Float.toString(cgpa);
	}

	public Iterator<CourseGrade_> courseList() {
		Iterator iter = courseslist.pos();
		return iter;
	}

}
