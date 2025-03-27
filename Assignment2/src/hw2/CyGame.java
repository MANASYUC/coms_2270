package hw2;



/**
 * Model of a Monopoly-like game. Two players take turns
 * rolling dice to move around a board. The game ends
 * when one of the players has at least MONEY_TO_WIN
 * money or one of the players goes bankrupt (they have
 * negative money).
 * 
 * @author YOUR_NAME_HERE
 */
public class CyGame {
	/**
	 * The endzone square type.
	 */
	public static final int ENDZONE = 0;
	/**
	 * The CyTown square type.
	 */
	public static final int CYTOWN = 1;
	/**
	 * The pay rent square type.
	 */
	public static final int PAY_RENT = 2;
	/**
	 * The fall behind square type.
	 */
	public static final int FALL_BEHIND = 3;
	/**
	 * The blizzard square type.
	 */
	public static final int BLIZZARD = 4;
	/**
	 * The pass class square type.
	 */
	public static final int PASS_CLASS = 5;
	/**
	 * Points awarded when landing on or passing over the endzone square.
	 */
	public static final int ENDZONE_PRIZE = 200;
	/**
	 * The standard rent payed to the other player when landing on a
	 * pay rent square.
	 */
	public static final int STANDARD_RENT_PAYMENT = 80;
	/**
	 * The cost to by CyTown.
	 */
	public static final int CYTOWN_COST = 200;
	/**
	 * The amount of money required to win.
	 */
	public static final int MONEY_TO_WIN = 400;


	// TODO: EVERTHING ELSE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The toString method below is provided for you and you should not modify
	// it. The compile errors will go away after you have written stubs for the
	// rest of the API methods.
	
	
	/**
	 * int board - to hold tiles
	 * int playerPos array - to hold current positions of players
	 * int playerMoney array - to hold player money
	 * boolean currPlayer - to check player( player 1 == true/ player 2 == false)
	 * int squares - to hold num tiles
	 * int cytownOwner - to hold who owns CyTown tile
	 */
	private int[] board;
	private  int[] playerPos = new int[2];
	private  int[] playerMoney = new int[2];
	private  boolean currPlayer;
	private int squares;
	private  int cytownOwner = 0;

	/**
	 * @param numSquares
	 * @param startingMoney
	 * created a new CyGame 
	 */
	public CyGame(int numSquares, int startingMoney)
	{
		//board is created with number of tiles
		//player position is set to 0
		//player money is set to starting money variable
		//current player is set to player 1
		board = new int[numSquares];
		squares = numSquares;
		
		playerPos[0] = 0;
		playerPos[1] = 0;
		
		playerMoney[0] = startingMoney;
		playerMoney[1] = startingMoney;
		currPlayer = true;
		
		//board is set with tiles based on tile specification
		for(int i = 0; i < numSquares;i++)
		{
			
			if(i == 0)
			{
				board[i] = ENDZONE;
			}
			else if(i == board.length - 1)
			{
				board[i] = CYTOWN;
			}
			else if((i % 7 == 0) || (i % 11 == 0))
			{
				board[i] = FALL_BEHIND;
			}
			else if(i % 3 == 0)
			{
				board[i] = BLIZZARD;
			}
			else if(i % 5 == 0)
			{
				board[i] = PAY_RENT;
			}
			else
			{
				board[i] = PASS_CLASS;
			}
		}
	}
	
	/**
	 * Method to buy CyTown tile
	 */
	public void buyCyTown()
	{
		// only works if game is not ended
		if(isGameEnded() || cytownOwner != 0)
		{
			return;
		}
		int currPlayer = getCurrentPlayer();
		//Only works if CyTown isn't already owned and if the player is on the CyTown tile
		if (playerPos[currPlayer - 1] == squares - 1 && playerMoney[currPlayer - 1] >= CYTOWN_COST) {
		    cytownOwner = getCurrentPlayer();
		    playerMoney[currPlayer - 1] -= CYTOWN_COST;
		    endTurn(); // Turn should end immediately after buying CyTown
		}

		
	}
	
	/**
	 * Method to end current players turn
	 * Just switches boolean value of currPlayer
	 */
	public void endTurn()
	{
		currPlayer = !currPlayer;
	}
	
	/**
	 * @return
	 * Method to return current player
	 */
	public int getCurrentPlayer()
	{
		if(!currPlayer)
		{
			return 2;
		}
		return 1;	
	}
	
	/**
	 * @return
	 * Method to return other player
	 */
	public int getOtherPlayer()
	{
		if(!currPlayer)
		{
			return 1;
		}	
		return 2;
		
	}
	
