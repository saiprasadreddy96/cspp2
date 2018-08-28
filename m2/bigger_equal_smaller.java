import java.util.*;
class bigger_equal_smaller {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int varA = sc.nextInt();
	int varB = sc.nextInt();
	if (varA > varB) System.out.println("Bigger");
	else if (varA == varB) System.out.println("Equal");
	else System.out.println("Smaller");
	}
}