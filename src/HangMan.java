import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Caleb_Brett 2012
 * 
 */
public class HangMan
{
	public int length;
	private int tries;
	Word word = new Word();
	public String win;
	public String lose;
	public List<String> allGuesses;
	Score score = new Score();
	
	public void play(){
			  
		settupGame();
			
		while(true){
			
			String guess = getGuessFromPlayer();
			if(guess.length() == 0){
				continue;
			}
			boolean isTrue = checkIfAlredyGuessed(guess);
			if(isTrue){
				print("You alredy guessed that");
				continue;
			}
			putGuessIntoAllGuesses(guess);
			int counter = word.getCountlettersInWord(guess.charAt(0));
			if(counter >0){
				score.increaseScore(counter);
				word.placeUnderscores(guess);
				print(word.getblank());
				doWiningStuff();
			}							
			else { 
				doWrongGuessAndLose();
			}
		}
	}
	
	/**
	 * gets the players guess
	 * @return what the player has guessed
	 */
	public String getGuessFromPlayer(){
		print("The ammount of letters is " + word.getLength());
		print("You have " + tries + " tries");
		print("Guess a letter");	
		
		String guess = readLine();
		guess = guess.toLowerCase();
		
		return guess;
	}
	
	/**
	 * find if the letter is in the word
	 */
	public boolean findOutIfTheGuessIsInWord(String guess){
		boolean letterIsInWord = word.contains(guess);
		return letterIsInWord;
	}
	
	
	/**
	 * win and right answer
	 */
	public void doWiningStuff(){
		System.out.println("You are right");
		
		if(score.getScore() == word.getLength()){
			System.out.println("You win!");
			resetGame();
			System.out.println("Press enter to play again");
			readLine();
		}				
	}
	
	/**
	 * Gets word, word length & reset blank method
	 */
	public void settupGame(){
		word.setWord("there");
		resetGame();
	}
	
	
	/**
	 * this resets the game
	 */
	public void resetGame(){
		allGuesses = new ArrayList<String>();
		word.resetBlank();
		score.reset();
		
		tries = word.getLength()*2;
	}
	
	
	/**
	 * lose and wrong answer
	 */
	public void doWrongGuessAndLose(){
		System.out.println("No that letter is not in the word");
		tries = tries-1;
		if(tries == 0){
			resetGame();
			print("Game Over");
			print("Press enter to retry");
			readLine();
		}
	}
	
	public boolean checkIfAlredyGuessed(String guess){
		return allGuesses.contains(guess);
	}
	
	public void putGuessIntoAllGuesses(String guess){
		allGuesses.add(guess);
	}
	
		
	//print method
	public static void print(String value) {
		System.out.println(value);
	}
	
	//read method
	public static String readLine()
	{
		String s = "";
		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			s = in.readLine();
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e);
		}
		return s;
	}
	
}
