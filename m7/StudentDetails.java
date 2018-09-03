import java.util.Scanner;
class StudentDetails {
	String name, rollno;
	float m1, m2, m3;
	private StudentDetails(String name, String rollno, float m1, float m2, float m3) {
		this.name = name;
		this.rollno = rollno;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	public void calculategpa() {
		System.out.println("The gpa is "+(Math.floor((m1 + m2 + m3)/ 3.0 * 10) / 10));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDetails[] sd = new StudentDetails[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter student name,rollno,m1,m2,m3 seperated by space");
			sd[i] = new StudentDetails(sc.next(), sc.next(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
			sd[i].calculategpa();
		}

	}
}