package cohen.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class DictionaryTest {

	@Test
	void constructorWordTest() throws FileNotFoundException 
	{
		//given
		Dictionary D = new Dictionary("src/cohenDictionary/dictionary.txt");		
		//when
		String w = D.dictionary.get(0).getWord();	
		//then
		assertEquals("AA", w);
	}
	
	@Test
	void containsTest() throws FileNotFoundException
	{
		//given 
		Dictionary D = new Dictionary("/Users/macbook/Desktop/dictionary.txt");
		//when
		String word = "AA";
		Boolean b = D.contains(word);
		//then
		assertTrue(word, b);
	}
	
	@Test
	void getDefTest() throws FileNotFoundException
	{
		//given
		Dictionary D = new Dictionary("/Users/macbook/Desktop/dictionary.txt");
		//when
		String d = D.getDefinition("ABASHMENT");
		//then
		assertEquals(null, d);
	}

}
