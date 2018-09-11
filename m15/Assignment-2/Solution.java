import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**.
 * Class for set.
 */
class Set {
    /**.
     * { var_description }
     */
    private int[] set;
    /**.
     * { item_description }
     */
    private int size, resize;
    /**.
     * { var_description }
     */
    private static final int MAGIC = 10;
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    protected Set(final int capacity) {
        set = new int[capacity];
        size = 0;
        resize = MAGIC;
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
     * @return     { description_of_the_return_value }
     */
    public int resize1() {
        return resize;
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
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int getindex(final int item) {
        int i = 0;
        while (set[i] < item && i < size) {
            i++;
        }
        return i;
    }
    /**.
     * { function_description }
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
        int item1 = item, temp, i = index;
        for (i = index; i < size; i++) {
            temp = set[i];
            set[i] = item1;
            item1 = temp;
        }
        set[i] = item1;
        size++;
    }
    /**.
     * { function_description }
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        return set[index];
    }
    /**.
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
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
        Set is = new Set(MAGIC);
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
        Set other = new Set(MAGIC);
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
     *
     * @param      capacity  The capacity
     */
    protected SortedSet(final int capacity) {
        super(capacity);
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            if (size() == resize1()) {
                resize();
            }
            int index = getindex(item);
            super.add(index, item);
        }

    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int last() throws Exception {
        if (size() == 0) {
            throw new Exception("Set Empty Exception");
        }
        return get(size() - 1);
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
     * @param      fromelement  The fromelement
     * @param      toelement    The toelement
     *
     * @return     { description_of_the_return_value }
     */
    public Set subSet(final int fromelement, final int toelement) throws Exception {
        final int magical = 10;
        Set other = new  Set(magical);
        if (toelement < fromelement) {
            throw new Exception("Invalid​ Arguments​ to​ Subset​ Exception");
        }
        for (int i = this.getindex(fromelement);
               i < this.getindex(toelement); i++) {
            other.add(this.get(i));
        }
        return other;
    }
    /**.
     * { function_description }
     *
     * @param      toelement  The toelement
     *
     * @return     { description_of_the_return_value }
     */
    public Set headSet(final int toelement) throws Exception {
        int index1 = getindex(toelement);
        if (size() == 0 && index1 <= 0) {
            throw new Exception("Set Empty Exception");
        }
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
    private static final int MAGIC3 = 10;
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
        SortedSet s = new SortedSet(MAGIC3);
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
                    s = new SortedSet(MAGIC3);
                    SortedSet t = new SortedSet(MAGIC3);
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.add(intArray);
                    System.out.println(s.intersection(t));
                    break;
                case "retainAll":
                    s = new SortedSet(MAGIC3);
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    System.out.println(s.retainAll(intArray));
                    break;
                case "cartesianProduct":
                    s = new SortedSet(MAGIC3);
                    t = new SortedSet(MAGIC3);
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
                        try {
                            System.out.println(s.last());  
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } 
                        break;
                case "subSet":
                    int[] intArray1 = intArray(tokens[1]);
                    try {
                       System.out.println(s.subSet(intArray1[0], intArray1[1]));
                    } catch (Exception e) {
                        System.out.
                            println(e.getMessage());
                    }
                    break;
                case "headSet":
                    int[] intArray2 = intArray(tokens[1]);
                    try {
                       System.out.println(s.headSet(intArray2[0]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}


