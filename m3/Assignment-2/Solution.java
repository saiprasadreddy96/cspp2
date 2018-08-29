
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int j, count = 0, a = 7, b = 1, c = 10;
        for (int i = 1; i <= n; i++) {
        	j = i;
        	while (j >= b) {
        		if (j % c == a) {
        			count++;
                }
        		j = j / c;

        	}
        }
        System.out.print(count);
    }
}

