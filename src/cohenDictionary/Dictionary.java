package cohenDictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    
    ArrayList<Definition> dictionary = new ArrayList();
    
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
		Boolean contain = false;
		for(int i = 0; i <= dictionary.size(); i++)
		{
			if(dictionary.get(i).getWord().equals(askLower))
			{
				contain = true;
				break;
			}
		}	
		return contain;
	}
	
	
	public String getDefinition(String ask)
	{
		String askLower = ask.toUpperCase();
		String definition = null;
		for(int i = 0; i <= dictionary.size(); i++)
		{
			if(dictionary.get(i).getWord().equals(askLower))
			{
				definition = dictionary.get(i).getDefinition();
				break;
			}
		}
		return definition;
	}	
	
	public void arrayLoad(Scanner wordsIn)
	{
		  while(wordsIn.hasNext())
	        {
	           String line = wordsIn.nextLine();
			   int space = line.indexOf(" ");
	           String[] parts = {line.substring(0, space),line.substring(space)};
	           Definition D = new Definition(parts[0],parts[1]);
	           dictionary.add(D);   
	        }
	}
}
