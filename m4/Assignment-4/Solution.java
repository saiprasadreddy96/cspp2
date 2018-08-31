import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution
{
	/**
	 * Constructs the object.
	 */
	private Solution() {
	}

	/**
	 * { function_description }
	 *
	 * @param      s     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String reversestring(final String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			s1 = s.charAt(i) + s1;
		}
		return s1;
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reversestring(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function

}
