package classpart;

public class Student {
	
	int studentID;
	String studentName;
	int grade;
	String address;
	
	/* public Student(int id, String name) {
		studentID = id;
		studentName = name;
	}  */
	
	public void showStudentInfor() {
		System.out.println(studentName + "," + address);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String name) {
		studentName = name;
	}
	
	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.studentName = "이건민";
		studentLee.studentID = 100;
		studentLee.address = "서울시 영등포구 여의도동";
		
		Student studentLim = new Student();
		studentLim.studentName = "이건한";
		studentLim.studentID = 101;
		studentLim.address = "경기도 시흥시 거모동";
	
		studentLee.showStudentInfor();
		studentLim.showStudentInfor();
	}
}

