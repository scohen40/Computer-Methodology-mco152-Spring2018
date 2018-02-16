package cohen.dictionary;

public class Definition {
	private String word;
	private String definition;
	
	public Definition(String word, String definition)
	{
		this.word = word;
		this.definition = definition;
	}
	
	//getters
	public String getWord()
	{
		return word;
	}
	
	public String getDefinition()
	{
		return definition;
	}
	
	//setters
	public void setWord(String word)
	{
		this.word = word;
	}
	
	public  void setDefinition(String definition)
	{
		this.definition = definition;
	}
}
