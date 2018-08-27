import java.util.Scanner;
public class Quotient_remainder
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("Quotient is "+a/b+" and Remainder is "+(a%b));
	}
}

