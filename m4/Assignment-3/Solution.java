import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**
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
	public static int binaryToDecimal(final String s) {
		int j = 0, sum = 0;
		for (int i = (s.length() - 1); i >= 0; i--) {
			int c = Character.getNumericValue(s.charAt(i));
			sum += (c) * Math.pow(2, j);
			j += 1;
		}
		return sum;
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int sum = binaryToDecimal(s);
			System.out.println(sum);
		}
	}

}
