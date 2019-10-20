import java.util.Iterator;

public class Hostel implements Entity_ {
	
	String Name;
	linkedlist<Student_> studs = new linkedlist<Student_>();
	Iterator<Student_> itr = studs.pos();
	
	public Hostel(String name){
		Name = name;
		Student_ girnar = new Student("","","","");
		studs.add(girnar);
	}
	
	public String name() {
		return Name;
	}
	
	public Iterator<Student_> studentList(){
		return itr;
	}
	
	public void addStud(Student_ stds) {
		studs.add(stds);
	}
	

}
