import java.util.Random;

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * Author: Jillian Biasotti
 * @date 1/31/2019
 */
import java.util.Scanner;
public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   private int roundCount;
	   
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		roundCount = 0;
	}
	
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				board[i][j] = EMPTY;
			}
		}
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
		board[(int)(location/3)][location%3] = player;
		roundCount++;	
	}
	
	@Override
	public int getComputerMove() {
		// TODO Auto-generated method stub
		int move = (int)(Math.random()*9);
		
		while (board[move/3][move%3] != EMPTY) 
		{
			move = (int)(Math.random()*9);
		}
		return move;
	}

	@Override
	public int checkForWinner() {
		// TODO Auto-generated method stub
		
		if((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
		{
			if(board[0][0] == 1)
			{
				return 2;
			}
			else if(board[0][0] == 2)
			{	
				return 3;
			}
		}
		if((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
		{
			if(board[1][0] == 1)
			{
				return 2;
			}
			else if(board[1][0] == 2)
			{	
				return 3;
			}
		}
		if((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
		{
			if(board[2][0] == 1)
			{
				return 2;
			}
			else if(board[2][0] == 2)
			{	
				return 3;
			}
		}
		if((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
		{
			if(board[0][0] == 1)
			{
				return 2;
			}
			else if(board[0][0] == 2)
			{	
				return 3;
			}
		}
		if((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
		{
			if(board[0][1] == 1)
			{
				return 2;
			}
			else if(board[0][1] == 2)
			{	
				return 3;
			}
		}
		if((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
		{
			if(board[0][2] == 1)
			{
				return 2;
			}
			else if(board[0][2] == 2)
			{	
				return 3;
			}
		}
		if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
		{
			if(board[0][0] == 1)
			{
				return 2;
			}
			else if(board[0][0] == 2)
			{	
				return 3;
			}
		}
		if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
		{
			if(board[0][2] == 1)
			{
				return 2;
			}
			else if(board[0][2] == 2)
			{	
				return 3;
			}
		}
		if (roundCount == 8) {
			return 1;
		}
		
		return 0;
	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

}
