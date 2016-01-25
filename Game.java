// Game class.
import java.lang.*;
import java.util.*;
import java.io.*;

// A "spare" is awarded when no pins are left standing after the second ball of a set; i.e., a player uses both balls of a set
// to clear all ten pins. Bonus points = 5.No extra ball is awarded.
// A strike is when the player knocks down all ten pins on his/her first try.If there is a strike the player gets 10 bonus points.
// with no extra balls.
// A player who bowls a spare/strike in the tenth (final) set is awarded one extra ball to allow for the bonus points + bonus points.

public class Game
{
	private Lane lane;
	private List<Player> players;
	private static final int numSets = 5;
	private static final int chancePerSets = 2;
	private int counter = 0;
	
	public Game( Lane lane, List<Player> players )
	{
		this.lane = lane;
		this.players = players;
	}
	
	public void start()
	{
		while ( counter < numSets )
		{
			
			for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
				Player player = (Player)iter.next();
				int standingPins = 10;
				int totalPinDown = 0;
				for ( int i = 0; i < chancePerSets; i++ ) {
					int numPinDown = takeShot(standingPins);
					totalPinDown += numPinDown;
					standingPins -= numPinDown;
					if ( i == 0 && numPinDown == 10 )
					{
						System.out.println("There's a strike by player " + player.getName());
						player.addScore(20);
						standingPins = 10;
					}
					else if ( i == 1 && standingPins == 0 )
					{
						System.out.println("There's a spare by player " + player.getName());
						player.addScore(numPinDown + 5);
					}
					else
					{
						System.out.println(player.getName() + " pinned down " + numPinDown + " in " + (i+1) + " shot");
						player.addScore(numPinDown);
					}
				}
			}
			counter++;
		}
	}
	
	public String getWinner()
	{
		int maxScore = -1, score;
		String name = null;
		for ( Player player : players )
		{
			score = player.getScore();
			if ( score > maxScore )
			{
				maxScore = player.getScore();
				name = player.getName();
			}
		}
		return name;
	}
	
	private int takeShot( int standingPins )
	{
		return 0 + (int)(Math.random() * ((standingPins - 0) + 1));
	}
}