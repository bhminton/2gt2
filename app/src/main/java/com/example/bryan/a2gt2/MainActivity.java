package com.example.bryan.a2gt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView results;
    MyDBHandler dbHandler;
    Button add;
    Button display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        results= (TextView)findViewById(R.id.results);
        add = (Button)findViewById(R.id.add);
        display= (Button)findViewById(R.id.display);
        dbHandler = new MyDBHandler(this,null,null,1);

    }
    public void addButtonClicked(View view){
        String event = input.getText().toString();
        String date  = String.valueOf(Calendar.DATE);
        dbHandler.addRecord(event,date);

    }
}
