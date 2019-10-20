import java.io.*;
import java.util.Iterator;

public class Assignment1 {
	static linkedlist<Hostel> allHostels = new linkedlist<Hostel>();
	static linkedlist<Department> allDepartments = new linkedlist<Department>();
	static linkedlist<Courses> allCourses = new linkedlist<Courses>();
	static linkedlist<Student> allStudents = new linkedlist<Student>();
	
	static void bubbleSort(String arr[], int n, String gr[])
    {
       for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    String temp2 = gr[j];
                    gr[j] = gr[j+1];
                    gr[j+1] = temp2;
                }
    }
	static void bubbleSort(String arr[], int n)
    {
       for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
	private static GradeInfo.LetterGrade getLetterGrade(String S) {		
		if(S.equals("A"))
			return 	 GradeInfo.LetterGrade.A;
		if(S.equals("Aminus"))
				return 	 GradeInfo.LetterGrade.Aminus;
		if(S.equals("B"))
			return 	 GradeInfo.LetterGrade.B;
		if(S.equals("Bminus"))
			return 	 GradeInfo.LetterGrade.Bminus;
		if(S.equals("C"))
			return 	 GradeInfo.LetterGrade.C;
		if(S.equals("Cminus"))
			return 	 GradeInfo.LetterGrade.Cminus;
		if(S.equals("D"))
			return 	 GradeInfo.LetterGrade.D;
		if(S.equals("E"))
			return 	 GradeInfo.LetterGrade.E;
		if(S.equals("F"))
			return 	 GradeInfo.LetterGrade.F;
		else
			return 	 GradeInfo.LetterGrade.I;
	}
	
	private static void getData(String f1, String f2) throws IOException {
		
				FileReader reader1 = new FileReader(f1);
				BufferedReader bro1 = new BufferedReader(reader1);
				
				FileReader reader2 = new FileReader(f2);
				BufferedReader bro2 = new BufferedReader(reader2);
				
				Student amitgen = null;
				String sname = "";
				
				String stud_rec_file;
				while((stud_rec_file = bro1.readLine()) != null) {
					
					String[] rec = stud_rec_file.split(" ", 4);
					
					Iterator<Position_<Department>> iter4 = allDepartments.positions();
					Iterator<Position_<Hostel>> iter5 = allHostels.positions();
					Iterator<Position_<Student>> iter7 = allStudents.positions();
					
					Student amit = new Student(rec[1],rec[0],rec[3],rec[2]);
					amitgen = amit;
					sname = rec[1];
					Hostel shiva = new Hostel(rec[3]);
					Department CS = new Department(rec[2]);
					
					
					boolean hosexists = false;
					while(iter5.hasNext()) {
						Position_<Hostel> hos = iter5.next();
						Hostel h = hos.value();
						if(h.Name.equals(null)) {
							break;
						}
						else if(shiva.Name.equals(h.Name)) {
							hosexists = true;
						}
					}
					
					
					
					boolean deptexists = false;
					
					while(iter4.hasNext()) {
						Position_<Department> hos = iter4.next();
						Department h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(CS.Name.equals(h.Name)) {
							deptexists = true;
						}
					}
					
					boolean studexists = false;
					
					while(iter7.hasNext()) {
						Position_<Student> hos = iter7.next();
						Student h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(amit.name.equals(h.name)) {
							studexists = true;
						}
					}
					
					if(!hosexists) {
						shiva.addStud(amit);
						allHostels.add(shiva);
					}
					if(hosexists) {
						Iterator<Position_<Hostel>> iter69 = allHostels.positions();
						Position_<Hostel> hos = iter69.next();
						Hostel h = hos.value();
						if(shiva.Name.equals(h.name())) {
							h.addStud(amitgen);
						}
					}
					
					if(!studexists) {
						allStudents.add(amit);
					}
					
					if(!deptexists) {
						CS.addStud(amit);
						allDepartments.add(CS);
					}
					if(deptexists) {
						Iterator<Position_<Department>> iter69 = allDepartments.positions();
						Position_<Department> hos = iter69.next();
						Department h = hos.value();
						if(CS.Name.equals(h.name())) {
							h.addStud(amitgen);
						}
					}					
					
					
				}
				bro1.close();
				String course_file;
				while((course_file = bro2.readLine()) != null) {

					String[] cour = course_file.split(" ", 4);
					
					Courses COL = new Courses(cour[1], cour[3]);
					Iterator<Position_<Courses>> iter6 = allCourses.positions();

					boolean corexists = false;
					
					while(iter6.hasNext()) {
						Position_<Courses> hos = iter6.next();
						Courses h = hos.value();
						if(hos.equals(null)) {
							break;
						}
						else if(COL.name.equals(h.name())) {
							corexists = true;
						}
					}
					if(!corexists) {
						COL.addStud(amitgen);
						allCourses.add(COL);
					}
					if(corexists) {
						Iterator<Position_<Courses>> iter69 = allCourses.positions();
						Position_<Courses> hos = iter69.next();
						Courses h = hos.value();
						if(COL.name.equals(h.name())) {
							h.addStud(amitgen);
						}
					}
					
					GradeInfo.LetterGrade A = getLetterGrade(cour[2]);
					CourseGrade G = new CourseGrade(cour[3],cour[1],A);
					Iterator<Position_<Student>> iter9 = allStudents.positions();
					while(iter9.hasNext()) {
						Position_<Student> hos = iter9.next();
						if(hos.value().entryNo.equals(cour[0])) {
							Student h = hos.value();
							h.courseslist.add(G);
						}
					}
					
				}
				bro2.close();
			}
	
	public static void AnswerQueries(String f3) throws IOException{
		FileReader reader1 = new FileReader(f3);
		BufferedReader bro1 = new BufferedReader(reader1);
		
		String Query;
		String finalout = "";
		while((Query = bro1.readLine()) != null) {
			String answer = "";
			String[] querry = Query.split(" ", 3);
				if(querry[0].equals("INFO")) {
					String entrynum = querry[1];
					Iterator<Position_<Student>> iter7 = allStudents.positions();
					while(iter7.hasNext()) {
						Position_<Student> hos = iter7.next();
						Student h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(h.entryNo.equals(entrynum) || h.name.equals(entrynum)) {

							answer = h.entryNo() + " " + h.name() + " " + h.department() + " " + h.hostel()+ " " +h.cgpa()+ " " ;
							Iterator<CourseGrade> itr = h.courseslist.pos();	
							String[] cnum = null;
							String[] gr = null;
							int i = 0;
							while(itr.hasNext()) {
							CourseGrade lol = itr.next();
								if(lol != null) {
										i++;
								}
							}
							cnum = new String[i];
							gr = new String[i];
							Iterator<CourseGrade> itr2 = h.courseslist.pos();
							int j = 0;
							while(itr2.hasNext()) {
								CourseGrade lol = itr2.next();
									if(lol != null) {
											cnum[j] = lol.coursenum;
											gr[j] = lol.grade + "";
											j++;
									}
								}
							Iterator<CourseGrade> itr3 = h.courseslist.pos();
							int k = 0;
							bubbleSort(cnum,i,gr);
							while(itr3.hasNext()) {
								CourseGrade lol = itr3.next();
									if(lol != null) {
										answer = answer + cnum[k] + " " + gr[k] + " ";
										k++;
									}
								}
							}
					}
					
				}
				else if(querry[0].equals("SHARE")) {
					String entity = querry[2];
					String same = querry[1];
					Iterator<Position_<Student>> iter7 = allStudents.positions();
					int i = 0;
					String[] ent;
					while(iter7.hasNext()) {
						Position_<Student> hos = iter7.next();
						Student h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(h.hostel.equals(entity) && !h.entryNo.equals(same)) {
							i++;
						}
						else if(h.department.equals(entity) && !h.entryNo.equals(same)) {
							i++;
						}
						Iterator<CourseGrade> itr = h.courseslist.pos();
						while(itr.hasNext()) {
							CourseGrade lol = itr.next();
								if(lol != null && lol.coursenum.equals(entity) && !h.entryNo.equals(same)) {
									i++;
								}
						}
					}
					
					Iterator<Position_<Student>> iter8 = allStudents.positions();
					ent = new String[i];
					int j = 0;
					while(iter8.hasNext()) {
						Position_<Student> hos = iter8.next();
						Student h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(h.hostel.equals(entity) && !h.entryNo.equals(same)) {
							ent[j] = h.entryNo();
							j++;
						}
						else if(h.department.equals(entity) && !h.entryNo.equals(same)) {
							ent[j] = h.entryNo();
							j++;
						}
						Iterator<CourseGrade> itr = h.courseslist.pos();
						while(itr.hasNext()) {
							CourseGrade lol = itr.next();
								if(lol != null && lol.coursenum.equals(entity) && !h.entryNo.equals(same)) {
									ent[j] = h.entryNo();
									j++;
								}
						}
					}
					bubbleSort(ent,i);
					Iterator<Position_<Student>> iter9 = allStudents.positions();
					int k = 0;
					while(iter9.hasNext()) {
						Position_<Student> hos = iter9.next();
						Student h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(h.hostel.equals(entity) && !h.entryNo.equals(same)) {
							answer = answer + ent[k] + " ";
							k++;
						}
						else if(h.department.equals(entity) && !h.entryNo.equals(same)) {
							answer = answer + ent[k] + " ";
							k++;
						}
						Iterator<CourseGrade> itr = h.courseslist.pos();
						while(itr.hasNext()) {
							CourseGrade lol = itr.next();
								if(lol != null && lol.coursenum.equals(entity) && !h.entryNo.equals(same)) {
									answer = answer + ent[k] + " ";
									k++;
								}
						}
					}
					
				}
				else if(querry[0].equals("COURSETITLE")) {
					String entity = querry[1];
					Iterator<Position_<Courses>> iter7 = allCourses.positions();
					while(iter7.hasNext()) {
						Position_<Courses> hos = iter7.next();
						Courses h = hos.value();
						if(h.equals(null)) {
							break;
						}
						else if(h.name.equals(entity)){
							answer = answer + h.coursenum;
						}
					}
					
				}
				finalout = answer + "\n" + finalout;
		}	
		bro1.close();
		System.out.println(finalout);
	}
	public static void main(String args[]) throws IOException
	{
		Hostel girnar = new Hostel("");
		allHostels.add(girnar);
		Courses emptyvala = new Courses(" ","");
		allCourses.add(emptyvala);
		Student emptyvalastud = new Student(" ","","","");
		allStudents.add(emptyvalastud);
		Department emptyvaladept = new Department("");
		allDepartments.add(emptyvaladept);

		getData(args[0],args[1]);					
		AnswerQueries(args[2]);
	}
}
