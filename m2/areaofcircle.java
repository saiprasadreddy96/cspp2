import java.util.Scanner;
class areaofcircle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		System.out.println(area(r));		
		}
	static double area(double r) {
		return pi() * r * r;
	}
	static double pi() {
		return 3.14;
	}
}