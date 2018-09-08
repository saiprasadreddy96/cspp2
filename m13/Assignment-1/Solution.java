import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for set.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size, resize;
    private static int m = 10;
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public Set(int capacity) {
    	set = new int[capacity];
    	size = 0;
    	resize = m;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
    	return size;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
    	for (int i = 0; i < size; i++) {
    		if (set[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
    	if (size == 0) {
    		return "{}";
    	}
    	String str = "{";
    	int i = 0;
    	for (i = 0; i < size - 1; i++) {
    		str += set[i] + ", ";
    	}
    	str += set[i] + "}";
    	return str;
     }
     /**.
      * { function_description }
      *
      * @param      item  The item
      */
     public void add(final int item) {
     	if (!contains(item)) {
     		if (size == resize) {
     			resize();
     		}
     		set[size++] = item;
     	}
     }
     /**.
      * { function_description }
      */
     public void resize() {
     	resize = 2 * size;
     	int[] set1 = new int[resize];
     	System.arraycopy(set, 0, set1, 0, set.length);
     	set = set1;
     }
     /**.
      * { function_description }
      *
      * @param      items  The items
      */
     public void add(final int[] items) {
     	for (int i = 0; i < items.length; i++) {
     		add(items[i]);
     	} 
     }
     /**.
      * { function_description }
      *
      * @param      other  The other
      *
      * @return     { description_of_the_return_value }
      */
     public Set intersection(final Set other) {
     	Set is = new Set(m);
     	for (int i = 0; i < size; i++) {
     		if (other.contains(this.set[i])) {
     			is.add(this.set[i]);
     		}
     	}
     	return is;
     }
     /**.
      * { function_description }
      *
      * @param      other  The other
      *
      * @return     { description_of_the_return_value }
      */
     public int[][] cartesianProduct(final Set other) {
     	int r = this.size * other.size, c = 2, k = 0;
     	int[][] a = new int[r][c];
     	for (int i = 0; i <this.size; i++) {
     		for (int j = 0; j < other.size; j++) {
     			a[k][0] = this.set[i];
     			a[k][1] = other.set[j];
     			k++;
     		}
     	}
     	return a;
     }
     /**.
      * { function_description }
      *
      * @param      items  The items
      *
      * @return     { description_of_the_return_value }
      */
     public Set retainAll(final int[] items) {
     	Set other = new Set(m);
     	other.add(items);
     	return this.intersection(other);
     }
 }
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    /**.
     * Constructs the object.
     */
    private static int m =10;
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    /**.
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set(m);
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set(m);
                Set t = new Set(m);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set(m);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set(m);
                t = new Set(m);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                if (s.size() == 0 || t.size() == 0) {
                	System.out.println("null");
                } else 
                {
                	System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                }
                break;
                default:
                break;
            }
        }
    }
}
