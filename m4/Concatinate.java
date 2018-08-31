import java.util.Scanner;
public class Concatinate {
	public static void main(String[] args) {
		String str;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter string name");
		str = s.nextLine();
		str = "Hello" + " " + str + "!";
		System.out.println(str);
	}
}