
public class CourseGrade implements CourseGrade_ {

	String title;
	String coursenum;
	public GradeInfo.LetterGrade grade;
	
	CourseGrade(String tit,String num,GradeInfo.LetterGrade gr){
		title = tit;
		coursenum = num;
		grade = gr;
	}
	
	public String coursetitle() {
		return title;
	}

	public String coursenum() {
		return coursenum;
	}

	public GradeInfo_ grade() {
		GradeInfo g = new GradeInfo(grade);
		return g;
	}

}
