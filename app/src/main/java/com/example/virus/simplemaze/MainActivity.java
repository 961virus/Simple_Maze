package com.example.virus.simplemaze;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button Left;
    Button Up;
    Button Right;
    Button Down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Left = (Button) findViewById(R.id.button_left);
        Up = (Button) findViewById(R.id.button_up);
        Right = (Button) findViewById(R.id.button_right);
        Down = (Button) findViewById(R.id.button_down);

//creating click listener for buttons
        View.OnClickListener oclLeft = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        };

        View.OnClickListener oclUp = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        View.OnClickListener oclRight = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        View.OnClickListener oclDown = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        //set click listeners
        Left.setOnClickListener(oclLeft);
        Up.setOnClickListener(oclUp);
        Right.setOnClickListener(oclRight);
        Down.setOnClickListener(oclDown);
    }






}
