// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution
{/*
	Do not modify this main function.
	*/
	/**.
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**.
	 * { function_description }
	 *
	 * @param      s     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static int binaryToDecimal(String s) {
		int j = 0, sum = 0;
		for (int i = (s.length() - 1); i >= 0; i--) {
			sum += (Character.getNumericValue(s.charAt(i)) * Math.pow(2, j));
			j += 1;
		}
		return sum;
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s=sc.next();
			int sum = binaryToDecimal(s);
			//String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(sum);
		}
	}

}