	/**
	 * @param player
	 * @return
	 * returns players money based on the parameter
	 */
	public int getPlayerMoney(int player)
	{
		int indx = player - 1;
		return playerMoney[indx];
	}
	
	/**
	 * @param player
	 * @return
	 * return players tile based on the parameter
	 * also checks does the wrap around to the board if the position is greater than # of tiles
	 */
	public int getPlayerSquare(int player)
	{
		int indx = player - 1;
		if(playerPos[indx] >= squares)
		{
			playerPos[indx] %= squares;
		}
		return playerPos[indx];
	}
	
	/**
	 * @param square
	 * @return
	 * just returns the tile @ the parameter
	 */
	public int getSquareType(int square)
	{
		return board[square];
	}
	
	/**
	 * @return
	 * return a boolean if any players money is greater that the MINEY_TO_WIN variable
	 * or if a player has negative money
	 */
	public boolean isGameEnded()
	{
		if(playerMoney[0] >= MONEY_TO_WIN || playerMoney[1] >= MONEY_TO_WIN || playerMoney[0] < 0 || playerMoney[1] < 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return
	 * returns boolean based on who owns CyTown tile
	 */
	public boolean isPlayer1CyTownOwner()
	{
		if(cytownOwner == 1)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return
	 * opposite method of isPlayer1CyTownOwner()
	 */
	public boolean isPlayer2CyTownOwner()
	{
		if(cytownOwner == 2)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @param value
	 * this method is used to roll the dice and do the tile action based on the roll	
	 */
	public void roll(int value)
	{
		//checks if game is ended with call to isGameEnded() method
		if(isGameEnded())
		{
			return;
		}
		
		//sets int indx to players who's turn it is
		int indx;
		if(currPlayer) 
		{
			indx = 0;
		}
		else
		{
			indx = 1;
		}
		
		//if the player is on a blizzard tile then they HAVE to roll a odd number to move on
		if(board[playerPos[indx]] == BLIZZARD  && value % 2 == 0)
		{
			return;
		}
		
		// adds the roll to player position
		playerPos[indx] += value;
		//checks if the roll will make the player pass ENDZONE tile and gives them the ENDZONE prize
		//updates the player position using mod to wrap around 
		if(playerPos[indx] >= squares)
		{
			playerPos[indx] %= squares;
			playerMoney[indx] += ENDZONE_PRIZE;
		}
		
		// holds what tile the player is on
		int currTile = board[playerPos[indx]];
		
		//checks if tile is FALL_BEHIND and then continues to do action based on that
		if(currTile == FALL_BEHIND)
		{
			playerPos[indx] -= 1;
			currTile = board[playerPos[indx]];
		}
		
		//Checks if tile is PASS_CLASS and then adds 4 to the roll and continues to do the action on the next tile
		//		- only is allowed to to next tile action if the tile isnt another PASS_CLASS tile
		if(currTile == PASS_CLASS)
		{
			playerPos[indx] += 4;
			if(playerPos[indx] >= squares)
			{
				playerPos[indx] %= squares;
				playerMoney[indx] += ENDZONE_PRIZE;
			}
			currTile = board[playerPos[indx]];
			if(currTile % PASS_CLASS == 0)
			{
				return;
			}
		}
		
		//checks if player on the PAY_RENT tile if they are
		// 		- checks if the other player owns CyTown tile & doubles the rent and then pays rent
		if(currTile == PAY_RENT)
		{
			int rent = STANDARD_RENT_PAYMENT;
			if((currPlayer &&  isPlayer2CyTownOwner()) || (!currPlayer && isPlayer1CyTownOwner()))
			{
				rent *= 2;
			}
			playerMoney[indx] -= rent;
			playerMoney[1- indx] += rent;
		}
		//up to player to by cytown tile or end turn.
		if(currTile == CYTOWN)
		{	
			return;
		}
		//finally ends the current players turn on if the game isnt ended.
		if (!isGameEnded()) {
	        endTurn();
	    }		
	}
	
	
	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player 1*: (0, false, $0) Player 2: (0, false, $0)</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which players turn it
	 * is. The values (0, false, $0) indicate which square the player is on,
	 * if the player is the owner of CyTown, and how much money the player has
	 * respectively.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player 1%s: (%d, %b, $%d) Player 2%s: (%d, %b, $%d)";
		String player1Turn = "";
		String player2Turn = "";
		if (getCurrentPlayer() == 1) {
			player1Turn = "*";
		} else {
			player2Turn = "*";
		}
		return String.format(fmt,
				player1Turn, getPlayerSquare(1), isPlayer1CyTownOwner(), getPlayerMoney(1),
				player2Turn, getPlayerSquare(2), isPlayer2CyTownOwner(), getPlayerMoney(2));
	}
}
