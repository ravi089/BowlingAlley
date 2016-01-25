// Testing class.
import java.lang.*;
import java.util.*;
import java.io.*;

public class BowlingAlleyTesting
{
	private static int counter = 1453;
	
	public static ArrayList<Player> getPlayerDetails()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of players.");
		int count = scanner.nextInt();
		scanner.nextLine();
		
		for ( int i = 0; i < count; i++ )
		{
			System.out.println("Enter the player name.");
			String name = scanner.nextLine();
			
			players.add(new Player(++counter, name));
		}
		
		return players;	
	}
	
	public static void main( String[] args )
	{
		BowlingAlley alley = new BowlingAlley();
		Tokens tokens = new Tokens();
		Lane lane = null;
		boolean success = false;
		while ( !success )
		{
			try
			{
				Scanner scanner = new Scanner(System.in);
				System.out.println("Get the token.");
				TOKEN_ID token = tokens.getToken();
				
				alley.showLanes();
				System.out.println("Choose the lane you wanted to play in by entering the id.");
				int laneid = scanner.nextInt();
				lane = alley.getLaneByID(laneid);
				
				success = alley.bookLane(laneid, token);
			}
			catch(BowlingAlleyException ex)
			{
				System.out.println(ex);
			}
			catch(Exception ex)
			{
			}
		}
		System.out.println("Enter player details.");
		ArrayList<Player> players = BowlingAlleyTesting.getPlayerDetails();
		Game game = new Game(lane, players);
		game.start();
		System.out.println("Winner of the game is " + game.getWinner());
	}
}