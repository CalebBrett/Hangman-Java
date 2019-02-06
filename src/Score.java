
public class Score {
	
	private int score;
	
	public void increaseScore(int i){
		score = score+i;
	}
	public int getScore(){
		return score;
	}
	public void reset(){
		score=0;
	}
	
}
