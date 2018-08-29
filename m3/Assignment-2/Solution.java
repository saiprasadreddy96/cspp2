import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
/**.
 * { function_description }
 */
     private Solution() {
     }
/**.
 * { function_description }
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int j, count = 0, a = 10, b = 7;
        for (int i = 1; i <= n; i++) {
            j = i;
            while (j >= 1) {
                if (j % a == b) {
                    count++;
                }
        		j = j / a;

        	}
        }
        System.out.print(count);
    }
}







