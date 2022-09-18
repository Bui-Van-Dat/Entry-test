package datastructures.algorithms;

import java.util.Scanner;

public class LongestWord {
	
	//Method to find longest word in a string 
	public static String findLongestWord(String string) {
		String longestWord = null;
		int max = 0;
		
		//List of words in string
		String[] listWord = string.split("[,;\\s]+");
		
		//Browse listWord to find longest word
		for(String words : listWord) {
			if(max < words.length()) {
				max = words.length();
				longestWord = words;
			}
		}
		return longestWord;
	}

	public static void main(String[] args) {
		System.out.printf("Enter a string         : ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.printf("\nString just entered    : %s \n", string);
		System.out.printf("\nLongest word in string : %s", findLongestWord(string));
	}
}
