// Lane details.

public class Lane
{
	private int id;
	private int maxPlayers;
	private int numPlayers;
	private int price;
	
	public Lane( int id, int maxPlayers, int price ) {
		this.id = id;
		this.maxPlayers = maxPlayers;
		this.price = price;
	}
	
	public void setNumPlayers( int numPlayers ) throws BowlingAlleyException
	{
		if ( numPlayers > maxPlayers )
			throw new BowlingAlleyException("Sorry! No more than " + maxPlayers + " can play in this lane.");
		this.numPlayers = numPlayers;
	}
	
	public int getID() {
		return id;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public int getPrice() {
		return price;
	}
}