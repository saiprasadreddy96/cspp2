import java.util.Scanner;
public class Average {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = s.nextInt();
		int a[] = new int[n];
		float sum = 0;
		System.out.println("Enter elements one by one");
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
			sum += a[i];
		}
		float f = ( sum / n);
		System.out.println("The average of is"+f);
	}
}