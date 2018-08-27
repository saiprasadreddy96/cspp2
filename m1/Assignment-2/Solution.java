import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		areaOfTriangle(base, height);
	}
	public static void areaOfTriangle(int base, int height) {
		System.out.println(base*height*0.5);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
}