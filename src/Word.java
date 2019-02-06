
public class Word {
	
	public String value;
	private String blank;	
	
	public int getCountlettersInWord(char gess){
		int counter = 0;
		for(int i = 0; i< value.length(); i++){
			char letter = value.charAt(i);
			if(letter == gess){
				counter = counter+1;
			}
		}
		return counter;
	}
	
	/**
	 * Replace Underscores
	 * @param guess is the letter that the player guessed
	 * @return blank is the underscores
	 */
	public String placeUnderscores(String guess){
		char guessLetter = guess.charAt(0);
		
		for(int i = 0; i< value.length(); i++){
			if(value.charAt(i) == guessLetter){
				StringBuilder d = new StringBuilder(blank);
					d.setCharAt(i, guessLetter);
					blank = d.toString();
						
			}
		}
		return blank;
	}
	
	public void setWord(String word){
		value = word;
	}
	
	public String getvalue(){
		return value;	
	}
	
	public int getLength(){
		return value.length();
		 
	}
	
	public boolean contains(String guess){
		return value.contains(guess);
	}
	
	public String getblank(){
		return blank;
	}

	/**
	 * gives a variable to blank
	 */
	public void resetBlank(){
		blank="";
		for(int b = 0; b < value.length(); b++){
			blank = blank + "_";
		}
	}
}
