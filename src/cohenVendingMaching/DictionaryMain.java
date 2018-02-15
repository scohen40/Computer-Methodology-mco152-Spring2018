package cohenVendingMaching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryMain {
	public static void main(String[] args) throws FileNotFoundException
	{
		Dictionary D = new Dictionary("/Users/macbook/Desktop/dictionary.txt");
		
		D.toString();
//		String w = D.dictionary.get(0).getWord();
//		System.out.println(w);
	}
}
