package classpart;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student();
		studentLee.studentName = "이순신";
		studentLee.address = "서울시 서초구 서초동" ;
		
		Student studentLim = new Student();
		studentLim.studentName = "이건한";
		studentLim.studentID = 101;
		studentLim.address = "경기도 시흥시 거모동";
		
		studentLim.showStudentInfor();
		studentLee.showStudentInfor();
	
		System.out.println(studentLee);
		System.out.println(studentLim);
	}

}
