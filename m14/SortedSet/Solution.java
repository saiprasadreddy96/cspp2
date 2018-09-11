import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
class Set {
    /**.
     * { var_description }
     */
    private int[] set;
    /**.
     * { item_description }
     */
    public int size, resize;
    /**.
     * { var_description }
     */
    private static final int m = 10;
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public Set(final int capacity) {
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
    public int getindex(int item) {
        int i = 0;
        while (set[i] < item && i < size) {
            i++;
        }
        return i;
    }
    public void add(int index, int item) {
        int item1 = item, temp, i = index;
        for (i = index; i < size; i++) {
            temp = set[i];
            set[i] = item1;
            item1 = temp;
        }
        set[i] = item1;
        size++;
    }
    public int get(int index) {
        return set[index];
    }
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
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
     	for (int i = 0; i < this.size; i++) {
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
 /**.
  * Class for sorted set.
  */
class SortedSet extends Set {
    /**.
     * Constructs the object.
     */
    public SortedSet(int capacity) {
        super(capacity);
    }
    public void add(int item) {
        if(!contains(item)) {
            if (size() == resize) {
                resize();
            }
            int index = getindex(item);
            super.add(index, item);
        }

    }
    public int last() {
        return get(size() - 1);
    }
    public void add(int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    public Set subSet(int fromelement, int toelement) {
        Set other = new  Set(10);
        for(int i = this.getindex(fromelement); i < this.getindex(toelement); i++) {
            other.add(this.get(i));
        }
        return other;
    }
    public Set headSet(int toelement) {
        return subSet(get(0), toelement);
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
    private static final int m = 10;
    /**.
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
        SortedSet s = new SortedSet(m);
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
                case "addAll":
                    int[] intArray = intArray(tokens[1]);
                    if (intArray.length == 1) {
                        s.add(intArray[0]);
                    } else {
                        s.add(intArray);
                    }
                    break;
                case "intersection":
                    s = new SortedSet(m);
                    SortedSet t = new SortedSet(m);
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.add(intArray);
                    System.out.println(s.intersection(t));
                    break;
                case "retainAll":
                    s = new SortedSet(m);
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    System.out.println(s.retainAll(intArray));
                    break;
                case "cartesianProduct":
                    s = new SortedSet(m);
                    t = new SortedSet(m);
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.add(intArray);
                    if (s.size() == 0 || t.size() == 0) {
                        System.out.println("null");
                    } else {
                        System.out.println(Arrays.deepToString(
                            s.cartesianProduct(t)));
                    }
                    break;
                case "last":
                    System.out.println(s.last());
                    break;
                case "subSet":
                    int[] intArray1 = intArray(tokens[1]);
                    if (intArray1[0] <= intArray1[1]) {
                       System.out.println(s.subSet(intArray1[0], intArray1[1]));
                    } else {
                        System.out.println("Invalid Arguments to Subset Exception");
                    }
                    break;
                case "headSet":
                    int[] intArray2 = intArray(tokens[1]);
                    System.out.println(s.headSet(intArray2[0]));
                    break;
                default:
                    break;
            }
        }
    }
}