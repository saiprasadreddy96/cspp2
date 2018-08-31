
import java.util.*;
/**.
 * Class for solution.
 */
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	/**.
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args)
	{
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		int[] a = new int[n];
		int max = -999;
		for (int i = 0; i < n; i++ ) {
			a[i] = sc.nextInt();
			if (max <= a[i])
				max = a[i];
		}
		System.out.println(max);
	}
}
