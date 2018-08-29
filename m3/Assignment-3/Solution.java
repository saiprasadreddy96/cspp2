import java.util.Scanner;
/*Do not modify this main function.
	*/
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
 * @param      n1    The n 1
 * @param      n2    The n 2
 *
 * @return     { description_of_the_return_value }
 */
    public static int gcd(final int n1, final int n2) {
        int temp, m1 = n1 ,m2 = n2;
        while (m2 > 0) {
            temp = m1;
            m1 = m2;
            m2 = temp % m2;
        }
        return m1;
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1 ,n2);
        System.out.println(gcd);
    }
    /*
	Need to write the gcd function and print the output.
	*/
}
