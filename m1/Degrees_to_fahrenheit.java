import java.util.Scanner;
public class Degrees_to_fahrenheit{
	 public static void main(String[] args) {
	 	Scanner s = new Scanner(System.in);
	 	System.out.println("Enter degrees in celsius");
	 	int c = s.nextInt();
	 	double f = (1.8) * c + 32;
	 	System.out.println("The fahrenheit equivalent of "+c+" is "+f);
		
	}
}