import java.util.Scanner;
public class SumOfNNumbers {
	public static void main(String[] args) {
		int sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = s.nextInt();
		for (int i = 1;i <= n; i++) {
			sum += i;
		}
		System.out.println("The sum of "+n+"natural numbers is "+sum);
	}
}