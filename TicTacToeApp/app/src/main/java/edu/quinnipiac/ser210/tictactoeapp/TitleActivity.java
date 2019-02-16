/*
    Jillian Biasotti
    2/15/2019
    Title Activity - initial screen
 */
package edu.quinnipiac.ser210.tictactoeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TitleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void onStartGame(View view)
    {
        EditText messageView = (EditText)findViewById(R.id.nameEntry);
        String nameText = messageView.getText().toString();
        Intent intent = new Intent(this, TicTacToe.class);
        intent.putExtra("name", nameText);
        startActivity(intent);
    }
}
