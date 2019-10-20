import java.util.Iterator;

public class Courses implements Entity_{


	String name;
	String coursenum;
	linkedlist<Student_> studs = new linkedlist<Student_>();
	Iterator<Student_> itr = studs.pos();
	
	public Courses(String name2, String name3){
		name = name2;
		coursenum = name3;
		Student_ girnar = new Student("","","","");
		studs.add(girnar);
	}
	
	public String name() {
		return name;
	}
	
	public Iterator<Student_> studentList(){
		return itr;
	}
	public void addStud(Student_ stds) {
		studs.add(stds);
	}
	
}
