// Manage the tokens.

import java.lang.*;
import java.util.*;

public class Tokens
{
	class Token
	{
		TOKEN_ID id;
		boolean status;
		Token( TOKEN_ID id, boolean status )
		{
			this.id = id;
			this.status = status;
		}
	}
	
	private List<Token> tokens = new LinkedList<Token>();
	
	public Tokens()
	{
		initTokens();
	}
	
	public void initTokens()
	{
		tokens.add(new Token(TOKEN_ID.TOKEN_1, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_2, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_3, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_4, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_5, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_6, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_7, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_8, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_9, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_10, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_11, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_12, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_13, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_14, false));
		tokens.add(new Token(TOKEN_ID.TOKEN_15, false));
	}
	
	public TOKEN_ID getToken() throws BowlingAlleyException
	{	
		boolean found = false;
		TOKEN_ID tokenid = TOKEN_ID.TOKEN_1;
		for ( Token token : tokens )
		{
			if ( token.status == false )
			{
				tokenid = token.id;
				found = true;
			}
		}
		if ( !found )
			throw new BowlingAlleyException("Currently there are no available tokens. Please wait for some time.");
		
		return tokenid;
	}
	
	public void returnToken( TOKEN_ID id )
	{
		for ( Token token : tokens )
		{
			if ( token.id == id && token.status == true )
			{
				tokens.remove(token);
				tokens.add(new Token(id, false));
			}
		}
	}
}