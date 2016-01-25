// Players class.

public class Player
{
	private int id;
	private String name;
	private int totalScore;
	
	public Player( int id, String name )
	{
		this.id = id;
		this.name = name;
		this.totalScore = 0;
	}
	
	public void addScore( int score )
	{
		this.totalScore += score;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getScore()
	{
		return totalScore;
	}
}