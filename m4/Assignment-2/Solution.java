import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	/**.
	 * Constructs the object.
	 */
	static Scanner sc = new Scanner(System.in);
	static int[][] d = new int[3][3];
	private Solution() {
	}
	/**.
	 * Constructs the object.
	 *
	 * @param      a     { parameter_description }
	 */
	public static int[][] readinput(final int r, final int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				d[i][j] = sc.nextInt();
			}
		}
		return d;
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		int r1, c1, r2, c2, j;
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		int[][] a = new int[r1][c1];
		a = readinput(r1, c1);
		System.out.println(d[0]);
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		int[][] b = new int[r2][c2];
		b = readinput(r2, c2);
		if ( r1 == r2 && r2 == c2 ) {
			for (int i = 0; i < r1; i++) {
				for (j = 0; j < c1 -1; j++) {
					int sum = a[i][j] + b[i][j];
					System.out.print(sum + " ");;
				}
				System.out.println(a[i][j] + b[i][j]);
			}
		}
		else
			System.out.println("not possible");
		
	}
}