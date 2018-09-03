import java.util.Scanner;
/**.
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**.
	 * Constructs the object.
	 */
	/**.
	 * { var_description }
	 */
	private String input;
	/**.
	 * Constructs the object.
	 *
	 * @param      input  The input
	 */
	InputValidator(final String input) {
		this.input = input;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean validateData() {
		final int m = 6;
		if (input.length() >= m) {
			return true;
		}
		return false;
	}
}
/**.
 * Class for solution.
 */
public class Solution {
	/**.
	 * { item_description }
	 */
	public static void main(final String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
        /**.
    	 * { var_description }
    	 */
        InputValidator i = new InputValidator(input);    	
        System.out.println(i.validateData());
    }
}



