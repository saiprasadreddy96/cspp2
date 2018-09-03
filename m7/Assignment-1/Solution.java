import java.util.*;
/**.
 * Class for input validator.
 */
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	/**.
	 * Constructs the object.
	 */
	String input;
	public InputValidator(String input) {
		this.input = input;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean validateData() {
		if (input.length() >= 6) 
			return true;
		return false;
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
