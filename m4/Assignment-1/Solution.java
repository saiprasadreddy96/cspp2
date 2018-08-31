
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
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
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		int[] a = new int[n];
		final int m = -999;
		int max = m;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (max <= a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
}



