
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static String reversestring(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			s1 = s.charAt(i) + s1;
		}
		return s1;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse = reversestring(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function

}
