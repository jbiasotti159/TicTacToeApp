

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * Author: Jillian Biasotti
 * @date 1/31/2019
 */

package edu.quinnipiac.ser210.tictactoeapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * Author: Jillian Biasotti
 * @date 2/15/2019
 */

public class TicTacToe extends Activity implements ITicTacToe {

	// The game board and the game status
	private static final int ROWS = 3, COLS = 3; // number of rows and columns
	private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	private int roundCount;
	private int[] buttonNames = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};
	private ArrayList<Button> buttons;
	TextView currPlayer;
	String nameText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		Intent intent = getIntent();
		nameText = intent.getStringExtra("name");
		TextView nameView = (TextView) findViewById(R.id.name);
		nameView.setText("Welcome " + nameText + "!");

		currPlayer = (TextView) findViewById(R.id.currPlayer);

		buttons = new ArrayList<Button>();
		for (int id : buttonNames) {
			Button button = (Button) findViewById(id);
			buttons.add(button);
		}
	}

	/**
	 * clear board and set current player
	 */
	public TicTacToe() {
		roundCount = 0;
	}

	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
		board[(int) (location / 3)][location % 3] = player;
		roundCount++;
	}

	@Override
	public int getComputerMove() {
		// TODO Auto-generated method stub
		int move = (int) (Math.random() * 9);

		while (board[move / 3][move % 3] != EMPTY) {
			move = (int) (Math.random() * 9);
		}
		return move;
	}


	public void onClickMove(View view) {
		this.setMove(1, buttons.indexOf(findViewById(view.getId())));
		if(roundCount <= 8)
		{
			this.setMove(2, this.getComputerMove());
		}
		display();
		if(checkForWinner() == 1)
		{
			showDialog(this, "Tie", "It's a tie! Click reset to play again!");
			//tie
		}
		else if(checkForWinner() == 2)
		{
			showDialog(this, "Winner", nameText + " wins! Click reset to play again!");
			//you win
		}
		else if(checkForWinner() == 3)
		{
			showDialog(this, "Loser", nameText +" loses! Click reset to play again!");
			//cpu wins
		}
	}
	public void showDialog(Activity activity, String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		if (title != null) builder.setTitle(title);

		builder.setMessage(message);
		builder.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id)
			{
				clearBoard();
				roundCount = 0;
				findViewById(R.id.one).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.two).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.three).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.four).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.five).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.six).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.seven).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.eight).setBackgroundResource(R.drawable.blank);
				findViewById(R.id.nine).setBackgroundResource(R.drawable.blank);
			}
		});
		builder.setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id)
			{
				TicTacToe.this.finish();
			}
		});
		builder.show();
	}
	//displays board
	public void display()
	{
		int counter = 0;

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				switch(board[row][col])
				{
					case 0:
						counter++;
						break;
					case 1:
						buttons.get(counter).setBackgroundResource(R.drawable.x);
						counter++;
						break;
					case 2:
						buttons.get(counter).setBackgroundResource(R.drawable.whiteo1);
						counter++;
						currPlayer.setText("Current Player is " + nameText);
						break;
				}
			}
		}
	}
	//checks for winner
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
		if (roundCount >= 9) {
			return 1;
		}

		return 0;
	}
}
