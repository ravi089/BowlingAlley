// Bowling alley game class.
import java.lang.*;
import java.util.*;
import java.io.*;

public class BowlingAlley
{
	private List<Lane> lanes = new LinkedList<Lane>();
	private HashMap<Lane, TOKEN_ID> bookedLanes = new HashMap<Lane, TOKEN_ID>();		// Map of <lane, token>

	public BowlingAlley() {
		try
		{
			File file = new File("lanes.txt");
			String line;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ( (line = br.readLine()) != null )
			{
				String[] temp = line.split(",");
			
				int id = Integer.parseInt(temp[0]);
				int numPlayers = Integer.parseInt(temp[1]);
				int price = Integer.parseInt(temp[2]);
			
				lanes.add(new Lane(id, numPlayers, price));
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}

	public Lane getLaneByID( int id ) throws BowlingAlleyException
	{
		boolean found = false;
		Lane lane = null;
		for ( Lane l : lanes )
		{
			if ( l.getID() == id )
			{
				lane = lane;
				found = true;
			}
		}
		if ( !found )
			throw new BowlingAlleyException("Entered lane id is invalid.");
		return lane;
	}
	
	public void showLanes()
	{
		for (Iterator<Lane> iter = lanes.iterator(); iter.hasNext(); ) {
			Lane lane = (Lane)iter.next();
			System.out.println(lane.getID() + "  " + lane.getMaxPlayers() + "  " + lane.getPrice() );
		}
	}
	
	public boolean bookLane( int laneID, TOKEN_ID tokenID ) throws BowlingAlleyException
	{
		boolean found = false;
		Lane lane = null;
		for (Iterator<Lane> iter = lanes.iterator(); iter.hasNext(); ) {
			lane = (Lane)iter.next();
			if ( lane.getID() == laneID ) {
				found = true;
				break;
			}
		}
		if ( found )
		{
			if ( !bookedLanes.containsKey(lane) ) 
				bookedLanes.put(lane, tokenID);
			else
				throw new BowlingAlleyException("Lane with id is already booked.");
		}
		else
			throw new BowlingAlleyException("Entered lane id is invalid.");
		
		return found;
	}
}