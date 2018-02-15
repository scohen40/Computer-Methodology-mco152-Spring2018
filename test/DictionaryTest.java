package cohenDictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class DictionaryTest {

	@Test
	void constructorWordTest() throws FileNotFoundException 
	{
		//given
		Dictionary D = new Dictionary("/Users/macbook/Desktop/dictionary.txt");
		
		//when
		String w = D.dictionary.get(0).getWord();
	
		//then
		assertEquals("aa", w);
		
	}

}
