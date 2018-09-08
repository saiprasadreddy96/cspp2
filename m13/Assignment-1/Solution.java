import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size, resize;
    public Set(int capacity) {
    	set = new int[capacity];
    	size = 0;
    	resize = 10;
    }

    public int size() {
    	return size;
    }
    public boolean contains(int item) {
    	for (int i = 0; i < size; i++) {
    		if (set[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
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
     public void add(int item) {
     	if (!contains(item)) {
     		if (size == resize) {
     			resize();
     		}
     		set[size++] = item;
     	}
     }
     public void resize() {
     	resize = 2 * size;
     	int[] set1 = new int[resize];
     	System.arraycopy(set, 0, set1, 0, set.length);
     	set = set1;
     }
     public void add(int[] items) {
     	for (int i = 0; i < items.length; i++) {
     		add(items[i]);
     	} 
     }
     public Set intersection(Set other) {
     	Set is = new Set(10);
     	for (int i = 0; i < size; i++) {
     		if (other.contains(this.set[i])) {
     			is.add(this.set[i]);
     		}
     	}
     	return is;
     }
     public int[][] cartesianProduct(Set other) {
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
     public Set retainAll(int[] items) {
     	return null;
     }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
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
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set(10);
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
                s = new Set(10);
                Set t = new Set(10);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set(10);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set(10);
                t = new Set(10);
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
