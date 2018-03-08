package cohen.dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    
    //ArrayList<Definition> dictionary = new ArrayList<Definition>();
	private HashMap<String, String> map = new HashMap<String, String>();
	//constructor loads the file dictionary.txt and forms and arraylist
	public Dictionary(String fname) throws FileNotFoundException
	{
		FileReader fin = new FileReader(fname);
		//try with resources
//		try(Scanner wordsIn = new Scanner(fin))
//		{
//			
//		};
		Scanner wordsIn = new Scanner(fin);
		arrayLoad(wordsIn);
	}
	
	public boolean contains(String ask)
	{
		String askLower = ask.toUpperCase();		
		if(map.containsKey(askLower))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	
	public String getDefinition(String ask)
	{
		String askLower = ask.toUpperCase();
		String definition = null;
		if(contains(askLower))
		{
			definition = map.get(askLower);
		}
		return definition;
	}	
	
	public void arrayLoad(Scanner wordsIn)
	{
		  while(wordsIn.hasNext())
	        {		  
			  String line = wordsIn.nextLine();
			  String part1, part2;
			  int space = line.indexOf(" ");
			  
			  if(space != -1)
			  {
				part1 = line.substring(0, space);     	   		
	        	   	part2 = line.substring(part1.length());
			  }
			  else
			  {
				part1 = line;
				part2 = null;
			  }
	        	           	   
	        	  map.put(part1, part2);
	            
	        }
	}
}
