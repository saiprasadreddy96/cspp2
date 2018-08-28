import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /*
    Do not modify this main function.
    */
    /**
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { constructor }
         */
    }
    /**.
     * class of the program
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**.
     * { function_description }
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { power of the variable }
     */
    public static long power(final int base, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}