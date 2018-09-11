import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**
 * Exception for signaling invalid subset selection errors.
 */
class Set {

    /**
     * This constant is used to create an array
     * with the initial capacity.
     */
    public static final int TEN = 10;

    /**
     * holds the elemtns in this Set array.
     */
    private int[] set;

    /**
     * indicates the number of elememnts of this set.
     */
    private int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    Set() {
        set = new int[TEN];
        size = 0;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int max() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] > max) {
                max = set[i];
            }
        }
        return max;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        int max;
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            max = max();
            if (size == 0 || item > max) {
                set[size++] = item;
            } else {
            for (int i = 0; i < size; i++) {
                    if (set[i] > item) {
                        for (int j = size; j > i; j--) {
                            set[j] = set[j - 1];
                        }
                        set[i] = item;
                        break;
                    }
                }
                size++;
            }
        }
    }
    /**
     * resize the set by double, when it is full.
     */
    public void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }
    /**
     * Finds the intersection of the two sets.
     * @param  other as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public Set intersection(final Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    /**
     * retains all the elements from the set.
     * @param  arr is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * This finds out the cartesian product of two sets.
     * @param  other as a Set 2.
     * @return the cartesian product in the form of 2D array.
     */
    public int[][] cartesianProduct(final Set other) {
        int[][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }

    /**
     * This methods finds out the number of elements in the set.
     * @return the integer value indicates the number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method finds out the elements
     * at a particular index.
     * @param  index to return the element at this index.
     * @return the element at this index, otherwise return -1.
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * String version of the object.
     * @return string.
     */
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /**
     * returns true if this set contains the item.
     * @param  item as a parameter to be checked in the set.
     * @return      true if the item present in the set,
     *                   otherwise false.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
/**.
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      str     { parameter_description }
     */
    InvalidSubsetSelectionException(final String str) {
        super(str);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      str     { parameter_description }
     */
    SetEmptyException(final String str) {
        super(str);
    }
}
/**
 * Class for sortedset.
 */
class Sortedset extends Set {
    /**
     * holds the elemtns in this Set array.
     */
    Sortedset() {
    }
    /**
     * add all elements of the array to this Set.
     * @param arr as an arr to be added in this set,
     *            if the element is not present in this set.
     */
    public void addAll(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size() == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return get(size() - 1);
        }
    }
    /**
     * { function_description }.
     *
     * @param      fromele                          The fromele
     * @param      toele                            The toele
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] subSet(final int fromele, final int toele)
        throws InvalidSubsetSelectionException {
        if (fromele > toele) {
            throw new InvalidSubsetSelectionException(
            "Invalid Arguments to Subset Exception");
        } else {
        int count = 0, temp = 0;
        for (int i = 0; i < size(); i++) {
            if (get(i) >= fromele && get(i) < toele) {
                count++;
            }

        }
        int[] arr = new int[count];
        for (int j = 0; j < size(); j++) {
            if (get(j) >= fromele && get(j) < toele) {
                arr[temp] = get(j);
                temp++;
            }
        }
        return arr;
        }
    }
    /**
     * { function_description }.
     *
     * @param      ele                The ele
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int[] headSet(final int ele) throws SetEmptyException {
        int count = 0, temp = 0;
        for (int i = 0; i < size(); i++) {
            if (get(i) < ele) {
                count++;
            }
        }
        int[] arr = new int[count];
        for (int i = 0; i < size(); i++) {
            if (get(i) < ele) {
                arr[temp] = get(i);
                temp++;
            }
        }
        if (arr.length == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return arr;
    }

}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * { item_description }.
         */
    }
    /**
     * { function_description }.
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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // code to read the test cases input file
        Sortedset s = new Sortedset();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
                case "print":
                System.out.println(s.toString());
                break;
                case "addAll":
                String[] arr = tokens[1].split(",");
                int[] arr1 = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    arr1[i] = Integer.parseInt(arr[i]);
                }
                s.addAll(arr1);
                break;
                case "last":
                try {
                System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "subSet":
                try {
                String[] token = tokens[1].split(",");
                int[] res = s.subSet(Integer.parseInt(token[0]),
                    Integer.parseInt(token[1]));
                if (res.length == 0) {
                    System.out.println("{}");
                    break;
                } else {
                String s1 = "{";
                for (int i = 0; i < res.length - 1; i++) {
                    s1 += res[i] + ", ";
                }
                s1 += res[res.length - 1] + "}";
                System.out.println(s1);
                }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "headSet":
                try {
                int[] res1 = s.headSet(Integer.parseInt(tokens[1]));
                String s1 = "{";
                for (int i = 0; i < res1.length - 1; i++) {
                    s1 += res1[i] + ", ";
                }
                s1 += res1[res1.length - 1] + "}";
                System.out.println(s1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "intersection":
                // int[] intArray = intArray(tokens[1]);
                s = new Sortedset();
                Sortedset t = new Sortedset();
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Sortedset();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                default:
            }
        }
    }
}


